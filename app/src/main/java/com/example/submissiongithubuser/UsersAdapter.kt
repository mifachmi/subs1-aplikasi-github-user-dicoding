package com.example.submissiongithubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UsersAdapter(private val listUser: ArrayList<Users>) : RecyclerView.Adapter<UsersAdapter.RecycleViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class RecycleViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivFoto: ImageView = itemView.findViewById(R.id.civUtama)
        var tvFullName: TextView = itemView.findViewById(R.id.fullNameUtama)
        var tvUsername: TextView = itemView.findViewById(R.id.usernameUtama)
        var tvFollowers: TextView = itemView.findViewById(R.id.tvFollowerUtama)
        var tvFollowing: TextView = itemView.findViewById(R.id.tvFollowingUtama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle_user, parent, false)
        return RecycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val users = listUser[position]

        Glide.with(holder.itemView.context)
            .load(users.photoUser)
            .apply(RequestOptions().override(500, 500))
            .into(holder.ivFoto)

        holder.tvFullName.text = users.fullname
        holder.tvUsername.text = users.username
        holder.tvFollowers.text = users.amountFollowers
        holder.tvFollowing.text = users.amountFollowing

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.absoluteAdapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Users)
    }

}