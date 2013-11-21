insert into `company`(id, name, site, location) values(1, "IT-лофт", "http://7bits.it/", null);
insert into `company`(id, name, site, location) values(2, "ЕСТ", "http://www.estaxi.ru/", null);
insert into `company`(id, name, site, location) values(3, "Гехтсофт", "http://www.gehtsoft.com", null);
insert into `company`(id, name, site, location) values(4, "Тик-Так Коуч", "http://tiktokcoach.ru/", null);

insert into `conference`(id, company_id, ordinal_number, date, registration) values(1, 1, 12, 1383994800, false);
insert into `conference`(id, company_id, ordinal_number, date, registration) values(2, 1, 13, 1388833200, true);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(2, 2, "Дмитрий", "Голушко", null, "/resources/images/photos/dgolushko.jpg", null, "Java Developer", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(3, 3, "Александр", "Самолов", null, "/resources/images/photos/asamolov.jpg", null, "Технический директор", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(4, 4, "Евгений", "Тюменцев", null, "/resources/images/photos/nophoto.png", null, "Управляющий партнер компании “Тик-Так Коуч”", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(1, 1, 2, "Впечатления от Grails после одного проекта", "Впечатления по большей части положительные. Давно искал web-фреймворк на Java, который можно было бы использовать без кучи xml конфигов, без необходимости прочесть ВСЮ документацию. Я пробовал ASP.NET MVC 4. Круто. Можно писать просто, но чтобы сделать что-то более-менее сложное, приходится извращаться. Опять же Entity Framework, который в неумелых руках превращается в монстра. Короче, как говорится, не зашло. А Grails можно взять и работать. Это отличный инструмент, который позволяет делать практически всё что нужно. Более того, радует что \"под капотом\" у него Spring и Hibernate, которые однако скрыты более простыми и удобными собственными инструментами Grails. Одним словом слоган на сайте Grails \"The search is over\" оказался для меня верным.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(2, 1, 3, "Фреймворки - сладкое зло, или почему я не люблю использовать фреймворки", "Я не хочу устраивать \"холиварный\" доклад, но хочу поделиться своим мнением почему я не люблю фреймворки и с нежностью отношусь к \"велосипедам\". Хочу рассказать про те факапы, которые я поимел, используя веб фреймворки в java и аргументированно рассказать о профитах, если использовать что-то свое.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(3, 1, 4, "HWdTech.DS - message-oriented middleware, продолжение", "Евгений ответит на вопрос, заданный на 1-й части доклада: \"Почему не Erlang?\" Средства управления платформой: ServiceManager Библиотека сервисов Управление конфигурацией Взаимозаменяемость компонентов", null, null, null, null, null);