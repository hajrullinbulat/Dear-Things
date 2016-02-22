Для сборки проекта необходимо иметь установленные Java 7 или старше, Apache Maven.
Должны быть прописаны JAVA_HOME и M2_HOME.
 
## Markdown
Для просмотра файла в отформатированном состоянии можно скачать плагин для idea `markdown`.
 
## Модули проекте
* core - модуль для общих классов и запросов к БД
* mailing - модуль для рассылки оповещений
* private - админка сайта
* public - публичная часть сайта, открытая пользователю

## Личный профиль разработчика
В корневом pom.xml файле должны быть прописаны настройки разработчика:

         <profile>
             <id>kamil-dev</id>
             <properties>
                 <tomcatHome>C:/Java/apache-tomcat-8.0.14</tomcatHome>
             </properties>
         </profile>
где tomcatHome указывает на корневую папку Tomcat.

Далее необходимо создать свою конфигурацию Maven для сборки проекта (рассмотрим на примере модуля `public`):

1. полный путь до корневой папки проекта `tutors`
2. команды для Maven `clean package cargo:redeploy`
3. подключаемые профили `kamil-dev public`

## Локальный стенд
* Запускаем Maven команду, описанную выше, она закинет все необходимые .war файлы в `${tomcatHome}/webapps`.
* Запускаем tomcat через команды `catalina jpda start` или `catalina jpda run` (для возможности дебага).
* Теперь можем просмотреть результат в браузере по адресу `http://localhost:8080/{название модуля}`.

## Git
[Работа с Git репозиториями](http://dev.call2ru.com/vs/%D0%A0%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%20%D1%81%20Git.pdf)

## Freemarker
* [FreeMarker Manual](http://freemarker.sourceforge.net/docs/)
* [Использование macro](http://freemarker.sourceforge.net/docs/ref_directive_macro.html)

## .bat файлы
  Файлы из ./etc/bat/ положить в корневую папку Tomcat.
  
* `clean.bat` - очищает старые логи, рабочие файлы, собранные проекты
* `start_tomcat.bat` - очищает и запускает Tomcat
