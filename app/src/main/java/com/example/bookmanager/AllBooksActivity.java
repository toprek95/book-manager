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
	private ArrayList<Book> books = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_books);

		initViews();

		initBooksList();

		adapter = new AllBooksRecyclerViewAdapter(AllBooksActivity.this);
		adapter.setBooks(books);

		allBooksRecyclerView.setAdapter(adapter);
		allBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));


	}

	private void initBooksList() {
		books.add(new Book(1,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(2,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		books.add(new Book(3,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(4,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		books.add(new Book(5,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(6,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		books.add(new Book(7,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(8,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		books.add(new Book(9,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(10,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		books.add(new Book(11,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(12,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		books.add(new Book(13,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(4,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));

		books.add(new Book(15,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/drini-cuprija-ivo-andric-slika-101207030.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(16,
				"Zločin i kazna",
				"Fjodor Dosrojevski",
				714,
				"https://antikvarijat-bono.com/wp-content/uploads/2017/05/160820126017161759272067791363_1.jpg",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin.",
				"Roman Zločin i kazna izgrađen je na fabuli koju poznajemo iz kriminalističkog štiva, s tom bitnom razlikom što ovdje već na početku djela saznajemo ko je ubojica, pa i šta ga je sve navelo na zločin. Zločin i kazna nije samo roman o pojedinačnom ljudskom karakteru ni samo psihološki roman ni roman o socijalno motiviranom karakteru već je sve to ali i mnogo više od toga. Djelo je u programu lektire za III razred gimnazije i sličnih srednjih škola."));


	}

	private void initViews() {
		allBooksRecyclerView = this.findViewById(R.id.all_books_recycler_view);
		toggleListGridButton = this.findViewById(R.id.toggle_grid_list_button);
	}
}
