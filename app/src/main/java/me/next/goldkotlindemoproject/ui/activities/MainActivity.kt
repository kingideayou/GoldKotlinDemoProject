package me.next.goldkotlindemoproject.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.avos.avoscloud.AVQuery
import me.next.goldkotlindemoproject.R
import me.next.goldkotlindemoproject.model.Entry
import me.next.goldkotlindemoproject.ui.adapter.EntryListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView : RecyclerView = find(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        async() {
            var entries : List<Entry>;
            val query: AVQuery<Entry> = AVQuery.getQuery("Entry")
            query.cachePolicy = AVQuery.CachePolicy.NETWORK_ELSE_CACHE
            query.include("user")
            query.include("user.installation")
            query.orderByDescending("createdAt")
            query.limit(50)
            entries = query.find()
            uiThread {
                recyclerView.adapter = EntryListAdapter(entries)
            }
        }
    }

}
