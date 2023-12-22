package com.mobiledev.diread.data.ui.view.detailJurnal

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.mobiledev.diread.R
import com.mobiledev.diread.data.item.Jurnal

class DetailJournalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_journal)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val webView: WebView = findViewById(R.id.web_view)
        webView.settings.javaScriptEnabled=true
        webView.webViewClient = WebViewClient()

        val jurnal = intent.getParcelableExtra<Jurnal>("shadow")


        jurnal?.webLink?.let { url -> webView.loadUrl(url) }
    }
}