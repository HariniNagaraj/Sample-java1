package com.example.harini.samplejava;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        CardForm  cardForm = (CardForm) findViewById(R.id.card_form);
        TextView txtDes = (TextView)findViewById(R.id.payment_amount);
        Button btnPay = (Button)findViewById(R.id.btn_pay);
        Intent jumppage = getIntent();
        String sl = jumppage.getStringExtra("value");
          txtDes.setText(sl);
          btnPay.setText(String.format("Payer %s",txtDes.getText()));

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                Toast.makeText(Activity2.this, "Name: "+card.getName() + "| Last 4 digits :"+card.getLast4(), Toast.LENGTH_SHORT).show();
                Intent jumppage = new Intent(Activity2.this,Activity3.class);
                startActivity(jumppage);
            }
        });
    }
}
