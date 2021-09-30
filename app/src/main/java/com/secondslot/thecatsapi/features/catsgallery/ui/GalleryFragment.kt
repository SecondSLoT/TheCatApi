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

    private fun initViews() = binding.run {
        recyclerView.run {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = catAdapter.withLoadStateHeaderAndFooter(
                header = CatsLoaderStateAdapter(),
                footer = CatsLoaderStateAdapter()
            )
        }
    }

    private fun setListeners() {
        // Show spinner instead of RecyclerView, before until data is loaded
        catAdapter.addLoadStateListener { state ->
            binding.run {
                recyclerView.isVisible = state.refresh != LoadState.Loading
                includeSpinner.spinner.isVisible = state.refresh == LoadState.Loading
            }
        }
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
}
