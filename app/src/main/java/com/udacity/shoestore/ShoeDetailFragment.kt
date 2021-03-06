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

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val activityViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_detail, container, false)

        binding.newsShoe = activityViewModel.newShoe

        binding.saveButton.setOnClickListener {
            activityViewModel.saveNewShoe()
            findNavController().popBackStack()
        }
        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}