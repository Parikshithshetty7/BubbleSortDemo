package com.example.sort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText enteredNumbers;
    TextView sortedNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredNumbers=findViewById(R.id.eneteredNumbers);
        sortedNumbers=findViewById(R.id.sortedNumbers);

    }

    public void sortButtonPressed(View view){
        String[] numberList = enteredNumbers.getText().toString().split(",");
        Integer[] numbers = new Integer[numberList.length];

        for(int i=0; i < numberList.length; i++){
            numbers[i]=Integer.parseInt(numberList[i]); // Convert String of arrays into integer arrays
        }
        sort(numbers, numbers.length); // Sorted numbers
        sortedNumbers.setText(Arrays.toString(numbers));
    }

    private void sort(Integer[] numbers, int length){
        if(length < 2){
            return;
        }
        for (int i = 0; i < length-1; i++){
            if(numbers[i] > numbers[i+1]){
//Swap
                Integer temp = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = temp;
            }
        }
        sort(numbers, length-1);
    }
}
