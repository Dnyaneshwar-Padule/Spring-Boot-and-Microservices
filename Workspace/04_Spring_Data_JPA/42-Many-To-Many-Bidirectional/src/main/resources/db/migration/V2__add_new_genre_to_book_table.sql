-- Step 1: Remove the old constraint that restricts the genres
ALTER TABLE public.book
DROP CONSTRAINT book_genre_check;

-- Step 2: Add the updated check constraint including 'EDUCATION'
ALTER TABLE public.book
    ADD CONSTRAINT book_genre_check
        CHECK (genre::text = ANY (ARRAY[
    'BIOGRAPHY'::character varying,
    'FICTION'::character varying,
    'SCI_FI'::character varying,
    'FANTASY'::character varying,
    'THRILLER'::character varying,
    'MYSTERY'::character varying,
    'ROMANCE'::character varying,
    'HORROR'::character varying,
    'HISTORY'::character varying,
    'EDUCATION'::character varying
    ]::text[]));
