package com.example.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class CountriesFragment : Fragment() {
    private var rootView: View? = null
    private var listViewCountries: ListView? = null
    private var countryNamesAdapter: ArrayAdapter<String>? = null
    private var context: Context? = null
    private lateinit var countries: Array<String>
    private var fragmentActionListener: FragmentActionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_countries, container, false)
        initUI()
        return rootView
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name) + "->Select Country"
    }

    fun setFragmentActionListener(fragmentActionListener: FragmentActionListener?) {
        this.fragmentActionListener = fragmentActionListener
    }

    private fun initUI() {
        context = getContext()
        countries = resources.getStringArray(R.array.year)
        listViewCountries = rootView!!.findViewById<View>(R.id.listViewCountries) as ListView
        countryNamesAdapter =
            ArrayAdapter(requireContext(), R.layout.custom_default_list_item, countries)
        listViewCountries!!.adapter = countryNamesAdapter
        listViewCountries!!.onItemClickListener =
            OnItemClickListener { _, _, i, _ ->
                fragmentActionListener?.onCountrySelected(countries[i])
            }
    }
}