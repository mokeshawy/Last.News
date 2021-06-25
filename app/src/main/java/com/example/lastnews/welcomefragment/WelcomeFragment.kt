package com.example.lastnews.welcomefragment

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import com.example.lastnews.R
import com.example.lastnews.databinding.FragmentWelcomeBinding
import java.util.*

class WelcomeFragment : Fragment() {

    lateinit var binding : FragmentWelcomeBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set animation.
        val ttb     = AnimationUtils.loadAnimation(requireActivity(), R.anim.ttb)
        val stb     = AnimationUtils.loadAnimation(requireActivity(), R.anim.stb)
        val btnCourse = AnimationUtils.loadAnimation(requireActivity(), R.anim.btt3)
        val btt     = AnimationUtils.loadAnimation(requireActivity(), R.anim.btt)
        val btt2    = AnimationUtils.loadAnimation(requireActivity(), R.anim.btt2)
        val btt3    = AnimationUtils.loadAnimation(requireActivity(), R.anim.btt3)

        binding.llChangeLanguage.startAnimation(ttb)
        binding.tvWelcomeTo.startAnimation(ttb)
        binding.tvToLastNews.startAnimation(ttb)
        binding.ivWelcomeScreen.startAnimation(stb)
        binding.btnNextCourse.startAnimation(btnCourse)

        // call loadLocate
        loadLocated()



        binding.languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected( adapterView : AdapterView<*>?,view: View?,position: Int, id: Long ) {
                binding.btnChangeLanguage.setOnClickListener {
                    if( position ==  0){
                        setLocate("en")
                        activity?.recreate()
                    }else if(position == 1){
                        setLocate("ar")
                        activity?.recreate()

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    @Suppress("DEPRECATION")
    private fun setLocate( language : String) {
        val local = Locale(language)
        Locale.setDefault(local)
        val config = Configuration()
        config.locale = local
        requireActivity().resources.updateConfiguration(config,requireActivity().resources.displayMetrics)

        val sharedPref = requireActivity().getSharedPreferences("setting", Context.MODE_PRIVATE)!!.edit()
        sharedPref.putString("myLanguage",language).apply()
    }

    private fun loadLocated(){
        val sharedPref = requireActivity().getSharedPreferences("setting", Context.MODE_PRIVATE)
        val language = sharedPref.getString("myLanguage","")
        setLocate(language.toString())
    }
}