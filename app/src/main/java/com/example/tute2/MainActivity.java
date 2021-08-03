package com.example.tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText et_value;
    RadioButton btn_celsius;
    RadioButton btn_fahrenhite;
    Button btn_calculate;
    TextView tv_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value = findViewById(R.id.et_value);
        btn_celsius = findViewById(R.id.btn_celsius);
        btn_fahrenhite = findViewById(R.id.btn_fahrenhite);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_display = findViewById(R.id.tv_display);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer(){
        Calculation calculation = new Calculation();
        String temp_value = et_value.getText().toString();

        if(TextUtils.isEmpty(temp_value)){
            Toast.makeText(this,"please enter a temperature value!", Toast.LENGTH_LONG).show();
            temp_value = "0.0";
            tv_display.setText(temp_value);
        }else {
           try {
               Float temp = Float.parseFloat(temp_value);

               if (btn_celsius.isChecked()) {
                   temp = calculation.convertFahrenhiteToCelcius(temp);
               } else if (btn_fahrenhite.isChecked()) {
                   temp = calculation.convertCelciusToFahrenhite(temp);
               } else {
                   Toast.makeText(this, "Please Radio!",Toast.LENGTH_LONG).show();
                   temp = 0.0f;
               }
               tv_display.setText(new Float(temp).toString());
           }catch (NullPointerException e){}
        }
    }
}