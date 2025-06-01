package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /*
        TextView userName = findViewById(R.id.txtUserName);
        TextView password = findViewById(R.id.txtPassword);
        Button submitButton = findViewById(R.id.btnLogIn);
        TextView userNameInvoker = findViewById(R.id.userNameLabel);
        TextView passwordInvoker = findViewById(R.id.passwordLabel);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameFieldValue = (String) userName.getText();
                String passwordFieldValue = (String) password.getText();
                userNameInvoker.setText(userNameFieldValue);
                passwordInvoker.setText(passwordFieldValue);
            }
        });

         */


        EditText text_height_feet, text_height_inch, text_weight;
        TextView text_result;
        Button calc_button;

        text_height_feet = findViewById(R.id.txt_height_ft);
        text_height_inch = findViewById(R.id.txt_height_inch);
        text_weight = findViewById(R.id.txt_weight);
        text_result = findViewById(R.id.txt_result);
        calc_button = findViewById(R.id.calc_btn);

        calc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ht_ft = Integer.parseInt(text_height_feet.getText().toString());
                int ht_in = Integer.parseInt(text_height_inch.getText().toString());

                int ht_total_inch = (ht_ft * 12) + ht_in;
                double ht_total_cm = ht_total_inch * 2.53;

                double ht_total_meter = ht_total_cm / 100;
                int wt = Integer.parseInt(text_weight.getText().toString());

                double bmi = wt / (ht_total_meter * ht_total_meter);

                if(bmi > 25)
                {
                    text_result.setText("Over Weight\nScore: " + new Double(bmi).toString());
                }
                else if(bmi < 18)
                {
                    text_result.setText("Under Weight\nScore: " + new Double(bmi).toString());
                }
                else {
                    text_result.setText("Healthy\nScore: " + new Double(bmi).toString());
                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}