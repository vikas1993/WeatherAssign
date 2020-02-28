package com.test.weatherapplication.view;


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapplication.R
import com.test.weatherapplication.databinding.SavedWeatherDataListItemBinding
import com.test.weatherapplication.viewmodel.WeatherDataSummaryItem

class WeatherDataAdapter(val onItemSelected: (item: WeatherDataSummaryItem) -> Unit)
    : RecyclerView.Adapter<WeatherDataAdapter.WeatherDataViewHolder>() {

    private val weatherDataSummaries = mutableListOf<WeatherDataSummaryItem>()

    fun updateList(updates: List<WeatherDataSummaryItem>) {
        weatherDataSummaries.clear()
        weatherDataSummaries.addAll(updates)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDataViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<SavedWeatherDataListItemBinding>(
                inflater, R.layout.saved_weather_data_list_item, parent, false)

        return WeatherDataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weatherDataSummaries.size
    }

    override fun onBindViewHolder(holder: WeatherDataViewHolder, position: Int) {
        holder.bind(weatherDataSummaries[position])
    }

    inner class WeatherDataViewHolder(val binding: SavedWeatherDataListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeatherDataSummaryItem) {
            binding.item = item
            binding.root.setOnClickListener { onItemSelected(item) }
            binding.executePendingBindings()
        }

    }

}