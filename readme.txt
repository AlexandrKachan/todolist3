Дипломный проект.
Приложение - Список дел. Используется  Spring Boot, Spring Security, Thymeleaf, Postgres.
- приложение по умолчанию доступно на http://localhost:8081/
- изменить настройки можно в файле application.properties

0. внести изменения в файлы application.properties, docker-compose
1 .\mvnw package
2. docker build --tag=todolist334:latest .
3. docker-compose up -d

чтобы удалить
 docker rmi todolist334 -f

