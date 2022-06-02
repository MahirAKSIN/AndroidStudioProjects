package com.example.game1;

import android.content.Context;
//import androidx.appcompat.widget.AppCompatDrawableManager;


public class kart extends androidx.appcompat.widget.AppCompatButton {
    boolean acikMi = false;
    int arkaPlanID;
    int resimID;

    public kart(Context context) {
        super(context);
        arkaPlanID = R.drawable.star;
      //  Drawable d= AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);

        //setBackground(d);

    }
}