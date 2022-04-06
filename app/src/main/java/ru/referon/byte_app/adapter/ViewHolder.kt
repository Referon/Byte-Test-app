package ru.referon.byte_app.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.referon.byte_app.R
import ru.referon.byte_app.databinding.CardLayoutBinding
import ru.referon.byte_app.model.Article
import java.text.SimpleDateFormat

class ViewHolder(
    private val binding: CardLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: Article) {

        binding.apply {

            name.text = news.source.name
            title.text = news.title
            description.text = news.description
            authorUrl.text = "Источник: ${news.url}"
            Glide.with(itemView)
                .load(news.urlToImage)
                .into(image)

            description.setOnClickListener {
                if (description.maxLines > 3){
                    description.maxLines = 3
                    description.setTextColor(Color.parseColor("#FFA9A9A9"))
                } else {
                    description.maxLines = 100
                    description.setTextColor(Color.parseColor("#FF000000"))
                }

            }

            var time = news.publishedAt
           time = time.replace("T", ":")
           time = time.replace("Z", "")
            val parser =  SimpleDateFormat("yyyy-MM-dd:HH:mm:ss")
            val formatter = SimpleDateFormat("d.MM.yyyy")
            val formattedDate = formatter.format(parser.parse(time))
            date.text = formattedDate
        }
    }
}