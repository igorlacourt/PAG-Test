package com.lacourt.myapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.lacourt.myapplication.domainMappers.not_used_interfaces.Mapper
import com.lacourt.myapplication.domainmodel.Details
import com.lacourt.myapplication.dto.MovieDTO
import com.lacourt.myapplication.dto.DbMovieDTO
import com.lacourt.myapplication.network.Resource
import com.lacourt.myapplication.repository.HomeRepository

class HomeViewModel(application: Application) : AndroidViewModel(application){

    private var homeRepository: HomeRepository? = null
    var topTrendingMovie: LiveData<Resource<Details>>? = null
    var topRatedMovies: LiveData<Resource<List<DbMovieDTO>>>? = null
    var trendingMovies: LiveData<Resource<List<DbMovieDTO>>>? = null
    var upcomingMovies: LiveData<Resource<List<DbMovieDTO>>>? = null
    var popularMovies: LiveData<Resource<List<DbMovieDTO>>>? = null
//    var trendingTv: LiveData<Resource<List<DbMovieDTO>>>? = null
//    var topRatedTv: LiveData<Resource<List<DbMovieDTO>>>? = null

    //    var latestTv: LiveData<Resource<List<DbMovieDTO>>>? = null

    init {
        Log.d("callstest", "homeViewModel init called.\n")
        homeRepository = HomeRepository(application)
        topTrendingMovie = homeRepository?.topTrendingMovie
        topRatedMovies = homeRepository?.topRatedMovies
        upcomingMovies = homeRepository?.upcomingMovies
        popularMovies = homeRepository?.popularMovies
        trendingMovies = homeRepository?.trendingMovies
//        latestTv = homeRepository?.latestTv
//        trendingTv = homeRepository?.trendingTv
//        topRatedTv = homeRepository?.topRatedTv
    }

    fun rearrengeMovies(order: String) {
//        homeRepository?.rearrengeMovies(order)
    }
}