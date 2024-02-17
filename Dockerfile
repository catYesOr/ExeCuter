# Используйте официальный образ базового слоя Java
FROM openjdk:11-jdk-slim as build

# Установите рабочую директорию внутри контейнера
WORKDIR /app

# Скопируйте ваш сборочный файл .jar в контейнер
COPY target/*.jar app.jar

# Укажите команду для запуска вашего приложения
ENTRYPOINT ["java","-jar","app.jar"]
