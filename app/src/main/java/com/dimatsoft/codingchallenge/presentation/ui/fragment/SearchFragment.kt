package com.dimatsoft.codingchallenge.presentation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.dimatsoft.codingchallenge.di.DaggerComponent
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.SearchScreen
import com.dimatsoft.codingchallenge.ui.theme.ChallengeTheme
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SearchViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ChallengeTheme{
                    SearchScreen(viewModel)
                }
            }
        }
    }
    private fun inject(){
        AndroidSupportInjection.inject(this)
    }
}