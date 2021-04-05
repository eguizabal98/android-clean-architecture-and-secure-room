package com.example.secureroombase.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.domain.Person
import com.example.secureroombase.R
import com.example.secureroombase.databinding.PersonItemRowBinding

class PersonAdapter(private val itemClickListener: ItemClickListener) :
    ListAdapter<Person, PersonAdapter.PersonViewHolder>(DIFF_OBJECT) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.person_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.personItemRowBinding.person = getItem(position)
        holder.personItemRowBinding.clickListener = itemClickListener
    }

    inner class PersonViewHolder(val personItemRowBinding: PersonItemRowBinding) :
        RecyclerView.ViewHolder(personItemRowBinding.root)

    interface ItemClickListener {
        fun onUpdateClick(Id: Int)
    }
}

val DIFF_OBJECT = object : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
        oldItem.id == newItem.id &&
                oldItem.name == newItem.name &&
                oldItem.secondName == newItem.secondName &&
                oldItem.age == newItem.age
}