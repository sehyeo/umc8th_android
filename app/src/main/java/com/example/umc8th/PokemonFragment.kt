//package com.example.umc8th
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.lifecycleScope
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.flo_android.PokemonDatabase
//import kotlinx.coroutines.launch
//
//class PokemonFragment : Fragment() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: PokemonRVAdapter
//    private lateinit var db: PokemonDatabase
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val view = inflater.inflate(R.layout.fragment_pokemon, container, false)
//        recyclerView = view.findViewById(R.id.pokemon_recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        db = PokemonDatabase.getInstance(requireContext())
//
//        lifecycleScope.launch {
//            val pokemonList = db.pokemonDao().getAll()
//            adapter = PokemonRVAdapter(pokemonList)
//            recyclerView.adapter = adapter
//        }
//
//        return view
//    }
//}
