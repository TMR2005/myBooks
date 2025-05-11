package com.example.mybooks;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView Booksrecycler;
    private BookRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_books);
        adapter = new BookRecyclerViewAdapter(this);
        Booksrecycler=findViewById(R.id.booksrecycler);
        Booksrecycler.setAdapter(adapter);
        Booksrecycler.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Books> books = new ArrayList<>();
        books.add(new Books(1,"Harry Potter : Prisoner of Azkaban","JK Rowling",1500,9,"https://upload.wikimedia.org/wikipedia/en/a/a0/Harry_Potter_and_the_Prisoner_of_Azkaban.jpg"));
        books.add(new Books(2, "Atomic Habits", "James Clear", 320, 10, "https://m.media-amazon.com/images/I/91bYsX41DVL.jpg"));
        adapter.setBooks(books);
    }
}