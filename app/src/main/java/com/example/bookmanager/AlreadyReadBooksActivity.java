package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bookmanager.Adapters.BooksRecyclerViewAdapter;

public class AlreadyReadBooksActivity extends AppCompatActivity {

	public static final String ALREADY_READ_BOOKS_ACTIVITY_NAME = "alreadyReadBooks";
	private RecyclerView alreadyReadBooksRecyclerView;
	private BooksRecyclerViewAdapter adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_already_read_books);

		alreadyReadBooksRecyclerView = findViewById(R.id.already_read_books_recycler_view);
		adapter = new BooksRecyclerViewAdapter(AlreadyReadBooksActivity.this, ALREADY_READ_BOOKS_ACTIVITY_NAME);

		adapter.setBooks(Utils.minimize(Utils.getAlreadyReadBooks()));

		alreadyReadBooksRecyclerView.setAdapter(adapter);
		alreadyReadBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
}