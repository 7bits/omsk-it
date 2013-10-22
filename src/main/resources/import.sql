insert into `company`(id, name, site, location) values(1, "7bits", "http://7bits.it/", null);
insert into `company`(id, name, site, location) values(2, "Luxoft", "http://www.luxoft.ru/", null);
insert into `company`(id, name, site, location) values(3, "Thumbtack", "http://thumbtack.ru/", null);

insert into `conference`(id, company_id, ordinal_number, date) values(1, 2, 10, 1378562400);

insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(1, 3, "Алексей", "Зиновьев", null, null, null, "Программист", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(2, 2, "Сергей", "Назаренко", null, null, null, "Project manager", null);
insert into `reporter`(id, company_id, first_name, second_name, email, photo, self_description, job_position, speech_experience) values(3, 1, "Анна", "Тарасенко", null, null, null, "Руководитель", null);

insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(1, 1, 1, "ALMADA-2013 или самый простой способ пожить в общаге МГУ", "Итоги Microsoft School on ALgorithms for MAssive DAta (ALMADA). Свежие алгоритмы BigData. Внутренняя кухня подразделения Microsoft Research. Заметки о Computer Science.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(2, 1, 2, "Почему они мне не подчиняются?", "Возможно, некоторые и вас, на заре своей карьеры попадали в ситуацию, когда при завершении задачи оказывалось, что результат не соответствует ожиданиям начальства, заказчика или коллег. В данном докладе, в интерактивном формате, докладчик и аудитория попробуют проанализировать возможные причины таких ситуаций, и выработать практические рекомендации на каждый день.", null, null, null, null, null);
insert into `report`(id, conference_id, reporter_id, title, description, presentation, video, other_conferences, key_technologies, reporter_wishes) values(3, 1, 3, "Выращиваем разработчиков с нуля. Опыт летней стажировки-2013", "Докладчик расскажет о программе стажировки в компании 7bits летом 2013 года, в которой участвовали разработчики и дизайнеры. Поделится программой, успехами и неудачами. Докладчик надеется на обратную связь слушателей, чтобы сделать следующую стажировку еще лучше.", null, null, null, null, null);
