package com.example.my_movie_app.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.my_movie_app.Fragment.MainFragment
import com.example.my_movie_app.R
import com.example.my_movie_app.data.NoteData

class NoteAdapter(): RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    private var mListNotes = emptyList<NoteData>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Electricity_TV: TextView = itemView.findViewById(R.id.electricity_TV)
        val XBC_TV: TextView = itemView.findViewById(R.id.XBC_TV)
        val GBC_TV: TextView = itemView.findViewById(R.id.GBC_TV)
        val gas_TV: TextView = itemView.findViewById(R.id.gas_TV)

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.note_item, p0, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.Electricity_TV.text = mListNotes[p1].electricity
        p0.XBC_TV.text = mListNotes[p1].XBC
        p0.GBC_TV.text = mListNotes[p1].GBC
        p0.gas_TV.text = mListNotes[p1].GAS

    }

    override fun getItemCount(): Int {
        return mListNotes.size
    }

    fun setList(list: List<NoteData>){
        mListNotes = list
        notifyDataSetChanged() //обновляем адаптер
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener{
           // MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }
}