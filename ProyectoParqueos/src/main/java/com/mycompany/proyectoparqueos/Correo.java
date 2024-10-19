package com.mycompany.proyectoparqueos;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;

public class Correo {
    private String from;
    private String password;
    private String host;
    private Properties properties;

    public Correo(String from, String password, String host) {
        this.from = from;
        this.password = password;
        this.host = host;

        // Configuración del servidor de correo con autenticación
        properties = new Properties();
        properties.put("mail.smtp.auth", "true"); // Habilitar autenticación SMTP
        properties.put("mail.smtp.starttls.enable", "true"); // Habilitar StartTLS
        properties.put("mail.smtp.host", host); // Servidor SMTP
        properties.put("mail.smtp.port", "587"); // Puerto SMTP (comúnmente 587 para TLS)
        properties.put("mail.smtp.ssl.trust", host); // Confiar en el host SMTP
    }

    public void enviarCorreoConAdjunto(String to, String asunto, String cuerpo, File archivoAdjunto) {
        // Crear una sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Crear el mensaje de correo
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(asunto);

            // Crear la parte del texto del mensaje
            MimeBodyPart textoParte = new MimeBodyPart();
            textoParte.setText(cuerpo);

            // Crear la parte del archivo adjunto
            MimeBodyPart archivoParte = new MimeBodyPart();
            archivoParte.attachFile(archivoAdjunto);  // Usa el objeto File aquí

            // Unir ambas partes en el mensaje
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textoParte);
            multipart.addBodyPart(archivoParte);

            // Establecer el contenido completo del mensaje
            message.setContent(multipart);

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Correo enviado con éxito a: " + to);

        } catch (MessagingException e) {
            System.err.println("Error al enviar el mensaje de correo: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error al adjuntar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
