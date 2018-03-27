package com.sample.ar442.sharedelements

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class ListFragment : Fragment() {

    private lateinit var list: RecyclerView
    private lateinit var adapter: TicketAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(
            R.layout.fragment_list,
            container,
            false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = view.findViewById(R.id.list)
        adapter = TicketAdapter(this::onTicketClicked)
        list.adapter = adapter
        list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        list.setHasFixedSize(true)
        adapter.submitList(Ticket.createMockedList())
    }

    private fun onTicketClicked(ticket: Ticket) {
        //todo: заменить на открытие фрагмента с детальной информацией
        Toast.makeText(context, "To: ${ticket.departureTo}; Departure date: ${ticket.departureDate}", Toast.LENGTH_SHORT).show()
    }

}