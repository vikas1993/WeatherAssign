package com.test.weatherapplication.view;


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapplication.R
import com.test.weatherapplication.databinding.SavedWeatherHourlyDataListItemBinding
import com.test.weatherapplication.network.response.WeatherResponseObject

class WeatherDataAdapterHourly()
    : RecyclerView.Adapter<WeatherDataAdapterHourly.WeatherDataViewHolder>() {

    private val weatherDataSummaries = mutableListOf<WeatherResponseObject>()

    fun updateList(updates: List<WeatherResponseObject>) {
        weatherDataSummaries.clear()
        weatherDataSummaries.addAll(updates)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDataViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<SavedWeatherHourlyDataListItemBinding>(
                inflater, R.layout.saved_weather_hourly_data_list_item, parent, false)

        return WeatherDataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weatherDataSummaries.size
    }

    override fun onBindViewHolder(holder: WeatherDataViewHolder, position: Int) {
        holder.bind(weatherDataSummaries[position])
    }

    inner class WeatherDataViewHolder(val binding: SavedWeatherHourlyDataListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeatherResponseObject) {
            binding.item = item
            //binding.root.setOnClickListener { onItemSelected(item) }
            binding.executePendingBindings()
        }

    }

}