package com.secondslot.thecatsapi.features.catdetails.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.secondslot.seloustev.extentions.loadImage
import com.secondslot.thecatsapi.databinding.FragmentDetailsBinding
import com.secondslot.thecatsapi.features.catdetails.vm.CatDetailsViewModel
import com.secondslot.thecatsapi.features.catdetails.vm.CatDetailsViewModelFactory

class CatDetailsFragment : Fragment() {

    //    private val viewModel by viewModels<CatDetailsViewModel>()
    private var _viewModel: CatDetailsViewModel? = null
    private val viewModel get() = requireNotNull(_viewModel)

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val args: CatDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        val androidViewModelFactory = CatDetailsViewModelFactory(requireActivity().application)
        _viewModel = ViewModelProvider(this, androidViewModelFactory)
            .get(CatDetailsViewModel::class.java)

        initViews()
        setListeners()
        setObservers()
        return binding.root
    }

    private fun initViews() {
        binding.catImageView.loadImage(args.url)
//        binding.urlTextView.text = args.url
    }

    private fun setListeners() {
        binding.downloadButton.setOnClickListener {
//            lifecycleScope.launch {
            viewModel.saveMediaToStorage(args.url)
//            }
        }
    }

    private fun setObservers() {
        viewModel.imageSavedLiveData.observe(viewLifecycleOwner) { isSavedEvent ->
            isSavedEvent.getContentIfNotHandled()?.let {
                Toast.makeText(context, "Saved to Photos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
