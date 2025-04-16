package com.example.tugas3

import android.os.Parcel
import android.os.Parcelable

data class ItemData(val imageSource : Int, val imageTitle : String, val asal : String, val imageDesc : String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageSource)
        parcel.writeString(imageTitle)
        parcel.writeString(asal)
        parcel.writeString(imageDesc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemData> {
        override fun createFromParcel(parcel: Parcel): ItemData {
            return ItemData(parcel)
        }

        override fun newArray(size: Int): Array<ItemData?> {
            return arrayOfNulls(size)
        }
    }

}
