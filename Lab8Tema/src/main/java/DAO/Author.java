package DAO;

public class Author extends AbstractModel {
    private int id;
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    // Getters and setters for id and name

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
