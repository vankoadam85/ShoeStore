package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val activityViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_detail, container, false)

        binding.saveButton.setOnClickListener {
            activityViewModel.addShoe(createShoe())
            findNavController().popBackStack()
        }
        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun createShoe(): Shoe {
        return Shoe(
            binding.shoeNameEditText.text.toString(),
            binding.shoeSizeEditText.text.toString().toDoubleOrNull() ?: 0.0,
            binding.companyEditText.text.toString(),
            binding.descriptionEditText.text.toString()
        )
    }
}