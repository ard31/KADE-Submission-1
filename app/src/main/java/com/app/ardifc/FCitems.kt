package com.app.ardifc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FCitems(val name : String?, val image : Int, val detail : String?) : Parcelable