package com.example.dessy.resepmamake;

/**
 * Created by Priyastini Dessy on 01/05/2018.
 */

public class Constactor {
    private String name;
    private int thumbnail;
    private String penjelasan;


    public Constactor(String name, int thumbnail, String penjelasan){
        this.name = name;
        this.thumbnail = thumbnail;
        this.penjelasan = penjelasan;
    }

    public String getName() {
        return name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }
}


