package com.sample.ar442.sharedelements.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.ar442.sharedelements.R
import com.sample.ar442.sharedelements.R.layout
import com.sample.ar442.sharedelements.data.Ticket

class ListFragment : Fragment() {

    private lateinit var list: RecyclerView
    private lateinit var adapter: TicketAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(
            layout.fragment_list,
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

    private fun onTicketClicked(ticket: Ticket, photoView: View, departureView: View) {
        val photoName = photoView.transitionName
        val departureName = departureView.transitionName
        val fragment = InfoFragment.getInstanceFor(ticket, photoName, departureName)
        activity?.supportFragmentManager?.run {
            //todo: сделай нормально, ну что ты
            //todo: пофиксить баг с переходом к первому элементу из фрагмента деталей
            beginTransaction()
                    .addSharedElement(photoView, photoName)
                    .addSharedElement(departureView, departureName)
                    .addToBackStack(tag)
                    .replace(R.id.main_content, fragment) //todo: заменить на нормальную реализацию. возможно навесить интерфейс на аквтивити с кастом
                    .commit()
        }
    }

}