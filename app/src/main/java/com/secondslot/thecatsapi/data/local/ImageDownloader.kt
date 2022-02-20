package com.secondslot.thecatsapi.data.local

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.WorkerThread
import com.bumptech.glide.Glide
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

// I think it's a data layer class.
// Agree. Replaced it to data layer
class ImageDownloader(private val context: Context) {

    @WorkerThread
    fun saveMediaToStorage(url: String): Boolean {

        val bitmap = Glide.with(context)
            .asBitmap()
            .load(url)
            .submit()
            .get()

        val filename = url.substringAfterLast('/')

        //Output stream
        var fos: OutputStream? = null

        //For devices running android >= Q
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            //getting the contentResolver
            context.contentResolver?.also { resolver ->

                //Content resolver will process the contentValues
                val contentValues = ContentValues().apply {

                    //putting file information in content values
                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                }

                //Inserting the contentValues to contentResolver and getting the Uri
                val imageUri: Uri? =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

                //Opening an outputStream with the Uri that we got
                fos = imageUri?.let { resolver.openOutputStream(it) }
            }
        } else {
            //These for devices running on android < Q
            val imagesDir =
                context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val image = File(imagesDir, filename)
            fos = FileOutputStream(image)
        }

        fos?.use {
            //Finally writing the bitmap to the output stream that we opened
            bitmap.compress(Bitmap.CompressFormat.JPEG, COMPRESS_QUALITY, it)
            Log.d(TAG, "Saved to Photos")
            return true
        }

        return false
    }

    companion object {
        private const val TAG = "ImageDownloader"
        private const val COMPRESS_QUALITY = 100
    }
}
