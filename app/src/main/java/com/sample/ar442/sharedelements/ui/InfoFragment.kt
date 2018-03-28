package com.sample.ar442.sharedelements.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sample.ar442.sharedelements.R
import com.sample.ar442.sharedelements.data.Ticket

class InfoFragment : Fragment() {

    companion object {

        private const val TICKET_KEY = "TICKET_KEY"
        private const val TRANSITION_KEY = "TRANSITION_KEY"
        private const val DEPARTURE_TRANSITION_KEY = "DEPARTURE_TRANSITION_KEY"

        fun getInstanceFor(ticket: Ticket, transitionName: String, departureName: String) = InfoFragment().apply {
            arguments = Bundle().apply {
                putSerializable(TICKET_KEY, ticket)
                putString(TRANSITION_KEY, transitionName)
                putString(DEPARTURE_TRANSITION_KEY, departureName)
            }
        }

    }

    private lateinit var photoView: ImageView
    private lateinit var titleView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

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
        photoView.transitionName = getPhotoTransitionName()
        photoView.setImageResource(ticket.clientPhoto)
        titleView.transitionName = getDepartureTransitionName()
        titleView.text = ticket.departureTo
        startPostponedEnterTransition()
    }

    private fun getTicket(): Ticket = arguments?.getSerializable(TICKET_KEY) as? Ticket ?: throw IllegalStateException("Ticket can't be null")

    private fun getPhotoTransitionName(): String? = arguments?.getString(TRANSITION_KEY)

    private fun getDepartureTransitionName(): String? = arguments?.getString(DEPARTURE_TRANSITION_KEY)

}