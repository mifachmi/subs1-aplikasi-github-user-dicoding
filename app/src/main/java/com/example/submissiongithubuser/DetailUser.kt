package com.example.submissiongithubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submissiongithubuser.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<Users>(EXTRA_USER) as Users
        supportActionBar?.title = user.username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.fullNameDetail.text = user.fullname
        binding.fotoDetail.setImageResource(user.photoUser)
        binding.usernameDetail.text = user.username
        binding.tvRepoDetail.text = user.amountRepository
        binding.tvFollowersDetail.text = user.amountFollowers
        binding.tvFollowingDetail.text = user.amountFollowing
        binding.tvComDetail.text = user.company
        binding.tvLocDetail.text = user.location
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}