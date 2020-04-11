package com.example.coronavirushelplines;

import android.content.Context;
import android.content.Intent;

public class BackArrow {
    public static void backArrow(Context context){
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
