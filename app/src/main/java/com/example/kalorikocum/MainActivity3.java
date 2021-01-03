package com.example.kalorikocum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView textView2,textView3;
    ImageView imageView2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);


        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            imageView2.setImageResource(mBundle.getInt("resimler"));
            textView2.setText(mBundle.getString("Yemekisimleri"));
            textView3.setText(mBundle.getString("Yemekbilgileri"));


        }
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
