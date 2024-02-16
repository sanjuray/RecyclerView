package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    RecyclerView recyclerView;
    ArrayList<Item> itemList;
    MyCustomAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        Item item1 = new Item(R.drawable.fruit, "Fruits", "Fresh Fruits from the Garden");
        Item item2 = new Item(R.drawable.vegitables, "Vegetable", "Delicious Vegetables");
        Item item3 = new Item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans");
        Item item4 = new Item(R.drawable.beverage, "Beverage", "Juice,Tea,Coffee, and Soda");
        Item item5 = new Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt");
        Item item6 = new Item(R.drawable.popcorn, "Snacks", "Popcorn, Donut and Drinks");
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        myAdapter = new MyCustomAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setItemClickListener(this);
    }

    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(getApplicationContext(),
                "You choose: "+itemList.get(pos).getItemTitle(),
                Toast.LENGTH_SHORT).show();
    }
}