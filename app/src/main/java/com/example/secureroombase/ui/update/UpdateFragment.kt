package com.example.secureroombase.ui.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.secureroombase.databinding.UpdateFragmentBinding
import com.example.secureroombase.ui.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class UpdateFragment : BaseFragment() {

    private val viewModel: UpdateViewModel by viewModel()
    private lateinit var binding: UpdateFragmentBinding
    private val args: UpdateFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UpdateFragmentBinding.inflate(inflater)
        context?.let { init(binding.progressBarUpdate, it) }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel
        subscribeToViewModel()
        viewModel.getPerson(args.id)
    }

    private fun subscribeToViewModel() {
        viewModel.getPersonState.observe(viewLifecycleOwner, { result ->
            handleResponse(result) { person ->
                viewModel.assignPerson(person)
            }
        })

        viewModel.updatePersonState.observe(viewLifecycleOwner, { result ->
            handleResponse(result) {
                showMessage("Successful upgrade")
            }
        })

        viewModel.deletePersonState.observe(viewLifecycleOwner, { result ->
            handleResponse(result) {
                showMessage("Successful delete")
                findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment())
            }
        })
    }

}