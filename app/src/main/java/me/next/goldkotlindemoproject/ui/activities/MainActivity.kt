package me.next.goldkotlindemoproject.ui.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.avos.avoscloud.AVQuery
import kotlinx.android.synthetic.main.activity_main.*
import me.next.goldkotlindemoproject.R
import me.next.goldkotlindemoproject.model.Entry
import me.next.goldkotlindemoproject.ui.adapter.EntryListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
//              val adapter = UserListAdapter(entries, { view -> toast("") })
//              val adapter = UserListAdapter(entries, { toast("") })
                val adapter = EntryListAdapter(entries) {
                    startActivity(
                            Intent(applicationContext, EntryWebviewActivity :: class.java)
                                    .putExtra(EntryWebviewActivity.ENTRY_URL, it.getString("url")))
                }
                recyclerView.adapter = adapter
            }
        }
    }

}
