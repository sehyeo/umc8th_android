//package com.example.umc8th
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class PokemonRVAdapter(private val pokemonList: List<Pokemon>) :
//    RecyclerView.Adapter<PokemonRVAdapter.ViewHolder>() {
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val nameText: TextView = itemView.findViewById(R.id.pokemon_name)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_pokemon, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.nameText.text = pokemonList[position].name
//    }
//
//    override fun getItemCount(): Int = pokemonList.size
//}
