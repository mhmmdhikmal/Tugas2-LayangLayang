package com.example.apk2_keliling_luas_layanglayang;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class luas_layanglayang extends AppCompatActivity implements View.OnClickListener{
    private EditText ediagonal1;
    private EditText ediagonal2;
    private Button bHitung;
    private TextView tHasilE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luas_layanglayang);

        ediagonal1 = findViewById(R.id.iddiagonal1);
        ediagonal2 = findViewById(R.id.iddiagonal2);
        bHitung = findViewById(R.id.bhitungT);
        tHasilE = findViewById(R.id.thasilt);

        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
        }
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.bhitungT);
        String inputdiagonal1 = ediagonal1.getText().toString().trim();
        String inputdiagonal2 = ediagonal2.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputdiagonal1)){
            isEmptyFields = true;
            ediagonal1.setError("Tidak Boleh Kosong");
        } if (TextUtils.isEmpty(inputdiagonal2)){
            isEmptyFields = true;
            ediagonal2.setError("Tidak Boleh Kosong");
        }

        Double diagonal1 = toDouble(inputdiagonal1);
        Double diagonal2 = toDouble(inputdiagonal2);


        if (diagonal1 == null){
            isInvalidDouble = true;
            ediagonal1.setError("Nomor harus sesuai");
        } if (diagonal2 == null){
            isInvalidDouble = true;
            ediagonal2.setError("Nomor harus sesuai");
        } if (!isEmptyFields && !isInvalidDouble){
            double volume = 1/2 * diagonal1*diagonal2;
            tHasilE.setText(String.valueOf(volume));
        }
    }

    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasilE.getText().toString());
    }
}
