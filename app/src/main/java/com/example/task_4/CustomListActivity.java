package com.example.task_4;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {

    private ListView customListView;
    private FoodItemAdapter adapter;
    private List<FoodItem> foodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        customListView = findViewById(R.id.customListView);

        String selectedCategory = getIntent().getStringExtra("selectedCategory");
        prepareData(selectedCategory);

        adapter = new FoodItemAdapter(this, foodItems);
        customListView.setAdapter(adapter);
    }

    private void prepareData(String category) {
        foodItems = new ArrayList<>();

        switch (category) {
            case "Appetizers":
                foodItems.add(new FoodItem("Spring Rolls", R.drawable.spring_rolls));
                foodItems.add(new FoodItem("Garlic Bread", R.drawable.garlic_bread));
                break;
            case "Main Courses":
                foodItems.add(new FoodItem("Grilled Chicken", R.drawable.grilled_chicken));
                foodItems.add(new FoodItem("Pasta Carbonara", R.drawable.pasta_carbonara));
                break;
            case "Desserts":
                foodItems.add(new FoodItem("Chocolate Cake", R.drawable.chocolate_cake));
                foodItems.add(new FoodItem("Ice Cream", R.drawable.ice_cream));
                break;
        }
    }
}
