package com.example.tp5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    EditText editTextTitle, editTextContent;
    Button btnSave;
    NoteDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        btnSave = findViewById(R.id.btnSave);

        db = new NoteDatabaseHelper(this);

        btnSave.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString();
            String content = editTextContent.getText().toString();
            db.addNote(title, content);
            Toast.makeText(this, "Note ajoutée avec succès", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
