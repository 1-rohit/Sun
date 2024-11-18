package com.example.sun724

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.Executor


class MainActivity : AppCompatActivity() {

    lateinit var myWebView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myWebView = findViewById<WebView>(R.id.myWebView)
        myWebView.apply {
            loadUrl("http://127.0.0.1:9999")
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient(){

            }
        }
    }

    override fun onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack()
        }
        else {
            super.onBackPressed()
        }
    }


}