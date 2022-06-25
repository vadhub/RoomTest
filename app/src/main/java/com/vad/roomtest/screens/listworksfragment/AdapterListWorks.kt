package com.vad.roomtest.screens.listworksfragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vad.roomtest.R
import com.vad.roomtest.room.dao.Work
import com.vad.roomtest.screens.ClickOptionMenu

class AdapterListWorks: RecyclerView.Adapter<AdapterListWorks.MyViewHolder>() {

    private var works: List<Work> = ArrayList()
    private var clickOptionMenu: ClickOptionMenu? = null

    fun setOnClickOptionMenu(clickOptionMenu: ClickOptionMenu) {
        this.clickOptionMenu = clickOptionMenu
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setWorks(works: List<Work>) {
        this.works = works
        notifyDataSetChanged()
    }

    fun getWorks() : List<Work> {
        return works
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.workName.text = works.get(position).nameWork
        holder.workPrice.text = works.get(position).price.toString()

        holder.imageOption.setOnClickListener {
            clickOptionMenu?.onClickOptionMenu(it, position)
        }
    }

    override fun getItemCount(): Int = works.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val workName:TextView = itemView.findViewById(R.id.workName)
        val workPrice:TextView = itemView.findViewById(R.id.workPrice)
        val imageOption: ImageView = itemView.findViewById(R.id.imageButtonWork)
    }
}