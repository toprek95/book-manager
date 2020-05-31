package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.bookmanager.Adapters.BooksRecyclerViewAdapter;

public class CurrentlyReadingBooksActivity extends AppCompatActivity {

	public static final String CURRENTLY_READING_BOOKS_ACTIVITY_NAME = "currentlyReadingBooks";
	private RecyclerView currentlyReadingBooksRecyclerView;
	private BooksRecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currently_reading_books);

		currentlyReadingBooksRecyclerView = findViewById(R.id.currently_reading_books_recycler_view);
		adapter = new BooksRecyclerViewAdapter(CurrentlyReadingBooksActivity.this, CURRENTLY_READING_BOOKS_ACTIVITY_NAME);

		adapter.setBooks(Utils.minimize(Utils.getCurrentlyReadingBooks()));

		currentlyReadingBooksRecyclerView.setAdapter(adapter);
		currentlyReadingBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
}
