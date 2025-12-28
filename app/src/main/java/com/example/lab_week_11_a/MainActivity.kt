package com.example.lab_week_11_a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.activity_main_text_view)
        val editText = findViewById<EditText>(R.id.activity_main_edit_text)
        val button = findViewById<Button>(R.id.activity_main_button)

        val settingsStore = (application as SettingsApplication).settingsStore

        val settingsViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SettingsViewModel(settingsStore) as T
            }
        })[SettingsViewModel::class.java]

        settingsViewModel.textLiveData.observe(this) { text ->
            textView.text = text
        }

        button.setOnClickListener {
            val input = editText.text.toString()
            settingsViewModel.saveText(input)
        }
    }
}