//package com.example.flo_android
//
//import androidx.room.*
//import com.example.umc8th.Pokemon
//
//@Dao
//interface PokemonDao {
//    @Insert
//    fun insert(pokemon: Pokemon)
//
//    @Update
//    fun update(pokemon: Pokemon)
//
//    @Delete
//    fun delete(pokemon: Pokemon)
//
//    @Query("SELECT * FROM PokemonTable")
//    suspend fun getAll(): List<Pokemon>
//
//}