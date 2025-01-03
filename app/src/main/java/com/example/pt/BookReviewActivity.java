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
        setContentView(R.layout.activity_book_review);

        ratingBar = findViewById(R.id.ratingBar);
        reviewEditText = findViewById(R.id.reviewEditText);
        submitReviewButton = findViewById(R.id.submitReviewButton);

        submitReviewButton.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String review = reviewEditText.getText().toString();

            if (rating == 0) {
                Toast.makeText(BookReviewActivity.this, "Please rate this book", Toast.LENGTH_SHORT).show();
            } else if (review.isEmpty()) {
                Toast.makeText(BookReviewActivity.this, "Please write a review", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(BookReviewActivity.this, "Review Submitted", Toast.LENGTH_SHORT).show();

                ratingBar.setRating(0);
                reviewEditText.setText("");
            }
        });
    }
}
