package com.example.bookmanager.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;
import com.example.bookmanager.Models.Book;
import com.example.bookmanager.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AllBooksRecyclerViewAdapter extends RecyclerView.Adapter<AllBooksRecyclerViewAdapter.MyViewHolder> {
	private ArrayList<Book> books = new ArrayList<>();
	private Context mContext;
	private static final String TAG = "AllBooksRecyclerViewAda";

	public AllBooksRecyclerViewAdapter(Context mContext) {
		this.mContext = mContext;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.all_books_recycler_view_layout_list, parent, false);
		return new MyViewHolder(view);

	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
		Log.d(TAG, "onBindViewHolder: Called");
		final Book bookItem = books.get(position);

		holder.bookNameList.setText(bookItem.getName());
		String author = "Author: " + bookItem.getAuthor();
		holder.bookAuthorList.setText(author);
		String pages = "Pages: " + bookItem.getNumberOdPages();
		holder.bookPagesList.setText(pages);

		Log.i(TAG, "onBindViewHolder: imageUrl before Glide: " + bookItem.getImageUrl());
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

		holder.shortBookDescription.setText(bookItem.getShortDescription());

		if (bookItem.isExpended()) {
			TransitionManager.beginDelayedTransition(holder.parentCardViewList);
			holder.downArrow.setVisibility(View.GONE);
			holder.expendedBooksContainer.setVisibility(View.VISIBLE);
		} else {
			TransitionManager.beginDelayedTransition(holder.parentCardViewList);
			holder.downArrow.setVisibility(View.VISIBLE);
			holder.expendedBooksContainer.setVisibility(View.GONE);
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

		private MaterialCardView parentCardViewList;
		private ImageView bookImageList;
		private TextView bookNameList, bookPagesList, bookAuthorList, shortBookDescription;
		private ImageView downArrow, upArrow;
		private LinearLayout collapsedBooksContainer;
		private RelativeLayout expendedBooksContainer;


		public MyViewHolder(@NonNull View itemView) {
			super(itemView);

			parentCardViewList = itemView.findViewById(R.id.parent_card_view_all_books_layout_list);
			bookAuthorList = itemView.findViewById(R.id.book_author_all_books_layout_list);
			bookImageList = itemView.findViewById(R.id.book_image_all_books_layout_list);
			bookNameList = itemView.findViewById(R.id.book_name_all_books_layout_list);
			bookPagesList = itemView.findViewById(R.id.book_pages_all_books_layout_list);

			downArrow = itemView.findViewById(R.id.down_arrow);
			upArrow = itemView.findViewById(R.id.up_arrow);

			collapsedBooksContainer = itemView.findViewById(R.id.collapsed_books_container);
			expendedBooksContainer = itemView.findViewById(R.id.expanded_books_container);

			shortBookDescription = itemView.findViewById(R.id.short_book_description);

			downArrow.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Book book = books.get(getAdapterPosition());
					book.setExpended(!book.isExpended());
					notifyItemChanged(getAdapterPosition());
				}
			});

			upArrow.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Book book = books.get(getAdapterPosition());
					book.setExpended(!book.isExpended());
					notifyItemChanged(getAdapterPosition());
				}
			});

		}
	}
}
