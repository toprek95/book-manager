package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookmanager.Adapters.AllBooksRecyclerViewAdapter;
import com.example.bookmanager.Models.Book;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

	private RecyclerView allBooksRecyclerView;
	private Button toggleListGridButton;
	private AllBooksRecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_books);

		initViews();


		adapter = new AllBooksRecyclerViewAdapter(AllBooksActivity.this);
		adapter.setBooks(Utils.getInstance().getAllBooks());

		allBooksRecyclerView.setAdapter(adapter);
		allBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));


	}

	private void initViews() {
		allBooksRecyclerView = this.findViewById(R.id.all_books_recycler_view);
		toggleListGridButton = this.findViewById(R.id.toggle_grid_list_button);
	}
}
