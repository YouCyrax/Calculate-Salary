package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonCalculate;
    EditText editTextState, editTextExperience, editTextAge;
    TextView textViewResult;
    String state;
    int result;
    int experience;
    int age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonCalculate = (Button) findViewById(R.id.btnCalculate);
        editTextState = (EditText) findViewById(R.id.editTextState);
        editTextExperience = (EditText) findViewById(R.id.editTexTExperience);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewResult.setText(editTextState.getText().toString());
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = editTextState.getText().toString();
                age = Integer.parseInt(editTextAge.getText().toString());
                experience = Integer.parseInt(editTextExperience.getText().toString());
                if (state.equals("m")){
                    if (experience < 3) {
                        result = 1500 + (experience * 50) + (age * 150);
                    }else if (experience >= 3 && experience < 6){
                        result = 1800 + (experience * 50) + (age * 150);
                    }else if (experience >= 6){
                        result = 1800 + (experience * 150) + (age * 150);
                    }else {
                        Toast.makeText(MainActivity.this, "Enter a valid value", Toast.LENGTH_SHORT).show();
                    }
                } else if (state.equals("s")){
                    if (age < 30) {
                        result = 1500 + (age * 5);
                    }else if (age >= 30 && age < 50){
                        result = 1800 + (age * 50);
                    }else if (age >= 50){
                        result = 1800 + (age * 5);
                    }else {
                        Toast.makeText(MainActivity.this, "Enter m for married, s for single", Toast.LENGTH_SHORT).show();
                        result = 0;
                    }
                }else {

                }
                textViewResult.setText("Your salary = $ " + result);
            }
        });

     }
}