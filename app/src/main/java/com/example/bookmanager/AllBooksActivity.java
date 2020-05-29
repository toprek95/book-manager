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

		initAdapter(this, true);


		toggleListGridButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(toggleListGridButton.getText().toString().equals(AllBooksActivity.this.getString(R.string.toggle_grid_view))) {
					initAdapter(AllBooksActivity.this, false);
					toggleListGridButton.setText(AllBooksActivity.this.getString(R.string.toggle_list_view));
				} else {
					initAdapter(AllBooksActivity.this, true);
					toggleListGridButton.setText(AllBooksActivity.this.getString(R.string.toggle_grid_view));
				}
			}
		});

	}

	private void initAdapter(Context context, boolean isAllBooksLayoutList) {
		adapter = new AllBooksRecyclerViewAdapter(AllBooksActivity.this, isAllBooksLayoutList);
		adapter.setBooks(books);

		allBooksRecyclerView.setAdapter(adapter);
		allBooksRecyclerView.setLayoutManager(isAllBooksLayoutList ? new LinearLayoutManager(context) : new GridLayoutManager(context, 2));

		adapter.notifyDataSetChanged();
	}

	private void initBooksList() {
		books.add(new Book(1,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(2,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(3,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(4,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(5,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(6,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(7,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(8,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(9,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(10,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

		books.add(new Book(11,
				"Na Drini ćuprija",
				"Ivo Andrić",
				333,
				"https://www.knjiga.ba/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/slike/na_drini_cuprija_brs.jpg",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam.",
				"Kameni most iz XVI veka, zadužbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda dok među njima u stvari vlada antagonizam. Najvidljivija je razlika između dve civilizacije, istočne i zapadne. Most je, između građenja i delimičnog rušenja početkom XX veka, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih života."));

	}

	private void initViews() {
		allBooksRecyclerView = this.findViewById(R.id.all_books_recycler_view);
		toggleListGridButton = this.findViewById(R.id.toggle_grid_list_button);
	}
}
