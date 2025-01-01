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

        // Mengatur ListView untuk menampilkan rekomendasi buku
        recommendationsListView = findViewById(R.id.recommendationsListView);
        recommendationsList = new ArrayList<>();

        // Menambahkan buku-buku rekomendasi (Contoh)
        recommendationsList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        recommendationsList.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction"));
        recommendationsList.add(new Book("1984", "George Orwell", "Dystopian"));
        recommendationsList.add(new Book("Moby Dick", "Herman Melville", "Adventure"));

        // Menggunakan adapter untuk menampilkan buku rekomendasi di ListView
        recommendationsAdapter = new RecommendationsAdapter(this, recommendationsList);
        recommendationsListView.setAdapter(recommendationsAdapter);

        // Menangani klik tombol Back to Home
        Button backToHomeButton = findViewById(R.id.backToHomeButton);
        backToHomeButton.setOnClickListener(v -> {
            // Mengarahkan pengguna kembali ke HomeActivity
            Intent intent = new Intent(RecommendationsActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Mengakhiri RecommendationsActivity agar tidak bisa kembali ke halaman ini
        });
    }
}
