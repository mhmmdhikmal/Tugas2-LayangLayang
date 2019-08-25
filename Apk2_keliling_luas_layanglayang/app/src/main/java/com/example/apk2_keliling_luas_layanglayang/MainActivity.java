package com.example.apk2_keliling_luas_layanglayang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int  req_code= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnKlayanglayang = findViewById(R.id.idKlayanglayang);
        btnKlayanglayang.setOnClickListener(this);

        Button btnLlayanglayang = findViewById(R.id.idLlayanglayang);
        btnLlayanglayang.setOnClickListener(this);

        Button btnresultdataA = findViewById(R.id.idKlayanglayang);
        btnresultdataA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.idKlayanglayang:
                Intent data = new Intent(MainActivity.this, keliling_layanglayang.class);
                startActivity(data);
                break;
            case R.id.idLlayanglayang:
                Intent moveIntentA = new Intent(MainActivity.this, luas_layanglayang.class);
                startActivity(moveIntentA);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasilnama = findViewById(R.id.view1);
                hasilnama.setText(data.getData().toString());

            }
        }
    }
}
