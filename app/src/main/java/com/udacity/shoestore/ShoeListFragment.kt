package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val activityViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_list, container, false)

        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        )

        activityViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                val shoeLayoutBinding: ShoeLayoutBinding =
                    DataBindingUtil.inflate(
                        layoutInflater,
                        R.layout.shoe_layout,
                        binding.shoesLayout,
                        false
                    )
                with(shoeLayoutBinding) {
                    companyText.text = shoe.company
                    nameText.text = shoe.name
                    sizeText.text = shoe.size.toString()
                    binding.shoesLayout.addView(root)
                }
            }
        })

        return binding.root
    }
}