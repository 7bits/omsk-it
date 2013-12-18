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
INSERT INTO user (login, password) VALUES ('moder', '111111'), ('adm', '222222');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2), (2, 1);

-- 13 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(13, 1, 13, 1388833200, true);

-- 12 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(12, 1, 12, 1383994800, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(10, 3, "Дмитрий", "Голушко", null, "dgolushko.png", null, "Java Developer", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(30, 4, "Александр", "Самолов", null, "nophoto.png", null, "Технический директор", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(31, 5, "Евгений", "Тюменцев", null, "nophoto.png", null, "Управляющий партнер компании “Тик-Так Коуч”", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(34, 12, 10, "Впечатления от Grails после одного проекта", "Впечатления по большей части положительные. Давно искал web-фреймворк на Java, который можно было бы использовать без кучи xml конфигов, без необходимости прочесть ВСЮ документацию. Я пробовал ASP.NET MVC 4. Круто. Можно писать просто, но чтобы сделать что-то более-менее сложное, приходится извращаться. Опять же Entity Framework, который в неумелых руках превращается в монстра. Короче, как говорится, не зашло. А Grails можно взять и работать. Это отличный инструмент, который позволяет делать практически всё что нужно. Более того, радует что \"под капотом\" у него Spring и Hibernate, которые однако скрыты более простыми и удобными собственными инструментами Grails. Одним словом слоган на сайте Grails \"The search is over\" оказался для меня верным.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(35, 12, 30, "Фреймворки - сладкое зло, или почему я не люблю использовать фреймворки", "Я не хочу устраивать \"холиварный\" доклад, но хочу поделиться своим мнением почему я не люблю фреймворки и с нежностью отношусь к \"велосипедам\". Хочу рассказать про те факапы, которые я поимел, используя веб фреймворки в java и аргументированно рассказать о профитах, если использовать что-то свое.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(36, 12, 31, "HWdTech.DS - message-oriented middleware, продолжение", "Евгений ответит на вопрос, заданный на 1-й части доклада: \"Почему не Erlang?\" Средства управления платформой: ServiceManager Библиотека сервисов Управление конфигурацией Взаимозаменяемость компонентов", null, null, null, null, null);

-- 11 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(11, 1, 11, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(27, 2, " Екатерина", "Боброва", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(28, 6, "Алексей", "Родионов", null, "nophoto.png", null, null, null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(31, 11, 27, "Обзор фреймворка Thucydides", "Обзор основанного на Selenuim фреймворка Thucydides. Он предназначен для написания тестов, имитирующих действия пользователя в браузере, и построения отчетов по их прохождению. Сейчас Thucydides - активно развивающийся open source проект, поддерживающий основные браузеры, параллельный запуск тестов, параметризацию тестов.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(32, 11, 28, "Как мы делали свой Travis CI: Vagrant + KVM", "Автор расскажет, как его команда построила гибкую VM-based систему непрерывной интеграции с помощью Vagrant и Linux KVM.", null, null, null, null, null);

-- 10 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(10, 7, 10, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(2, 2, "Алексей", "Зиновьев", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(26, 7, "Сергей", "Назаренко", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(1, 1, "Анна", "Тарасенко", null, "nophoto.png", null, "директор", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(28, 10, 2, "ALMADA-2013 или самый простой способ пожить в общаге МГУ", "Итоги Microsoft School on ALgorithms for MAssive DAta (ALMADA). Свежие алгоритмы BigData. Внутренняя кухня подразделения Microsoft Research. Заметки о Computer Science.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(29, 10, 26, "Почему они мне не подчиняются?", "Возможно, некоторые из вас, на заре своей карьеры попадали в ситуацию, когда при завершении задачи оказывалось, что результат не соответствует ожиданиям начальства, заказчика или коллег. В данном докладе, в интерактивном формате, докладчик и аудитория попробуют проанализировать возможные причины таких ситуаций, и выработать практические рекомендации на каждый день.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(30, 10, 1, "Выращиваем разработчиков с нуля. Опыт летней стажировки-2013", "Докладчик расскажет о программе стажировки в компании 7bits летом 2013 года, в которой участвовали разработчики и дизайнеры. Поделится программой, успехами и неудачами. Докладчик надеется на обратную связь слушателей, чтобы сделать следующую стажировку еще лучше.", null, null, null, null, null);	

-- 9 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(9, 1, 9, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(23, 8, "Михаил", "Подгурский", null, "nophoto.png", null, "начальник отдела банковских систем УБСДИТ", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(24, 2, "Александр", "Шиповалов", null, "nophoto.png", null, "инженер по тестированию", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(25, 9, "Роман", "Кудияров", null, "nophoto.png", null, "Соучредитель", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(25, 9, 23, "АБС Плюс Банк - 20 лет внутренней разработки", "В докладе я продемонстрирую, что такое банковский софт на самом деле. Немного расскажу об архитектуре, принципах построения и стиле разработки одной из тех не многих автоматизированных банковских систем созданной внутри банка, и до сих пор не выведенной из эксплуатации. Постараюсь рассказать о причинах успеха, почему это все до сих пор работает и во многом устраивает пользователей. Покажу что реально важно, а что нет в условиях боевой эксплуатации. Осторожно, это банковский софт. Доклад не рекомендуется к прослушиванию школьниками, студентами и лицами с неустойчивыми вкусами к архитектуре ПО. 18+ only", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(26, 9, 24, "Как автоматизировать тестирование web-приложения с использованием Selenium WebDriver (Java)", null, null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(27, 9, 25, "Start-up accelerator изнутри", "Впечатления и опыт прохождения через start-up accelerator LightningLab в качестве virtual CTO . LighningLab был построен по типу TechCrunch.", null, null, null, null, null);	

-- 8 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(8, 1, 8, 1373108400, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(22, 2, "Анатолий", "Никулин", null, "nophoto.png", null, null, null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(22, 8, 22, "BigData inside. Архитектурные изыскания в HBase", "Вы узнаете много всего про Hbase, примеры применения, отличные BigData кейсы и прочее. также будет затронут Hadoop.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(23, 8, 10, "житейским опытом приготовления Cassandra", "Он после долги уговоров решил приоткрыть завесу над вопросом - \"а зачем она вообще нужна?\")))", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(24, 8, 2, "Javascript - библиотека под Android и iOS", "Он пожалуется вам на судьбу, которая столкнула его с задачей портирования одной Javascript - библиотеки под Android и iOS", null, null, null, null, null);	

-- 7 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(7, 7, 7, 1370080800, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(20, 10, "Алексей", "Коровянский", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(21, 9, "Дмитрий", "Лыфарь", null, "nophoto.png", null, "соучредитель", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(20, 7, 20, "Google I/O туда и обратно.", "Рассказ лидеров GDG Omsk о поездке на Google I/O в Сан-Франциско. Вы узнаете, насколько сложно попасть в Силиконовую долину, что такое GDG -братство во всемирном масштабе, и как стучат сердца, когда Ларри Пейдж дарит благую весть о грядущем.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(21, 7, 21, "\"Другой\" outsource и production development", "ассказ об аутсорсе, которым занимается компания (C++ проекты), а также о попытках перейти на продуктовую разработку и что из этого получилось", null, null, null, null, null);

-- 6 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(6, 1, 6, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(17, 11, "Ксения", "Дмитриева", null, "nophoto.png", null, "консультант по безопасности", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(18, 12, "Сергей", "Корсаков", null, "nophoto.png", null, "PM", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(19, 13, "Юлия", "Герасимович", null, "nophoto.png", null, "Владелец", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(18, 6, 17, "HTML5: взлом и защита", "С появлением HTML5 веб приложения становятся все более интерактивными и все больше приближаются к обычным desktop-приложениям. Но с новыми технологиями приходят новые \"дырки\" и способы взлома. Как можно эксплойтить такие нововведения, как Cross-Origin Resource Sharing, Web Messaging, Web Storage и iframe sandboxing? Как правильно защитить свой код от новых уязвимостей? Об этом я расскажу и покажу в своем докладе.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(19, 6, 18, "Ток-шоу про Фак-апы", "Не так давно в Санкт-Петербурге проходила конференция \"План Б\", посвященная фак-апам. В рамках сего мероприятия было проведено шоу про фак-апы: http://tech.yandex.ru/events/planb/spb-feb-2013/talks/514/ Получилось очень здорово и я хотел бы рассказать о нескольких фак-апах из своей жизни, а потом поговорить с аудиторией про те факапы, которые случались с ними. Конечно, это будет не просто разговор, а попытка понять, что было сделано не так и какие выводы из всего этого можно вынести.", null, null, null, null, null);


-- 5 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(5, 1, 5, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(14, 7, "Максим", "Юнусов", null, "nophoto.png", null, "Group Manager", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(15, 14, "Евгений", "Тюменцев", null, "nophoto.png", null, "старший преподаватель", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(16, 18, "Ольга", "Павлова", null, "nophoto.png", null, "совладелец", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(15, 5, 14, "Архитектура в Agile проекте", "Разработка программного обеспечения, базирующаяся на архитектуре, и разработка программного обеспечения по методологии Agile концептуально несовместимые процессы. Однако, практика показывает, что создать качественный продукт без проработки архитектуры зачастую невозможно. Хотелось бы поделиться опытом внедрения архитектурных практик в Agile процесс, зафиксировав основные цели, активности и техники, используемые при этом.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(16, 5, 15, "HWdTech.DS - message-ortiented middleware", "В данном докладе будет рассказано об архитектуре и опыте внедрения собственной open-source распределенной системы серверов приложений. Будут рассмотрены программные решения, повышающие надежность системы, а также ключевые компоненты. В настоящий момент сервер внедряется в нескольких проектах, в том числе одном стартапе и одном высоконагруженном (1 млн. просмотров страниц в сутки) веб-сайте.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(17, 5, 16, "Тексты в интерфейсах", "Почему 37 важнее, чем 42? Как выглядит хорошо структурированная шизофрения? Почему импотенты любят уникальные предложения? Ну и другие речевые чудеса в нашем с вами интернет-пространстве. Разговор, как всегда, для менеджеров и сочувствующих", null, null, null, null, null);

-- 4 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(4, 1, 4, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(12, 15, "Леонид", "Бабиенко", null, "nophoto.png", null, "генеральный директор", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(13, 2, "Дмитрий", "Пашкевич", null, "nophoto.png", null, "директор", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(12, 4, 12, "Активы веб-студии", "В рамках доклада рассматривается внутренняя кухня компании: работа с персоналом, деньгами и проектами. Путь от маленькой веб-студии до международной группы компаний. Адресован руководителям студий и компаний, ищущих путь к успеху.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(13, 4, 13, "Код на стероидах", "К чему приводит необоснованное наращивание функционала и сложности программной системы? Рассмотрим работу принципов KISS, YAGNI, \"Lean Startup\" и прочих методов и подходов к производству диетических программных продуктов. Адресован в первую очередь разработчикам и во вторую - им же.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(14, 4, 1, "Принцип YAGNI в управлении проектами", "Почему управление проектом может быть делом всей команды, как можно избежать срывов сроков и сверхурочной работы. Доклад адресован разработчикам может быть даже больше, чем менеджерам.", null, null, null, null, null);

-- 3 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(3, 1, 3, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(8, null, "Сергей", "Сусиков", null, "nophoto.png", null, "self-employed", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(9, 2, "Денис", "Нелюбин", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(11, 17, "Антон", "Непомнящих", null, "nophoto.png", null, null, null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(8, 3, 8, "Прокладка между софтом и железом", "Виртуализация рулит. Зачем нужна виртуализация и как она делает людей счастливыми. Гипервизор, VMWare, VirtualBox, Xen, прикладной аспект.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(9, 3, 9, "Почему NoSQL", "Ответы на вопросы: Что такое NoSQL? Почему он возник? Зачем и когда он нужен?", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(10, 3, 10, "Полнотекстовый поиск с Elasticsearch", "Рассмотрим базовые основы полнотекстового поиска. Основы непосредственно Elasticsearch. Небольшой рассказ о том что мы планируем делать с Elasticsearch у себя в компании.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(11, 3, 11, "Распределение человеческих ресурсов по проектам без простоев и скамейки запасных", "Доклад для тех, кто руководит менеджерами проектов и распределяет ресурсы по проектам: - как решить проблему распределения ресурсов между проектами. - сколько надо народу в фирме. - зачем нужно специализироваться на одной технологии, а не хвататься за все подряд.", null, null, null, null, null);

-- 2 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(2, 1, 2, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(4, null, "Юлия", "Миттова", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(5, 16, "Александр", "Омельницкий", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(6, null, "Сергей", "Корсаков", null, "nophoto.png", null, null, null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(7, 12, "Леонид", "Евдокимов", null, "nophoto.png", null, "Разработчик систем мониторинга", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(4, 2, 4, "Тестировании мобильных приложений", "Здравствуйте! Меня зовут Миттова Юлия. Для всех, кто выжил после празднования Нового Года и конца света, буду рада рассказать о тестировании мобильных приложений.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(5, 2, 5, "Типографика для не дизайнеров", "1. Что такое типографика? 2. Почему программисту надо быть немного дизайнером? 3. Макро- микро- типографика 4. Использование модульных сеток 5. Простые правила микротипографики", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(6, 2, 6, "Онлайн обучение.", "- для чего обучаться - где обучаться - как много занимает он-лайн обучение", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(7, 2, 7, "Web-scale. Взорвётся всё.", "Я хочу рассказать о некотором числе неприятных и не всегда очевидных особенностей инструментов, которые мы эксплуатируем ежедневно: MySQL, MongoDB, Python, Linux & FreeBSD.", null, null, null, null, null);

-- 1 IT-субботник
insert into `conference`(id, company_id, ordinal_number, date, registration) values(1, 1, 1, 0000, false);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(3, 7, "Серик", "Бейсенов", null, "nophoto.png", null, null, null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(1, 1, 1, "Про ИТ-экосистему Омска, энтузиастов, сообщества и конференции", "В докладе будет сделана попытка классификации компаний Омска и причин ее неполноты, тенденций упадка последних лет и наметившегося перелома в этом направлении, призыв к действию и указание конкретных точек приложения сил.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(2, 1, 2, "MyBatis & Hibernate, давайте жить дружно", "Очень часто разработчики находят себе кумира в виде одной ORM, забывая о том, что самое важное - удобно работать с данными, поддерживать DAO - слой. В докладе изложен способ применения на одном проекте двух ORM с различной идеологией и предложен способ оптимального разграничения сфер ответственности между двумя подходами доступа к данным.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(3, 1, 3, "Разгрузочный доклад о нагрузочном тестировании", "Вот моменты, которые Серик затронет в своем докладе: - Зачем вообще нужно нагрузочное тестирование - Как подготовить систему к нагрузочному тестированию - Какие тулзы использовать и как - Какие метрики снимать - Как их анализировать - Как часто повторять тестирование - С какими результатами можно быть уверенным, что система не упадет", null, null, null, null, null);