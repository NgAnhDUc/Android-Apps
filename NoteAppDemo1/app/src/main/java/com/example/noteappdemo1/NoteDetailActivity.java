package com.example.NoteAppDemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailActivity extends AppCompatActivity {

    EditText TitleEdt,ContentEdt;
    ImageButton SaveNoteBtn;
    TextView pageTitleTv;
    TextView deleteNoteBtn;
    String title,content,docId;
    boolean isEditmode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        TitleEdt = findViewById(R.id.note_title_text);
        ContentEdt = findViewById(R.id.note_content_text);
        SaveNoteBtn = findViewById(R.id.save_note_btn);
        pageTitleTv = findViewById(R.id.page_title);
        deleteNoteBtn = findViewById(R.id.delete_note_btn);

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if(docId!=null && !docId.isEmpty()){
            isEditmode = true;
        }

        TitleEdt.setText(title);
        ContentEdt.setText(content);
        if (isEditmode){
            pageTitleTv.setText("Edit your note");
            deleteNoteBtn.setVisibility(View.VISIBLE);
        }

        SaveNoteBtn.setOnClickListener(view -> saveNote());
        deleteNoteBtn.setOnClickListener(view -> deleteNoteFireBase());
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
        if (isEditmode){
            documentReference = Utility.getCollectionReferenceForNote().document(docId);

        }else {
            documentReference = Utility.getCollectionReferenceForNote().document();

        }
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

    void deleteNoteFireBase(){
        DocumentReference documentReference;
            documentReference = Utility.getCollectionReferenceForNote().document(docId);

        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(NoteDetailActivity.this,"Note deleted successfully");
                    finish();
                }else {
                    Utility.showToast(NoteDetailActivity.this,"Failed while deleting note");
                    finish();
                }
            }
        });
    }
}