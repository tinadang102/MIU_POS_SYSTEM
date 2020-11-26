package miu.com.pos_miu_application.Models;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private Double price;
    private int image;

    public Product() {
    }

    public Product(String name, Double price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
