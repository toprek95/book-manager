package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bookmanager.Adapters.BooksRecyclerViewAdapter;

public class AllBooksActivity extends AppCompatActivity {

	private RecyclerView allBooksRecyclerView;
	private BooksRecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_books);

		initViews();


		adapter = new BooksRecyclerViewAdapter(AllBooksActivity.this);
		adapter.setBooks(Utils.getInstance().getAllBooks());

		allBooksRecyclerView.setAdapter(adapter);
		allBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));


	}

	private void initViews() {
		allBooksRecyclerView = this.findViewById(R.id.all_books_recycler_view);
	}
}
