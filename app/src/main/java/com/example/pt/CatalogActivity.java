package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        Button bookDetailButton = findViewById(R.id.bookDetailButton);
        Button searchBooksButton = findViewById(R.id.searchBooksButton);
        Button categoryButton = findViewById(R.id.categoryButton);

        bookDetailButton.setOnClickListener(v -> {
            Intent intent = new Intent(CatalogActivity.this, BookDetailActivity.class);
            startActivity(intent);
        });

        searchBooksButton.setOnClickListener(v -> {
            Intent intent = new Intent(CatalogActivity.this, SearchBooksActivity.class);
            startActivity(intent);
        });

        categoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(CatalogActivity.this, CategoryActivity.class);
            startActivity(intent);
        });
    }
}
