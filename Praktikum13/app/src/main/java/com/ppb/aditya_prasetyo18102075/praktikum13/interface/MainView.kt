package com.ppb.aditya_prasetyo18102075.praktikum13.`interface`

import com.ppb.aditya_prasetyo18102075.praktikum13.model.Login
import com.ppb.aditya_prasetyo18102075.praktikum13.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}