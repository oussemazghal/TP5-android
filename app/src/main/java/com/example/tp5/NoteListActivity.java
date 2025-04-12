package com.example.tp5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    ListView listView;
    NoteDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        listView = findViewById(R.id.listViewNotes);
        db = new NoteDatabaseHelper(this);

        List<String> notes = db.getAllNotes();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);
    }
}
