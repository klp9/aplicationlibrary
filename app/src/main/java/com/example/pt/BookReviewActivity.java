package com.example.pt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookReviewActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText reviewEditText;
    private Button submitReviewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_review);  // Pastikan layout yang benar digunakan

        // Inisialisasi elemen UI dengan referensi ID
        ratingBar = findViewById(R.id.ratingBar);
        reviewEditText = findViewById(R.id.reviewEditText);
        submitReviewButton = findViewById(R.id.submitReviewButton);

        // Menangani aksi klik tombol Submit Review
        submitReviewButton.setOnClickListener(v -> {
            // Mendapatkan rating dan review yang dimasukkan pengguna
            float rating = ratingBar.getRating();
            String review = reviewEditText.getText().toString();

            // Cek apakah rating dan review sudah diisi
            if (rating == 0) {
                Toast.makeText(BookReviewActivity.this, "Please rate this book", Toast.LENGTH_SHORT).show();
            } else if (review.isEmpty()) {
                Toast.makeText(BookReviewActivity.this, "Please write a review", Toast.LENGTH_SHORT).show();
            } else {
                // Simpan rating dan review (misalnya ke SharedPreferences atau Firebase)
                // Untuk demo ini, kita akan menampilkan Toast
                Toast.makeText(BookReviewActivity.this, "Review Submitted", Toast.LENGTH_SHORT).show();

                // Reset form setelah submit
                ratingBar.setRating(0);
                reviewEditText.setText("");
            }
        });
    }
}
