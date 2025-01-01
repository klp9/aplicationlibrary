package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button fictionButton = findViewById(R.id.fictionButton);
        Button nonFictionButton = findViewById(R.id.nonFictionButton);

        // Tombol untuk memilih kategori Fiction
        fictionButton.setOnClickListener(v -> {
            // Menyaring dan menampilkan buku berdasarkan kategori Fiction
            showBooksForCategory("Fiction");
        });

        // Tombol untuk memilih kategori Non-Fiction
        nonFictionButton.setOnClickListener(v -> {
            // Menyaring dan menampilkan buku berdasarkan kategori Non-Fiction
            showBooksForCategory("Non-Fiction");
        });
    }

    private void showBooksForCategory(String category) {
        // Intent untuk membuka Activity yang menampilkan daftar buku berdasarkan kategori
        Intent intent = new Intent(CategoryActivity.this, BookListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
