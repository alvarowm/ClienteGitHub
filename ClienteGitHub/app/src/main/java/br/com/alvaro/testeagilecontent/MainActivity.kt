package br.com.alvaro.testeagilecontent

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.alvaro.models.Repo
import br.com.alvaro.retrofit.RetroFitCaller
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Response
import java.io.IOException
import java.io.Serializable

private const val ERROR_BLANK = "The user name can't be blank"
private const val NETWORK_ERROR = "A network error has occurred. Check your Internet connection and try again later."
private const val ERROR_USER_NOT_FOUND = "User not found."

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    fun onSearchClicked(v: View) {
        if (editText.text.toString().equals(""))
            chamarDialog(ERROR_BLANK)
        else
            getRepos(editText.text.toString())
    }

    private fun getRepos(user: String) {
        val doAsync = doAsync {
            try {
                val repos = RetroFitCaller().chamarGetRepoByUser(user)
                when {
                    repos.code() == 404 ->
                        uiThread {
                                chamarDialog(ERROR_USER_NOT_FOUND)
                        }
                    else -> callListReposActivity(repos)
                }
            } catch (e: IOException) {
                uiThread {
                    chamarDialog(NETWORK_ERROR)
                }
            }
        }
    }

    private fun callListReposActivity(response: Response<List<Repo>>) {
        val intent = Intent(this, ListActivity::class.java)
        intent.putExtra("repos",response.body() as Serializable)
        startActivity(intent)
    }

    private fun chamarDialog (msg : String){
        val builder = AlertDialog.Builder(this@MainActivity, R.style.MyDialogTheme)
                .setMessage(msg)
                .setPositiveButton("OK") { _: DialogInterface, i: Int ->
                }.create().show()
    }


}
