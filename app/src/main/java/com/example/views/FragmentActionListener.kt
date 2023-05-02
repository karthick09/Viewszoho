package com.example.views


interface FragmentActionListener {
    fun onCountrySelected(country: String?)

    companion object {
        const val KEY_SELECTED_COUNTRY = "KEY_SELECTED_COUNTRY"
    }
}