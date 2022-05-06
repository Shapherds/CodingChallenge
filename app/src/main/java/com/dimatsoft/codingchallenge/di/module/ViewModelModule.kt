package com.dimatsoft.codingchallenge.di.module

import android.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dimatsoft.codingchallenge.di.viewModelSetup.ViewModelFactory
import com.dimatsoft.codingchallenge.di.viewModelSetup.ViewModelKey
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModel
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(viewModel: SearchViewModelImpl): ViewModel
}
