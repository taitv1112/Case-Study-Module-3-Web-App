package model;

import java.util.Date;
import java.util.List;

public class Product {
    private long id;
    private String sku ;
    private String name ;
    private String description ;
    private long quantity ;
    private double import_price;
    private double wholesale_prices;
    private double retail_price;
    private double wholesale_quantity;
    private double discount;
    private double retail_quantity;
    private double wholesale_profit;
    private double retail_profit;
    private String create_by;
    private String modify_by;
    private Date create_date;
    private Date modify_date;
    private long id_supplier;
    private long id_category;
    private long views;
    private long likes;
    private boolean status;
    private List<Img> imgList;
    public Product(long id, String sku, String name, String description, long quantity, double import_price, double wholesale_prices, double retail_price, double wholesale_quantity, double discount, double retail_quantity, double wholesale_profit, double retail_profit, String create_by, String modify_by, Date create_date, Date modify_date, long id_supplier, long id_category, long views, long likes, boolean status) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.import_price = import_price;
        this.wholesale_prices = wholesale_prices;
        this.retail_price = retail_price;
        this.wholesale_quantity = wholesale_quantity;
        this.discount = discount;
        this.retail_quantity = retail_quantity;
        this.wholesale_profit = wholesale_profit;
        this.retail_profit = retail_profit;
        this.create_by = create_by;
        this.modify_by = modify_by;
        this.create_date = create_date;
        this.modify_date = modify_date;
        this.id_supplier = id_supplier;
        this.id_category = id_category;
        this.views = views;
        this.likes = likes;
        this.status = status;
    }

    public Product(String sku, String name, String description, long quantity, double import_price, double wholesale_prices, double retail_price, double wholesale_quantity, double discount, double retail_quantity, double wholesale_profit, double retail_profit, long id_supplier, long id_category, long views, long likes, boolean status) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.import_price = import_price;
        this.wholesale_prices = wholesale_prices;
        this.retail_price = retail_price;
        this.wholesale_quantity = wholesale_quantity;
        this.discount = discount;
        this.retail_quantity = retail_quantity;
        this.wholesale_profit = wholesale_profit;
        this.retail_profit = retail_profit;
        this.id_supplier = id_supplier;
        this.id_category = id_category;
        this.views = views;
        this.likes = likes;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getImport_price() {
        return import_price;
    }

    public void setImport_price(double import_price) {
        this.import_price = import_price;
    }

    public double getWholesale_prices() {
        return wholesale_prices;
    }

    public void setWholesale_prices(double wholesale_prices) {
        this.wholesale_prices = wholesale_prices;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }

    public double getWholesale_quantity() {
        return wholesale_quantity;
    }

    public void setWholesale_quantity(double wholesale_quantity) {
        this.wholesale_quantity = wholesale_quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRetail_quantity() {
        return retail_quantity;
    }

    public void setRetail_quantity(double retail_quantity) {
        this.retail_quantity = retail_quantity;
    }

    public double getWholesale_profit() {
        return wholesale_profit;
    }

    public void setWholesale_profit(double wholesale_profit) {
        this.wholesale_profit = wholesale_profit;
    }

    public double getRetail_profit() {
        return retail_profit;
    }

    public void setRetail_profit(double retail_profit) {
        this.retail_profit = retail_profit;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getModify_by() {
        return modify_by;
    }

    public void setModify_by(String modify_by) {
        this.modify_by = modify_by;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(long id_supplier) {
        this.id_supplier = id_supplier;
    }

    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
