package com.example.bookmanager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.bookmanager.Models.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

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
			editor.putString(FAVOURITE_BOOKS_KEY,gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}

		if (null == getAlreadyReadBooks()) {
			editor.putString(ALREADY_READ_BOOKS_KEY,gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}

		if (null == getWishListBooks()) {
			editor.putString(WISHLIST_BOOKS_KEY,gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}

		if (null == getCurrentlyReadingBooks()) {
			editor.putString(CURRENTLY_READING_BOOKS_KEY,gson.toJson(new ArrayList<Book>()));
			editor.commit();
		}
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

	public static ArrayList<Book> minimize (ArrayList<Book> books) {
		for (Book book: books) {
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
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		books.add(new Book(3,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.delfi.rs/_img/artikli/2016/04/na_drini_cuprija_v.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));

		books.add(new Book(4,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		books.add(new Book(5,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.delfi.rs/_img/artikli/2016/04/na_drini_cuprija_v.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));

		books.add(new Book(6,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		books.add(new Book(7,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.delfi.rs/knjige/90011_na_drini_cuprija_knjiga_delfi_knjizare.html"));

		books.add(new Book(8,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://www.delfi.rs/_img/artikli/2017/07/zlocin_i_kazna_v.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));

		books.add(new Book(9,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));

		books.add(new Book(10,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		books.add(new Book(11,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.delfi.rs/_img/artikli/2016/04/na_drini_cuprija_v.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));

		books.add(new Book(12,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://www.delfi.rs/_img/artikli/2017/07/zlocin_i_kazna_v.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		books.add(new Book(13,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));

		books.add(new Book(4,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		books.add(new Book(15,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života.",
				"https://www.knjizarakultura.com/proizvod/na-drini-aeuprija-tp-sezam-andriae-ivosezam-book/"));

		books.add(new Book(16,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://www.delfi.rs/_img/artikli/2017/07/zlocin_i_kazna_v.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola.",
				"https://www.delfi.rs/knjige/139253_zlocin_i_kazna_knjiga_delfi_knjizare.html"));

		SharedPreferences.Editor editor = sharedPreferences.edit();
		Gson gson = new Gson();
		editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
		editor.commit();
	}

	public ArrayList<Book> getAllBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>(){}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
		return books;
	}

	public ArrayList<Book> getFavouriteBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>(){}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVOURITE_BOOKS_KEY, null), type);
		return books;
	}

	public ArrayList<Book> getAlreadyReadBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>(){}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS_KEY, null), type);
		return books;
	}

	public ArrayList<Book> getWishListBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>(){}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WISHLIST_BOOKS_KEY, null), type);
		return books;
	}

	public ArrayList<Book> getCurrentlyReadingBooks() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Book>>(){}.getType();
		ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS_KEY, null), type);
		return books;
	}
}
