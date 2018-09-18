package com.samueljbeck.cursorlistadapter

import android.database.Cursor
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cursor_list_item.view.*

/*
 * Created by samueljbeck on 9/18/18.
 */
class CursorRecyclerAdapterExample(cursor: Cursor) : CursorRecyclerAdapter<CursorRecyclerAdapterExample.ViewHolder>(cursor) {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        internal var variableToBeSet: String? = null
        val view = itemView

    }


    override fun onBindViewHolderCursor(viewHolder: ViewHolder, cursor: Cursor) {
        val view = viewHolder.view

        viewHolder.variableToBeSet = cursor.getString(cursor.getColumnIndex("variable_from_database"))

        view.cursor_item_text.text = viewHolder.variableToBeSet

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cursor_list_item, parent, false)
        return ViewHolder(itemView)
    }


}
