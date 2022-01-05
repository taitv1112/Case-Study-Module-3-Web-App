package model;

public class OrderDetail {
    private long id;
    private long id_Orders;
    private long id_Product;
    private long quantity_order;

    public OrderDetail(long id, long id_Orders, long id_Product, long quantity_order) {
        this.id = id;
        this.id_Orders = id_Orders;
        this.id_Product = id_Product;
        this.quantity_order = quantity_order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_Orders() {
        return id_Orders;
    }

    public void setId_Orders(long id_Orders) {
        this.id_Orders = id_Orders;
    }

    public long getId_Product() {
        return id_Product;
    }

    public void setId_Product(long id_Product) {
        this.id_Product = id_Product;
    }

    public long getQuantity_order() {
        return quantity_order;
    }

    public void setQuantity_order(long quantity_order) {
        this.quantity_order = quantity_order;
    }
}
