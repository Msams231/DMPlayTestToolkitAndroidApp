package com.example.ms_final_dmpt

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate

import androidx.preference.CheckBoxPreference

import androidx.preference.PreferenceFragmentCompat


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)


        val nightMode: CheckBoxPreference?  = findPreference("NIGHT")
        if (nightMode != null) {
            nightMode.onPreferenceChangeListener
            if (nightMode.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); //For night mode theme
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); //For day mode theme


}