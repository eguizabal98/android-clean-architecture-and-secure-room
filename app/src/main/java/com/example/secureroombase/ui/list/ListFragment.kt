package com.example.secureroombase.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.VerifiedInputEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secureroombase.R
import com.example.secureroombase.databinding.ListFragmentBinding
import com.example.secureroombase.ui.BaseFragment
import com.example.secureroombase.ui.create.CreatePersonFragment
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment(), PersonAdapter.ItemClickListener {

    private val viewModel: ListViewModel by viewModel()
    private lateinit var binding: ListFragmentBinding
    private lateinit var personAdapter: PersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater)
        subscribeToView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personAdapter = PersonAdapter(this)
        binding.personsRecycler.adapter = personAdapter
        subscribeToViewModel()
        viewModel.getPersonList()
    }

    private fun subscribeToView() {
        binding.floatingBtnAddPerson.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_createPersonFragment)
        }
    }

    private fun subscribeToViewModel() {
        viewModel.getPersonState.observe(viewLifecycleOwner, { result ->
            handleResponse(result) {
                if (it.isEmpty()) {
                    binding.textInfoEmpty.visibility = View.VISIBLE
                } else {
                    binding.textInfoEmpty.visibility = View.GONE
                    personAdapter.submitList(it)
                }
            }
        })
    }

    override fun onUpdateClick(Id: Int) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToUpdateFragment(Id))
    }
}