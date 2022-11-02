package com.example.noteappdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton menuBtn;
    FloatingActionButton addNotebtn;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNotebtn = findViewById(R.id.add_note_btn);
        recyclerView = findViewById(R.id.recycler_view);
        menuBtn = findViewById(R.id.menu_btn);

        addNotebtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,NoteDetailActivity.class)));
        menuBtn.setOnClickListener(view -> showMenu());
        setupRecyclerView();
    }


    private void showMenu() {

    }

    private void setupRecyclerView() {
        Query query = Utility.getCollectionReferenceForNote().orderBy("timestamp",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query,Note.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(options,this);
        recyclerView.setAdapter(noteAdapter);

    }

}