package com.ppb.aditya_prasetyo18102075.praktikum9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.ppb.aditya_prasetyo18102075.praktikum9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var settingModel: SettingModel
    private lateinit var mSettingPreference: SettingPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.act = this
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.main_title)
        mSettingPreference = SettingPreference(this)
        showExistingPreference()
    }

    private fun showExistingPreference() {
        settingModel = mSettingPreference.getSetting()
        populateView(settingModel)
    }

    private fun populateView(settingModel: SettingModel) {
        if (settingModel.isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            delegate.applyDayNight()
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            delegate.applyDayNight()
        }
        binding.settingModel = settingModel
    }

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == SettingPreferenceActivity.RESULT_CODE) {
                showExistingPreference()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                this.startActivityForResult(Intent(this@MainActivity, SettingPreferenceActivity::class.java), REQUEST_CODE)
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
        return super.onOptionsItemSelected(item)
    }
}