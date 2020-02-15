package com.example.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {

    private Bitmap chosenImage;
    private static  Singleton singleton;

    private  Singleton(){ // <-- constructor


    }

    public Bitmap getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public static Singleton getInstance(){// bir singleton objesi döndürücem bu objenin adı da getInstance olacak getInstance çağırdığımda
        //sigleton objesi döndürecek

        if (singleton == null){
            singleton = new Singleton();
        }
            return singleton; // boş değilse oluşturulmuş singleton u döndür!!!

    }
}
