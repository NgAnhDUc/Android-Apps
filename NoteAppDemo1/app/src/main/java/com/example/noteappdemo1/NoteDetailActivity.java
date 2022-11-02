package com.example.noteappdemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailActivity extends AppCompatActivity {

    EditText TitleEdt,ContentEdt;
    ImageButton SaveNoteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        TitleEdt = findViewById(R.id.note_title_text);
        ContentEdt = findViewById(R.id.note_content_text);
        SaveNoteBtn = findViewById(R.id.save_note_btn);

        SaveNoteBtn.setOnClickListener(view -> saveNote());
    }

    private void saveNote() {
        String noteTitle = TitleEdt.getText().toString();
        String noteContent = ContentEdt.getText().toString();
        if (noteTitle==null || noteTitle.isEmpty()){
            TitleEdt.setError("Title is required");
            return;
        }
        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp(Timestamp.now());
        saveNoteToFirebase(note);
    }

    void saveNoteToFirebase(Note note){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNote().document();
        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(NoteDetailActivity.this,"Note added successfully");
                    finish();
                }else {
                    Utility.showToast(NoteDetailActivity.this,"Failed while adding note");
                    finish();
                }
            }
        });
    }
}