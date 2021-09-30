package com.secondslot.thecatsapi.features.catdetails.vm

import android.app.Application
import android.content.ContentValues
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.secondslot.thecatsapi.TheCatApiApplication
import com.secondslot.thecatsapi.core.LiveDataEventWrapper.LiveDataEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

private const val TAG = "CatDetailsViewModel"

class CatDetailsViewModel(app: Application) : AndroidViewModel(app) {

    private var _imageSavedLiveData = MutableLiveData<LiveDataEvent<Boolean>>()
    val imageSavedLiveData get() = _imageSavedLiveData as LiveData<LiveDataEvent<Boolean>>

    fun saveMediaToStorage(url: String) {

        viewModelScope.launch(Dispatchers.IO) {

            val context = getApplication<TheCatApiApplication>()

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
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
                Log.d(TAG, "Saved to Photos")
            }
        }

        _imageSavedLiveData.value = LiveDataEvent(true)
    }
}
