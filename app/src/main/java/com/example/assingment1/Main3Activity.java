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

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText input;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.liquid, android.R.layout.simple_spinner_item);
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
        if(text.compareTo("ml") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString());
            a.setText(String.format("%.2f", n1) + " ml");
            double n2 = Double.valueOf(input.getText().toString()) / 1000;
            b.setText(String.format("%.2f", n2) + " litre");
            double n3 = Double.valueOf(input.getText().toString()) / 4546.09;
            c.setText(String.format("%.2f", n3) + " gal");
            double n4 = Double.valueOf(input.getText().toString()) / 29.574;
            d.setText(String.format("%.2f", n4) + " fl oz");
        }

        if(text.compareTo("litre") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString()) * 1000;
            a.setText(String.format("%.2f", n1) + " ml");
            double n2 = Double.valueOf(input.getText().toString());
            b.setText(String.format("%.2f", n2) + " litre");
            double n3 = Double.valueOf(input.getText().toString()) / 3.785;
            c.setText(String.format("%.2f", n3) + " gal");
            double n4 = Double.valueOf(input.getText().toString()) / 33.814;
            d.setText(String.format("%.2f", n4) + " fl oz");
        }

        if(text.compareTo("gal") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString()) * 4546.09;
            a.setText(String.format("%.2f", n1) + " ml");
            double n2 = Double.valueOf(input.getText().toString()) * 3.785;
            b.setText(String.format("%.2f", n2) + " litre");
            double n3 = Double.valueOf(input.getText().toString());
            c.setText(String.format("%.2f", n3) + " gal");
            double n4 = Double.valueOf(input.getText().toString()) / 128;
            d.setText(String.format("%.2f", n4) + " fl oz");
        }

        if(text.compareTo("fl oz") == 0)
        {
            double n1 = Double.valueOf(input.getText().toString()) * 29.574;
            a.setText(String.format("%.2f", n1) + " ml");
            double n2 = Double.valueOf(input.getText().toString()) * 33.814;
            b.setText(String.format("%.2f", n2) + " litre");
            double n3 = Double.valueOf(input.getText().toString()) * 128;
            c.setText(String.format("%.2f", n3) + " gal");
            double n4 = Double.valueOf(input.getText().toString());
            d.setText(String.format("%.2f", n4) + " fl oz");
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
