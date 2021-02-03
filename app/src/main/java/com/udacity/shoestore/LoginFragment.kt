package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)

        binding.logInButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))
        binding.registerButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))

        return binding.root
    }
}