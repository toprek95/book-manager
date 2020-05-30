package com.example.bookmanager;

import com.example.bookmanager.Models.Book;

import java.util.ArrayList;

public class Utils {

	private static Utils instance;

	private static ArrayList<Book> allBooks, favouriteBooks, alreadyReadBooks, wishListBooks, currentlyReadingBooks;

	private Utils() {

		if (null == allBooks) {
			allBooks = new ArrayList<>();
			initData();
		}

		if (null == favouriteBooks) {
			favouriteBooks = new ArrayList<>();
		}

		if (null == alreadyReadBooks) {
			alreadyReadBooks = new ArrayList<>();
		}

		if (null == wishListBooks) {
			wishListBooks = new ArrayList<>();
		}

		if (null == currentlyReadingBooks) {
			currentlyReadingBooks = new ArrayList<>();
		}

	}

	public static boolean addCurrentlyReadingBook(Book book) {
		return currentlyReadingBooks.add(book);
	}

	public static boolean addFavouriteBook(Book book) {
		return favouriteBooks.add(book);
	}

	public static boolean addAlreadyReadBook(Book book) {
		return alreadyReadBooks.add(book);
	}

	public static boolean addWishListBook(Book book) {
		return wishListBooks.add(book);
	}

	public static void removeFromCurrentlyReadingBooks(Book book) {
		currentlyReadingBooks.remove(book);
	}

	public static void removeFromAlreadyReadBooks(Book book) {
		alreadyReadBooks.remove(book);
	}

	public static void removeFromWishListBooks(Book book) {
		wishListBooks.remove(book);
	}

	public Book getBookById(int id) {

		for (Book book : allBooks) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	public static synchronized Utils getInstance() {
		if (null != instance) {
			return instance;
		} else {
			instance = new Utils();
			return instance;
		}
	}

	private void initData() {

		allBooks.add(new Book(1,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(2,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		allBooks.add(new Book(3,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.delfi.rs/_img/artikli/2016/04/na_drini_cuprija_v.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(4,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		allBooks.add(new Book(5,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.delfi.rs/_img/artikli/2016/04/na_drini_cuprija_v.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(6,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		allBooks.add(new Book(7,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(8,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://www.delfi.rs/_img/artikli/2017/07/zlocin_i_kazna_v.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		allBooks.add(new Book(9,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(10,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		allBooks.add(new Book(11,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.delfi.rs/_img/artikli/2016/04/na_drini_cuprija_v.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(12,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://www.delfi.rs/_img/artikli/2017/07/zlocin_i_kazna_v.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		allBooks.add(new Book(13,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(4,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		allBooks.add(new Book(15,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		allBooks.add(new Book(16,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://www.delfi.rs/_img/artikli/2017/07/zlocin_i_kazna_v.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));


	}

	public ArrayList<Book> getAllBooks() {
		return allBooks;
	}

	public ArrayList<Book> getFavouriteBooks() {
		return favouriteBooks;
	}

	public ArrayList<Book> getAlreadyReadBooks() {
		return alreadyReadBooks;
	}

	public ArrayList<Book> getWishListBooks() {
		return wishListBooks;
	}

	public ArrayList<Book> getCurrentlyReadingBooks() {
		return currentlyReadingBooks;
	}
}
