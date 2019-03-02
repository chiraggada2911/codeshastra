package com.example.qr;

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

public class MainActivity extends AppCompatActivity {
    private Button login;
    public static String number;
    EditText login1,password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        login = findViewById( R.id.Login_button );
        login1 = (EditText) findViewById( R.id.Login_number );
        password1 = (EditText) findViewById( R.id.Password );



        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = firebaseDatabase.getReference("user");

        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_user.addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String user = login1.getText().toString();
                        String password = password1.getText().toString();

                        DataLogin dataLogin = (DataLogin) dataSnapshot.child(user).getValue(DataLogin.class);

                        if (password.equals( dataLogin.getPassword())){
                            Toast.makeText( MainActivity.this,dataLogin.getName(),Toast.LENGTH_LONG ).show();

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
