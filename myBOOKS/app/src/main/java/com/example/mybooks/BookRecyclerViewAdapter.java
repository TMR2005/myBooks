package com.example.mybooks;

import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // Ensure Glide is imported

import java.util.ArrayList;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Books> books = new ArrayList<>();
    private Context mContext;

    // Constructor to initialize the context
    public BookRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    // Method to set the list of books and notify adapter about data changes
    public void setBooks(ArrayList<Books> books) {
        this.books = books;
        notifyDataSetChanged();  // Notify adapter that the data has changed
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to the views
        Books book = books.get(position);

        // Set the book name to the TextView
        holder.nametxt.setText(book.getName());

        // Load the book image using Glide
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())  // Assuming getImageUrl() returns the image URL or resource
                .into(holder.img);  // Load the image into the ImageView
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.numRating.setText(books.get(position).getMyRating());


        if(books.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }
        else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();  // Return the number of items in the list
    }

    // ViewHolder class to hold the views for each item
    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parent;
        private final ImageView img;
        private TextView nametxt;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedLayout;
        private TextView txtAuthor, numRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the views
            parent = itemView.findViewById(R.id.parent);
            img = itemView.findViewById(R.id.imgbook);
            nametxt = itemView.findViewById(R.id.bookname);
            downArrow=itemView.findViewById(R.id.down);
            upArrow=itemView.findViewById(R.id.btnup);
            expandedLayout = itemView.findViewById(R.id.expandrellayout);
            txtAuthor=itemView.findViewById(R.id.authorname);
            numRating=itemView.findViewById(R.id.myrating);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
