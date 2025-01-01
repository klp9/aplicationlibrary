package com.example.pt;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);  // Pastikan nama layout XML sesuai dengan yang Anda miliki

        // Inisialisasi Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Tambahkan tombol back di Toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Gambar Ilustrasi - Interaksi
        ImageView illustration = findViewById(R.id.appIcon);  // Pastikan ID gambar di XML sesuai dengan yang digunakan
        illustration.setOnClickListener(v -> {
            Toast.makeText(this, "Selamat membaca!", Toast.LENGTH_SHORT).show();
        });

        // Statistik Pengguna - Interaksi
        findViewById(R.id.statisticContainer).setOnClickListener(v -> {
            Toast.makeText(this, "Statistik akan segera diperbarui!", Toast.LENGTH_SHORT).show();
        });
    }

    // Menangani tombol back di Toolbar
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Kembali ke halaman sebelumnya
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
