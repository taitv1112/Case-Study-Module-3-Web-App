package model;

import java.util.Date;

public class Orders {
    private long id;
    private long id_customer;
    private long id_manager;
    private Date create_date;
    private Date modify_date;
    private String create_by;
    private String modify_by;
    private double total_bill;
    private String status;

    public Orders(long id, long id_customer, long id_manager, Date create_date, Date modify_date, String create_by, String modify_by, double total_bill, String status) {
        this.id = id;
        this.id_customer = id_customer;
        this.id_manager = id_manager;
        this.create_date = create_date;
        this.modify_date = modify_date;
        this.create_by = create_by;
        this.modify_by = modify_by;
        this.total_bill = total_bill;
        this.status = status;
    }

    public Orders(long id_customer, long id_manager, Date create_date, Date modify_date, String create_by, String modify_by, double total_bill, String status) {
        this.id_customer = id_customer;
        this.id_manager = id_manager;
        this.create_date = create_date;
        this.modify_date = modify_date;
        this.create_by = create_by;
        this.modify_by = modify_by;
        this.total_bill = total_bill;
        this.status = status;
    }

    public Orders() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_customer() {
        return id_customer;
    }

    public void setId_customer(long id_customer) {
        this.id_customer = id_customer;
    }

    public long getId_manager() {
        return id_manager;
    }

    public void setId_manager(long id_manager) {
        this.id_manager = id_manager;
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

    public double getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(double total_bill) {
        this.total_bill = total_bill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
