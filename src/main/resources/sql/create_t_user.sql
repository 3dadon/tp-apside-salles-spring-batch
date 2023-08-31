-- public.t_user definition

-- Drop table

-- DROP TABLE public.t_user;

CREATE TABLE public.t_user (
	id serial4 NOT NULL,
	login varchar NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	email varchar NOT NULL,
	CONSTRAINT t_user_pkey PRIMARY KEY (id)
);