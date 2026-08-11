# Flyway with Spring Boot

## Table of Contents

-   [1. What is Migration?](#1-what-is-migration)
-   [2. What are Migration Tools?](#2-what-are-migration-tools)
-   [3. Why Do We Need Database
    Migrations?](#3-why-do-we-need-database-migrations)
-   [4. What is Flyway?](#4-what-is-flyway)
-   [5. Flyway's Basic Idea](#5-flyways-basic-idea)
-   [6. How Flyway Tracks Previous
    Migrations](#6-how-flyway-tracks-previous-migrations)
-   [7. The `flyway_schema_history`
    Table](#7-the-flyway_schema_history-table)
-   [8. How Flyway Works with Spring
    Boot](#8-how-flyway-works-with-spring-boot)
-   [9. Migration File Structure](#9-migration-file-structure)
-   [10. A Complete Example](#10-a-complete-example)
-   [11. What Happens on Every Application
    Startup?](#11-what-happens-on-every-application-startup)
-   [12. What Happens When a New Migration is
    Added?](#12-what-happens-when-a-new-migration-is-added)
-   [13. Why Applied Migrations Should Not Be
    Modified](#13-why-applied-migrations-should-not-be-modified)
-   [14. Checksums](#14-checksums)
-   [15. What Happens When a Migration
    Fails?](#15-what-happens-when-a-migration-fails)
-   [16. Development and Deployment](#16-development-and-deployment)
-   [17. Database Migration vs Data Migration vs System
    Migration](#17-database-migration-vs-data-migration-vs-system-migration)
-   [18. Flyway's Mental Model](#18-flyways-mental-model)
-   [19. Important Rules to Remember](#19-important-rules-to-remember)
-   [20. Summary](#20-summary)

------------------------------------------------------------------------

# 1. What is Migration?

In software, **migration** generally means moving or changing something
from one state, structure, system, or environment to another in a
controlled way.

In the database context, migration usually means changing the **database
schema or data as an application evolves**.

For example, initially we may have:

``` text
students
----------------
id
name
```

Later, the application needs an email address:

``` text
students
----------------
id
name
email
```

The change from the old database structure to the new one is a
**database migration**.

A migration could contain SQL such as:

``` sql
ALTER TABLE students
ADD COLUMN email VARCHAR(150);
```

The important idea is:

> A migration describes a change that needs to be made to the database.

------------------------------------------------------------------------

# 2. What are Migration Tools?

A **database migration tool** automates, organizes, and tracks database
changes.

Instead of developers manually executing SQL whenever the database
structure changes, migration tools allow database changes to be stored
as versioned migration files.

Some popular migration tools are:

-   Flyway --- commonly used with Java and Spring Boot
-   Liquibase --- commonly used with Java/Spring
-   Alembic --- commonly used with Python
-   Django Migrations --- built into Django
-   Prisma Migrate --- commonly used with Prisma/Node.js
-   Entity Framework Core Migrations --- used in .NET

For Spring Boot applications, two important choices are:

``` text
Flyway
Liquibase
```

This document focuses on **Flyway**.

------------------------------------------------------------------------

# 3. Why Do We Need Database Migrations?

Imagine an application is being developed by several developers.

Initially:

``` text
Database V1

students
----------------
id
name
```

Developer A adds an email column.

Developer B adds a phone column.

Developer C creates an attendance table.

Without a migration system, developers might manually execute different
SQL commands on their databases.

This can easily lead to:

``` text
Developer A's database → V3
Developer B's database → V2
Developer C's database → V4
Production database    → V2
```

Now the same application code is running against different database
structures.

That creates problems.

Migration tools solve this by making database changes **versioned and
reproducible**.

For example:

``` text
V1__create_students.sql
V2__add_email.sql
V3__add_phone.sql
V4__create_attendance.sql
```

Now everyone has a clear history of how the database evolved.

------------------------------------------------------------------------

# 4. What is Flyway?

**Flyway is a database migration tool.**

Its job is to keep the database schema synchronized with the migration
files that belong to the application.

The basic idea is:

``` text
Migration files
      +
Migration history stored in database
      ↓
     Flyway
      ↓
Database at correct version
```

Flyway does not normally require application developers to manually call
migration methods.

With Spring Boot, Flyway can be automatically configured and executed
during application startup.

------------------------------------------------------------------------

# 5. Flyway's Basic Idea

Suppose our project contains:

``` text
db/migration/
├── V1__create_users.sql
├── V2__create_students.sql
├── V3__add_email.sql
└── V4__create_attendance.sql
```

These files represent the evolution of the database.

Conceptually:

``` text
V1
 ↓
V2
 ↓
V3
 ↓
V4
```

Each migration is applied in order.

For example:

``` text
V1 → Create users table
V2 → Create students table
V3 → Add email to students
V4 → Create attendance table
```

Flyway keeps track of which migrations have already been executed.

The crucial point is:

> Flyway stores the migration history inside the database, not in
> separate local files.

------------------------------------------------------------------------

# 6. How Flyway Tracks Previous Migrations

This is one of the most important concepts.

Flyway creates a special table in the database:

``` text
flyway_schema_history
```

This table stores information about migrations that Flyway has executed.

Suppose our project contains:

``` text
V1__create_users.sql
V2__create_students.sql
V3__add_email.sql
V4__create_attendance.sql
```

After all four have been executed, the database will have a history
similar to:

``` text
flyway_schema_history

installed_rank | version | description             | success
---------------|---------|-------------------------|--------
1              | 1       | create_users            | true
2              | 2       | create_students         | true
3              | 3       | add_email               | true
4              | 4       | create_attendance       | true
```

The exact columns and metadata depend on the Flyway version, but
conceptually this is what is happening.

When Spring Boot starts again, Flyway:

1.  Finds the migration files.
2.  Connects to the database.
3.  Reads `flyway_schema_history`.
4.  Compares the migration files with the recorded history.
5.  Finds migrations that have not been applied.
6.  Executes those migrations.
7.  Records successful migrations in the history table.

Therefore:

> Yes, Flyway checks the database every time the application starts.

But it does **not** execute every migration every time.

It checks the migration history and only executes migrations that still
need to be applied.

------------------------------------------------------------------------

# 7. The `flyway_schema_history` Table

The `flyway_schema_history` table is Flyway's record of database
migration history.

It can contain information such as:

-   Installation order
-   Migration version
-   Description
-   Migration type
-   Script name
-   Checksum
-   Execution timestamp
-   Execution time
-   Success/failure status

Conceptually:

``` text
flyway_schema_history
----------------------------------------------------
installed_rank
version
description
type
script
checksum
installed_by
installed_on
execution_time
success
```

The exact structure can vary by Flyway version.

The important concept is:

``` text
Migration files = instructions
flyway_schema_history = record of what happened
```

------------------------------------------------------------------------

# 8. How Flyway Works with Spring Boot

Spring Boot provides automatic configuration for many common
technologies.

When Flyway is added to the project, Spring Boot can detect it and
configure it automatically.

The high-level startup flow is:

``` text
Spring Boot starts
       |
       v
Spring Boot configures the DataSource
       |
       v
Flyway is initialized
       |
       v
Flyway connects to the database
       |
       v
Flyway checks flyway_schema_history
       |
       v
Flyway finds pending migrations
       |
       v
Pending migrations are executed
       |
       v
Database reaches required schema version
       |
       v
Spring Boot continues application startup
```

This is why you normally do not need code such as:

``` java
Flyway flyway = new Flyway();
flyway.migrate();
```

Spring Boot handles the integration.

------------------------------------------------------------------------



---

# 8A. What Does Flyway Depend On?

To understand Flyway properly, it is important to understand that **Flyway itself does not magically connect to PostgreSQL or another database**.

Flyway needs a way to communicate with the database.

In a Spring Boot application, this is normally provided through a **DataSource**.

The relationship is roughly:

```text
Spring Boot
    |
    | configures
    ↓
DataSource
    |
    | provides database connections
    ↓
Flyway
    |
    | executes migration SQL
    ↓
Database
```

So Flyway is dependent on having access to a database connection.

---

## 8A.1 What is a DataSource?

A `DataSource` is an abstraction that provides connections to a database.

Instead of every component creating database connections manually, Spring Boot creates/configures a `DataSource` and components such as Flyway can use it.

Conceptually:

```text
DataSource
    |
    +---- getConnection()
              |
              ↓
       Database Connection
              |
              ↓
          PostgreSQL
```

The actual connection is usually created using JDBC.

For example, a PostgreSQL JDBC URL might be:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
```

along with:

```properties
spring.datasource.username=postgres
spring.datasource.password=your_password
```

Spring Boot uses these properties to configure the `DataSource`.

---

## 8A.2 Why Does Flyway Need a DataSource?

Flyway's job is to execute SQL against the database.

For example:

```sql
CREATE TABLE students (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100)
);
```

To execute this SQL, something needs to establish a connection to PostgreSQL.

That connection is provided through the DataSource.

Conceptually:

```text
V1__create_students.sql
          |
          ↓
        Flyway
          |
          ↓
      DataSource
          |
          ↓
    JDBC Connection
          |
          ↓
      PostgreSQL
```

Therefore:

> **Flyway needs database connectivity because its migrations must actually execute SQL against the target database.**

---

## 8A.3 What Does the JDBC Driver Do?

There is another important component: the **JDBC driver**.

For PostgreSQL, the application needs the PostgreSQL JDBC driver.

The driver is what allows Java/JDBC to communicate with PostgreSQL's database protocol.

Conceptually:

```text
Java application
      |
      ↓
    JDBC API
      |
      ↓
PostgreSQL JDBC Driver
      |
      ↓
PostgreSQL Database
```

The driver translates the JDBC-level operations into communication that PostgreSQL understands.

For example:

```text
Java
 |
 | DriverManager / DataSource
 ↓
PostgreSQL JDBC Driver
 |
 ↓
PostgreSQL
```

Spring Boot usually manages the JDBC driver dependency when you add the appropriate database starter/dependency.

---

## 8A.4 The Important Dependencies

For a typical Spring Boot + PostgreSQL + Flyway application, there are several related pieces:

```text
Spring Boot
   |
   +── Spring JDBC / DataSource support
   |
   +── PostgreSQL JDBC Driver
   |
   +── Flyway
   |
   ↓
PostgreSQL Database
```

Their responsibilities are different.

### Spring Boot

Automatically configures many components based on the dependencies and configuration you provide.

### DataSource

Provides database connections to application components.

### JDBC Driver

Allows Java/JDBC to communicate with the particular database, such as PostgreSQL.

### Flyway

Uses database connectivity to execute migrations and maintain migration history.

### PostgreSQL

The actual database where:

```text
Application data
+
flyway_schema_history
```

are stored.

---

## 8A.5 A More Accurate Startup Picture

The complete relationship can be visualized as:

```text
                Spring Boot starts
                       |
                       ↓
              Read configuration
                       |
                       ↓
             Configure DataSource
                       |
             ┌─────────┴─────────┐
             |                   |
             ↓                   ↓
       JDBC Driver          Connection details
             |              URL / username /
             |              password etc.
             └─────────┬─────────┘
                       ↓
              Database Connection
                       |
                       ↓
                  PostgreSQL
                       ↑
                       |
                    Flyway
                       |
             ┌─────────┴─────────┐
             ↓                   ↓
      Migration files     flyway_schema_history
             |                   |
             └─────────┬─────────┘
                       ↓
              Compare and migrate
                       |
                       ↓
             Database is updated
                       |
                       ↓
          Spring Boot continues startup
```

The exact internal startup ordering can depend on the Spring Boot/Flyway versions and configuration, but this is the correct conceptual model.

---

## 8A.6 Does Flyway Create the DataSource?

In a normal Spring Boot setup, you should think of it as:

```text
Spring Boot
    ↓
creates/configures DataSource
    ↓
Flyway uses the DataSource
```

rather than:

```text
Flyway
    ↓
creates the application's DataSource
```

Spring Boot's auto-configuration is responsible for wiring these components together.

Flyway can also be configured with its own database connection properties in some setups, but the common Spring Boot arrangement is to let Flyway use the application's configured database connectivity.

---

## 8A.7 What If the DataSource Cannot Connect?

Suppose you configure:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
```

but PostgreSQL is not running.

Then the connection cannot be established.

The conceptual flow becomes:

```text
Spring Boot
     ↓
DataSource
     ↓
Try to connect
     ↓
PostgreSQL unavailable
     ↓
Connection failure
     ↓
Flyway cannot access database
     ↓
Migration cannot run
```

This means a Flyway migration cannot succeed without working database connectivity.

Similarly, incorrect credentials can cause:

```text
Authentication failed
     ↓
No usable database connection
     ↓
Flyway cannot execute migration
```

---

## 8A.8 Why This Matters for Understanding Flyway

It is useful to separate the responsibilities:

```text
"How do I connect to the database?"
                ↓
          DataSource/JDBC


"Which database technology am I connecting to?"
                ↓
          JDBC Driver


"What database changes should be executed?"
                ↓
          Flyway migrations


"What changes have already been executed?"
                ↓
     flyway_schema_history
```

This separation makes the whole architecture much easier to understand.

---

## 8A.9 Example Dependencies in a Maven Spring Boot Project

A typical project may contain dependencies conceptually like:

```xml
<!-- Spring Boot application support -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>

<!-- PostgreSQL JDBC driver -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Flyway -->
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

The exact dependency versions should normally be managed by the Spring Boot version/BOM rather than manually specifying versions for every dependency.

Depending on the Spring Boot and Flyway versions, additional database-specific Flyway support may also be required.

The important point is not the exact XML, but the roles:

```text
Spring Boot
     ↓
DataSource configuration

PostgreSQL driver
     ↓
Java ↔ PostgreSQL communication

Flyway
     ↓
Database migration management
```

---

## 8A.10 Flyway Does Not Store Your Application Data

Flyway's history table:

```text
flyway_schema_history
```

is part of the database, but it is **metadata maintained by Flyway**.

For example:

```text
PostgreSQL database
│
├── users
├── students
├── attendance
├── leave_applications
│
└── flyway_schema_history   ← Flyway metadata
```

Your application tables contain application data.

The Flyway table contains information about database migrations.

---

## 8A.11 One Complete Mental Model

When you put everything together:

```text
                    Spring Boot
                        |
                        ↓
              Application Configuration
                        |
                        ↓
                    DataSource
                        |
                        ↓
                  JDBC Driver
                        |
                        ↓
                  PostgreSQL
                        ↑
                        |
                     Flyway
                    /     \
                   /       \
                  ↓         ↓
        Migration files   Migration history
        V1, V2, V3...     flyway_schema_history
                  \         /
                   \       /
                    ↓     ↓
                 Compare
                    |
                    ↓
             Apply pending
              migrations
                    |
                    ↓
              Updated database
                    |
                    ↓
          Spring Boot application
             continues startup
```

The key chain to remember is:

```text
Spring Boot
    ↓
DataSource
    ↓
JDBC Driver
    ↓
Database connection
    ↓
Flyway
    ↓
Migration SQL
    ↓
Database
```

More precisely, Flyway and the DataSource are both components participating in the same Spring Boot database setup; Flyway uses the database connectivity rather than being the component responsible for the application's general database connection management.

# 10. Migration File Structure

By default, Flyway looks for migrations under:

``` text
src/main/resources/db/migration/
```

A typical Spring Boot project may look like:

``` text
src/
└── main/
    ├── java/
    │   └── ...
    │
    └── resources/
        ├── application.properties
        └── db/
            └── migration/
                ├── V1__create_users.sql
                ├── V2__create_students.sql
                ├── V3__add_email.sql
                └── V4__create_attendance.sql
```

The standard versioned migration naming pattern is:

``` text
V<version>__<description>.sql
```

For example:

``` text
V1__create_users.sql
V2__create_students.sql
V3__add_email_to_students.sql
V4__create_attendance_table.sql
```

Notice that there are **two underscores** between the version and
description:

``` text
V1__create_users.sql
  ^^
```

The first part identifies the migration version.

The second part describes what the migration does.

------------------------------------------------------------------------

# 11. A Complete Example

Let's build a simple example.

## Step 1: Initial database

Initially, there is no `students` table.

Create:

``` text
V1__create_students.sql
```

Contents:

``` sql
CREATE TABLE students (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100)
);
```

When the Spring Boot application starts, Flyway executes V1.

The database becomes:

``` text
students
----------------
id
name
```

And Flyway records V1 in:

``` text
flyway_schema_history
```

------------------------------------------------------------------------

## Step 2: Add email

Later, the application needs an email address.

Do NOT modify V1.

Create:

``` text
V2__add_email_to_students.sql
```

Contents:

``` sql
ALTER TABLE students
ADD COLUMN email VARCHAR(150);
```

Now the migration files are:

``` text
V1__create_students.sql
V2__add_email_to_students.sql
```

If the database has already executed V1, Flyway sees:

``` text
V1 → already applied
V2 → not applied
```

So it executes only V2.

The database becomes:

``` text
students
----------------
id
name
email
```

------------------------------------------------------------------------

## Step 3: Add attendance

Later:

``` text
V3__create_attendance.sql
```

``` sql
CREATE TABLE attendance (
    id BIGINT PRIMARY KEY,
    student_id BIGINT NOT NULL,
    attendance_date DATE NOT NULL,
    present BOOLEAN NOT NULL
);
```

Now:

``` text
V1 → students
V2 → email
V3 → attendance
```

The database is now at V3.

------------------------------------------------------------------------

# 12. What Happens on Every Application Startup?

Suppose the database is already at:

``` text
V3
```

and the project contains:

``` text
V1
V2
V3
```

You start Spring Boot.

Flyway checks:

``` text
Migration files          Database history
------------------       -----------------
V1                       V1 ✓
V2                       V2 ✓
V3                       V3 ✓
```

There is nothing new.

Therefore:

``` text
No migration is executed.
```

Now suppose you add:

``` text
V4__add_phone.sql
```

The next startup looks conceptually like:

``` text
Migration files          Database history
------------------       -----------------
V1                       V1 ✓
V2                       V2 ✓
V3                       V3 ✓
V4                       V4 ✗
```

Flyway executes V4.

Then:

``` text
V1 ✓
V2 ✓
V3 ✓
V4 ✓
```

------------------------------------------------------------------------

# 13. What Happens When a New Migration is Added?

Imagine production is currently at V4:

``` text
Production DB
--------------
V1 ✓
V2 ✓
V3 ✓
V4 ✓
```

You create:

``` text
V5__create_leave_applications.sql
```

and deploy the new application.

On startup:

``` text
Spring Boot
     ↓
Flyway
     ↓
Read migration files
     ↓
Read flyway_schema_history
     ↓
Production DB is at V4
     ↓
V5 is pending
     ↓
Execute V5
     ↓
Record V5
```

Now production is at:

``` text
V5
```

This is especially useful during deployment because the database can
automatically be brought to the schema expected by the new application
version.

------------------------------------------------------------------------

# 14. Why Applied Migrations Should Not Be Modified

Suppose you created:

``` text
V3__add_email.sql
```

with:

``` sql
ALTER TABLE students
ADD COLUMN email VARCHAR(100);
```

You deploy the application.

V3 is now recorded in:

``` text
flyway_schema_history
```

Later, you decide that the column should be:

``` text
VARCHAR(200)
```

A common mistake would be to modify V3:

``` sql
ALTER TABLE students
ADD COLUMN email VARCHAR(200);
```

This is bad practice because V3 has already been executed in existing
databases.

Instead, create a new migration:

``` text
V4__change_email_length.sql
```

with:

``` sql
ALTER TABLE students
ALTER COLUMN email TYPE VARCHAR(200);
```

The history now accurately represents what happened:

``` text
V1 → create students
V2 → add something
V3 → add email as VARCHAR(100)
V4 → change email to VARCHAR(200)
```

This gives you a reproducible history of the database's evolution.

------------------------------------------------------------------------

# 15. Checksums

Flyway can store a **checksum** for a migration.

For example:

``` text
V3__add_email.sql
```

has some contents.

Flyway calculates a checksum for those contents and stores it in:

``` text
flyway_schema_history
```

Conceptually:

``` text
Migration file
      |
      v
   Checksum
      |
      v
flyway_schema_history
```

If someone later modifies an already-applied migration, Flyway can
detect that the migration's current checksum differs from the recorded
checksum.

This helps detect unexpected modification of migration files.

For example:

``` text
Originally applied:

V3
checksum = ABC123
```

Later:

``` text
V3 file changed

checksum = XYZ789
```

Flyway can recognize:

``` text
Expected checksum → ABC123
Current checksum  → XYZ789

Mismatch!
```

This is another reason why already-applied migrations should generally
not be edited.

------------------------------------------------------------------------

# 16. What Happens When a Migration Fails?

Suppose V5 contains an invalid SQL statement:

``` sql
ALTER TABLE students
ADD SOMETHING INVALID;
```

Flyway attempts to execute it.

The database reports an error.

Flyway reports the migration failure.

Depending on the database and migration situation, Flyway handles the
migration transaction/repair behavior according to the database's
transaction capabilities and Flyway configuration.

With Spring Boot, a migration failure can prevent successful application
startup.

This is useful because the application should not silently start against
an incompatible database schema.

The desired situation is:

``` text
Migration failed
      ↓
Application startup fails
      ↓
Fix migration
      ↓
Run application again
```

rather than:

``` text
Database migration failed
      ↓
Application starts anyway
      ↓
Application expects schema V5
      ↓
Database is actually V4
      ↓
Runtime errors
```

------------------------------------------------------------------------

# 17. Development and Deployment

One of the biggest benefits of Flyway is that database changes can be
committed to Git alongside application code.

For example:

``` text
Git repository
│
├── src/main/java/
│   └── ...
│
├── src/main/resources/
│   ├── application.properties
│   └── db/
│       └── migration/
│           ├── V1__create_users.sql
│           ├── V2__create_students.sql
│           ├── V3__add_email.sql
│           └── V4__create_attendance.sql
│
└── pom.xml
```

Suppose the development database is at V4.

Then you deploy a new application version containing V5.

Production may currently be at V4:

``` text
Development DB → V5
Production DB  → V4
```

When the new Spring Boot application starts in production:

``` text
Application
    ↓
Flyway
    ↓
Production database
    ↓
History says V4
    ↓
Migration files contain V5
    ↓
Execute V5
    ↓
Production database becomes V5
```

This allows database changes to be part of the application's deployment
process.

------------------------------------------------------------------------

# 18. Database Migration vs Data Migration vs System Migration

The word "migration" is broader than just Flyway.

## 17.1 Database Schema Migration

Changes the structure of the database.

Examples:

``` sql
CREATE TABLE
ALTER TABLE
DROP TABLE
ADD COLUMN
DROP COLUMN
CREATE INDEX
```

Example:

``` text
Old schema
    ↓
migration
    ↓
New schema
```

Flyway is commonly used for this.

------------------------------------------------------------------------

## 17.2 Data Migration

Changes or moves the actual data.

For example:

Before:

``` text
full_name
-----------------------
Dnyaneshwar Patil
```

After:

``` text
first_name | last_name
-----------|----------
Dnyaneshwar| Patil
```

The structure and/or data transformation can be performed through
migration scripts.

------------------------------------------------------------------------

## 17.3 Database-to-Database Migration

Moving data from one database technology to another.

For example:

``` text
MySQL
  ↓
PostgreSQL
```

This is also called database migration, but it is a broader migration
problem than simply managing schema versions.

------------------------------------------------------------------------

## 17.4 Application/System Migration

Moving an application or system from one environment to another.

For example:

``` text
Old server
    ↓
New server
```

or:

``` text
Old architecture
    ↓
New architecture
```

So:

> "Migration" is a general concept. Flyway specifically focuses on
> managing database changes through migrations.

------------------------------------------------------------------------

# 19. Flyway's Mental Model

A very useful way to remember Flyway is:

> **Git tracks how application source code evolves; Flyway tracks how
> the database schema evolves.**

For example:

``` text
Git
│
├── Commit 1 → Student entity
├── Commit 2 → Attendance entity
└── Commit 3 → Leave entity


Flyway
│
├── V1 → students table
├── V2 → attendance table
└── V3 → leave table
```

The two evolve together.

The application might evolve like:

``` text
Application V1
     ↓
Application V2
     ↓
Application V3
```

while the database evolves like:

``` text
Database V1
     ↓
Database V2
     ↓
Database V3
```

Flyway helps ensure that the database reaches the schema expected by the
application.

------------------------------------------------------------------------

# 20. Important Rules to Remember

## Rule 1 --- Migration files are instructions

For example:

``` text
V3__add_email.sql
```

contains the SQL necessary to move the database from the previous state
to the next state.

------------------------------------------------------------------------

## Rule 2 --- The database stores the history

Flyway stores migration information in:

``` text
flyway_schema_history
```

It does not rely on separate local files to remember what happened.

------------------------------------------------------------------------

## Rule 3 --- Flyway checks the database on startup

Conceptually:

``` text
Application starts
       ↓
Flyway checks history
       ↓
Compare with migration files
       ↓
Apply pending migrations
```

------------------------------------------------------------------------

## Rule 4 --- Don't modify already-applied migrations

Bad:

``` text
V3__add_email.sql
```

was already deployed and then its contents are changed.

Better:

``` text
V3__add_email.sql
V4__change_email_length.sql
```

Create a new migration for a new change.

------------------------------------------------------------------------

## Rule 5 --- Migration files should be versioned

Store them in Git along with your application.

For example:

``` text
db/migration/
├── V1__create_users.sql
├── V2__create_students.sql
├── V3__add_email.sql
└── V4__create_attendance.sql
```

------------------------------------------------------------------------

## Rule 6 --- Migration history makes environments reproducible

A new developer or a new server can start with an empty database and
execute:

``` text
V1
 ↓
V2
 ↓
V3
 ↓
V4
```

to reach the required schema.

------------------------------------------------------------------------

# 21. Summary

### What is migration?

A controlled change from an old state/structure to a new one.

In databases:

``` text
Old database schema
        ↓
     Migration
        ↓
New database schema
```

### What is a migration tool?

Software that manages, executes, and tracks database changes.

Examples:

``` text
Flyway
Liquibase
Alembic
Django Migrations
```

### What is Flyway?

Flyway is a database migration tool commonly used with Java and Spring
Boot.

### Where are migrations stored?

Usually:

``` text
src/main/resources/db/migration/
```

### How are migrations named?

``` text
V1__create_users.sql
V2__create_students.sql
V3__add_email.sql
```

### How does Flyway remember what it already executed?

Through a database table:

``` text
flyway_schema_history
```

### Does Flyway create a file to remember previous versions?

No.

The migration files are stored in your project, but the **execution
history is stored in the database**.

### Does Flyway check the database every time?

Yes.

On application startup, Flyway checks the migration history and compares
it with the available migration files.

It executes only the migrations that are still pending.

### How does Spring Boot interact with Flyway?

Spring Boot detects/configures Flyway and runs it as part of application
startup.

The high-level flow is:

``` text
Spring Boot starts
       ↓
DataSource configured
       ↓
Flyway initialized
       ↓
Connect to database
       ↓
Read flyway_schema_history
       ↓
Find pending migrations
       ↓
Execute them
       ↓
Record successful migrations
       ↓
Application continues startup
```

### The most important mental model

``` text
             APPLICATION
                  │
                  │ evolves
                  ↓
              Git commits


              DATABASE
                  │
                  │ evolves
                  ↓
          Flyway migrations
                  │
                  ↓
       flyway_schema_history
```

In one sentence:

> **Flyway is a version-control-like system for database schema changes:
> migration files describe how the database should evolve, while
> `flyway_schema_history` records which changes have already been
> applied.**
