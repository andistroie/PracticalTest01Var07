package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText number1, number2, number3,  number4;
    private Button buttonSet;


    private IntentFilter intentFilter = new IntentFilter();

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if(number1.getText().toString() == "" &&
                    number2.getText().toString() == "" &&
               number3.getText().toString() == "" &&
                    number4.getText().toString() == "" ) {

            } else if (view.getId() == R.id.buttonSet) {
                ArrayList<Integer> numbers = new ArrayList<Integer>();
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                numbers.add(Integer.valueOf(number1.getText().toString()));
                numbers.add(Integer.valueOf(number2.getText().toString()));
                numbers.add(Integer.valueOf(number3.getText().toString()));
                numbers.add(Integer.valueOf(number4.getText().toString()));
                intent.putIntegerArrayListExtra("sendNumbers", numbers);
                startActivityForResult(intent,1);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);


        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("number1")) {
                number1.setText(savedInstanceState.getString("number1"));
            } else {
                number1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("number2")) {
                number1.setText(savedInstanceState.getString("number2"));
            } else {
                number2.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("number3")) {
                number3.setText(savedInstanceState.getString("number3"));
            } else {
                number3.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("number4")) {
                number4.setText(savedInstanceState.getString("number4"));
            } else {
                number4.setText(String.valueOf(0));
            }
        } else {
            number1.setText(String.valueOf(0));
            number2.setText(String.valueOf(0));
            number3.setText(String.valueOf(0));
            number4.setText(String.valueOf(0));
        }

        buttonSet = findViewById(R.id.buttonSet);
        buttonSet.setOnClickListener(genericButtonClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("number1", number1.getText().toString());
        savedInstanceState.putString("number2", number2.getText().toString());
        savedInstanceState.putString("number3", number3.getText().toString());
        savedInstanceState.putString("number4", number4.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("number1")) {
            number1.setText(savedInstanceState.getString("number1"));
        } else {
            number1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("number2")) {
            number2.setText(savedInstanceState.getString("number2"));
        } else {
            number2.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("number3")) {
            number3.setText(savedInstanceState.getString("number3"));
        } else {
            number3.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("number4")) {
            number4.setText(savedInstanceState.getString("number4"));
        } else {
            number4.setText(String.valueOf(0));
        }
    }
}
