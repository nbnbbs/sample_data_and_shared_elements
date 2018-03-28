package com.sample.ar442.sharedelements.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sample.ar442.sharedelements.R
import com.sample.ar442.sharedelements.data.Ticket

class InfoFragment : Fragment() {

    companion object {

        private const val TICKET_KEY = "TICKET_KEY";

        fun getInstanceFor(ticket: Ticket) = InfoFragment().apply {
            arguments = Bundle().apply { putSerializable(TICKET_KEY, ticket) }
        }

    }

    private lateinit var photoView: ImageView
    private lateinit var titleView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(
            R.layout.fragment_info,
            container,
            false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoView = view.findViewById(R.id.info_photo)
        titleView = view.findViewById(R.id.info_title)
        val ticket = getTicket()
        photoView.setImageResource(ticket.clientPhoto)
        titleView.text = ticket.departureTo
    }

    private fun getTicket(): Ticket = arguments?.getSerializable(TICKET_KEY) as? Ticket ?: throw IllegalStateException("Ticket can't be null")

}