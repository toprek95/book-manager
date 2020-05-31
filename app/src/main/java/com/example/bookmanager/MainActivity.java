package com.example.bookmanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.bookmanager.WebsiteActivity.URL_NAME_TAG;

public class MainActivity extends AppCompatActivity {

	private Button allBooksButton, currentlyReadingBooks, alreadyReadBooksButton, wishlistBooksButton, favouritesBooksButton, aboutButton;

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

		allBooksButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
				startActivity(intent);
			}
		});

		currentlyReadingBooks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CurrentlyReadingBooksActivity.class);
				startActivity(intent);
			}
		});

		alreadyReadBooksButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AlreadyReadBooksActivity.class);
				startActivity(intent);
			}
		});

		favouritesBooksButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, FavouriteBooksActivity.class);
				startActivity(intent);
			}
		});

		wishlistBooksButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, WishlistBooksActivity.class);
				startActivity(intent);
			}
		});

		aboutButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
				alertDialog.setTitle(getString(R.string.app_name));
				alertDialog.setMessage(getString(R.string.app_description));
				alertDialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				alertDialog.setCancelable(false);
				alertDialog.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
						intent.putExtra(URL_NAME_TAG, "https://github.com/toprek95");
						startActivity(intent);
					}
				});
				alertDialog.create().show();
			}
		});

		//Create instance of Utils singleton class, to initialize data so you can call static methods without exception
		Utils.getInstance();

	}

	private void initViews() {
		allBooksButton = findViewById(R.id.all_books_button);
		currentlyReadingBooks = findViewById(R.id.currently_reading_books_button);
		alreadyReadBooksButton = findViewById(R.id.already_read_books_button);
		wishlistBooksButton = findViewById(R.id.wish_list_books_button);
		favouritesBooksButton = findViewById(R.id.favourites_books_button);
		aboutButton = findViewById(R.id.about_button);
	}
}
