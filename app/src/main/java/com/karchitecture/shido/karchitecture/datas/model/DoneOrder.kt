package com.karchitecture.shido.karchitecture.datas.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Created by mira on 11/09/2017.
 */
@Entity(tableName = "DONE_ORDERS")
data class DoneOrder(@PrimaryKey
                     var sequence: Int = 0,
                     var type: String = "",
                     var time: String = "",
                     var orderId: String = "",
                     var side: String = "",
                     var price: String = "",
                     var reason: String = "",
                     var remainingSize: String = "") {

    @Ignore constructor() : this(0)
}