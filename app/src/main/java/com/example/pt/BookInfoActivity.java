package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        ImageView imageView = findViewById(R.id.imageView);
        Button borrowButton = findViewById(R.id.borrowButton);

        Intent intent = getIntent();
        int imageResource = intent.getIntExtra("imageResource", -1);

        if (imageResource != -1) {
            imageView.setImageResource(imageResource);
        } else {
            Toast.makeText(this, "Error loading image", Toast.LENGTH_SHORT).show();
        }

        borrowButton.setOnClickListener(v ->
            Toast.makeText(BookInfoActivity.this, "Buku berhasil dipinjam!", Toast.LENGTH_SHORT).show()
        );
    }
}
