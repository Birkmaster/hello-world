package org.example.helloworld;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class HelloWorld extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        Button buttonnews = (Button) findViewById(R.id.buttonnews);
        buttonnews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HelloWorld.this, NewsActivity.class));
                }
        });
        Button buttonradio = (Button) findViewById(R.id.buttonradio);
        buttonradio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HelloWorld.this, RadioActivity.class));
            }
        });
        Button buttontv = (Button) findViewById(R.id.buttontv);
        buttontv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HelloWorld.this, TVActivity.class));
            }
        });
    }

}

