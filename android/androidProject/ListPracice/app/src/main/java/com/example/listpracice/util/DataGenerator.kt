package com.example.listpracice.util

import com.example.listpracice.R
import kotlin.random.Random


data class ChatRoomInfo(val image:Int, val name:String, val time:String)

class DataGenerator {
    companion object{
        @JvmField
        val images = arrayOf(
            R.drawable.baseline_accessible_24,
            R.drawable.baseline_accessibility_24,
            R.drawable.baseline_accessible_forward_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_circle_24,
            R.drawable.baseline_accessible_24,
            R.drawable.baseline_airline_seat_flat_angled_24,
            R.drawable.baseline_airline_seat_recline_extra_24
        )


        @JvmField
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        @JvmStatic
        fun get(): MutableList<ChatRoomInfo> {
            val count = Random.nextInt(1, 100)
            val list = MutableList(count) {
                val imageIndex = Random.nextInt(images.size)
                val nameLength = Random.nextInt(3, 80)
                val randomString = (1..nameLength)
                    .map { charPool[Random.nextInt(0, charPool.size)] }
                    .joinToString("")
                val randomDay = Random.nextInt(1, 32)
                ChatRoomInfo(images[imageIndex], randomString, "3월 ${randomDay}일")
            }
            return list
        }

    }
}