package com.mobiledev.diread.data.ui.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mobiledev.diread.R
import com.mobiledev.diread.data.ui.view.ViewModelFactory


class Profile : Fragment() {
    private val viewModel: profileViewModel by viewModels {
        ViewModelFactory.getInstance(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonLogout=view.findViewById<Button>(R.id.buttonLogout)
        buttonLogout.setOnClickListener {
            viewModel.logout()
        }

    }


}