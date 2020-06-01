package com.example.bookmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bookmanager.Adapters.BooksRecyclerViewAdapter;

import java.util.Objects;

public class AllBooksActivity extends AppCompatActivity {

	private RecyclerView allBooksRecyclerView;
	private BooksRecyclerViewAdapter adapter;
	public static final String ALL_BOOKS_ACTIVITY_NAME = "allBooks";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_books);

//		//To set display back arrow in action bar
//		Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

		initViews();


		adapter = new BooksRecyclerViewAdapter(AllBooksActivity.this, ALL_BOOKS_ACTIVITY_NAME);
		adapter.setBooks(Utils.minimize(Utils.getInstance(this).getAllBooks()));

		allBooksRecyclerView.setAdapter(adapter);
		allBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));


	}

//	//On back arrow clicked
//	@Override
//	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//		switch (item.getItemId()) {
//			case android.R.id.home:
//				onBackPressed();
//				break;
//			default:
//				break;
//		}
//		return super.onOptionsItemSelected(item);
//	}

	private void initViews() {
		allBooksRecyclerView = this.findViewById(R.id.all_books_recycler_view);
	}
}
