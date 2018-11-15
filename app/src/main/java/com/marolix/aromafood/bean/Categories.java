package com.marolix.aromafood.bean;

import com.google.gson.annotations.SerializedName;

public class Categories {

    @SerializedName("name 1")
    private String categoryOne;

    @SerializedName("name 2")
    private String categoryTwo;

    @SerializedName("name 3")
    private String categoryThree;

    public String getCategoryOne() {
        return categoryOne;
    }

    public String getCategoryTwo() {
        return categoryTwo;
    }

    public String getCategoryThree() {
        return categoryThree;
    }



}
