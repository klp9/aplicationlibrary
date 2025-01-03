package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecommendationsActivity extends AppCompatActivity {

    private ListView recommendationsListView;
    private RecommendationsAdapter recommendationsAdapter;
    private ArrayList<Book> recommendationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        recommendationsListView = findViewById(R.id.recommendationsListView);
        recommendationsList = new ArrayList<>();

        recommendationsList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        recommendationsList.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction"));
        recommendationsList.add(new Book("1984", "George Orwell", "Dystopian"));
        recommendationsList.add(new Book("Moby Dick", "Herman Melville", "Adventure"));

        recommendationsAdapter = new RecommendationsAdapter(this, recommendationsList);
        recommendationsListView.setAdapter(recommendationsAdapter);

        Button backToHomeButton = findViewById(R.id.backToHomeButton);
        backToHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(RecommendationsActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
