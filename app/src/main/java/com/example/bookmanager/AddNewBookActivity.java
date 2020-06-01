package com.example.bookmanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.bookmanager.Models.Book;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class AddNewBookActivity extends AppCompatActivity {

	private TextInputEditText bookName, authorName, numberOfPages, bookImageUrl, bookUrl, shortDesc, longDesc;
	private MaterialButton addNewBookButton, cancelAddButton;
	private RelativeLayout parentLayout;
	private boolean areEntriesCorrect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_book);

		initViews();

		cancelAddButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showCancelAlertDialog();
			}
		});

		addNewBookButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				areEntriesCorrect = true;
				if (bookName.getText().toString().isEmpty()) {
					bookName.setError("Enter book name");
					areEntriesCorrect = false;
				}
				if (authorName.getText().toString().isEmpty()) {
					authorName.setError("Enter author name");
					areEntriesCorrect = false;
				}
				if (numberOfPages.getText().toString().isEmpty()) {
					numberOfPages.setError("Enter number of pages");
					areEntriesCorrect = false;
				}
				if (bookImageUrl.getText().toString().isEmpty()) {
					bookImageUrl.setError("Enter book URL");
					areEntriesCorrect = false;
				}
				if (bookUrl.getText().toString().isEmpty()) {
					bookUrl.setError("Enter book URL");
					areEntriesCorrect = false;
				}

				if (areEntriesCorrect) {
					String bookNameInput = bookName.getText().toString();
					String authorNameInput = authorName.getText().toString();
					int numberOfPagesInput = Integer.parseInt(numberOfPages.getText().toString());
					String bookImageUrlInput = bookImageUrl.getText().toString();
					String bookUrlInput = bookUrl.getText().toString();
					String shortDescInput = shortDesc.getText().toString();
					String longDescInput = longDesc.getText().toString();
					int nextId = Utils.getInstance(AddNewBookActivity.this).getNextId();

					Book book = new Book(nextId, bookNameInput, authorNameInput, numberOfPagesInput, bookImageUrlInput, shortDescInput, longDescInput, bookUrlInput);

					addNewBook(book);
				}
			}
		});

		removeWarnings();
	}

	private void addNewBook(Book book) {
		if (Utils.getInstance(AddNewBookActivity.this).addNewBook(book)) {
			Toast.makeText(AddNewBookActivity.this, "New book added.", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(AddNewBookActivity.this, AllBooksActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		} else {
			showSnackbar(book);
		}
	}

	private void initViews() {
		bookName = findViewById(R.id.add_new_book_name);
		authorName = findViewById(R.id.add_new_book_author_name);
		numberOfPages = findViewById(R.id.add_new_book_pages);
		bookImageUrl = findViewById(R.id.add_new_book_image_url);
		bookUrl = findViewById(R.id.add_new_book_url);
		shortDesc = findViewById(R.id.add_new_book_short_desc);
		longDesc = findViewById(R.id.add_new_book_long_desc);

		addNewBookButton = findViewById(R.id.button_add_new_book);
		cancelAddButton = findViewById(R.id.button_cancel_add_new_book);

		parentLayout = findViewById(R.id.add_new_book_parent_relative_layout);
	}

	private void showCancelAlertDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(AddNewBookActivity.this);
		builder.setTitle("Quit editor");
		builder.setMessage("Do you want to cancel adding a new book?");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				AddNewBookActivity.super.onBackPressed();
			}
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});
		builder.setCancelable(false);
		builder.create().show();
	}

	private void removeWarnings() {

		bookName.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				bookName.setError(null);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});


		authorName.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				authorName.setError(null);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		numberOfPages.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				numberOfPages.setError(null);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		bookImageUrl.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				bookImageUrl.setError(null);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		bookUrl.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				bookUrl.setError(null);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

	}

	private void showSnackbar(final Book book) {
		Snackbar snackbar = Snackbar.make(parentLayout, "Something went wrong. Please try again.", Snackbar.LENGTH_INDEFINITE)
				.setAction("RETRY", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						addNewBook(book);
					}
				})
				.setAnchorView(R.id.button_add_new_book);
		snackbar.show();
	}

	@Override
	public void onBackPressed() {
		showCancelAlertDialog();
	}
}