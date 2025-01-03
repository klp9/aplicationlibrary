package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button catalogButton = findViewById(R.id.catalogButton);
        Button logoutButton = findViewById(R.id.logoutButton);
        Button aboutButton = findViewById(R.id.aboutButton);
        Button contactButton = findViewById(R.id.contactButton);
        Button ratingButton = findViewById(R.id.ratingButton);
        Button quizButton = findViewById(R.id.quizButton);

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });


        catalogButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CatalogActivity.class);
            startActivity(intent);
        });

        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        contactButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ContactActivity.class);
            startActivity(intent);
        });

        ratingButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, BookReviewActivity.class);
            startActivity(intent);
        });

        quizButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, QuizActivity.class); // Ganti dengan nama activity yang sesuai
            startActivity(intent);
        });
    }
}
