package com.example.lastnews.splashfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.lastnews.R
import com.example.lastnews.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    lateinit var binding : FragmentSplashBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ttb     = AnimationUtils.loadAnimation(requireActivity(),R.anim.ttb)
        val stb     = AnimationUtils.loadAnimation(requireActivity(),R.anim.stb)
        val btnCourse = AnimationUtils.loadAnimation(requireActivity(),R.anim.btt3)

        val btt     = AnimationUtils.loadAnimation(requireActivity(),R.anim.btt)
        val btt2    = AnimationUtils.loadAnimation(requireActivity(),R.anim.btt2)
        val btt3    = AnimationUtils.loadAnimation(requireActivity(),R.anim.btt3)

        //binding.tvWelcomeTitle.startAnimation(btt)
        binding.tvCopyRight.startAnimation(btt)

        binding.ivSplashScreen.startAnimation(stb)
        //binding.btnNextCourse.startAnimation(btnCourse)

        // will go welcome fragment after start splash.
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
        }
    }
}