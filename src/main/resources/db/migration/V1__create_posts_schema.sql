CREATE TABLE IF NOT EXISTS public.posts
(
    id uuid NOT NULL,
    title character varying(300) COLLATE pg_catalog."default" NOT NULL,
    description character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    content text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp without time zone NOT NULL DEFAULT now(),
    modified_at timestamp without time zone,
    CONSTRAINT posts_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;