package com.secondslot.thecatsapi.features.catsgallery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.secondslot.thecatsapi.TheCatApiApplication
import com.secondslot.thecatsapi.data.repository.model.Cat
import com.secondslot.thecatsapi.databinding.FragmentGalleryBinding
import com.secondslot.thecatsapi.features.catsgallery.adapter.CatAdapter
import com.secondslot.thecatsapi.features.catsgallery.adapter.CatsLoaderStateAdapter
import com.secondslot.thecatsapi.features.catsgallery.vm.GalleryViewModel
import com.secondslot.thecatsapi.features.catsgallery.vm.GalleryViewModelFactory
import kotlinx.coroutines.flow.collectLatest

class GalleryFragment : Fragment(), CatListener {

    private var _viewModel: GalleryViewModel? = null
    private val viewModel get() = requireNotNull(_viewModel)

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val catAdapter by lazy(LazyThreadSafetyMode.NONE) {
        CatAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val viewModelFactory =
            GalleryViewModelFactory(TheCatApiApplication.getComponent().injectCatsUseCase())
        _viewModel = ViewModelProvider(this, viewModelFactory)
            .get(GalleryViewModel::class.java)

        initViews()
        setListeners()
        setObservers()
        return binding.root
    }

    private fun initViews() {
        binding.recyclerView.run {
            layoutManager = GridLayoutManager(requireContext(), RECYCLER_VIEW_SPAN_COUNT)
            adapter = catAdapter.withLoadStateHeaderAndFooter(
                header = CatsLoaderStateAdapter(),
                footer = CatsLoaderStateAdapter()
            )
        }
    }

    private fun setListeners() {

        catAdapter.addLoadStateListener { state ->
            binding.run {
                // Show spinner instead of RecyclerView, before until data is loaded
                recyclerView.isVisible = state.refresh != LoadState.Loading
                includeSpinner.spinner.isVisible = state.refresh is LoadState.Loading
                // Show error message and "retry" button if get loading error
                errorTextView.isVisible =
                    state.refresh is LoadState.Error ||
                        state.append is LoadState.Error
                retryButton.isVisible =
                    state.refresh is LoadState.Error ||
                        state.append is LoadState.Error
            }

            // Get error state and show error message
            val errorState = state.refresh as? LoadState.Error ?: state.append as? LoadState.Error
            errorState?.let {
                binding.errorTextView.text = it.error.localizedMessage
            }
        }

        binding.retryButton.setOnClickListener { catAdapter.retry() }
    }

    private fun setObservers() {

        lifecycleScope.launchWhenStarted {
            viewModel.cats.collectLatest(catAdapter::submitData)
        }
    }

    override fun onCatSelected(cat: Cat) {
        val action = GalleryFragmentDirections.toCatDetailsFragment(cat.url)
        findNavController().navigate(action)
    }

    companion object {
        private const val RECYCLER_VIEW_SPAN_COUNT = 3
    }
}
