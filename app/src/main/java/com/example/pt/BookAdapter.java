package com.example.pt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class BookAdapter extends ArrayAdapter<String> {

    public BookAdapter(Context context, List<String> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        String book = getItem(position);
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(book);

        return convertView;
    }
}
