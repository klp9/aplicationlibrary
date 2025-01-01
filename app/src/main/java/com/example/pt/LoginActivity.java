package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth; // Firebase Authentication Instance
    private EditText emailField, passwordField; // Input fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Menggunakan layout activity_login.xml

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Menghubungkan elemen layout ke variabel Java
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton); // Tombol Register

        // Listener untuk tombol Login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil input dari user
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                // Validasi input
                if (email.isEmpty()) {
                    emailField.setError("Email is required");
                    emailField.requestFocus();
                } else if (password.isEmpty()) {
                    passwordField.setError("Password is required");
                    passwordField.requestFocus();
                } else {
                    // Lakukan proses login
                    loginUser(email, password);
                }
            }
        });

        // Listener untuk tombol Register
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman RegisterActivity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    // Metode untuk login menggunakan Firebase Authentication
    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    // Login berhasil
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                    // Pindah ke HomeActivity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Selesaikan LoginActivity agar tidak kembali ke sini
                } else {
                    // Jika login gagal
                    Toast.makeText(LoginActivity.this, "Login failed. Check your credentials.", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
