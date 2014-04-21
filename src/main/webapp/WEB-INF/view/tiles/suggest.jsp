<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <div class="content">
     <div class="page">
         <div class="text-content-up">
             Если Вы хотите услышать доклад по определенной теме, но не знаете, кто мог бы об этом рассказать, предложите тему.  Мы не обещаем, что удовлетворим абсолютно все заявки, но это позволит нам понять, чего хочет аудитория, и учесть это.
         </div>
         <div class="box">
             <h1 class="title">
                 Предложить тему доклада
             </h1>
             <form class="js-suggestion-form form-content" action='<c:url value="/suggest"/>' method="POST">
                 <div class="form-info">
                     Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                 </div>
                 <div class="field">
                     <span class="left-label top-label" >Какова Ваша основная специализация?<span class="attention">*</span></span>
                     <br>
                     <input type="checkbox" name="senderSpecialization" value="Разработчик">Разработчик<br>
                     <input type="checkbox" name="senderSpecialization" value="Менеджер">Менеджер<br>
                     <input type="checkbox" name="senderSpecialization" value="Дизайнер">Дизайнер<br>
                     <input type="checkbox" name="senderSpecialization" value="Верстальщик">Верстальщик<br>
                     <input type="checkbox" name="senderSpecialization" value="Тестировщик">Тестировщик (инженер по качеству)<br>
                     <input type="checkbox" name="senderSpecialization" value="other">Другое:
                     <input class="js-sender-specialization-other-input js-input small-input" type="text" name="senderSpecializationOther">
                     <span class="js-field-response js-senderSpecialization-response attention"></span>
                     <span class="js-field-response js-senderSpecializationOther-response attention"></span>
                 </div>
                 <div class="field ">
                     <span class="left-label top-label">По каким темам Вы хотели бы получать дополнительную информацию в виде докладов на ИТ-субботнике?<span class="attention">*</span></span>
                     <br>
                     <input type="checkbox" name="favoriteTheme" value="Технологии и веб-разработка">Технологии и веб-разработка<br>
                     <input type="checkbox" name="favoriteTheme" value="Базы данных">Базы данных<br>
                     <input type="checkbox" name="favoriteTheme" value="iOS-разработка">iOS-разработка<br>
                     <input type="checkbox" name="favoriteTheme" value="Разработка под Android">Разработка под Android<br>
                     <input type="checkbox" name="favoriteTheme" value="Фронтенд (верстка, JS)">Фронтенд (верстка, JS)<br>
                     <input type="checkbox" name="favoriteTheme" value="Разработка десктопных приложений">Разработка десктопных приложений<br>
                     <input type="checkbox" name="favoriteTheme" value="Проектирование интерфейсов">Проектирование интерфейсов<br>
                     <input type="checkbox" name="favoriteTheme" value="Дизайн">Дизайн<br>
                     <input type="checkbox" name="favoriteTheme" value="Автоматизированное, нагрузочное и другие виды тестирования">Автоматизированное, нагрузочное и другие виды тестирования<br>
                     <input type="checkbox" name="favoriteTheme" value="Высоконагруженные приложения">Высоконагруженные приложения<br>
                     <input type="checkbox" name="favoriteTheme" value="Управление проектами (процессы)">Управление проектами (процессы)<br>
                     <input type="checkbox" name="favoriteTheme" value="Управление людьми">Управление людьми<br>
                     <input type="checkbox" name="favoriteTheme" value="other">Другое:
                     <input class ="js-sender-favorite-theme-input js-input small-input" type="text" name="favoriteThemeOther">
                     <span class="js-field-response js-favoriteTheme-response attention"></span>
                     <span class="js-field-response js-favoriteThemeOther-response attention"></span>
                 </div>
                 <div class="field">
                     <span class="top-label">По какой теме Вы хотели бы услышать доклад в ближайшее время?</span>
                     <span class="field-info long-info">
                         <span class="js-field-response js-description-response attention"></span>
                         <span class="js-field-info">Пожалуйста, укажите одну тему, у Вас всегда есть возможность заполнить эту форму еще раз</span>
                     </span>
                     <br>
                     <textarea class="small-input wide-input big-input" name="themeRequest"></textarea>
                     <span class="js-field-response js-themeRequest-respons attentione"></span>
                 </div>
                 <div class="field">
                      <span class="top-label">Кого Вы хотели бы услышать на ИТ-субботнике в качестве докладчика?</span>
                      <span class="field-info long-info">
                          <span class="js-field-response js-description-response attention"></span>
                          <span class="js-field-info">Укажите фамилию, имя и место работы - все, что знаете. Расскажите нам о человеке, даже если Вы не знаете конкретной темы, но уверены, что это хороший докладчик.</span>
                      </span>
                      <br>
                      <textarea class="small-input wide-input big-input" name="reporterRequest"></textarea>
                      <span class="js-field-response js-reporterRequest-respons attentione"></span>
                  </div>
                 <div class="field">
                     <input class="js-suggestion-form-button button-submit" type="submit" value="Отправить">
                     <div class="js-suggest-response"></div>
                 </div>
             </form>
         </div>
     </div>
 </div>