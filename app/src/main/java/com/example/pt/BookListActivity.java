package com.example.pt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        // Mendapatkan kategori yang dipilih dari intent
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        // Menampilkan judul kategori
        categoryTitle.setText(category + " Books");

        // Mengisi daftar buku berdasarkan kategori yang dipilih
        if ("Fiction".equals(category)) {
            bookList.add("Fiction Menjadi Pribadi Yang Menyenangkan");
            bookList.add("Fiction Book 2");
            bookList.add("Fiction Book 3");
            bookList.add("Fiction Book 4");
        } else if ("Non-Fiction".equals(category)) {
            bookList.add("Non-Fiction Book 1");
            bookList.add("Non-Fiction Book 2");
            bookList.add("Non-Fiction Book 3");
            bookList.add("Non-Fiction Book 4");
        }

        // Menampilkan daftar buku di ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList);
        bookListView.setAdapter(adapter);
    }
}
