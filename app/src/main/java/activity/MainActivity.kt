package activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiongithubuser.R
import adapter.UsersAdapter
import model.DataUsers
import model.Users

class MainActivity : AppCompatActivity() {

    private lateinit var rvGithubUsers: RecyclerView
    private var list: ArrayList<Users> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGithubUsers = findViewById(R.id.list_of_users)
        rvGithubUsers.setHasFixedSize(true)

        list.addAll(DataUsers.listData)
        showRecyclerList()

        rvGithubUsers.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun showRecyclerList() {
        rvGithubUsers.layoutManager = LinearLayoutManager(this)
        val listUsersAdapter = UsersAdapter(list)
        rvGithubUsers.adapter = listUsersAdapter

        listUsersAdapter.setOnItemClickCallback(object : UsersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Users) {
                val moveWithObjectIntent = Intent(this@MainActivity, DetailUserActivity::class.java)
                moveWithObjectIntent.putExtra(DetailUserActivity.EXTRA_USER, data)
                startActivity(moveWithObjectIntent)
            }
        })
    }

}