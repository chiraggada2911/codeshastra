package com.example.myapplication;

import android.util.Log;

import java.util.Random;

public class uuid {

    String token;

    public void u_id() {


        token = "DI";

        // char (1), random A-Z
        int ranChar = 65 + (new Random()).nextInt(90 - 65);
        char ch = (char) ranChar;
        token += ch;

        // numbers (6), random 0-9
        Random r = new Random();
        int numbers = 1000 + (int) (r.nextFloat() * 8990);
        token += String.valueOf(numbers);

        token += "-";
        // char or numbers (5), random 0-9 A-Z
        for (int i = 0; i < 3; ) {
            int ranAny = 48 + (new Random()).nextInt(90 - 65);

            if (!(57 < ranAny && ranAny <= 65)) {
                char c = (char) ranAny;
                token += c;
                i++;
            }

        }

        Log.i("bbbbb", token);

    }


}
