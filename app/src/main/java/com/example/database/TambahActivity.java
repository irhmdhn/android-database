package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNpm = findViewById(R.id.etNpm);
        etFullName = findViewById(R.id.etFullName);
        btnSimpan = findViewById(R.id.btnSimpan);
        database = AppDatabase.getInstance(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.fullNama = etFullName.getText().toString();
                mahasiswa.npm = etNpm.getText().toString();
                database.mahasiswaDao().insertAll(mahasiswa);
                finish();
            }
        });

    }
}