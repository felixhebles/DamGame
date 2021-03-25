package dam.gala.damgame.utils;

import android.os.AsyncTask;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTask extends AsyncTask<GameMailMessage,Integer,Boolean> {
    public boolean sendMail(GameMailMessage gameMailMessage){
        final String USERNAME = "dam2ajavieralmenaragarcia@iesantoniogala.es";
        final String PASSWORD = "";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new
                                PasswordAuthentication(USERNAME,
                                PASSWORD);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(gameMailMessage.getMailTo())
            );
            message.setSubject(gameMailMessage.getObject());
            message.setText(gameMailMessage.getBody());

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    @Override
    protected Boolean doInBackground(GameMailMessage... gameMailMessages) {
        int num=300;
        for (int i=0; i<num; i++){
            this.publishProgress(i);
            return  this.sendMail(gameMailMessages[0]);
        }
        return this.sendMail(gameMailMessages[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
