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

        // Mengakses tombol yang ada di layout
        Button catalogButton = findViewById(R.id.catalogButton);
        Button logoutButton = findViewById(R.id.logoutButton);
        Button aboutButton = findViewById(R.id.aboutButton);
        Button contactButton = findViewById(R.id.contactButton);
        Button ratingButton = findViewById(R.id.ratingButton);
        Button quizButton = findViewById(R.id.quizButton); // Tombol untuk navigasi ke halaman quiz

        // Logout Button
        logoutButton.setOnClickListener(v -> {
            // Log out dari Firebase dan pindah ke halaman login
            // mAuth.signOut();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        // Navigasi ke Catalog
        catalogButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CatalogActivity.class);
            startActivity(intent);
        });

        // Navigasi ke About
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        // Navigasi ke Contact
        contactButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ContactActivity.class);
            startActivity(intent);
        });

        // Navigasi ke halaman Rating
        ratingButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, BookReviewActivity.class);
            startActivity(intent);
        });

        // Navigasi ke halaman Quiz
        quizButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, QuizActivity.class); // Ganti dengan nama activity yang sesuai
            startActivity(intent);
        });
    }
}
