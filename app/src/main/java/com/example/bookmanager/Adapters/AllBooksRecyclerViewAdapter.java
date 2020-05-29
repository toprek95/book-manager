package com.example.bookmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookmanager.Models.Book;
import com.example.bookmanager.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AllBooksRecyclerViewAdapter extends RecyclerView.Adapter<AllBooksRecyclerViewAdapter.MyViewHolder> {
	private ArrayList<Book> books = new ArrayList<>();
	private Context mContext;
	private boolean isAllBooksLayoutList;

	public AllBooksRecyclerViewAdapter(Context mContext, boolean isAllBooksLayoutList) {
		this.mContext = mContext;
		this.isAllBooksLayoutList = isAllBooksLayoutList;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(isAllBooksLayoutList ? R.layout.all_books_recycler_view_layout_list : R.layout.all_books_recycler_view_layout_grid,
						parent,
						false);
		return new MyViewHolder(view);

	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

		final Book bookItem = books.get(position);
		if (!isAllBooksLayoutList) {
			holder.bookNameGrid.setText(bookItem.getName());

			Glide.with(mContext)
					.asBitmap()
					.load(bookItem.getImageUrl())
					.into(holder.bookImageGrid);

			holder.parentCardViewGrid.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//TODO: Implement on book card view click listener
					Toast.makeText(mContext, bookItem.getId() + ": " + bookItem.getName() + " clicked", Toast.LENGTH_SHORT).show();
				}
			});
		} else {
			holder.bookNameList.setText(bookItem.getName());
			String author = "Author: " + bookItem.getAuthor();
			holder.bookAuthorList.setText(author);
			String pages = "Number of pages: " + bookItem.getNumberOdPages();
			holder.bookPagesList.setText(pages);

			Glide.with(mContext)
					.asBitmap()
					.load(bookItem.getImageUrl())
					.into(holder.bookImageList);

			holder.parentCardViewList.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//TODO: Implement on book list card view click listener
					Toast.makeText(mContext, bookItem.getId() + ": " + bookItem.getName() + " clicked", Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

	@Override
	public int getItemCount() {
		return books.size();
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
		notifyDataSetChanged();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {

		private MaterialCardView parentCardViewGrid, parentCardViewList;
		private ImageView bookImageGrid, bookImageList;
		private TextView bookNameGrid, bookNameList, bookPagesList, bookAuthorList;


		public MyViewHolder(@NonNull View itemView) {
			super(itemView);
			parentCardViewGrid = itemView.findViewById(R.id.parent_card_view_all_books_layout);
			bookImageGrid = itemView.findViewById(R.id.book_image_all_books_layout);
			bookNameGrid = itemView.findViewById(R.id.book_name_all_books_layout);

			parentCardViewList = itemView.findViewById(R.id.parent_card_view_all_books_layout_list);
			bookAuthorList = itemView.findViewById(R.id.book_author_all_books_layout_list);
			bookImageList = itemView.findViewById(R.id.book_image_all_books_layout_list);
			bookNameList = itemView.findViewById(R.id.book_name_all_books_layout_list);
			bookPagesList = itemView.findViewById(R.id.book_pages_all_books_layout_list);

		}
	}
}
