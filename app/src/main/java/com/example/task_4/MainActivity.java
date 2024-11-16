package com.example.task_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.start_btn);

        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExpandableListActivity.class);
            startActivity(intent);
        });
    }
}
