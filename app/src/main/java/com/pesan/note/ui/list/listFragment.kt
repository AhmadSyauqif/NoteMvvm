package com.pesan.note.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pesan.note.R
import com.pesan.note.databinding.FragmentListBinding
import com.pesan.note.utils.hideKeyBoard


class listFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        hideKeyBoard(requireActivity())
        return binding.root
    }

}