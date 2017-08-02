package hello;

public class Greeting {

    private final long id; // The id field is a unique identifier for the greeting
    private final String content; // content is the textual representation of the greeting.

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}