package domain;

public class Player {
    private int ID;
    private String name;
    private String password;

    public Player(String name, String password) {
        this(0, name, password);
    }

    public Player(int ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
