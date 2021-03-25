package dam.gala.damgame.utils;

public class GameMailMessage {
    private String mailTo,object,body;

    public GameMailMessage(String mailTo, String object, String body) {
        this.mailTo = mailTo;
        this.object = object;
        this.body = body;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
