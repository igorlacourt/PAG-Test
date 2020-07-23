package com.movies.allmovies.di.subcomponent

import androidx.lifecycle.ViewModel
import com.movies.allmovies.di.ViewModelKey
import com.movies.allmovies.viewmodel.DetailsViewModel
import com.movies.allmovies.viewmodel.HomeViewModel
import com.movies.allmovies.viewmodel.PersonViewModel
import com.movies.allmovies.viewmodel.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonViewModel::class)
    fun bindPersonViewModel(viewModel: PersonViewModel): ViewModel


//    @Binds
//    @IntoMap
//    @ViewModelKey(MyListViewModel::class)
//    fun bindMyListViewModel(viewModel: MyListViewModel): ViewModel
}