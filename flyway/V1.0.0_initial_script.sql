CREATE TABLE public.category (
	category_guid uuid NOT NULL,
	"name" varchar NOT NULL,
	date_time_created timestamp NOT NULL,
	CONSTRAINT category_pk PRIMARY KEY (category_guid),
	CONSTRAINT category_unique UNIQUE ("name")
);

CREATE TABLE public.type_notification (
	type_notification_guid uuid NOT NULL,
	"name" varchar NOT NULL,
	date_time_created timestamp NOT NULL,
	CONSTRAINT type_notification_pk PRIMARY KEY (type_notification_guid),
	CONSTRAINT type_notification_unique UNIQUE ("name")
);

CREATE TABLE public."user" (
	user_guid uuid NOT NULL,
	"name" varchar NOT NULL,
	email varchar NOT NULL,
	phone varchar NOT NULL,
	date_time_created timestamp NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (user_guid)
);

CREATE TABLE public.notification (
	notification_guid uuid NOT NULL,
	message varchar NOT NULL,
	category_guid uuid NOT NULL,
	date_time_created timestamp NOT NULL,
	CONSTRAINT notification_pk PRIMARY KEY (notification_guid)
);

CREATE TABLE public.log_notification (
	log_notification_guid uuid NOT NULL,
	notification_guid uuid NOT NULL,
	user_guid uuid NOT NULL,
	type_notification_guid uuid NOT NULL,
	date_time_created timestamp NOT NULL,
	CONSTRAINT log_notification_pk PRIMARY KEY (log_notification_guid)
);

CREATE TABLE public.user_type_notification (
	user_type_notification_guid uuid NOT NULL,
	user_guid uuid NOT NULL,
	type_notification_guid uuid NOT NULL,
	date_time_created timestamp NOT NULL,
	CONSTRAINT user_type_notification_pk PRIMARY KEY (user_type_notification_guid)
);

CREATE TABLE public.user_category (
	user_category_guid uuid NOT NULL,
	user_guid uuid NOT NULL,
	category_guid uuid NOT NULL,
	date_time_created timestamp NOT NULL,
	CONSTRAINT user_category_pk PRIMARY KEY (user_category_guid)
);

ALTER TABLE public.user_category ADD CONSTRAINT user_category_user_fk FOREIGN KEY (user_guid) REFERENCES public."user"(user_guid);
ALTER TABLE public.user_category ADD CONSTRAINT user_category_category_fk FOREIGN KEY (category_guid) REFERENCES public.category(category_guid);
ALTER TABLE public.user_type_notification ADD CONSTRAINT user_type_notification_user_fk FOREIGN KEY (user_guid) REFERENCES public."user"(user_guid);
ALTER TABLE public.user_type_notification ADD CONSTRAINT user_type_notification_type_notification_fk FOREIGN KEY (type_notification_guid) REFERENCES public.type_notification(type_notification_guid);
ALTER TABLE public.notification ADD CONSTRAINT notification_category_fk FOREIGN KEY (category_guid) REFERENCES public.category(category_guid);
ALTER TABLE public.log_notification ADD CONSTRAINT log_notification_type_notification_fk FOREIGN KEY (type_notification_guid) REFERENCES public.type_notification(type_notification_guid);
ALTER TABLE public.log_notification ADD CONSTRAINT log_notification_user_fk FOREIGN KEY (user_guid) REFERENCES public."user"(user_guid);
ALTER TABLE public.log_notification ADD CONSTRAINT log_notification_notification_fk FOREIGN KEY (notification_guid) REFERENCES public.notification(notification_guid);


