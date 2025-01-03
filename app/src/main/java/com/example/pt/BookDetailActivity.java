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
        books.add("Laut Bercerita");

        ListView bookListView = findViewById(R.id.bookListView);
        BookAdapter adapter = new BookAdapter(this, books);
        bookListView.setAdapter(adapter);

        bookListView.setOnItemClickListener((parent, view, position, id) -> {
            int imageResource;
            switch (position) {
                case 0:
                    imageResource = R.drawable.image1;
                    break;
                case 1:
                    imageResource = R.drawable.image2;
                    break;
                case 2:
                    imageResource = R.drawable.image3;
                    break;
                case 3:
                    imageResource = R.drawable.image4;
                    break;
                case 4:
                    imageResource = R.drawable.image5;
                    break;
                case 5:
                    imageResource = R.drawable.image6;
                    break;
                case 6:
                    imageResource = R.drawable.image7;
                    break;
                case 7:
                    imageResource = R.drawable.image8;
                    break;
                case 8:
                    imageResource = R.drawable.image9;
                    break;
                case 9:
                    imageResource = R.drawable.image10;
                    break;
                case 10:
                    imageResource = R.drawable.image11;
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
