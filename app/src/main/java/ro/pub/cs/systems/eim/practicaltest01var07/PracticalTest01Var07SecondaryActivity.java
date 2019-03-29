package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private EditText number1, number2, number3,  number4;
    private Button buttonSum, buttonProd;

    private ArrayList<Integer> numbers;

    private int sum = 0, prod = 0;

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.buttonSum) {
                sum = numbers.get(0) + numbers.get(1) +
                        numbers.get(2) + numbers.get(3);
                Toast.makeText(view.getContext(),"Suma este " + String.valueOf(sum) , Toast.LENGTH_LONG).show();
            } else if (view.getId() == R.id.buttonProd){
                prod = numbers.get(0) * numbers.get(1) *
                        numbers.get(2) * numbers.get(3);
                Toast.makeText(view.getContext(),"Produsul este " + String.valueOf(prod) , Toast.LENGTH_LONG).show();
            } else if (view.getId() == R.id.buttonBack){

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);


        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("sendNumbers")) {
            numbers = getIntent().getIntegerArrayListExtra("sendNumbers");
            number1.setText(numbers.get(0).toString());
            number2.setText(numbers.get(1).toString());
            number3.setText(numbers.get(2).toString());
            number4.setText(numbers.get(3).toString());
        }

        buttonSum = findViewById(R.id.buttonSum);
        buttonSum.setOnClickListener(genericButtonClickListener);
        buttonProd = findViewById(R.id.buttonProd);
        buttonProd.setOnClickListener(genericButtonClickListener);
    }
}