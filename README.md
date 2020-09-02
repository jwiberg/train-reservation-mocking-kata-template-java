# train-reservation-mocking-kata-template-java
Template for practicing mocking, integration and testing unit testing when integrating to background services with Java.

## Prerequisites
* Java 8+
* Gradle 6+
* Some code editor (IDE) like IntelliJ IDEA or Eclipse

## Command line stuff
* `./gradlew openIdea`
    * Opens project in IntelliJ IDEA and creates local configuraition
* `.gradle run --args="express_2000 2"` 
    * Runs command line version of this app
* Check gradle documentation [here](https://docs.gradle.org/current/userguide/userguide.html)
    * `gradle build, gradle compile, gradle test` etc.

# Libraries
* [Unirest](http://kong.github.io/unirest-java/)
* [Junit Jupiter](https://junit.org/junit5/docs/current/user-guide/)
* [Mockito](https://site.mockito.org/)

# Features, tests to implement
* Unit tests for reservation service (like validations), use mocks
* Train listing (this might need changes to background services)
* Unhappy paths, technical and business errors
* Are there some problems with test services? How can we avoid them?
* Something else?
