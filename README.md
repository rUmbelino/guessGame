# GuessGame

GuessGame is a game capable of guessing what food the player is thinking of, asking questions about the food. 
When it's not possible to find out the user is asked to inform about the name and charachterisct of the food, the new plate is stored, teaching the game about a new plate.
The game was developed using a [decision tree](https://en.wikipedia.org/wiki/Decision_tree) in java.

# Requirements
Have Java Runtime Enviroment 1.8 installed on the machine with the [JAVA_HOME](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html) enviroment variable configured.

# Overview

This project was build using [gradle](https://gradle.org/). Find below the main project commands:

- gradlew test
  - Run unitary tests
- gradlew run
  - Start the project
- gradlew launch4j
  - Generate build with .exe
