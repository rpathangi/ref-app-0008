# ref-app-0008

OS Used for Development: Ubuntu17.04
IDE Used for Development: IntelliJ
Java: OpenJDK1.8

Note: This application uses App Engine standard environment which is not compatible with java version 8. 
However, this code can be downloaded and run locally.

# Features
20170815 - Read properties from an external file.
20170813 - Integrate with GoogleAppEngine.
20170810 - Expose a basic rest endpoint using spring boot.

# Issue # 1

With IntelliJ you could get the following error

Caused by: org.springframework.context.ApplicationContextException: Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.

# Resolution # 1

Most likely you provided an incorrect argument - Application.class.

SpringApplication.run(Application.class, args); 