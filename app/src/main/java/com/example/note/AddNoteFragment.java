package com.example.note;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddNoteFragment extends AppCompatActivity {
    private Toolbar toolbar;

    private EditText title, content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        toolbar = findViewById(R.id.add_note_toolbar);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_note, menu);
        MenuItem menuItem = menu.findItem(R.id.add_note_toolbar);

        

        return true;
    }
}
