//package com.example.flo_android
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.umc8th.Pokemon
//
//@Database(entities = [Pokemon::class], version = 1)
//abstract class PokemonDatabase: RoomDatabase() {
//    abstract fun pokemonDao(): PokemonDao
//
//    companion object {
//        private var instance: PokemonDatabase? = null
//
//        @Synchronized
//        fun getInstance(context: Context): PokemonDatabase {
//            if (instance == null) {
//                synchronized(PokemonDatabase::class){
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        PokemonDatabase::class.java,
//                        "pokemon-database"
//                    )
//                        .fallbackToDestructiveMigration() // 기존 데이터 삭제 허용
//                        .allowMainThreadQueries()
//                        .build()
//                }
//            }
//
//            return instance!!
//        }
//    }
//}