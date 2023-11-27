package com.example.database.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.database.db.entity.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {
    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Insert
    void insertAll(Mahasiswa... mahasiswas);

}
