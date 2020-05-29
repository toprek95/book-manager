package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	private Button allBooksButton, currentlyReadingBooks, alreadyReadBooks, wishListBooksButton, favouritesBooksButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// To hide action bar
//		Objects.requireNonNull(getSupportActionBar()).hide();

		//To change action bar background dolor
//		Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
		setContentView(R.layout.activity_main);

		//Initialize all view fields on activity_main layout
		initViews();

	}

	private void initViews() {
		allBooksButton = findViewById(R.id.all_books_button);
		currentlyReadingBooks = findViewById(R.id.currently_reading_books_button);
		alreadyReadBooks = findViewById(R.id.already_read_books_button);
		wishListBooksButton = findViewById(R.id.wish_list_books_button);
		favouritesBooksButton = findViewById(R.id.favourites_books_button);
	}
}
