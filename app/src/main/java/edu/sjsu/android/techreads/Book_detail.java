package edu.sjsu.android.techreads;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.media.Rating;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toolbar;


public class Book_detail extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView bookTitle = (TextView) findViewById(R.id.bookTitle_textView);
        TextView bookDesc = (TextView) findViewById(R.id.content_textView);
        ImageView bookImage = (ImageView) findViewById(R.id.book_imageView);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            bookTitle.setText(b.getString("title"));
            bookDesc.setText(b.getString("description"));
            int bookresid = b.getInt("image");
            bookImage.setImageResource(bookresid);
            ratingBar.setRating(b.getFloat("rating"));
        }
    }
}