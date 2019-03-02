package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.rest.ApiClient;
import com.example.myapplication.rest.ApiInterface;

import java.time.Year;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {
    TextView name1, to, from;
    Button submit;
    List<Checkpogo> checkpogo;
    String coach, period;
    private RadioButton First, Second, Year, quartly;
    String namestudent, clgstn, clg, source, clgid, userid;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        sharedPreferences = getSharedPreferences(Qrcode.pres_file, Context.MODE_PRIVATE);
        String isdatagaga=  sharedPreferences.getString("filename","chirag");

            getqw();



    }

    public void getqw(){
        name1 = findViewById(R.id.Form_name_id);
        to = findViewById(R.id.To_Starting_form);
        from = findViewById(R.id.From_Ending_form);
        namestudent = getIntent().getStringExtra("name");
        clgstn = getIntent().getStringExtra("clgstn");
        clg = getIntent().getStringExtra("clg");
        source = getIntent().getStringExtra("source");
        clgid = getIntent().getStringExtra("clgid");
        userid = getIntent().getStringExtra("userid");
        to.setText( clgstn );
        from.setText( source );
        name1.setText(namestudent );
        First = findViewById( R.id.radio_first);
        Second = findViewById( R.id.radio_second );
        Year = findViewById(R.id.radio_one);
        quartly = findViewById( R.id.radio_two );

        submit = findViewById( R.id.Form_submit );
        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(First.isChecked()){
                    coach = (String) First.getText();

                }
                else{
                    coach = (String) Second.getText();

                }
                if(Year.isChecked()){
                    period = (String) Year.getText();

                }
                else{
                    period = (String) quartly.getText();

                }

                Intent login = new Intent( FormActivity.this,Qrcode.class );
                login.putExtra( "name", namestudent );
                login.putExtra( "source",source );
                login.putExtra( "clg",clg );
                login.putExtra( "clgstn",clgstn );
                login.putExtra("coach",coach);
                login.putExtra( "period",period );
                startActivity( login );


            }
        } );
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Checkpogo>> call = apiInterface.login();
        call.enqueue(new Callback<List<Checkpogo>>() {
            @Override
            public void onResponse(Call<List<Checkpogo>> call, Response<List<Checkpogo>> response) {
                checkpogo =response.body();


            }

            @Override
            public void onFailure(Call<List<Checkpogo>> call, Throwable t) {

            }
        });


    }

}

