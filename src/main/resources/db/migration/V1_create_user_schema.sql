CREATE TABLE IF NOT EXISTS public._user
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    first_name character varying(200) COLLATE pg_catalog."default",
    last_name character varying(200) COLLATE pg_catalog."default",
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(300) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT _user_pkey PRIMARY KEY (id),
    CONSTRAINT user_unq_email UNIQUE (email)
)

TABLESPACE pg_default;