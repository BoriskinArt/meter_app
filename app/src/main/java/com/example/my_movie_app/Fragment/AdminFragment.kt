package com.example.my_movie_app.Fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_movie_app.Adapter.NoteAdapter
import com.example.my_movie_app.R
import com.example.my_movie_app.data.NoteData
import com.mancj.materialsearchbar.MaterialSearchBar


class AdminFragment: Fragment(), MaterialSearchBar.OnSearchActionListener {
    private lateinit var myView: View
    private lateinit var searchBar: MaterialSearchBar
    private var suggestList: MutableList<String> = mutableListOf()
    private var searchList: MutableList<NoteData> = mutableListOf()
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        myView = inflater.inflate(R.layout.admin_fragment, container, false)

        return myView

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        initFields()

    }

    private fun initFields() {
        recyclerView = myView.findViewById(R.id.recycler_search)
        searchBar = myView.findViewById(R.id.search_bar)
        searchBar.setOnSearchActionListener(this)
        searchBar.setCardViewElevation(3)
        addSuggesList()
        searchBar.addTextChangeListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var suggest: MutableList<String> = mutableListOf()
                var str:String = searchBar.text.toString().lowercase()
                for (search_item in suggestList){
                    if(str.contains(search_item)){
                        suggest.add(search_item)
                    }
                }
                searchBar.lastSuggestions = suggest
            }
        })
    }

    private fun addSuggesList() {
        //сдесь выполняеться запрос и заполнение списка
        //Временная запись ..
        suggestList.add("1")
        suggestList.add("2")
        suggestList.add("3")
        suggestList.add("4")
        searchBar.lastSuggestions = suggestList
    }


    override fun onSearchStateChanged(enabled: Boolean) {
        val s = if (enabled) "enabled" else "disabled"
        Toast.makeText(myView.context, "Search $s", Toast.LENGTH_SHORT).show()
    }

    override fun onSearchConfirmed(text: CharSequence?) {
        //запрос на сервер для получение списка показаний счетчиков квариры
        //получение списка по запросу с помощью метода addSuggesList(searchBar.text.toString().lowercase())
        Toast.makeText(myView.context, text, Toast.LENGTH_SHORT).show()
        fillList(text.toString())
        recyclerView.layoutManager = LinearLayoutManager(myView.context)
        //recyclerView.adapter = NoteAdapter((searchList)




    }

    override fun onButtonClicked(buttonCode: Int) {

    }

    fun fillList(s: String): MutableList<AddNote>? {
        searchList.clear()
        val noteDate = NoteData(1,s,s,s,s)
        searchList.add(noteDate)
        searchList.add(noteDate)
        searchList.add(noteDate)
        searchList.add(noteDate)
        searchList.add(noteDate)
        searchList.add(noteDate)
        searchList.add(noteDate)
        searchList.add(noteDate)





        return null
    }
}