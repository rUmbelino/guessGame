# GuessGame

GuessGame is a game capable of guess what food the player is thinking, asking questions about the food's charachteristics. 
When its not possible to find out, the user is asked to inform about the name and charachterisct of the food, the new plate is stored, teaching the game about a new plate.
The game was developed using a [decision tree](https://en.wikipedia.org/wiki/Decision_tree) in java.

# Requirements
Have Java 8 installed on the machine with the [enviroment variable JAVA_HOME](https://confluence.atlassian.com/confbr1/configurando-a-variavel-java_home-no-windows-933709538.html) configured.

# Overview

This project was build using [gradle](https://gradle.org/). Find below the main project commands:

- gradlew test
  - Run unitary tests
- gradlew run
  - Start the project
- gradlew launch4j
  - Generate build with .exe
