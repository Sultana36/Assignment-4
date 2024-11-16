package com.example.task_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private FoodCategoryAdapter adapter;
    private List<String> categories;
    private HashMap<String, List<String>> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        expandableListView = findViewById(R.id.expandableListView);
        prepareData();

        adapter = new FoodCategoryAdapter(this, categories, items);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Intent intent = new Intent(ExpandableListActivity.this, CustomListActivity.class);
            intent.putExtra("selectedCategory", categories.get(groupPosition));
            startActivity(intent);
            return true;
        });
    }

    private void prepareData() {
        categories = new ArrayList<>();
        items = new HashMap<>();

        categories.add("Appetizers");
        categories.add("Main Courses");
        categories.add("Desserts");

        List<String> appetizers = new ArrayList<>();
        appetizers.add("Spring Rolls");
        appetizers.add("Garlic Bread");

        List<String> mainCourses = new ArrayList<>();
        mainCourses.add("Grilled Chicken");
        mainCourses.add("Pasta Carbonara");

        List<String> desserts = new ArrayList<>();
        desserts.add("Chocolate Cake");
        desserts.add("Ice Cream");

        items.put(categories.get(0), appetizers);
        items.put(categories.get(1), mainCourses);
        items.put(categories.get(2), desserts);
    }
}
