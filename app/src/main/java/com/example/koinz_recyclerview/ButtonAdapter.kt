package com.example.koinz_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ButtonAdapter(private val buttonList: List<ButtonItem>) : RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>() {

    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.button_item, parent, false)
        return ButtonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val buttonItem = buttonList[position]
        holder.bind(buttonItem, position)
    }

    override fun getItemCount(): Int = buttonList.size

    inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val button: Button = itemView.findViewById(R.id.button_item)

        fun bind(buttonItem: ButtonItem, position: Int) {
            button.text = buttonItem.label

            // Set background based on selection state
            if (position == selectedPosition) {
                button.background = ContextCompat.getDrawable(button.context, R.drawable.button_selected_bg)
            } else {
                button.background = ContextCompat.getDrawable(button.context, R.drawable.button_bg)
            }

            // Handle button click
            button.setOnClickListener {
                val previousSelectedPosition = selectedPosition
                selectedPosition = position

                // Notify previous and current item to update the background
                notifyItemChanged(previousSelectedPosition)
                notifyItemChanged(position)
            }
        }
    }
}
