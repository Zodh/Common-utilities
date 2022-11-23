# Email Sender

Módulo que possibilita a implementação rápida de um serviço de envio de e-mail. Para utilizá-lo, basta importá-lo e alocar as seguintes configurações no seu projeto: 

```
spring.mail.host=
spring.mail.username=
spring.mail.password=
spring.mail.port=
spring.mail.properties.mail.smtp.starttls.enable=
spring.mail.properties.mail.smtp.auth=
spring.mail.properties.mail.smtp.connectiontimeout=
spring.mail.properties.mail.smtp.timeout=
spring.mail.properties.mail.smtp.writetimeout=
```

Após preencher estas configurações no seu projeto, seja em um javaBean ou no application.properties, é só fazer uso da implementação da classe *EmailServiceImpl*.
