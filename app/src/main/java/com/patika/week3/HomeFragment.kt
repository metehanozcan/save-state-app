package com.patika.week3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.patika.week3.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v("PATIKADEV", "onCreateView called.")//
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
        //        return inflater.inflate(R.layout.fragment_home, container,false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            binding.textView.text = binding.userInputText.text.toString()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            Log.v("Test", "Another Test")
            binding.textView.text = savedInstanceState.getString("USER_TEXT", "DEFAULT VAL")
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("USER_TEXT", binding.textView.text.toString())
        Log.v("Test", "onSaveInstanceState called.")
    }
}