INSERT INTO public.category (category_guid,name,date_time_created) VALUES
	 ('5b26a8aa-5cc6-4abb-beaa-eeaa7b7ed40c'::uuid,'Finance','2024-01-01 00:00:00'),
	 ('21db8d85-ae3b-41ae-a83a-77660c851841'::uuid,'Films','2024-01-01 00:00:00'),
	 ('0139f976-be6e-4e0a-b8ac-ba0dcc91fe0e'::uuid,'Sports','2024-01-01 00:00:00');

INSERT INTO public.type_notification (type_notification_guid,name,date_time_created) VALUES
	 ('ef9c7e8e-2f43-441d-be84-2cc0acb84899'::uuid,'SMS','2024-01-01 00:00:00'),
	 ('f683835d-7e5c-414b-9fdf-79510a45d9c6'::uuid,'E-mail','2024-01-01 00:00:00'),
	 ('99f89913-151c-40ce-bef8-fe5a1ea112da'::uuid,'Push notification','2024-01-01 00:00:00');

INSERT INTO public."user" (user_guid,name,email,phone,date_time_created) VALUES
	 ('e6259608-cadd-42f0-bcb1-4047600c2c02'::uuid,'User1','user1@gmail.com','5512345678','2024-01-01 00:00:00'),
	 ('cd592faf-d3c6-4acb-a787-a6adbe46b99b'::uuid,'User2','user2@gmail.com','5523456789','2024-01-01 00:00:00'),
	 ('163a3a97-5abd-4129-b87f-0a5ed304eaeb'::uuid,'User3','user3@gmail.com','5534567890','2024-01-01 00:00:00');

INSERT INTO public.user_category (user_category_guid,user_guid,category_guid,date_time_created) VALUES
	 ('ba42e0d6-deef-4754-a97f-ba0b51f4e80c'::uuid,'e6259608-cadd-42f0-bcb1-4047600c2c02'::uuid,'0139f976-be6e-4e0a-b8ac-ba0dcc91fe0e'::uuid,'2024-01-01 00:00:00');

INSERT INTO public.user_type_notification (user_type_notification_guid,user_guid,type_notification_guid,date_time_created) VALUES
	 ('1f81a109-ea04-4922-a2e4-3b42890dcf85'::uuid,'e6259608-cadd-42f0-bcb1-4047600c2c02'::uuid,'f683835d-7e5c-414b-9fdf-79510a45d9c6'::uuid,'2024-01-01 00:00:00'),
	 ('9a96d8f3-77e6-4f7c-b5f9-55ba244277aa'::uuid,'e6259608-cadd-42f0-bcb1-4047600c2c02'::uuid,'99f89913-151c-40ce-bef8-fe5a1ea112da'::uuid,'2024-01-01 00:00:00');
