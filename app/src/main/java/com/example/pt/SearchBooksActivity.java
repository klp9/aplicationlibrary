package com.example.pt;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class SearchBooksActivity extends AppCompatActivity {

    private EditText searchInput;
    private Button searchButton;
    private ListView searchResultsListView;

    // Daftar buku yang akan dicari
    private List<String> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);

        // Inisialisasi view
        searchInput = findViewById(R.id.searchInput);
        searchButton = findViewById(R.id.searchButton);
        searchResultsListView = findViewById(R.id.searchResultsListView);

        // Daftar buku yang ada
        bookList.add("Book 1");
        bookList.add("Book 2");
        bookList.add("Book 3");
        bookList.add("Book 4");
        bookList.add("Book 5");
        bookList.add("Book 6");
        bookList.add("Book 7");
        bookList.add("Book 8");
        bookList.add("Book 9");
        bookList.add("Book 10");

        // Setup button click listener untuk mencari buku
        searchButton.setOnClickListener(v -> {
            String query = searchInput.getText().toString().trim();
            if (!query.isEmpty()) {
                // Pencarian buku yang mengandung query
                searchBooks(query);
            } else {
                Toast.makeText(this, "Please enter a book name to search", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void searchBooks(String query) {
        List<String> result = new ArrayList<>();
        for (String book : bookList) {
            if (book.toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }

        if (!result.isEmpty()) {
            // Menampilkan hasil pencarian di ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, result);
            searchResultsListView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No books found", Toast.LENGTH_SHORT).show();
        }
    }
}
