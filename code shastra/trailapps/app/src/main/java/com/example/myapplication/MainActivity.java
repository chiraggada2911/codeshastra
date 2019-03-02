package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.DatagramPacket;

public class MainActivity extends AppCompatActivity {
    EditText userid,password;
    Button login;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        sharedPreferences = getSharedPreferences(Qrcode.pres_file, Context.MODE_PRIVATE);
       String isdatagaga=  sharedPreferences.getString("filename","chirag");

           get();

    }
    private  void get (){
        userid = (EditText)findViewById( R.id.edittextlogin );
        password = (EditText)findViewById( R.id.editpasslogin );
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference TAble = firebaseDatabase.getReference("user");
        login = (Button)findViewById( R.id.loginBtn );
//        final String user = userid.getText().toString().trim();
//        String pass = password.getText().toString();
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TAble.addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String user = userid.getText().toString().trim();
                        String pass = password.getText().toString();
                        Datapogo dataLogin = (Datapogo) dataSnapshot.child(user).getValue( Datapogo.class);
                        if(pass.equals( dataLogin.getPassword() )){
                            Intent login = new Intent( MainActivity.this,FormActivity.class );
                            login.putExtra( "name",dataLogin.getName() );
                            login.putExtra( "source",dataLogin.getSource() );
                            login.putExtra( "clg",dataLogin.getClg() );
                            login.putExtra( "clgstn",dataLogin.getClgstn() );


                            login.putExtra( "userid",user );
                            startActivity( login );

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                } );






            }
        } );


    }


}
