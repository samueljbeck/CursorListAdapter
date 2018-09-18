package com.acst.android.utilities

import android.app.Activity
import android.database.Cursor
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.samueljbeck.cursorlistadapter.CursorRecyclerAdapterExample
import com.samueljbeck.cursorlistadapter.R
import kotlinx.android.synthetic.main.cursor_recycler_list.*

/*
 * Created by samueljbeck on 9/18/18.
 */
class CursorRecyclerExampleUse: Activity() {
    var exampleUse: CursorRecyclerAdapterExample? = null

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cursor_recycler_list)


        val layoutManager = LinearLayoutManager(this)
        cursor_recycler_view.setLayoutManager(layoutManager)



        updateAdapter()
    }

    fun updateAdapter() {
        if (exampleUse != null) {

            val cursor = getCursor()
            if (cursor != null) {
                runOnUiThread {
                    exampleUse!!.changeCursor(cursor)
                    exampleUse!!.notifyDataSetChanged()
                }
            }


        } else {
            val cursor = getCursor()
            if (cursor != null) {
                runOnUiThread {
                    exampleUse = CursorRecyclerAdapterExample(cursor)
                    cursor_recycler_view.setAdapter(exampleUse)
                    exampleUse!!.notifyDataSetChanged()
                }
            }

        }
    }

    fun getCursor(): Cursor? {
        //add code to get cursor
        return null
    }
}