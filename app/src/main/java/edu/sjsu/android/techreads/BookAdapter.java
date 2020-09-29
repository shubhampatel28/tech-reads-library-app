package edu.sjsu.android.techreads;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Book> bookArrayList;
    private onBookClick listener;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView bookNameTextView;
        public TextView authorTextView;
        ImageView bookImageView;

        public ViewHolder(View mBookView) {
            super(mBookView);
            bookNameTextView = mBookView.findViewById(R.id.bookTitle);
            authorTextView = mBookView.findViewById(R.id.authorName);
            bookImageView = mBookView.findViewById(R.id.bookImage);
            mBookView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface onBookClick {
        void onClick(View view, int position);
    }

    public BookAdapter(ArrayList<Book> bookArrayList, onBookClick listerner) {
        //mInflater = LayoutInflater.from(context);
        this.bookArrayList = bookArrayList;
        this.listener = listerner;
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        View mBookView = mInflater.inflate(R.layout.books_list, parent, false);
        return new ViewHolder(mBookView);
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {
        Book currentPosition = bookArrayList.get(position);
        holder.bookNameTextView.setText(currentPosition.getBookTitle());
        holder.authorTextView.setText(currentPosition.getBookAuthor());
        holder.bookImageView.setImageResource(currentPosition.getBookImage());
    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }


}
