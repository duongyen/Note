package com.example.note;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;

    private EditText title, content;
    private Button back, save;

    Database db = new Database(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        toolbar = findViewById(R.id.add_note_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        save = findViewById(R.id.save);
        save.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == back) {
            Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if (v == save) {
            Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
            String t = title.getText().toString();
            String c = content.getText().toString();
            Note note = new Note(t, c);
            if (!t.equals("") || !c.equals("")) {
                db.insertData(note);
                Bundle bundle = new Bundle();

                bundle.putString("Title", t);
                bundle.putString("Content", c);

                intent.putExtras(bundle);
                setResult(1, intent);
                finish();

            } else {
                Toast.makeText(this, "Cần có tiêu đề và nội dung", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
