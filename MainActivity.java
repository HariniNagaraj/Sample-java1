package com.example.harini.samplejava;


import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.BreakIterator;
import java.text.NumberFormat;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import static android.widget.ArrayAdapter.*;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{

    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    Button clk;
    int price;
    String priceMessage;


    private int quantity = 0;
    private TextView quantityTextView;
    private TextView priceTextView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = findViewById(R.id.quantity_text_view);
        priceTextView = findViewById(R.id.price_text_view);
        clk=(Button) findViewById(R.id.button);
        viewPager = findViewById(R.id.view_pager);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List categories = new ArrayList<>();
        categories.add("Cappuccino" );
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter dataAdapter = new ArrayAdapter (this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?>parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        /* TODO Auto-generated method stub */

    }

    public void increment(View view) {
        quantity = quantity + 1 ;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
    public void submit(View view) {
        int price = quantity * 5;
         priceMessage = "Total: $ "  +  price ;
        displayMessage(priceMessage);
    }



    /**

     * This method is called when the order button is clicked.

     */

    public void submitOrder(View view) {
        String sl = priceMessage ;
        Intent jumppage = new Intent(MainActivity.this,Activity2.class);
        jumppage.putExtra("value", priceMessage);
        startActivity(jumppage);

    }
    public void clear(View view) {
        quantityTextView.setText("");
        priceTextView.setText("");
    }



    /**

     * This method displays the given quantity value on the screen.

     */

    private void display(int number) {

        quantityTextView.setText("" + number);

    }
    private void displayPrice(int number) {

        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
    private void displayMessage(String message) {
        priceTextView.setText(message);
    }



}
