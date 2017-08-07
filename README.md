# ref-app-0008



# Issue # 1

With IntelliJ you could get the following error

Caused by: org.springframework.context.ApplicationContextException: Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.

Fix:

Most likely you provided an incorrect argument for Application.clas.

SpringApplication.run(Application.class, args); 