package com.sample.ar442.sharedelements

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class InfoFragment : Fragment() {

    private lateinit var photoView: ImageView
    private lateinit var titleView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(
            R.layout.fragment_info,
            container,
            false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoView = view.findViewById(R.id.info_photo)
        titleView = view.findViewById(R.id.info_title)
    }
    
}