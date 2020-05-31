package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bookmanager.Adapters.BooksRecyclerViewAdapter;

public class WishlistBooksActivity extends AppCompatActivity {

	private RecyclerView wishlistBooksRecyclerView;
	private BooksRecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wishlist_books);

		wishlistBooksRecyclerView = findViewById(R.id.wishlist_books_recycler_view);
		adapter = new BooksRecyclerViewAdapter(this);

		adapter.setBooks(Utils.getInstance().getWishListBooks());

		wishlistBooksRecyclerView.setAdapter(adapter);
		wishlistBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
}
