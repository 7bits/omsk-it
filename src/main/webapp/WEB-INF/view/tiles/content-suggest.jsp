<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <div class="content">
     <div class="page">
         <div class="about">
             Если Вы хотите услышать доклад по определенной теме, но не знаете, кто мог бы об этом рассказать, предложите тему.  Мы не обещаем, что удовлетворим абсолютно все заявки, но это позволит нам понять, чего хочет аудитория, и учесть это.
         </div>
         <div class="apply-form">
             <div class="title">
                 Предложить тему доклада
             </div>
             <div class="form-content">
                 <form class="js-suggestion-form suggestion-form" action='<c:url value="/suggest"/>' method="POST">
                     <div class="info">
                         Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                     </div>
                     <div class="field">
                         <span class="top-label" >Какова Ваша основная специализация?<span class="attention">*</span></span>
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
                     <div class="field">
                         <span class="top-label">По каким темам Вы хотели бы получать дополнительную информацию в виде докладов на ИТ-субботнике?<span class="attention">*</span></span>
                         <input type="checkbox" name="favoriteTheme" value="Технологии и веб-разработка">Технологии и веб-разработка<br>
                         <input type="checkbox" name="favoriteTheme" value="Базы данных">Базы данных<br>
                         <input type="checkbox" name="favoriteTheme" value="iOS-разработка">iOS-разработка<br>
                         <input type="checkbox" name="favoriteTheme" value="Разработка под Android">Разработка под Android<br>
                         <input type="checkbox" name="favoriteTheme" value="Тестировщик">...<br>
                         <input type="checkbox" name="favoriteTheme" value="other">Другое:
                         <input class ="js-sender-favorite-theme-input js-input small-input" type="text" name="favoriteThemeOther">
                         <span class="js-field-response js-favoriteTheme-response attention"></span>
                         <span class="js-field-response js-favoriteThemeOther-response attention"></span>
                     </div>
                     <div class="field">
                         <span class="top-label">По какой теме Вы хотели бы услышать доклад в ближайшее время?</span>
                         <textarea class="big-input" name="themeRequest" placeholder="Пожалуйста, укажите одну тему, у Вас всегда есть возможность заполнить эту форму еще раз"></textarea>
                         <span class="js-field-response js-themeRequest-respons attentione"></span>
                     </div>
                     <div class="field">
                         <input class="js-suggestion-form-button submit-button" type="submit" value="Отправить">
                         <div class="js-suggest-response"></div>
                     </div>
                 </form>
             </div>
         </div>
     </div>
 </div>