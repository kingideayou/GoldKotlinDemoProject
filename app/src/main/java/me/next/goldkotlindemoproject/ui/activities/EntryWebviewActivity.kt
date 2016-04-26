package me.next.goldkotlindemoproject.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.webkit.WebView
import me.next.goldkotlindemoproject.R
import org.jetbrains.anko.find

/**
 * Created by NeXT on 16/4/26.
 * GoldKotlinDemoProject
 */
class EntryWebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_entry)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val webView : WebView = find(R.id.webView)
        webView.loadUrl(intent.getStringExtra(ENTRY_URL))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val ENTRY_URL = "ENTRY_URL"
    }

}