package ir.moris.taskoneapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import ir.moris.domain.models.UserInfoModel
import ir.moris.taskoneapplication.viewModels.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var btnSignIn: Button
    private lateinit var etPhoneNumber: EditText
    private lateinit var etPassword: EditText
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.blue)

        btnSignIn = findViewById(R.id.btnSignIn)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etPassword = findViewById(R.id.etPassword)

        btnSignIn.setOnClickListener {

            viewModel.signIn(
                UserInfoModel(
                    0, etPhoneNumber.text.toString().toLong(),
                    etPassword.text.toString()
                )
            )
        }

        viewModel.dbContent.observe(this, Observer {
            it.forEach {
                println("user : ${it.id} , phone number : ${it.phoneNumber} , password : ${it.password} ")
            }
        })


    }
}