package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cmaier on 14.11.17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    /**
     * Constructor
     * @param context   current context to inflate layout file
     * @param words     List of Word objects to display
     */
    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }
    /**
     * {@inheritDoc}
     *
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the Word to display and fill the Views in the listItemView
        Word wordUp = getItem(position);
        ((TextView) listItemView.findViewById(R.id.line_1)).setText(wordUp.getMiwok());
        ((TextView) listItemView.findViewById(R.id.line_2)).setText(wordUp.getDefault());
        return listItemView;
    }
}
