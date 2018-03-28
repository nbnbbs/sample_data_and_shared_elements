package com.sample.ar442.sharedelements.ui

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sample.ar442.sharedelements.R.id
import com.sample.ar442.sharedelements.R.layout
import com.sample.ar442.sharedelements.data.Ticket
import com.sample.ar442.sharedelements.ui.TicketAdapter.TicketViewHolder

class TicketAdapter(private val onItemClickListener: (ticket: Ticket) -> Unit) : ListAdapter<Ticket, TicketViewHolder>(differ) {

    companion object {
        private val differ = object : DiffUtil.ItemCallback<Ticket>() {

            override fun areItemsTheSame(oldItem: Ticket?, newItem: Ticket?) = oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: Ticket?, newItem: Ticket?) = oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TicketViewHolder(
            LayoutInflater.from(parent.context)
                    .inflate(
                            layout.item_ticket_info,
                            parent,
                            false
                    ),
            onItemClickListener
    )

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class TicketViewHolder(itemView: View, private val onItemClickListener: (ticket: Ticket) -> Unit) : ViewHolder(itemView) {

        private val departureToView: TextView = itemView.findViewById(id.info_title)
        private val dateView: TextView = itemView.findViewById(id.item_date)
        private val photo: ImageView = itemView.findViewById(id.info_photo)

        fun bindTo(ticket: Ticket) {
            itemView.setOnClickListener { onItemClickListener.invoke(ticket) }
            departureToView.text = ticket.departureTo
            dateView.text = ticket.departureDate
            photo.setImageResource(ticket.clientPhoto)
        }

    }

}