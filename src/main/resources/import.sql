insert into `company`(id, name, site, location) values(1, "IT-лофт", "http://7bits.it/", null);
insert into `company`(id, name, site, location) values(2, "Тамтэк", "http://thumbtack.ru/", null);
insert into `company`(id, name, site, location) values(3, "ЕСТ", "http://www.estaxi.ru/", null);
insert into `company`(id, name, site, location) values(4, "Гехтсофт", "http://www.gehtsoft.com/", null);
insert into `company`(id, name, site, location) values(5, "Тик-Так Коуч", "http://tiktokcoach.ru/", null);
insert into `company`(id, name, site, location) values(6, "Toptal", "http://www.toptal.com/", null);	
insert into `company`(id, name, site, location) values(7, "Luxoft", "http://www.luxoft.ru/", null);
insert into `company`(id, name, site, location) values(8, "Плюс Банк", "http://www.plus-bank.ru/", null);
insert into `company`(id, name, site, location) values(9, "Crystalnix", "http://crystalnix.com/", null);
insert into `company`(id, name, site, location) values(10, "Al Digit", "http://aldigit.com/", null);
insert into `company`(id, name, site, location) values(11, "Cigital", "http://www.cigital.com/", null);
insert into `company`(id, name, site, location) values(12, "Яндекс", "http://www.yandex.ru/", null);
insert into `company`(id, name, site, location) values(13, "IT-People", "http://it-people.ru/", null);
insert into `company`(id, name, site, location) values(14, "ОмГУ", "http://www.omsu.ru/", null);
insert into `company`(id, name, site, location) values(15, "Magnetic Project", "http://magnetic-money.ru/", null);
insert into `company`(id, name, site, location) values(16, "Аппарат", "http://www.apparat.ws/", null);
insert into `company`(id, name, site, location) values(17, "ИСС Арт", "http://www.issart.com/", null);
insert into `company`(id, name, site, location) values(18, "Собака Павлова", "http://pavlova.cc/", null);

-- Юзеры для тестов spring-security
INSERT INTO role (role) VALUES ('admin'), ('moderator');

-- 13 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(13, 1, 13, 1388833200, true);

-- 12 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(12, 1, 12, 1383994800, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (10, 'golush@gmail.com', '111111', 'Дмитрий', 'Голушко', 'golush@gmail.com', 'Java Developer', 1111111, true, 'dgolushko.png', 3, null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (30, 'samol@gmail.com', '111111', 'Александр', 'Самолов', 'samol@gmail.com', 'Технический директор', 1111111, true, null, 4, null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (31, 'tumen@gmail.com', '111111', 'Евгений', 'Тюменцев', 'tumen@gmail.com', 'Управляющий партнер Тик-Так Коуч ', 1111111, true, null, 5, null);
INSERT INTO user_roles (user_id, role_id) VALUES (10, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (30, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (31, 2);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(34, 12, 10, "Впечатления от Grails после одного проекта", "Впечатления по большей части положительные. Давно искал web-фреймворк на Java, который можно было бы использовать без кучи xml конфигов, без необходимости прочесть ВСЮ документацию. Я пробовал ASP.NET MVC 4. Круто. Можно писать просто, но чтобы сделать что-то более-менее сложное, приходится извращаться. Опять же Entity Framework, который в неумелых руках превращается в монстра. Короче, как говорится, не зашло. А Grails можно взять и работать. Это отличный инструмент, который позволяет делать практически всё что нужно. Более того, радует что \"под капотом\" у него Spring и Hibernate, которые однако скрыты более простыми и удобными собственными инструментами Grails. Одним словом слоган на сайте Grails \"The search is over\" оказался для меня верным.", null, '//player.vimeo.com/video/79188704', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(35, 12, 30, "Фреймворки - сладкое зло, или почему я не люблю использовать фреймворки", "Я не хочу устраивать \"холиварный\" доклад, но хочу поделиться своим мнением почему я не люблю фреймворки и с нежностью отношусь к \"велосипедам\". Хочу рассказать про те факапы, которые я поимел, используя веб фреймворки в java и аргументированно рассказать о профитах, если использовать что-то свое.", null, '//player.vimeo.com/video/79188703', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(36, 12, 31, "HWdTech.DS - message-oriented middleware, продолжение", "Евгений ответит на вопрос, заданный на 1-й части доклада: \"Почему не Erlang?\" Средства управления платформой: ServiceManager Библиотека сервисов Управление конфигурацией Взаимозаменяемость компонентов", null, '//player.vimeo.com/video/79856301', null, null, null);

-- 11 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(11, 1, 11, 1380966630, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (27, 'bobrova@gmail.com', '111111',' Екатерина', 'Боброва', 'bobrova@gmail.com', null, 1111111, true, null, 2, null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (28, 'rodionov@gmail.com', '111111', 'Алексей', 'Родионов', 'godionov@gmail.com', null, 1111111, true, null, 6, null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(31, 11, 27, "Обзор фреймворка Thucydides", "Обзор основанного на Selenuim фреймворка Thucydides. Он предназначен для написания тестов, имитирующих действия пользователя в браузере, и построения отчетов по их прохождению. Сейчас Thucydides - активно развивающийся open source проект, поддерживающий основные браузеры, параллельный запуск тестов, параметризацию тестов.", null, '//player.vimeo.com/video/76500586', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(32, 11, 28, "Как мы делали свой Travis CI: Vagrant + KVM", "Автор расскажет, как его команда построила гибкую VM-based систему непрерывной интеграции с помощью Vagrant и Linux KVM.", null, '//player.vimeo.com/video/76501005', null, null, null);

-- 10 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(10, 7, 10, 1378547430, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (2,'zinoviev@gmail.com','111111','Алексей','Зиновьев','zinoviev@gmail.com',null,null,true,null,2,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (26,'nazarenko@gmail.com','111111','Сергей','Назаренко','nazarenko@gmail.com',null,null,true,null,7,null)
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (1,'annie.tarasenko@7bits.it','111111','Анна','Тарасенко','annie.tarasenko@7bits.it','Директор',null,true,null,1,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(28, 10, 2, "ALMADA-2013 или самый простой способ пожить в общаге МГУ", "Итоги Microsoft School on ALgorithms for MAssive DAta (ALMADA). Свежие алгоритмы BigData. Внутренняя кухня подразделения Microsoft Research. Заметки о Computer Science.", null,'//player.vimeo.com/video/75683772', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(29, 10, 26, "Почему они мне не подчиняются?", "Возможно, некоторые из вас, на заре своей карьеры попадали в ситуацию, когда при завершении задачи оказывалось, что результат не соответствует ожиданиям начальства, заказчика или коллег. В данном докладе, в интерактивном формате, докладчик и аудитория попробуют проанализировать возможные причины таких ситуаций, и выработать практические рекомендации на каждый день.", null, '//player.vimeo.com/video/75683771', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(30, 10, 1, "Выращиваем разработчиков с нуля. Опыт летней стажировки-2013", "Докладчик расскажет о программе стажировки в компании 7bits летом 2013 года, в которой участвовали разработчики и дизайнеры. Поделится программой, успехами и неудачами. Докладчик надеется на обратную связь слушателей, чтобы сделать следующую стажировку еще лучше.", null, '//player.vimeo.com/video/74568341', null, null, null);

-- 9 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(9, 1, 9, 1375523430, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (23,'podgurski@gmail.com','111111','Михаил','Подгурский','podgurski@gmail.com','начальник отдела банковских систем УБСДИТ',null,true,null,8,null)
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (24,'shipovalov@gmail.com','111111','Александр','Шиповалов','shipovalov@gmail.com','Инженер по тестированию',null,true,null,2,null)
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (25,'kudiarov@gmail.com','111111','Роман','Кудияров','kudiarov@gmail.com','Соучредитель',null,true,null,9,null)

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(25, 9, 23, "АБС Плюс Банк - 20 лет внутренней разработки", "В докладе я продемонстрирую, что такое банковский софт на самом деле. Немного расскажу об архитектуре, принципах построения и стиле разработки одной из тех не многих автоматизированных банковских систем созданной внутри банка, и до сих пор не выведенной из эксплуатации. Постараюсь рассказать о причинах успеха, почему это все до сих пор работает и во многом устраивает пользователей. Покажу что реально важно, а что нет в условиях боевой эксплуатации. Осторожно, это банковский софт. Доклад не рекомендуется к прослушиванию школьниками, студентами и лицами с неустойчивыми вкусами к архитектуре ПО. 18+ only", null, '//player.vimeo.com/video/71747317', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(26, 9, 24, "Как автоматизировать тестирование web-приложения с использованием Selenium WebDriver (Java)", null, null, null, null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(27, 9, 25, "Start-up accelerator изнутри", "Впечатления и опыт прохождения через start-up accelerator LightningLab в качестве virtual CTO . LighningLab был построен по типу TechCrunch.", null,'//player.vimeo.com/video/71798655', null, null, null);

-- 8 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(8, 1, 8, 1373108400, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (22,'nikulin@gmail.com','111111','Анатолий','Никулин','nikulin@gmail.com',null,null,true,null,2,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(22, 8, 22, "BigData inside. Архитектурные изыскания в HBase", "Вы узнаете много всего про Hbase, примеры применения, отличные BigData кейсы и прочее. также будет затронут Hadoop.", null, '//player.vimeo.com/video/71227795', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(23, 8, 10, "житейским опытом приготовления Cassandra", "Он после долги уговоров решил приоткрыть завесу над вопросом - \"а зачем она вообще нужна?\")))", null, '//player.vimeo.com/video/71227796', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(24, 8, 2, "Javascript - библиотека под Android и iOS", "Он пожалуется вам на судьбу, которая столкнула его с задачей портирования одной Javascript - библиотеки под Android и iOS", null, '//player.vimeo.com/video/71227794', null, null, null);

-- 7 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(7, 7, 7, 1370080800, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (20,'korovianski@gmail.com','111111','Алексей', 'Коровянский','korovianski@gmail.com',null,null,true,null,10,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (21,'lifar@gmail.com','111111','Дмитрий','Лыфарь','lifar@gmail.com','Соучредитель',null,true,null,9,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(20, 7, 20, "Google I/O туда и обратно.", "Рассказ лидеров GDG Omsk о поездке на Google I/O в Сан-Франциско. Вы узнаете, насколько сложно попасть в Силиконовую долину, что такое GDG -братство во всемирном масштабе, и как стучат сердца, когда Ларри Пейдж дарит благую весть о грядущем.", null, '//player.vimeo.com/video/67648961', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(21, 7, 21, "\"Другой\" outsource и production development", "ассказ об аутсорсе, которым занимается компания (C++ проекты), а также о попытках перейти на продуктовую разработку и что из этого получилось", null, '//player.vimeo.com/video/68193238', null, null, null);

-- 6 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(6, 1, 6, 1367661030, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (17,'dmitrieva@gmail.com','111111','Ксения', 'Дмитриева','korovianski@gmail.com','Консультант по безопасности',null,true,null,11,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (18,'korsakov@gmail.com','111111','Сергей', 'Корсаков','korsakov@gmail.com','PM',null,true,null,12,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (19,'gerasimovich@gmail.com','111111','Юлия', 'Герасимович','gerasemovich@gmail.com','Владелец',null,true,null,13,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(18, 6, 17, "HTML5: взлом и защита", "С появлением HTML5 веб приложения становятся все более интерактивными и все больше приближаются к обычным desktop-приложениям. Но с новыми технологиями приходят новые \"дырки\" и способы взлома. Как можно эксплойтить такие нововведения, как Cross-Origin Resource Sharing, Web Messaging, Web Storage и iframe sandboxing? Как правильно защитить свой код от новых уязвимостей? Об этом я расскажу и покажу в своем докладе.", null, '//player.vimeo.com/video/65577228', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(19, 6, 18, "Ток-шоу про Фак-апы", "Не так давно в Санкт-Петербурге проходила конференция \"План Б\", посвященная фак-апам. В рамках сего мероприятия было проведено шоу про фак-апы: http://tech.yandex.ru/events/planb/spb-feb-2013/talks/514/ Получилось очень здорово и я хотел бы рассказать о нескольких фак-апах из своей жизни, а потом поговорить с аудиторией про те факапы, которые случались с ними. Конечно, это будет не просто разговор, а попытка понять, что было сделано не так и какие выводы из всего этого можно вынести.", null, null, null, null, null);


-- 5 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(5, 1, 5, 1365241830, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (14,'unusov@gmail.com','111111','Максим', 'Юнусов','unusov@gmail.com','Group Manager',null,true,null,7,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (16,'pavlova@gmail.com','111111','Ольга', 'Павлова','pavlova@gmail.com','Совладелец',null,true,null,18,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(15, 5, 14, "Архитектура в Agile проекте", "Разработка программного обеспечения, базирующаяся на архитектуре, и разработка программного обеспечения по методологии Agile концептуально несовместимые процессы. Однако, практика показывает, что создать качественный продукт без проработки архитектуры зачастую невозможно. Хотелось бы поделиться опытом внедрения архитектурных практик в Agile процесс, зафиксировав основные цели, активности и техники, используемые при этом.", null, '//player.vimeo.com/video/63959954', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(16, 5, 31, "HWdTech.DS - message-ortiented middleware", "В данном докладе будет рассказано об архитектуре и опыте внедрения собственной open-source распределенной системы серверов приложений. Будут рассмотрены программные решения, повышающие надежность системы, а также ключевые компоненты. В настоящий момент сервер внедряется в нескольких проектах, в том числе одном стартапе и одном высоконагруженном (1 млн. просмотров страниц в сутки) веб-сайте.", null,'//player.vimeo.com/video/63960098', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(17, 5, 16, "Тексты в интерфейсах", "Почему 37 важнее, чем 42? Как выглядит хорошо структурированная шизофрения? Почему импотенты любят уникальные предложения? Ну и другие речевые чудеса в нашем с вами интернет-пространстве. Разговор, как всегда, для менеджеров и сочувствующих", null, '//player.vimeo.com/video/64141660', null, null, null);

-- 4 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(4, 1, 4, 1365249234, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (12,'babienko@gmail.com','111111','Леонид', 'Бабиенко','babienko@gmail.com','Генеральный директор',null,true,null,15,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values (13,'pashkevich@gmail.com','111111','Дмитрий', 'Пашкевич','pashkevich@gmail.com','Директор',null,true,null,2,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(12, 4, 12, "Активы веб-студии", "В рамках доклада рассматривается внутренняя кухня компании: работа с персоналом, деньгами и проектами. Путь от маленькой веб-студии до международной группы компаний. Адресован руководителям студий и компаний, ищущих путь к успеху.", null, '//player.vimeo.com/video/60981594', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(13, 4, 13, "Код на стероидах", "К чему приводит необоснованное наращивание функционала и сложности программной системы? Рассмотрим работу принципов KISS, YAGNI, \"Lean Startup\" и прочих методов и подходов к производству диетических программных продуктов. Адресован в первую очередь разработчикам и во вторую - им же.", null, '//player.vimeo.com/video/60981593', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(14, 4, 1, "Принцип YAGNI в управлении проектами", "Почему управление проектом может быть делом всей команды, как можно избежать срывов сроков и сверхурочной работы. Доклад адресован разработчикам может быть даже больше, чем менеджерам.", null, '//player.vimeo.com/video/61078434', null, null, null);

-- 3 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(3, 1, 3, 1359798630, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values(8,'susikov@gmail.com','111111','Сергей', 'Сусиков','susikov@gmail.com','self-employed',null,true,null,null,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values(9,'nelubin@gmail.com','111111','Денис', 'Нелюбин','nelubin@gmail.com',null,null,true,null,2,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values(11,'nepomnashih@gmail.com','111111','Антон', 'Непомнящих','nepomnashih@gmail.com',null,null,true,null,17,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(8, 3, 8, "Прокладка между софтом и железом", "Виртуализация рулит. Зачем нужна виртуализация и как она делает людей счастливыми. Гипервизор, VMWare, VirtualBox, Xen, прикладной аспект.", null, '//player.vimeo.com/video/58810809', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(9, 3, 9, "Почему NoSQL", "Ответы на вопросы: Что такое NoSQL? Почему он возник? Зачем и когда он нужен?", null, '//player.vimeo.com/video/58810811', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(10, 3, 10, "Полнотекстовый поиск с Elasticsearch", "Рассмотрим базовые основы полнотекстового поиска. Основы непосредственно Elasticsearch. Небольшой рассказ о том что мы планируем делать с Elasticsearch у себя в компании.", null, '//player.vimeo.com/video/59063666', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(11, 3, 11, "Распределение человеческих ресурсов по проектам без простоев и скамейки запасных", "Доклад для тех, кто руководит менеджерами проектов и распределяет ресурсы по проектам: - как решить проблему распределения ресурсов между проектами. - сколько надо народу в фирме. - зачем нужно специализироваться на одной технологии, а не хвататься за все подряд.", null, '<//player.vimeo.com/video/59063669', null, null, null);

-- 2 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(2, 1, 2, 1357379430, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values(4,'mittova@gmail.com','111111','Юлия', 'Миттова','mittova@gmail.com',null,null,true,null,3,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values(5,'omelnicki@gmail.com','111111','Александр', 'Омельницкий','omelnicki@gmail.com',null,null,true,null,16,null);
insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values(7,'evdokimov@gmail.com','111111','Леонид', 'Евдокимов','evdokimov@gmail.com','Разработчик систем мониторинга',null,true,null,12,null);

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(4, 2, 4, "Тестировании мобильных приложений", "Здравствуйте! Меня зовут Миттова Юлия. Для всех, кто выжил после празднования Нового Года и конца света, буду рада рассказать о тестировании мобильных приложений.", null, '//player.vimeo.com/video/57376847', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(5, 2, 5, "Типографика для не дизайнеров", "1. Что такое типографика? 2. Почему программисту надо быть немного дизайнером? 3. Макро- микро- типографика 4. Использование модульных сеток 5. Простые правила микротипографики", null, '//player.vimeo.com/video/56818661"', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(6, 2, 18, "Онлайн обучение.", "- для чего обучаться - где обучаться - как много занимает он-лайн обучение", null, '//player.vimeo.com/video/56818663', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(7, 2, 7, "Web-scale. Взорвётся всё.", "Я хочу рассказать о некотором числе неприятных и не всегда очевидных особенностей инструментов, которые мы эксплуатируем ежедневно: MySQL, MongoDB, Python, Linux & FreeBSD.", null, '//player.vimeo.com/video/56818662', null, null, null);

-- 1 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(1, 1, 1, 1354355430, false);

insert into user(id, login, password, first_name, second_name, email, job_position, confirmation_token, enabled, photo, company_id, self_description) values(3,'beisenov@gmail.com','111111','Серик', 'Бейсенов','beisenov@gmail.com',null,null,true,null,7,null)

insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(1, 1, 1, "Про ИТ-экосистему Омска, энтузиастов, сообщества и конференции", "В докладе будет сделана попытка классификации компаний Омска и причин ее неполноты, тенденций упадка последних лет и наметившегося перелома в этом направлении, призыв к действию и указание конкретных точек приложения сил.", null, '//player.vimeo.com/video/54912917', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(2, 1, 2, "MyBatis & Hibernate, давайте жить дружно", "Очень часто разработчики находят себе кумира в виде одной ORM, забывая о том, что самое важное - удобно работать с данными, поддерживать DAO - слой. В докладе изложен способ применения на одном проекте двух ORM с различной идеологией и предложен способ оптимального разграничения сфер ответственности между двумя подходами доступа к данным.", null, '//player.vimeo.com/video/55367423', null, null, null);
insert into `report`(id, conference_id, user_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(3, 1, 3, "Разгрузочный доклад о нагрузочном тестировании", "Вот моменты, которые Серик затронет в своем докладе: - Зачем вообще нужно нагрузочное тестирование - Как подготовить систему к нагрузочному тестированию - Какие тулзы использовать и как - Какие метрики снимать - Как их анализировать - Как часто повторять тестирование - С какими результатами можно быть уверенным, что система не упадет", null, '//player.vimeo.com/video/55835122', null, null, null);