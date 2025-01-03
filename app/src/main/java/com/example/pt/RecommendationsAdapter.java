package com.example.pt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecommendationsAdapter extends ArrayAdapter<Book> {

    private Context context;
    private ArrayList<Book> books;

    public RecommendationsAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
        this.context = context;
        this.books = books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recommendation, parent, false);
        }

        Book currentBook = books.get(position);

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView authorTextView = convertView.findViewById(R.id.authorTextView);
        TextView genreTextView = convertView.findViewById(R.id.genreTextView);

        titleTextView.setText(currentBook.getTitle());
        authorTextView.setText("By: " + currentBook.getAuthor());
        genreTextView.setText("kelompok9: " + currentBook.getGenre());

        return convertView;
    }
}
