package model;

public class Img {
    private int idImg;
    private int idProduct;
    private String img;

    public Img() {
    }

    public Img(int idImg, int idProduct, String img) {
        this.idImg = idImg;
        this.idProduct = idProduct;
        this.img = img;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
