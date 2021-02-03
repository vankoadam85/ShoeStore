package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val activityViewModel by activityViewModels<MainViewModel>()
    private val shoe = Shoe("", 0.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoe = shoe

        binding.saveButton.setOnClickListener {
            activityViewModel.addShoe(shoe)
            findNavController().popBackStack()
        }
        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}

object ShoeSizeConverter {

    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(value: Double): String {
        return if (value > 0.0) value.toString() else ""
    }

    @JvmStatic fun stringToDouble(value: String): Double {
        return value.toDoubleOrNull() ?: 0.0
    }
}