package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


@Suppress("DEPRECATION")
class CountryDescriptionFragment : Fragment() {
    private var rootView: View? = null
    private var textViewCountryDescription: TextView? = null
    private var countryName: String? = null
    private var countryDescription: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_country_description, container, false)
        initUI()
        return rootView
    }

    private fun initUI() {
        textViewCountryDescription =
            rootView?.findViewById(R.id.textViewCountryDescription) as TextView
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle: Bundle? = arguments
        countryName = bundle?.getString(FragmentActionListener.KEY_SELECTED_COUNTRY, "India")
        countryDescription = getString(getStringId(countryName))
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.title = countryName
        textViewCountryDescription?.text = countryDescription
    }

    private fun getStringId(countryName: String?): Int {
        return when (countryName) {
            "India" -> {
                R.string.India
            }
            "USA" -> {
                R.string.USA
            }
            "Pakistan" -> {
                R.string.Pakistan
            }
            "Bangladesh" -> {
                R.string.Bangladesh
            }
            "Egypt" -> {
                R.string.Egypt
            }
            "Indonesia" -> {
                R.string.Indonesia
            }
            "UK" -> {
                R.string.UK
            }
            "Germany" -> {
                R.string.Germany
            }
            else -> {
                R.string.India
            }
        }
    }


}