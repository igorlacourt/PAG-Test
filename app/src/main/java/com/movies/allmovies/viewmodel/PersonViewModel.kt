package com.movies.allmovies.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.movies.allmovies.domainmodel.DomainMovie
import com.movies.allmovies.dto.PersonDetails
import com.movies.allmovies.network.Apifactory
import com.movies.allmovies.network.Error
import com.movies.allmovies.network.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonViewModel(application: Application) : AndroidViewModel(application){
    var person: MutableLiveData<Resource<PersonDetails>>? = MutableLiveData()
    var starredMovies: MutableLiveData<Resource<List<DomainMovie>>> = MutableLiveData()

    fun getPersonDetails(id: Int) {
        Apifactory.tmdbApi.getPerson(id).enqueue(object : Callback<PersonDetails> {
            override fun onFailure(call: Call<PersonDetails>, t: Throwable) {
                Log.d("personlog", "ViewModel, onFailure")
                person?.value = Resource.error(Error(400, t.localizedMessage))
            }

            override fun onResponse(call: Call<PersonDetails>, response: Response<PersonDetails>) {
                Log.d("personlog", "ViewModel, onResponse")
                if (response.isSuccessful) {
                    Log.d("personlog", "ViewModel, isSuccessful")
                    response.body()?.let { personData ->
                        person?.value = Resource.success(personData)
                    }
                } else {
                    Log.d("personlog", "ViewModel, NOT Successful")
                }
            }

        })
    }
}