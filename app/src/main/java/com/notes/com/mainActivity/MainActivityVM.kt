package com.notes.com.mainActivity

import android.content.Context
import android.util.Log
import android.widget.EditText
import androidx.lifecycle.ViewModel

class MainActivityVM(val context : Context) : ViewModel() {

    var undoBoolean = false

    var actionList : ArrayList<String> = ArrayList()
    var textList : ArrayList<String> = ArrayList()

    fun notesAdd(string: CharSequence, editText: EditText)
    {
        Log.e("AddText",textList.toString())
    }

    fun addAction(string: String)
    {
        actionList.add(string)

        Log.e("AddAction",actionList.toString())
    }

    fun undoClick(editText: EditText)
    {
        if (editText.text.isNotEmpty())
        {
            undoBoolean = true
            if (undoBoolean)
            {

                if (actionList[actionList.size - 1] == " ")
                {
                    val text = editText.text

                    editText.setText(text.substring(0,text.length -1))
                    actionList.removeAt(actionList.size -1)

                    Log.e("action","removed : ${actionList.size}")
                }
                else
                {
                    val text = editText.text.toString()+actionList[actionList.size -1]

                    editText.setText(text)
                    actionList.removeAt(actionList.size -1)
                    Log.e("action","add : ${actionList.size}")
                }

                undoBoolean = false
            }
        }
        else
        {
            actionList.clear()
        }
    }

}