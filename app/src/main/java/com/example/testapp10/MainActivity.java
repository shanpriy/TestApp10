package com.example.testapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSum();
        customToast();
    }

    public void addSum() {
        t1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.editText2);
        Button addSum = findViewById(R.id.addSum);

        addSum.setOnClickListener(view -> {

            String v1 = t1.getText().toString();
            String v2 = t2.getText().toString();
            if (!v1.equals("") & !v2.equals("")) {
                int a = Integer.parseInt(v1);
                int b = Integer.parseInt(v2);
                int sum = a + b;
                Toast.makeText(getApplicationContext(), String.valueOf(sum), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Please fill the values !", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void customToast(){
        Button customToast = findViewById(R.id.customToastButton);

        customToast.setOnClickListener(view -> {
            LayoutInflater li = getLayoutInflater();
            View layout = li.inflate(R.layout.toast_custom, findViewById(R.id.customToast));
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(layout);
            toast.show();
        });
    }
}