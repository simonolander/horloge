package org.simonolander.horloge.util

import android.content.Context
import android.widget.Toast

fun toaster(context: Context) =
    fun(text: Any?) {
        Toast.makeText(context, text.toString(), Toast.LENGTH_SHORT).show()
    }
