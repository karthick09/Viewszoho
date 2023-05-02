package com.example.views


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(), FragmentActionListener {
    var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        addCountriesFragment()
    }

    private fun addCountriesFragment() {
        fragmentTransaction = fragmentManager?.beginTransaction()
        val countryListFragment = CountriesFragment()
        countryListFragment.setFragmentActionListener(this)
        fragmentTransaction!!.add(R.id.fragmentContainer, countryListFragment)
        fragmentTransaction!!.commit()
    }

    private fun addCountryDescriptionFragment(countryName: String?) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        val countryDescriptionFragment = CountryDescriptionFragment()
        val bundle = Bundle()
        bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY, countryName)
        countryDescriptionFragment.setArguments(bundle)
        fragmentTransaction!!.replace(R.id.fragmentContainer, countryDescriptionFragment)
        fragmentTransaction!!.addToBackStack(null)
        fragmentTransaction!!.commit()
    }

    override fun onCountrySelected(country: String?) {
        addCountryDescriptionFragment(country)
    }
}