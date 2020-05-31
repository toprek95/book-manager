package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bookmanager.Adapters.BooksRecyclerViewAdapter;

public class FavouriteBooksActivity extends AppCompatActivity {

	private RecyclerView favouriteBooksRecyclerView;
	private BooksRecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favourite_books);

		favouriteBooksRecyclerView = findViewById(R.id.favourite_books_recycler_view);
		adapter = new BooksRecyclerViewAdapter(this);

		adapter.setBooks(Utils.getInstance().getFavouriteBooks());
		favouriteBooksRecyclerView.setAdapter(adapter);
		favouriteBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
}
