package com.example.waytocode

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class
SigninActivity : AppCompatActivity() {
    lateinit var txtsignup: TextView
    lateinit var btn_signin: Button
    lateinit var txtskip: TextView
    lateinit var edtemail: EditText
    lateinit var edtpass: EditText
    lateinit var txtforgotpassword: TextView
    private var mAuth: FirebaseAuth? = null
    @SuppressLint("CutPasteId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        txtsignup = findViewById(R.id.txtsignup)
        txtskip = findViewById(R.id.txtskip)
        btn_signin =findViewById<Button>(R.id.btn_signin)
        edtemail =findViewById<EditText>(R.id.edtemail)
        edtpass =findViewById<EditText>(R.id.edtpass)
        txtforgotpassword=findViewById<TextView>(R.id.txtforgotpassword)
        mAuth = FirebaseAuth.getInstance()
        intiView()
    }

    private fun intiView() {
        txtsignup.setOnClickListener {
            startActivity(
                Intent(this,
                    SignupActivity::class.java)
            )
        }
        txtforgotpassword.setOnClickListener {
            startActivity(
                Intent( this, ForgotPasswordActivity::class.java)
            )
        }
        txtskip.setOnClickListener {
            startActivity(
                Intent(this,
                    NavigationActivity::class.java)
            )
        }
        btn_signin.setOnClickListener { mAuth?.signInWithEmailAndPassword(
            edtemail.text.toString().trim(),
            edtpass.text.toString().trim()
        )
            ?.addOnCompleteListener(this@SigninActivity, object :
                OnCompleteListener<AuthResult> {
                override fun onComplete(@NonNull task: Task<AuthResult>) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithEmail:success")
                        startActivity(
                            Intent(
                                this@SigninActivity,
                                NavigationActivity::class.java
                            )
                        )
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithEmail:failure", task.getException())
                        Toast.makeText(
                            this@SigninActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                    // ...
                }
            }) }
    }
}