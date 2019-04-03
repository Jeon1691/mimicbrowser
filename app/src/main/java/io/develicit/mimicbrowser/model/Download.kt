package io.develicit.mimicbrowser.model

import android.os.Parcel
import android.os.Parcelable

class Download(
    val url: String,
    val userAgent: String,
    val contentDisposition: String,
    val mimeType: String,
    val contentLength: Long,
    val destinationDirectory: String,
    val fileName: String
) : Parcelable {

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(url)
        dest.writeString(userAgent)
        dest.writeString(contentDisposition)
        dest.writeString(mimeType)
        dest.writeLong(contentLength)
        dest.writeString(destinationDirectory)
        dest.writeString(fileName)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Download> {

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        override fun createFromParcel(source: Parcel): Download = Download(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readLong(),
            source.readString(),
            source.readString()
        )

        override fun newArray(size: Int): Array<Download?> = Array(size) { null }
    }
}