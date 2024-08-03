package com.example.mynbaapp

import android.content.Intent
import android.provider.Telephony.Mms.Intents
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynbaapp.databinding.ItemStarBinding

class ListStarAdapter(private val listStar: ArrayList<Star>): RecyclerView.Adapter<ListStarAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemStarBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgPhoto : ImageView = binding.imgItemPhoto
        val tvName : TextView = binding.tvItemName
        val tvTeam : TextView = binding.tvItemTeam
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemStarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listStar.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, team, photo) = listStar[position]
        holder.tvName.text = name
        holder.tvTeam.text = team
        holder.imgPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.KEY_STAR,listStar[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}