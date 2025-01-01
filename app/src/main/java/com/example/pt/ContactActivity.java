package com.example.pt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Mengambil referensi tombol dan ikon
        Button backButton = findViewById(R.id.backButton);
        ImageView whatsappIcon = findViewById(R.id.whatsappIcon);
        ImageView instagramIcon = findViewById(R.id.instagramIcon);

        // Set up Back Button
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ContactActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        // Set up WhatsApp Icon untuk membuka WhatsApp
        whatsappIcon.setOnClickListener(v -> {
            String whatsappNumber = "+1234567890"; // Gantilah dengan nomor WhatsApp yang sesuai
            String url = "https://wa.me/" + whatsappNumber;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // Set up Instagram Icon untuk membuka Instagram
        instagramIcon.setOnClickListener(v -> {
            String instagramUsername = "your_username"; // Gantilah dengan username Instagram yang sesuai
            String url = "https://instagram.com/" + instagramUsername;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}
