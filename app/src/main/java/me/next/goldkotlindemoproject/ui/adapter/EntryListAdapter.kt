package me.next.goldkotlindemoproject.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.next.goldkotlindemoproject.R
import me.next.goldkotlindemoproject.model.Entry

/**
 * Created by NeXT on 16/4/26.
 * GoldKotlinDemoProject
 */
//https://kotlinlang.org/docs/reference/classes.html
class EntryListAdapter(val entryList: List<Entry>) : RecyclerView.Adapter<EntryListAdapter.MyViewHolder>() {

    override fun getItemCount() = 50

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder? {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_entry, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViewHolder()
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindViewHolder() {

        }
    }

}