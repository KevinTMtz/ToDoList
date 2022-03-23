package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.ToDo

class ToDoAdapter (private val toDoList: List<ToDo>): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    private var clickListener: ClickListener? = null

    fun setOnItemClickListener(clickListener: ClickListener){
        this.clickListener = clickListener
    }

    interface  ClickListener{
        fun onItemClick(view: View, pos: Int)
    }

    inner class ToDoViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private val date: TextView = view.findViewById(R.id.text_view_date)
        private val title: TextView = view.findViewById(R.id.text_view_list_title)
        private val description: TextView = view.findViewById(R.id.text_view_list_description)
        private val priority: TextView = view.findViewById(R.id.text_view_list_priority)

        fun bind(todo: ToDo) {
            date.text = todo.date
            title.text = todo.title
            description.text = todo.description
            priority.text = "Priority: ${todo.priority.toString()}"
        }

        init {
            view.setOnClickListener(this)
        }
        override fun onClick(view: View?) {
            if(view != null) {
                clickListener?.onItemClick(view, bindingAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val quote = toDoList[position]

        holder.bind(quote)
    }

    override fun getItemCount() = toDoList.size

    fun getData(pos: Int): ToDo{
        return toDoList[pos]
    }
}