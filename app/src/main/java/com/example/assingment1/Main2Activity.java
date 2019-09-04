package com.example.assingment1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    private EditText input;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.length, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        input = (EditText) findViewById(R.id.editText);

        Button bt_calculate = (Button) findViewById(R.id.button3);

        a = (TextView) findViewById(R.id.textView);
        b = (TextView) findViewById(R.id.textView5);
        c = (TextView) findViewById(R.id.textView8);
        d = (TextView) findViewById(R.id.textView9);

        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
            }
        });
    }
    private void makeCalculations() {
        double result=0;
        if(text.compareTo("inch") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString());
            a.setText(String.format("%.2f", n1) + " inch");
            double n2 = Double.valueOf(input.getText().toString()) * 2.54;
            b.setText(String.format("%.2f", n2) + " cm");
            double n3 = Double.valueOf(input.getText().toString()) / 12;
            c.setText(String.format("%.2f", n3) + " feet");
            double n4 = Double.valueOf(input.getText().toString()) / 63360;
            d.setText(String.format("%.2f", n4) + " mile");
        }

        if(text.compareTo("cm") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString()) / 2.54;
            a.setText(String.format("%.2f", n1) + " inch");
            double n2 = Double.valueOf(input.getText().toString());
            b.setText(String.format("%.2f", n2) + " cm");
            double n3 = Double.valueOf(input.getText().toString()) / 30.48;
            c.setText(String.format("%.2f", n3) + " feet");
            double n4 = Double.valueOf(input.getText().toString()) / 160934.4;
            d.setText(String.format("%.2f", n4) + " mile");
        }

        if(text.compareTo("feet") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString()) * 12;
            a.setText(String.format("%.2f", n1) + " inch");
            double n2 = Double.valueOf(input.getText().toString()) * 30.48;
            b.setText(String.format("%.2f", n2) + " cm");
            double n3 = Double.valueOf(input.getText().toString());
            c.setText(String.format("%.2f", n3) + " feet");
            double n4 = Double.valueOf(input.getText().toString()) / 5280;
            d.setText(String.format("%.2f", n4) + " mile");
        }

        if(text.compareTo("mile") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString()) * 63360;
            a.setText(String.format("%.2f", n1) + " inch");
            double n2 = Double.valueOf(input.getText().toString()) * 160934.4;
            b.setText(String.format("%.2f", n2) + " cm");
            double n3 = Double.valueOf(input.getText().toString()) * 5280;
            c.setText(String.format("%.2f", n3) + " feet");
            double n4 = Double.valueOf(input.getText().toString());
            d.setText(String.format("%.2f", n4) + " mile");
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
