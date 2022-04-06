package ru.referon.byte_app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ru.referon.byte_app.adapter.Adapter
import ru.referon.byte_app.databinding.ActivityMainBinding
import ru.referon.byte_app.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {
    val business = "business"
    val politics = "politics"
    val science = "science"
    val sports = "sports"
    val entertainment = "entertainment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: ViewModel by viewModels()

        viewModel.loadNews(business)
        val adapter = Adapter()
        binding.list.adapter = adapter
        binding.b1.isSelected = true

        binding.b1.setOnClickListener {

            viewModel.loadNews(business)
            it.isSelected = !it.isSelected
            binding.b2.isSelected = false
            binding.b3.isSelected = false
            binding.b4.isSelected = false

        }

        binding.b2.setOnClickListener {
            viewModel.loadNews(politics)

            it.isSelected = !it.isSelected
            binding.b1.isSelected = false
            binding.b3.isSelected = false
            binding.b4.isSelected = false
            binding.b5.isSelected = false
        }

        binding.b3.setOnClickListener {
            viewModel.loadNews(science)

            it.isSelected = !it.isSelected
            binding.b1.isSelected = false
            binding.b2.isSelected = false
            binding.b4.isSelected = false
            binding.b5.isSelected = false
        }

        binding.b4.setOnClickListener {
            viewModel.loadNews(sports)

            it.isSelected = !it.isSelected
            binding.b1.isSelected = false
            binding.b2.isSelected = false
            binding.b3.isSelected = false
            binding.b5.isSelected = false
        }

        binding.b5.setOnClickListener {
            viewModel.loadNews(entertainment)

            it.isSelected = !it.isSelected
            binding.b1.isSelected = false
            binding.b2.isSelected = false
            binding.b3.isSelected = false
            binding.b4.isSelected = false
        }

        viewModel.data.observe(this) {
            binding.loading.isVisible = it.loading
            adapter.submitList(it.news?.articles)
        }
    }
}