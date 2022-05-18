package com.example.pbt_foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare variable
    double drink, addOn, food = 0.00;
    String order , price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout orderCont = (LinearLayout) findViewById(R.id.orderContainer);
        LinearLayout coffeeCreamCont = (LinearLayout) findViewById(R.id.coffeeAddOnCreamCont);
        LinearLayout coffeeChocoCont = (LinearLayout) findViewById(R.id.coffeeAddOnChocoCont);
        CheckBox coffee = (CheckBox) findViewById(R.id.coffee);
        CheckBox coffeeCream = (CheckBox) findViewById(R.id.coffeeAddOnCream);
        CheckBox coffeeChoco = (CheckBox) findViewById(R.id.coffeeAddOnChoco);
        CheckBox food1 = (CheckBox) findViewById(R.id.food1);
        CheckBox food2 = (CheckBox) findViewById(R.id.food2);
        CheckBox food3 = (CheckBox) findViewById(R.id.food3);
        ImageView foodImage = (ImageView) findViewById(R.id.foodImage);
        Button placeOrderButton = (Button) findViewById(R.id.placeOrderButton);
        TextView totalOrder = (TextView) findViewById(R.id.totalOrder);
        TextView orderPrice = (TextView) findViewById(R.id.price);


        //declare initial state for specific container
        coffeeCreamCont.setVisibility(View.GONE);
        coffeeChocoCont.setVisibility(View.GONE);
        orderCont.setVisibility(View.GONE);

        //event listener for coffee checkbox
        coffee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    //change state of addOn Container
                    coffeeChocoCont.setVisibility(View.VISIBLE);
                    coffeeCreamCont.setVisibility(View.VISIBLE);
                    drink = 3.5;
                    order = "\n Coffee";
                    price = "\n Rm 3.50";

                }

                //change container to initial state if coffee option not chosen
                if(!isChecked){
                    coffeeCreamCont.setVisibility(View.GONE);
                    coffeeChocoCont.setVisibility(View.GONE);
                    coffeeCream.setChecked(false);
                    coffeeChoco.setChecked(false);
                    addOn = 0;
                }
            }
        });

        //event listener for coffee addOn Cream checkbox
        coffeeCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    addOn += 1;
                }

                if(!isChecked){
                    addOn -=1;
                }
            }
        });

        //event listener for coffee addOn choco checkbox
        coffeeChoco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    addOn += 2;
                }

                if(!isChecked){
                    addOn -= 2;
                }
            }
        });

        //event listener for food1 checkbox
        food1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    food = 8.00;
                    food2.setChecked(false);
                    food3.setChecked(false);
                    foodImage.setImageDrawable(getResources().getDrawable(R.drawable.food1));
                }
            }
        });

        //event listener for food2 checkbox
        food2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    food = 6.00;
                    food1.setChecked(false);
                    food3.setChecked(false);
                    foodImage.setImageDrawable(getResources().getDrawable(R.drawable.food2));
                }
            }
        });

        //event listener for food3 checkbox
        food3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    food = 7.00;
                    food2.setChecked(false);
                    food1.setChecked(false);
                    foodImage.setImageDrawable(getResources().getDrawable(R.drawable.food3));
                }
            }
        });

        //event listener for order button
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalOrder.setText(order);
                orderPrice.setText(price);
                orderCont.setVisibility(View.VISIBLE);
            }
        });
    }
}