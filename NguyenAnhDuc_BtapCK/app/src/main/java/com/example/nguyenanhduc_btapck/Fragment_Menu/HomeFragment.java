package com.example.nguyenanhduc_btapck.Fragment_Menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyenanhduc_btapck.LoginScreen.LoginActivity;
import com.example.nguyenanhduc_btapck.MainActivity;
import com.example.nguyenanhduc_btapck.Note;
import com.example.nguyenanhduc_btapck.NoteAdapter;
import com.example.nguyenanhduc_btapck.NoteDetailActivity;
import com.example.nguyenanhduc_btapck.R;
import com.example.nguyenanhduc_btapck.Utility;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ImageButton menuBtn;
    FloatingActionButton addNotebtn;
    NoteAdapter noteAdapter;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);

        addNotebtn = view.findViewById(R.id.add_note_btn);
        recyclerView = view.findViewById(R.id.recycler_view);
        menuBtn = view.findViewById(R.id.menu_btn);

        addNotebtn.setOnClickListener(v -> startActivity(new Intent(getActivity(), NoteDetailActivity.class)));
        menuBtn.setOnClickListener(v -> showMenu());
        setupRecyclerView();

        return view;
    }
    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(getActivity(),menuBtn);
        popupMenu.getMenu().add("Logout");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle()=="Logout"){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                    return true;
                }

                return false;
            }
        });
    }

    private void setupRecyclerView() {
        Query query = Utility.getCollectionReferenceForNote().orderBy("timestamp",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query,Note.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        noteAdapter = new NoteAdapter(options,getContext());
        recyclerView.setAdapter(noteAdapter);

    }
    @Override
    public void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }
}
