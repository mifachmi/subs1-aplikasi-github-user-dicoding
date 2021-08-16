package activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submissiongithubuser.databinding.ActivityDetailUserBinding
import model.Users

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<Users>(EXTRA_USER) as Users
        supportActionBar?.title = user.username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.apply {
            fullNameDetail.text = user.fullname
            fotoDetail.setImageResource(user.photoUser)
            usernameDetail.text = user.username
            tvRepoDetail.text = user.amountRepository
            tvFollowersDetail.text = user.amountFollowers
            tvFollowingDetail.text = user.amountFollowing
            tvComDetail.text = user.company
            tvLocDetail.text = user.location
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}