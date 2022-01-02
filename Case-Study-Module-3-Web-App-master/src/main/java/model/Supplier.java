package model;

public class Supplier {
    private int idSupplier;
    private String nameSupplier;
    private String descriptionSupplier;

    public Supplier() {
    }

    public Supplier(int idSupplier, String nameSupplier, String descriptionSupplier) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.descriptionSupplier = descriptionSupplier;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getDescriptionSupplier() {
        return descriptionSupplier;
    }

    public void setDescriptionSupplier(String descriptionSupplier) {
        this.descriptionSupplier = descriptionSupplier;
    }
}
