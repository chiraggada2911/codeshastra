package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.rest.ApiClient;
import com.example.myapplication.rest.ApiInterface;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.List;
import java.util.Random;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Qrcode extends AppCompatActivity {
    String testdata,token ;
    ImageView image;
    List<Checkpogo> checkpogo;
    public static final String pres_file = "presfile";
    String namestudent,clgstn,clg,source,coach,userid,period;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_qrcode );
        image = (ImageView) findViewById(R.id.image);
        Bitmap bitmap;
        namestudent = getIntent().getStringExtra( "name" );
        clgstn = getIntent().getStringExtra( "clgstn" );
        clg = getIntent().getStringExtra( "clg" );
        source = getIntent().getStringExtra( "source" );
        coach = getIntent().getStringExtra( "coach" );
        period = getIntent().getStringExtra( "period" );
        userid = getIntent().getStringExtra( "userid" );

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Checkpogo>> call = apiInterface.update(userid);
        sharedPreferences = getSharedPreferences(pres_file,Context.MODE_PRIVATE);
        call.enqueue(new Callback<List<Checkpogo>>() {
            @Override
            public void onResponse(Call<List<Checkpogo>> call, Response<List<Checkpogo>> response) {
                checkpogo = response.body();

                Toast.makeText(Qrcode.this,"heya",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<Checkpogo>> call, Throwable t) {
//                Toast.makeText(Qrcode.this,"oh no",Toast.LENGTH_LONG).show();
            }
        });




        testdata = getIntent().getStringExtra("key");

        testdata = token+"\n" +namestudent+"\n"+source+"\n"+clgstn+"\n"+coach+"\n"+period+"\n"+clg;



        QRGEncoder qrgEncoder = new QRGEncoder(testdata, null, QRGContents.Type.TEXT, 200);
        try {
            // Getting QR-Code as Bitmap
            bitmap = qrgEncoder.encodeAsBitmap();
            // Setting Bitmap to ImageView
            image.setImageBitmap(bitmap);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("filename",testdata);
            editor.putBoolean("isdatavalide",true);
            editor.commit();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }



}

