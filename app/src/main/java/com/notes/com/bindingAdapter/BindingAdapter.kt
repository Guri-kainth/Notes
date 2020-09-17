package com.notes.com.bindingAdapter

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.notes.com.mainActivity.MainActivityVM

object BindingAdapter {

    @BindingAdapter(value = ["app:TextWatcher"], requireAll = false)
    @JvmStatic
    fun setTextWatcher(editText: EditText, mainActivityVM: MainActivityVM)
    {
        var textCount = 0
        var text =""

        editText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?)
            {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
            {
            }

            override fun onTextChanged(p0: CharSequence?, start:Int, before:Int, count:Int)
            {
                if (!mainActivityVM.undoBoolean)
                {
                    when
                    {
                        editText.length() > textCount ->
                        {
                            textCount = editText.length()
                            text = p0!!.toString()
                            mainActivityVM.addAction(" ")
                        }
                        editText.length() < textCount && editText.length() != 0 ->
                        {
                            val char = text.toCharArray()
                            mainActivityVM.addAction(char[char.size - 1].toString())
                            textCount = editText.length()
                        }
                    }
                }
                else
                {
                    textCount = editText.length()
                    text = editText.toString()
                }
            }
        })
    }

}