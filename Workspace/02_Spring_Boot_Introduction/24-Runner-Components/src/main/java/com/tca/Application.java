package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =  SpringApplication.run(Application.class, args);

        Environment env = applicationContext.getBean(Environment.class);

        System.out.println("Environment-propertis...");
        System.out.println("name = " + env.getProperty("name") );
        System.out.println("server.port = " + env.getProperty("server.port", Integer.class));
        System.out.println("application.name = " + env.getProperty("application.name", "Unknown"));
    }

    /*

        Read HELP.md
        in IntelliJ or GitHub...............................

     */

    /*

       ## SpringApplication.run()

When a Spring Boot application starts using:

```java
SpringApplication.run(Application.class, args);
```

Spring Boot performs several startup steps. At a high level, they can be understood as:

1. **Create and start the Spring IoC container**
2. **Load and apply configurations**
3. **Execute Runner components**

### 1. Create and Start the Spring IoC Container

* Spring Boot determines the type of application (Console, Servlet Web, or Reactive Web).
* It creates the appropriate `ApplicationContext`.
* It loads bean definitions, performs dependency injection, creates singleton beans, and initializes the container.

### 2. Load and Apply Configurations

Spring Boot loads configuration from various sources, such as:

* `application.properties`
* `application.yml`
* Environment variables
* JVM system properties
* Command-line arguments

If the same property is defined in multiple places, the source with the higher precedence overrides the others.

Example:

```text
java -jar application.jar --server.port=8081
```

This overrides the default server port (`8080`) or the value specified in `application.properties`.

### 3. Execute Runner Components

Runner components are beans that execute **once** immediately after the Spring container has been fully initialized and all singleton beans have been created.

They are commonly used for:

* Initializing application data
* Loading cache
* Performing startup validation
* Printing startup information
* Executing one-time startup logic

A runner must be registered as a Spring bean (for example, using `@Component` or a `@Bean` method).

Spring Boot provides two types of runners:

#### 1. CommandLineRunner

* Implements the `CommandLineRunner` interface.
* Receives the command-line arguments as a `String[]` (via varargs).

#### 2. ApplicationRunner

* Implements the `ApplicationRunner` interface.
* Receives an `ApplicationArguments` object.
* `ApplicationArguments` provides convenient methods to access command-line options and non-option arguments.

`ApplicationRunner` is generally preferred when you need to process named command-line options.

### Execution Order

If multiple Runner components exist, Spring Boot executes all of them during startup.

The execution order is **not guaranteed** by default.

To define a specific execution order, use the `@Order` annotation (or implement the `Ordered` interface). Beans with lower order values execute before those with higher values.


     */

}
