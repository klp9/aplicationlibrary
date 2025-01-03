package com.example.pt;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchBooksActivity extends AppCompatActivity {

    private EditText searchInput;
    private Button searchButton;
    private ListView searchResultsListView;
    private ImageView bookImageView;

    private List<String> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);

        // Inisialisasi komponen UI
        searchInput = findViewById(R.id.searchInput);
        searchButton = findViewById(R.id.searchButton);
        searchResultsListView = findViewById(R.id.searchResultsListView);
        bookImageView = findViewById(R.id.bookImageView);

        // Daftar buku
        bookList.add("Buku Ajar Pengantar Sistem Informasi");
        bookList.add("Modul Programing");
        bookList.add("Mobile Programing For Student");
        bookList.add("Mekanika Bahan");
        bookList.add("Geomatika");
        bookList.add("Dasar Teknik Digital");
        bookList.add("Dasar-Dasar Teknik Informatika");
        bookList.add("Teknik Komputer Dan Jaringan");
        bookList.add("Teknik Pemesinan FRAIS");
        bookList.add("Menjadi Pribadi Yang Menyenangkan");

        // Set tombol pencarian
        searchButton.setOnClickListener(v -> {
            String query = searchInput.getText().toString().trim();
            if (!query.isEmpty()) {
                searchBooks(query);
            } else {
                Toast.makeText(this, "Please enter a book name to search", Toast.LENGTH_SHORT).show();
            }
        });

        // Tampilkan gambar saat item dipilih
        searchResultsListView.setOnItemClickListener((parent, view, position, id) -> {
            int imageResource = getImageResource(position);
            if (imageResource != -1) {
                bookImageView.setImageResource(imageResource);
            } else {
                Toast.makeText(this, "Image not available", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Pencarian buku berdasarkan kata kunci
    private void searchBooks(String query) {
        List<String> result = new ArrayList<>();
        for (String book : bookList) {
            if (book.toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }

        if (!result.isEmpty()) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, result);
            searchResultsListView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No books found", Toast.LENGTH_SHORT).show();
        }
    }

    // Mengembalikan resource gambar berdasarkan posisi
    private int getImageResource(int position) {
        switch (position) {
            case 0:
                return R.drawable.image1;
            case 1:
                return R.drawable.image2;
            case 2:
                return R.drawable.image3;
            case 3:
                return R.drawable.image4;
            case 4:
                return R.drawable.image5;
            case 5:
                return R.drawable.image6;
            case 6:
                return R.drawable.image7;
            case 7:
                return R.drawable.image8;
            case 8:
                return R.drawable.image9;
            case 9:
                return R.drawable.image10;
            case 10:
                return R.drawable.image11;
            default:
                return -1;
        }
    }
}
