package com.example.noteapp

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NoteDetailsActivity : AppCompatActivity() {
    companion object {
        val EXTRA_NOTE = "note"
        val EXTRA_NOTE_INDEX = "noteIndex"

        lateinit var note : Note
        var noteIndex: Int = -1

        lateinit var titleView: TextView
        lateinit var textView: TextView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_note_details)

        note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_NOTE, Note::class.java)!!
        } else {
            intent.getParcelableExtra<Note>(EXTRA_NOTE)!!
        }

        titleView = findViewById(R.id.title)
        textView = findViewById(R.id.text)

        titleView.text = note.title
        textView.text = note.text
    }
}