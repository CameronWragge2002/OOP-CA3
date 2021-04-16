package socialmedia;

public class Account {
    //Attributes
    private int id;
    
    private String handle;

    private String description;

    //setters
    public void setHandle(String h) {
        this.handle = h;
    }

    public void setDescription(String d) {
        this.description = d;
    }
    public void setId(int id) {
        this.id = id;
    }

    //getters
    public String getHandle(){
        return this.handle;
    }
    
    public int getid(){
        return this.id;
    }

    public String getDesc() {
        return this.description;
        }

    //Constructors
    public Account(int id, String h) {
        setHandle(h);
    }

    public Account(int id, String h, String d) {
        setHandle(h);
        setDescription(d);
    }
}
