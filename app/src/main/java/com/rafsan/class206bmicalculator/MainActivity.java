package com.rafsan.class206bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextWeight,editTextFeet,editTextInch;
    Button buttonCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextWeight = findViewById(R.id.editTextWeight);
        editTextFeet = findViewById(R.id.editTextFeet);
        editTextInch = findViewById(R.id.editTextInch);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // weight section>>>>>>>>>>>>>>>>>>>>>>>>>>>
                String weight_string = editTextWeight.getText().toString();


                // Height Section....................................
                String feet_string,inch_string;

                feet_string = editTextFeet.getText().toString();
                inch_string = editTextInch.getText().toString();



                if(weight_string.length() > 0 && feet_string.length() > 0 && inch_string.length() > 0){

                    // weight section>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    float weight_string_to_number = Float.parseFloat(weight_string);

                    // Height Section....................................
                    // 1 feet = 0.3048 meter.
                    double feet_string_to_numberMeter = Double.parseDouble(feet_string);
                    feet_string_to_numberMeter = feet_string_to_numberMeter*0.3048;

                    // 1 Inch = 0.0254 meter.
                    double inch_string_to_numberMeter = Double.parseDouble(inch_string);
                    inch_string_to_numberMeter = inch_string_to_numberMeter*0.0254;

                    double height = feet_string_to_numberMeter + inch_string_to_numberMeter;


                    double bmi_Index = weight_string_to_number / (height*height);

                    if(bmi_Index < 18.5){

                        textViewResult.setText("Your BMI is = "+bmi_Index+"\n ভাই,তুমি চিকন ");

                    } else if (bmi_Index >= 18.5 && bmi_Index <= 24.9) {

                        textViewResult.setText("Your BMI is = "+bmi_Index+"\n ভাই,তুমি একদম  ঠিক-ঠাক আছো");

                    } else if (bmi_Index >= 25.0 && bmi_Index <= 29.9) {

                        textViewResult.setText("Your BMI is = "+bmi_Index+"\n ভাই,তোমার ওজন অতিরিক্ত বেশি");

                    } else if (bmi_Index >= 30.0 && bmi_Index <= 34.9) {

                        textViewResult.setText("Your BMI is = "+bmi_Index+"\n ভাই,তুমি মোটা");

                    }
                    else {
                        textViewResult.setText("Your BMI is = "+bmi_Index+"\n ভাই,তুমি অতিরিক্ত মোটা");
                    }

                }

                else {
                        editTextWeight.setError("please,enter a number");
                        editTextFeet.setError("please,enter a number");
                        editTextInch.setError("please,enter a number");
                        Toast.makeText(MainActivity.this , "Please, Fill up the all fields", Toast.LENGTH_LONG).show();

                        textViewResult.setText("দয়া করে , সকল ঘর পূরণ করুন।");


                }




            }
        });

    }
}