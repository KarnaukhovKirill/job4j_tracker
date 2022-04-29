# job4j_tracker

## О пректе
Проект для ведения учёта различных domain. В учебных целях tracker работает с 
[Item](https://github.com/KarnaukhovKirill/job4j_tracker/blob/master/src/main/java/ru/job4j/tracker/Item.java) в котором 
есть поле name и description. С моделью можно выполнять CRUD операции: создание, чтение, редактирование и удаление. Проект 
написан с применением ООП для возможности дальнейшего масштабирования.

![alt text](https://img.shields.io/badge/java-version%3E%3D11-green)
![alt text](https://img.shields.io/badge/maven-version%3E%3D5-blue)
![alt text](https://img.shields.io/badge/junit-version%3E%3D4-important)
![alt text](https://img.shields.io/badge/mockito-version%3E%3D3-orange)

## Запуск приложения ![alt text](https://badges.aleen42.com/src/java.svg)
Для запуска потребуется JRE 11-ой версии или старше
Скачиваем jar файл с репозитория
````
https://github.com/KarnaukhovKirill/job4j_tracker/raw/master/jar/Tracker.jar
````
Переходим в папку со скаченным файлом Tracker.jar, заходим в консоль и выполняем команду
````
java -jar Tracker.jar
````

## Запуск приложения в Docker ![alt text](https://badges.aleen42.com/src/docker.svg)
````
docker run --rm -it buzzerbitter/job4j_tracker:memTracker
````

## Как использовать
После запуска вы увидете меню

![alt text](https://github.com/KarnaukhovKirill/job4j_tracker/blob/master/img/1_Start.png)

Для выбора пункта меню используются цифры. После выбора пункта меню следуйте указаниям.

![alt text](https://github.com/KarnaukhovKirill/job4j_tracker/blob/master/img/2_CreateItem.png)

Для выхода из приложения пункт 7.

## Контакты
Есть вопросы по проекту? Свяжитесь со мной в [![alt text](https://badges.aleen42.com/src/telegram.svg)](https://t.me/Tur_Boyama)

Или пишите на почту: karnaukhov.kirill23@gmail.com

[![codecov](https://codecov.io/gh/KarnaukhovKirill/job4j_tracker/branch/master/graph/badge.svg)](https://codecov.io/gh/KarnaukhovKirill/job4j_tracker)

[![Build Status](https://travis-ci.com/KarnaukhovKirill/job4j_tracker.svg?branch=master)](https://travis-ci.com/KarnaukhovKirill/job4j_tracker)
