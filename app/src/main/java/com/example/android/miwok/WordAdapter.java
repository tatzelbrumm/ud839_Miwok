package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cmaier on 14.11.17.
 * A hand crafted ArrayAdapter for Word class
 * that can handle an optional image and two lines of text
 */
public class WordAdapter extends ArrayAdapter<Word> {
    /** background color for list item text */
    private int mColorResourceId;
    /**
     * Constructor
     * @param context   current context to inflate layout file
     * @param words     List of Word objects to display
     * @param colorId   background color resource ID for list item text
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorId)
    {
        super(context, 0, words);
        mColorResourceId = colorId;
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
        // set the background color of the text field
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        listItemView.findViewById(R.id.item).setBackgroundColor(color);
        // Get the Word to display and fill the Views in the listItemView
        Word wordUp = getItem(position);
        ((TextView) listItemView.findViewById(R.id.line_1)).setText(wordUp.getMiwok());
        ((TextView) listItemView.findViewById(R.id.line_2)).setText(wordUp.getDefault());
        ImageView img = (ImageView) listItemView.findViewById(R.id.image_label);
        if (wordUp.hasImage()) {
            img.setImageResource(wordUp.getImageResourceId());
            img.setVisibility(View.VISIBLE);
        }
        else
        {
            img.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
