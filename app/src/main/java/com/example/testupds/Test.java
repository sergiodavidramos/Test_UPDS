package com.example.testupds;

import android.graphics.Bitmap;
import android.net.Uri;

public class Test {
String NombreTest, detalle;
int image;
    public Test() {
    }

    public Test(String nombreTest, String detalle, int image) {
        NombreTest = nombreTest;
        this.detalle = detalle;
        this.image = image;
    }

    public String getNombreTest() {
        return NombreTest;
    }

    public void setNombreTest(String nombreTest) {
        NombreTest = nombreTest;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
