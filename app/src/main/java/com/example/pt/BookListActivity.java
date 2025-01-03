package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private ListView bookListView;
    private TextView categoryTitle;
    private List<String> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        bookListView = findViewById(R.id.bookListView);
        categoryTitle = findViewById(R.id.categoryTitle);


        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        categoryTitle.setText(category + " Books");


        if ("Fiction".equals(category)) {
            bookList.add("Laut Bercerita");
        } else if ("Non-Fiction".equals(category)) {
            bookList.add("Buku Ajar Pengantar Sistem Informasi");
            bookList.add("Modul Programing");
            bookList.add("Mobile Programing For Student");
            bookList.add("Geomatika");
            bookList.add("Dasar Teknik Digital");
            bookList.add("Dasar-Dasar Teknik Informatika");
            bookList.add("Teknik Komputer Dan Jaringan");
            bookList.add("Teknik Pemesinan FRAIS");
            bookList.add("Menjadi Pribadi Yang Menyenangkan");
            bookList.add("Tehnik Farmasi");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList);
        bookListView.setAdapter(adapter);

        bookListView.setOnItemClickListener((parent, view, position, id) -> {
            int imageResource;
            switch (category) {
                case "Fiction":
                    switch (position) {
                        case 0:
                            imageResource = R.drawable.image11;
                            break;
                        default:
                            imageResource = -1;
                            break;
                    }
                    break;

                case "Non-Fiction":
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
                        default:
                            imageResource = -1;
                            break;
                    }
                    break;

                default:
                    imageResource = -1;
                    break;
            }

            if (imageResource != -1) {
                Toast.makeText(this, "Buku Tersedia Di Daftar List Buku : " + bookList.get(position), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Buku Lagi kosong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
