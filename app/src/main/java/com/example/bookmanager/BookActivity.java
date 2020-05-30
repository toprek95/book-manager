package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bookmanager.Models.Book;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

	public static final String BOOK_ID_KEY = "bookId";
	private ImageView bookImage;
	private TextView bookName, authorName, numberOfPages, longDescription;
	private MaterialButton currentlyReadingBooksButton, addToFavouritesBooksButton, alreadyReadBooksButton, addToWishListBooksButton;
	private boolean isAlreadyReadButtonClicked = false;
	private boolean isCurrentlyReadingButtonClicked = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book);

		initViews();

		Intent intent = getIntent();

		if (null != intent) {
			int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
			if (bookId != -1) {
				Book selectedBook = Utils.getInstance().getBookById(bookId);
				if (null != selectedBook) {
					setBookViewData(selectedBook);

					handleCurrentlyReadingBooksButton(selectedBook);

					handleAddToFavouritesButton(selectedBook);

					handleAlreadyReadBooksButton(selectedBook);

					handleAddToWishListBooksButton(selectedBook);
				}
			}
		}
	}

	private void handleAddToWishListBooksButton(final Book currentBook) {
		ArrayList<Book> wishListBooks = Utils.getInstance().getWishListBooks();
		ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
		ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();

		boolean existsInWishListBooks = false;
		boolean existsInAlreadyReadBooks = false;
		boolean existsInCurrentlyReadingBooks = false;

		if (null != wishListBooks) {
			for (Book book : wishListBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInWishListBooks = true;
				}
			}
		}

		if (null != alreadyReadBooks) {
			for (Book book : alreadyReadBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInAlreadyReadBooks = true;
				}
			}
		}

		if (null != currentlyReadingBooks) {
			for (Book book : currentlyReadingBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInCurrentlyReadingBooks = true;
				}
			}
		}

		if (existsInWishListBooks) {
			addToWishListBooksButton.setIconResource(R.drawable.ic_check);
			addToWishListBooksButton.setClickable(false);
		} else {
			final boolean finalExistsInAlreadyReadBooks = existsInAlreadyReadBooks;
			final boolean finalExistsInCurrentlyReadingBooks = existsInCurrentlyReadingBooks;
			addToWishListBooksButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.addWishListBook(currentBook)) {
						if (finalExistsInAlreadyReadBooks) {
							alreadyReadBooksButton.setIcon(null);
							alreadyReadBooksButton.setClickable(true);
							Utils.removeFromAlreadyReadBooks(currentBook);
						}
						if (finalExistsInCurrentlyReadingBooks) {
							currentlyReadingBooksButton.setIcon(null);
							currentlyReadingBooksButton.setClickable(true);
							Utils.removeFromCurrentlyReadingBooks(currentBook);
						}
						Toast.makeText(BookActivity.this, "Book added to wishlist. Hope you get it soon.", Toast.LENGTH_SHORT).show();
						//TODO: navigate user to WishListBooksActivity
						Intent intent = new Intent(BookActivity.this, MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
					} else {
						Toast.makeText(BookActivity.this, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	private void handleAlreadyReadBooksButton(final Book currentBook) {
		ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
		ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();
		ArrayList<Book> wishListBooks = Utils.getInstance().getWishListBooks();

		boolean existsInAlreadyReadBooks = false;
		boolean existsInCurrentlyReadingBooks = false;
		boolean existsInWishListBooks = false;

		if (null != alreadyReadBooks) {
			for (Book book : alreadyReadBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInAlreadyReadBooks = true;
				}
			}
		}

		if (null != currentlyReadingBooks) {
			for (Book book : currentlyReadingBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInCurrentlyReadingBooks = true;
				}
			}
		}

		if (null != wishListBooks) {
			for (Book book : wishListBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInWishListBooks = true;
				}
			}
		}

		if (existsInAlreadyReadBooks) {
			alreadyReadBooksButton.setIconResource(R.drawable.ic_check);
			alreadyReadBooksButton.setClickable(false);
		} else {
			final boolean finalExistsInCurrentlyReadingBooks = existsInCurrentlyReadingBooks;
			final boolean finalExistsInWishListBooks = existsInWishListBooks;
			alreadyReadBooksButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.addAlreadyReadBook(currentBook)) {
						if (finalExistsInCurrentlyReadingBooks) {
							currentlyReadingBooksButton.setIcon(null);
							currentlyReadingBooksButton.setCheckable(true);
							Utils.removeFromCurrentlyReadingBooks(currentBook);
						}
						if (finalExistsInWishListBooks) {
							addToWishListBooksButton.setIcon(null);
							addToWishListBooksButton.setClickable(true);
							Utils.removeFromWishListBooks(currentBook);
						}
						Toast.makeText(BookActivity.this, "Congrats on reading this book.", Toast.LENGTH_SHORT).show();
						//TODO: navigate user to AlreadyReadBooksActivity
						Intent intent = new Intent(BookActivity.this, MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
					} else {
						Toast.makeText(BookActivity.this, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	private void handleAddToFavouritesButton(final Book currentBook) {
		ArrayList<Book> favouriteBooks = Utils.getInstance().getFavouriteBooks();

		boolean existsInFavouriteBooks = false;

		if (null != favouriteBooks) {
			for (Book book : favouriteBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInFavouriteBooks = true;
				}
			}
		}

		if (existsInFavouriteBooks) {
			addToFavouritesBooksButton.setIconResource(R.drawable.ic_check);
			addToFavouritesBooksButton.setClickable(false);
		} else {
			addToFavouritesBooksButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.addFavouriteBook(currentBook)) {
						Toast.makeText(BookActivity.this, "Added to favourite books.", Toast.LENGTH_SHORT).show();
						//TODO: navigate user to FavouriteBooksActivity
						Intent intent = new Intent(BookActivity.this, MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
					} else {
						Toast.makeText(BookActivity.this, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	private void handleCurrentlyReadingBooksButton(final Book currentBook) {
		ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();
		ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
		ArrayList<Book> wishListBooks = Utils.getInstance().getWishListBooks();

		boolean existsInCurrentlyReadingBooks = false;
		boolean existsInAlreadyReadBooks = false;
		boolean existsInWishListBooks = false;

		if (null != currentlyReadingBooks) {
			for (Book book : currentlyReadingBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInCurrentlyReadingBooks = true;
				}
			}
		}

		if (null != alreadyReadBooks) {
			for (Book book : alreadyReadBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInAlreadyReadBooks = true;
				}
			}
		}

		if (null != wishListBooks) {
			for (Book book : wishListBooks) {
				if (book.getId() == currentBook.getId()) {
					existsInWishListBooks = true;
				}
			}
		}

		if (existsInCurrentlyReadingBooks) {
			currentlyReadingBooksButton.setIconResource(R.drawable.ic_check);
			currentlyReadingBooksButton.setClickable(false);
		} else {
			final boolean finalExistsInAlreadyReadBooks = existsInAlreadyReadBooks;
			final boolean finalExistsInWishListBooks = existsInWishListBooks;
			currentlyReadingBooksButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.addCurrentlyReadingBook(currentBook)) {
						if (finalExistsInAlreadyReadBooks) {
							alreadyReadBooksButton.setIcon(null);
							alreadyReadBooksButton.setCheckable(true);
							Utils.removeFromAlreadyReadBooks(currentBook);
						}

						if (finalExistsInWishListBooks) {
							addToWishListBooksButton.setIcon(null);
							addToWishListBooksButton.setClickable(true);
							Utils.removeFromWishListBooks(currentBook);
						}

						Toast.makeText(BookActivity.this, "You are currently reading this book.", Toast.LENGTH_SHORT).show();
						//TODO: navigate user to CurrentlyReadingBooksActivity
						Intent intent = new Intent(BookActivity.this, MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
					} else {
						Toast.makeText(BookActivity.this, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	private void initViews() {
		bookImage = findViewById(R.id.book_image_book_layout);

		bookName = findViewById(R.id.book_name_book_layout);
		authorName = findViewById(R.id.author_book_layout);
		numberOfPages = findViewById(R.id.number_of_pages_book_layout);
		longDescription = findViewById(R.id.long_description_book_layout);

		currentlyReadingBooksButton = findViewById(R.id.currently_reading_books_button_book_layout);
		addToFavouritesBooksButton = findViewById(R.id.favourites_books_button_book_layout);
		alreadyReadBooksButton = findViewById(R.id.already_read_books_button_book_layout);
		addToWishListBooksButton = findViewById(R.id.wish_list_books_button_book_layout);
	}

	private void setBookViewData(Book book) {
		bookName.setText(book.getName());
		authorName.setText(book.getAuthor());
		numberOfPages.setText(String.valueOf(book.getNumberOdPages()));
		longDescription.setText(book.getLongDescription());

		Glide.with(this)
				.asBitmap()
				.load(book.getImageUrl())
				.into(bookImage);
	}
}
