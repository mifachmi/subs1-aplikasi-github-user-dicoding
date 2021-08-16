package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiongithubuser.R
import com.example.submissiongithubuser.databinding.ItemRecycleUserBinding
import model.Users

class UsersAdapter(private val listUser: ArrayList<Users>) : RecyclerView.Adapter<UsersAdapter.RecycleViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class RecycleViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRecycleUserBinding.bind(itemView)

        fun bind(user: Users) {
            binding.civUtama.setImageResource(user.photoUser)
            binding.fullNameUtama.text = user.fullname
            binding.usernameUtama.text = user.username
            binding.tvFollowerUtama.text = user.amountFollowers
            binding.tvFollowingUtama.text = user.amountFollowing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle_user, parent, false)
        return RecycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val users = listUser[position]

        holder.bind(users)
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