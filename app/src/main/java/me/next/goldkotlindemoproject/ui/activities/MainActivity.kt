package me.next.goldkotlindemoproject.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.next.goldkotlindemoproject.R
import me.next.goldkotlindemoproject.model.Entry
import me.next.goldkotlindemoproject.ui.adapter.EntryListAdapter
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView : RecyclerView = find(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = EntryListAdapter(entries)
    }

    val entries = listOf(
        Entry(),
        Entry(),
        Entry(),
        Entry(),
        Entry(),
        Entry(),
        Entry()
    )
}
