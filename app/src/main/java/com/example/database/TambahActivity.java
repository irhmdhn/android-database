package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.database.db.AppDatabase;
import com.example.database.db.entity.Mahasiswa;

public class TambahActivity extends AppCompatActivity {

    EditText etNpm, etFullName;
    Button btnSimpan;
    AppDatabase database;

    int id = 0;
    boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNpm = findViewById(R.id.etNpm);
        etFullName = findViewById(R.id.etFullName);
        btnSimpan = findViewById(R.id.btnSimpan);
        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        if (id > 0){
            isEdit = true;
            Mahasiswa mahasiswa = database.mahasiswaDao().get(id);
            etFullName.setText(mahasiswa.fullNama);
            etNpm.setText(mahasiswa.npm);
        }else{
            isEdit = false;
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.fullNama = etFullName.getText().toString();
                mahasiswa.npm = etNpm.getText().toString();
                if (isEdit){
                    database.mahasiswaDao().update(id,mahasiswa.fullNama,mahasiswa.npm);
                }else {
                    database.mahasiswaDao().insertAll(mahasiswa);
                }
                finish();
            }
        });

    }
}