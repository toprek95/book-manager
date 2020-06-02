package com.example.bookmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.example.bookmanager.Models.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Utils {

	private static final String PREFERENCE_NAME = "alternative_db";
	private static final String ALL_BOOKS_KEY = "all_books";
	private static final String FAVOURITE_BOOKS_KEY = "favourite_books";
	private static final String ALREADY_READ_BOOKS_KEY = "already_read_books";
	private static final String WISHLIST_BOOKS_KEY = "wishlist_books";
	private static final String CURRENTLY_READING_BOOKS_KEY = "currently_reading_books";
	private static Utils instance;
	private SharedPreferences sharedPreferences;

//	private static ArrayList<Book> allBooks, favouriteBooks, alreadyReadBooks, wishListBooks, currentlyReadingBooks;

	private Utils(Context context) {

		sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

		if (null == getAllBooks()) {
			initData();
		}

		SharedPreferences.Editor editor = sharedPreferences.edit();
		Gson gson = new Gson();

		if (null == getFavouriteBooks()) {
			editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}

		if (null == getAlreadyReadBooks()) {
			editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}

		if (null == getWishListBooks()) {
			editor.putString(WISHLIST_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}

		if (null == getCurrentlyReadingBooks()) {
			editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}
	}

	public boolean editBook(Book editedBook) {
		ArrayList<Book> allBooks = getAllBooks();
		if (null != allBooks) {
			for (Book b : allBooks) {
				if (b.getId() == editedBook.getId()) {
					if (allBooks.remove(b)) {
						if (allBooks.add(editedBook)) {
							Gson gson = new Gson();
							SharedPreferences.Editor editor = sharedPreferences.edit();
							editor.remove(ALL_BOOKS_KEY);
							editor.putString(ALL_BOOKS_KEY, gson.toJson(allBooks));
							editor.commit();

							if (removeFromWishListBooks(b)) {
								addWishListBook(editedBook);
							}

							if (removeFromFavouriteBooks(b)) {
								addFavouriteBook(editedBook);
							}

							if (removeFromCurrentlyReadingBooks(b)) {
								addCurrentlyReadingBook(editedBook);
							}

							if (removeFromAlreadyReadBooks(b)) {
								addAlreadyReadBook(editedBook);
							}

							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean addNewBook(Book book) {
		ArrayList<Book> books = getAllBooks();
		if (null != books) {
			if (books.add(book)) {
				Gson gson = new Gson();
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.remove(ALL_BOOKS_KEY);
				editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
				editor.commit();
				return true;
			}
		}
		return false;
	}

	public boolean addCurrentlyReadingBook(Book book) {
		ArrayList<Book> books = getCurrentlyReadingBooks();
		if (null != books) {
			if (books.add(book)) {
				Gson gson = new Gson();
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.remove(CURRENTLY_READING_BOOKS_KEY);
				editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(books));
				editor.commit();
				return true;
			}
		}
		return false;
	}

	public boolean addFavouriteBook(Book book) {
		ArrayList<Book> books = getFavouriteBooks();
		if (null != books) {
			if (books.add(book)) {
				Gson gson = new Gson();
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.remove(FAVOURITE_BOOKS_KEY);
				editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(books));
				editor.commit();
				return true;
			}
		}
		return false;
	}

	public boolean addAlreadyReadBook(Book book) {
		ArrayList<Book> books = getAlreadyReadBooks();
		if (null != books) {
			if (books.add(book)) {
				Gson gson = new Gson();
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.remove(ALREADY_READ_BOOKS_KEY);
				editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(books));
				editor.commit();
				return true;
			}
		}
		return false;
	}

	public boolean addWishListBook(Book book) {
		ArrayList<Book> books = getWishListBooks();
		if (null != books) {
			if (books.add(book)) {
				Gson gson = new Gson();
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.remove(WISHLIST_BOOKS_KEY);
				editor.putString(WISHLIST_BOOKS_KEY, gson.toJson(books));
				editor.commit();
				return true;
			}
		}
		return false;
	}

	public boolean removeFromAllBooks(Book book) {
		ArrayList<Book> books = getAllBooks();
		if (null != books) {
			for (Book b : books) {
				if (b.getId() == book.getId()) {
					if (books.remove(b)) {
						Gson gson = new Gson();
						SharedPreferences.Editor editor = sharedPreferences.edit();
						editor.remove(ALL_BOOKS_KEY);
						editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
						editor.commit();
						//Also remove from all the lists
						removeFromAlreadyReadBooks(book);
						removeFromCurrentlyReadingBooks(book);
						removeFromFavouriteBooks(book);
						removeFromWishListBooks(book);
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean removeFromCurrentlyReadingBooks(Book book) {
		ArrayList<Book> books = getCurrentlyReadingBooks();
		if (null != books) {
			for (Book b : books) {
				if (b.getId() == book.getId()) {
					if (books.remove(b)) {
						Gson gson = new Gson();
						SharedPreferences.Editor editor = sharedPreferences.edit();
						editor.remove(CURRENTLY_READING_BOOKS_KEY);
						editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(books));
						editor.commit();
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean removeFromAlreadyReadBooks(Book book) {
		ArrayList<Book> books = getAlreadyReadBooks();
		if (null != books) {
			for (Book b : books) {
				if (b.getId() == book.getId()) {
					if (books.remove(b)) {
						Gson gson = new Gson();
						SharedPreferences.Editor editor = sharedPreferences.edit();
						editor.remove(ALREADY_READ_BOOKS_KEY);
						editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(books));
						editor.commit();
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean removeFromWishListBooks(Book book) {
		ArrayList<Book> books = getWishListBooks();
		if (null != books) {
			for (Book b : books) {
				if (b.getId() == book.getId()) {
					if (books.remove(b)) {
						Gson gson = new Gson();
						SharedPreferences.Editor editor = sharedPreferences.edit();
						editor.remove(WISHLIST_BOOKS_KEY);
						editor.putString(WISHLIST_BOOKS_KEY, gson.toJson(books));
						editor.commit();
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean removeFromFavouriteBooks(Book book) {
		ArrayList<Book> books = getFavouriteBooks();
		if (null != books) {
			for (Book b : books) {
				if (b.getId() == book.getId()) {
					if (books.remove(b)) {
						Gson gson = new Gson();
						SharedPreferences.Editor editor = sharedPreferences.edit();
						editor.remove(FAVOURITE_BOOKS_KEY);
						editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(books));
						editor.commit();
						return true;
					}
				}
			}
		}
		return false;
	}

	public static ArrayList<Book> minimize(ArrayList<Book> books) {
		for (Book book : books) {
			book.setExpended(false);
		}
		return books;
	}

	public Book getBookById(int id) {

		ArrayList<Book> books = getAllBooks();
		if (null != books) {
			for (Book book : books) {
				if (book.getId() == id) {
					return book;
				}
			}
		}
		return null;
	}

	public int getNextId() {
		ArrayList<Book> books = getAllBooks();
		ArrayList<Integer> ids = new ArrayList<>();
		if (null != books) {
			for (Book b : books) {
				ids.add(b.getId());
			}
			if (!ids.isEmpty()) {
				int maxId = 0;
				for (int i : ids) {
					if (i > maxId) {
						maxId = i;
					}
				}
				return maxId + 1;
			} else {
				return 1;
			}
		}

		return -1;
	}

	public static synchronized Utils getInstance(Context context) {
		if (null == instance) {
			instance = new Utils(context);
		}
		return instance;
	}

	private void initData() {

		ArrayList<Book> books = new ArrayList<>();

		books.add(new Book(1,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));
		books.add(new Book(2,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://www.delfi.rs/_img/artikli/2017/07/zlocin_i_kazna_vv.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		books.add(new Book(3,
				"Tvrđava",
				"Meša Selimović",
				333,
				"https://www.delfi.rs/_img/artikli/2014/10/tvrdjava_vv.jpg",
				"Troje nas je, u cijelom svijetu samo troje: moji prsti, njeno tijelo i njegov ujednačeni damar. Nije važno šta se dešava u svijetu, nije važno šta će biti sutra, važan je ovaj čas blaženstva bez misli.\n" +
						"Hiljadu nečijih srećnih časaka biće kao ovaj, ali ovaj nikada više. Hiljadu tuđih ljubavi biće kao ova, ali ova nikad više.",
				"Troje nas je, u cijelom svijetu samo troje: moji prsti, njeno tijelo i njegov ujednačeni damar. Nije važno šta se dešava u svijetu, nije važno šta će biti sutra, važan je ovaj čas blaženstva bez misli.\n" +
						"Hiljadu nečijih srećnih časaka biće kao ovaj, ali ovaj nikada više. Hiljadu tuđih ljubavi biće kao ova, ali ova nikad više.\n" +
						"\n" +
						"Prvi put znam šta je sreća, osjećam je, vidim, mirišem.\n" +
						"Cio svijet i cijela vasiona, nas troje. Nikog drugog osim nas nema. I ima sreća. Da li je mogu zadržati?\n" +
						"Napolju je proljetna noć, i mjesečina. A ja ne mogu da zaspim, od sreće kojoj nisam tražio razlog. I nisam se čudio što je tako. Kako bi drukčije i moglo biti?“\n" +
						"\n" +
						"Srpska književna scena može se pohvaliti brojnim piscima izuzetnog dara, ali malo je onih čije stvaralaštvo dotiče čitaoca kao Selimovićevo – toplina i neposrednost njegovih junaka i čistota osećanja koja izviru sa stranica ovih dela, ispričanih takvom jednostavnošću kakvu samo vrhunski majstor može da postigne, diraju pravo u dušu i zauvek tu ostaju. „Derviš i smrt“, „Tvrđava“ i „Ostrvo“ pravi su biseri ovog velikana. \n",
				"https://www.delfi.rs/knjige/62780_tvrdjava_knjiga_delfi_knjizare.html"));


		SharedPreferences.Editor editor = sharedPreferences.edit();
		Gson gson = new Gson();
		editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
		editor.commit();
	}

	public ArrayList<Book> getAllBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>() {
		}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
		//Sort books before returning
		if (books != null) {
			Collections.sort(books, Book.bookIdComparator);
		}
		return books;
	}

	public ArrayList<Book> getFavouriteBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>() {
		}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVOURITE_BOOKS_KEY, null), type);
		//Sort books before returning
		if (books != null) {
			Collections.sort(books, Book.bookIdComparator);
		}
		return books;
	}

	public ArrayList<Book> getAlreadyReadBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>() {
		}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS_KEY, null), type);
		//Sort books before returning
		if (books != null) {
			Collections.sort(books, Book.bookIdComparator);
		}
		return books;
	}

	public ArrayList<Book> getWishListBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>() {
		}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WISHLIST_BOOKS_KEY, null), type);
		//Sort books before returning
		if (books != null) {
			Collections.sort(books, Book.bookIdComparator);
		}
		return books;
	}

	public ArrayList<Book> getCurrentlyReadingBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>() {
		}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS_KEY, null), type);
		//Sort books before returning
		if (books != null) {
			Collections.sort(books, Book.bookIdComparator);
		}
		return books;
	}
}
