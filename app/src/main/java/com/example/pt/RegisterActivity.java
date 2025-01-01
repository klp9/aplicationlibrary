package com.example.pt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth; // Firebase Authentication Instance
    private EditText emailField, passwordField, confirmPasswordField; // Input fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Layout untuk register

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Menghubungkan elemen layout ke variabel Java
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        confirmPasswordField = findViewById(R.id.confirmPasswordField);
        Button registerButton = findViewById(R.id.registerButton);

        // Listener untuk tombol Register
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil input dari user
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();
                String confirmPassword = confirmPasswordField.getText().toString().trim();

                // Validasi input
                if (email.isEmpty()) {
                    emailField.setError("Email is required");
                    emailField.requestFocus();
                } else if (password.isEmpty()) {
                    passwordField.setError("Password is required");
                    passwordField.requestFocus();
                } else if (confirmPassword.isEmpty()) {
                    confirmPasswordField.setError("Please confirm your password");
                    confirmPasswordField.requestFocus();
                } else if (!password.equals(confirmPassword)) {
                    confirmPasswordField.setError("Passwords do not match");
                    confirmPasswordField.requestFocus();
                } else {
                    // Lakukan proses pendaftaran
                    registerUser(email, password);
                }
            }
        });
    }

    // Metode untuk register pengguna baru dengan Firebase Authentication
    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    // Pendaftaran berhasil
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    finish(); // Kembali ke LoginActivity
                } else {
                    // Jika pendaftaran gagal
                    Toast.makeText(RegisterActivity.this, "Registration failed. Try again.", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
