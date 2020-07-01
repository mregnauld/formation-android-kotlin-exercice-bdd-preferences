package com.formationandroid.bddpreferences.bdd

import androidx.room.*

@Dao
abstract class MemosDAO
{
    @Query("SELECT * FROM memos")
    abstract fun getListeMemos(): MutableList<MemoDTO>

    @Query("SELECT COUNT(*) FROM memos WHERE intitule = :intitule")
    abstract fun countMemosParIntitule(intitule: String): Long

    @Insert
    abstract fun insert(vararg memos: MemoDTO)

    @Update
    abstract fun update(vararg memos: MemoDTO)

    @Delete
    abstract fun delete(vararg memos: MemoDTO)
}