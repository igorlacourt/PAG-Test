package com.lacourt.myapplication.domainmodel

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.lacourt.myapplication.R
import com.lacourt.myapplication.dto.CastsDTO
import com.lacourt.myapplication.dto.CrewDTO
import com.lacourt.myapplication.dto.GenreXDTO
import com.lacourt.myapplication.dto.VideoDTO
import java.util.*
import kotlin.collections.ArrayList

data class Details(
    val backdrop_path: String?,
    val genres: List<GenreXDTO>?,
    val id: Int?,
    val overview: String?,
    val poster_path: String?,
    var release_date: String?,
    var runtime: Int?,
    val title: String?,
    val vote_average: Double?,
    val videos: ArrayList<VideoDTO>?,
    val casts: CastsDTO?
) {
    init {
        release_date = release_date?.subSequence(0, 4).toString()

        val trailer = getTrailer()
        videos?.clear()
        trailer?.let { videos?.add(it) }

       formatCasts()
    }

    fun formatCasts() {
        if (!casts?.cast.isNullOrEmpty()){
            for (i in casts?.cast!!.size - 1 downTo 4){
                casts.cast.removeAt(i)
            }
        }

        var director: CrewDTO? = null
        if(!casts?.crew.isNullOrEmpty()){
            var i = 0
            casts?.crew?.forEach { crew ->
                Log.d("dirlog", "forEach, $i")
                i++
                var job = crew.job?.toLowerCase()
                if (director == null && job == "director" ) {
                    director = crew
                    Log.d("dirlog", "$job == \"director\", is director, ${crew.job?.toLowerCase()}")
                } else {
                    Log.d("dirlog", "$job == \"director\", not director, ${crew.job?.toLowerCase()}")
                }
            }
            casts?.crew?.clear()
            director?.let { casts?.crew?.add(it) }
        }

    }

    fun getTrailer(): VideoDTO? {
        var trailer: VideoDTO? = null

        videos?.forEach { video ->
            val name = video.name?.toLowerCase()
            if (name != null) {
                if (name.contains("official trailer"))
                    trailer = video
            }
        }

        if (trailer == null) {
            videos?.forEach { video ->
                val name = video.name?.toLowerCase()
                if (name != null) {
                    if (name.contains("trailer"))
                        trailer = video
                }
            }
        }


        if (trailer == null)
            if (!videos.isNullOrEmpty())
                trailer = videos.get(0)

        return trailer
    }
}


