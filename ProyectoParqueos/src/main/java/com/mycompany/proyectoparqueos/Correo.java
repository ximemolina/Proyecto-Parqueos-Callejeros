
package com.mycompany.proyectoparqueos;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Correo {
    private String from;
    private String host;
    private Properties properties;

    public Correo(String from, String host) {
        this.from = from;
        this.host = host;

        // Configuración del servidor de correo
        properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
    }

    // Método genérico para enviar un correo
public void enviarCorreo(String to, String asunto, String cuerpo) {
    // Crear una sesión con el servidor de correo
    Session session = Session.getDefaultInstance(properties);

    try {
        // Crear el mensaje de correo
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(asunto);
        message.setText(cuerpo);

        // Enviar el mensaje
        Transport.send(message);
        System.out.println("Correo enviado a: " + to);

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}