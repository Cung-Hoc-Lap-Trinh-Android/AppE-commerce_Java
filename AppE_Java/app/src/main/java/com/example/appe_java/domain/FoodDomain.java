package com.example.appe_java.domain;

public class FoodDomain {
    private String title;
    private String img;
    private String description;
    private Double fee;
    private int numberInCart;

    public FoodDomain(String title, String img, String description, Double fee) {
        this.title = title;
        this.img = img;
        this.description = description;
        this.fee = fee;
    }

    public FoodDomain(String title, String img, String description, Double fee, int numberInCart) {
        this.title = title;
        this.img = img;
        this.description = description;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
