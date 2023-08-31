-- public.t_booking definition

-- Drop table

-- DROP TABLE public.t_booking;

CREATE TABLE public.t_booking (
	id serial4 NOT NULL,
	debutdate date NOT NULL,
	enddate date NOT NULL,
	user_id serial4 NOT NULL,
	debut_date timestamp NULL,
	end_date timestamp NULL,
	CONSTRAINT t_booking_pkey PRIMARY KEY (id),
	CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.t_user(id)
);


-- public.t_booking foreign keys

--ALTER TABLE public.t_booking ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.t_user(id);