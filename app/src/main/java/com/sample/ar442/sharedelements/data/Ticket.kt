package com.sample.ar442.sharedelements.data

import android.support.annotation.DrawableRes
import com.sample.ar442.sharedelements.R.drawable
import java.io.Serializable

data class Ticket(val id: Int, val departureTo: String, val departureDate: String, @DrawableRes val clientPhoto: Int) : Serializable {

    companion object {
        fun createMockedList() = listOf(
                Ticket(0, "Left box", "12-12-20", drawable.cat1),
                Ticket(1, "Right box", "22-12-20", drawable.cat2)
        )
    }

}