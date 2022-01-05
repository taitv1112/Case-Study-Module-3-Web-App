package model;

public class Supplier {
    private long id;
    private String name;
    private String description;

    public Supplier(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Supplier(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Supplier() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
