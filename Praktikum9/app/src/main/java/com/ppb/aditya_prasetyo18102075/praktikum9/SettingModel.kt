package com.ppb.aditya_prasetyo18102075.praktikum9

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SettingModel (
    var name: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var age: Int = 0,
    var birthday: String? = null,
    var sex: String? = null,
    var isDarkTheme: Boolean = false
): Parcelable
