# ref-app-0008

OS: Ubuntu17.04
Java: OpenJDK1.8
Spring: 

Note: Currently this application cannot be deployed to google app engine as it is build using Java1.8.

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