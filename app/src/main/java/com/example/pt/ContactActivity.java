package com.example.pt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    private EditText messageInput;
    private Button submitButton;
    private ImageView whatsappIcon, instagramIcon, twitterIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Initialize views
        messageInput = findViewById(R.id.messageInput);
        submitButton = findViewById(R.id.submitButton);
        whatsappIcon = findViewById(R.id.whatsappIcon);
        instagramIcon = findViewById(R.id.instagramIcon);
        twitterIcon = findViewById(R.id.twitterIcon);

        // Handle back button
        findViewById(R.id.backButton).setOnClickListener(v -> {
            Intent intent = new Intent(ContactActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        whatsappIcon.setOnClickListener(v -> {
            String whatsappNumber = "+6285334376542";
            String url = "https://wa.me/" + whatsappNumber;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        instagramIcon.setOnClickListener(v -> {
            String instagramUsername = "yessu.na";
            String url = "https://instagram.com/" + instagramUsername;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        twitterIcon.setOnClickListener(v -> {
            String twitterUsername = "aertehaa";
            String url = "https://twitter.com/" + twitterUsername;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // Send Message (Send email)
        submitButton.setOnClickListener(v -> {
            String emailSubject = "Message from Contact Us";
            String emailBody = messageInput.getText().toString();
            if (!emailBody.isEmpty()) {
                sendEmail(emailSubject, emailBody);
            }
        });
    }

    private void sendEmail(String subject, String body) {
        String recipientEmail = "yessyalfiah@gmail.com"; // Replace with your email address

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", recipientEmail, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
