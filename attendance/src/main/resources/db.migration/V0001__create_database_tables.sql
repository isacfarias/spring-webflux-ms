CREATE TABLE IF NOT EXISTS public.attendance_register (
	attr_id serial NOT NULL,
	attendance_type VARCHAR (50) NOT NULL,
	description VARCHAR (255) NOT NULL,
	status_type VARCHAR (50) NOT NULL,
	created TIMESTAMP NOT NULL,
    closure TIMESTAMP,
    CONSTRAINT public.pk_attendance_register_id PRIMARY KEY (attr_id)
);


CREATE TABLE IF NOT EXISTS public.attendance_register_product (
	attrp_id serial PRIMARY KEY,
	attr_id integer  NOT NULL,
	product VARCHAR (255) NOT NULL,
    CONSTRAINT public.pk_attendance_register_product PRIMARY KEY (attrp_id)
);

ALTER TABLE IF EXISTS public.attendance_register_product
    ADD CONSTRAINT fk_attendance_register_product_to_attendance_register FOREIGN KEY (attr_id)
    REFERENCES public.attendance_register (attr_id)