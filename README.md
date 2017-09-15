# ref-app-0008

# Features
    * Prediction IO Docker Instance
    * Reference Application: Spring Boot, Rest, GoogleAppEngine

# Environment

OS Used for Development: Ubuntu17.04
IDE Used for Development: IntelliJ
Java: OpenJDK1.8

Application can be deployed to google cloud.

# Issue # 1

With IntelliJ you could get the following error

Caused by: org.springframework.context.ApplicationContextException: Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.

# Resolution # 1

Most likely you provided an incorrect argument - Application.class.

SpringApplication.run(Application.class, args); 

# Reference

maven:
* package creation: mvn clean install package

* Universal Recommender: 
    ** https://predictionio.incubator.apache.org/install/install-sourcecode/
    ** https://hub.docker.com/r/g2crowd/apache-pio-full/~/dockerfile/
    
ndscheduler:
    * http://localhost:8888
    
# Unix Commands
    * grep -r -e token1 -e token2 -e token3 .

    