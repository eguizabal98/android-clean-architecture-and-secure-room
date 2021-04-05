package com.example.secureroombase.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.secureroombase.databinding.CreatePersonFragmentBinding
import com.example.secureroombase.ui.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class CreatePersonFragment : BaseFragment() {

    companion object {
        fun newInstance() = CreatePersonFragment()
    }

    private val viewModel: CreatePersonViewModel by viewModel()
    private lateinit var binding: CreatePersonFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CreatePersonFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        context?.let { init(binding.progressBarCreate, it) }

        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        viewModel.savePersonState.observe(viewLifecycleOwner, { result ->
            handleResponse(result) {
                showMessage("Item Saved")
                viewModel.cleanFields()
            }
        })
    }

}