package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // Daftar buku (10 buku)
        ArrayList<String> books = new ArrayList<>();
        books.add("Buku Ajar Pengantar Sistem Informasi");
        books.add("Modul Programing");
        books.add("Mobile Programing For Student");
        books.add("Mekanika Bahan");
        books.add("Geomatika");
        books.add("Dasar Teknik Digital");
        books.add("Dasar-Dasar Teknik Informatika");
        books.add("Teknik Komputer Dan Jaringan");
        books.add("Teknik Pemesinan FRAIS");
        books.add("Menjadi Pribadi Yang Menyenangkan");

        // Menyiapkan ListView
        ListView bookListView = findViewById(R.id.bookListView);
        BookAdapter adapter = new BookAdapter(this, books);
        bookListView.setAdapter(adapter);

        // Mengatur listener klik pada daftar buku
        bookListView.setOnItemClickListener((parent, view, position, id) -> {
            int imageResource;
            switch (position) {
                case 0:
                    imageResource = R.drawable.image1; // Gambar 1
                    break;
                case 1:
                    imageResource = R.drawable.image2; // Gambar 2
                    break;
                case 2:
                    imageResource = R.drawable.image3; // Gambar 3
                    break;
                case 3:
                    imageResource = R.drawable.image4; // Gambar 4
                    break;
                case 4:
                    imageResource = R.drawable.image5; // Gambar 5
                    break;
                case 5:
                    imageResource = R.drawable.image6; // Gambar 6
                    break;
                case 6:
                    imageResource = R.drawable.image7; // Gambar 7
                    break;
                case 7:
                    imageResource = R.drawable.image8; // Gambar 8
                    break;
                case 8:
                    imageResource = R.drawable.image9; // Gambar 9
                    break;
                case 9:
                    imageResource = R.drawable.image10; // Gambar 10
                    break;
                default:
                    imageResource = -1;
                    break;
            }

            if (imageResource != -1) {
                Intent intent = new Intent(BookDetailActivity.this, BookInfoActivity.class);
                intent.putExtra("imageResource", imageResource);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Image not found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
