package com.example.waytocode

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
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    lateinit var txtsignin: TextView
    lateinit var btn_signup: Button
    lateinit var edtemaxilu: EditText
    lateinit var edtmnumber: EditText
    lateinit var edtpassu: EditText
    lateinit var edtconfirmpass: EditText
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        mAuth = FirebaseAuth.getInstance()
        txtsignin = findViewById(R.id.txtsignin)
        edtemaxilu=findViewById<EditText>(R.id.edtemailu)
        edtmnumber=findViewById<EditText>(R.id.edtmnumber)
        edtpassu=findViewById<EditText>(R.id.edtpassu)
        edtconfirmpass=findViewById<EditText>(R.id.edtconfirmpass)
        btn_signup=findViewById(R.id.btn_signup)


        intiView()



    }

    private fun intiView() {
        txtsignin.setOnClickListener {
            startActivity(
                Intent(this,
                    SigninActivity::class.java)
            )
        }
        btn_signup.setOnClickListener {
            val ref= FirebaseDatabase.getInstance().getReference("user")
            val userid = ref.push().key
            val user = AddData(
                email = edtemaxilu.text.toString(),
                mobilenumber = edtmnumber.text.toString(),
                password = edtpassu.text.toString(),
                confirmpassword = edtconfirmpass.text.toString()
            )
            ref.child(userid!!).setValue(user).addOnCompleteListener {
                Toast.makeText(this@SignupActivity, "Sent Successfully", Toast.LENGTH_SHORT).show()

            }

            mAuth?.createUserWithEmailAndPassword(edtemaxilu.text.toString().trim(), edtpassu.text.toString().trim())
                ?.addOnCompleteListener(this, object: OnCompleteListener<AuthResult> {
                    override fun onComplete(@NonNull task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success")
                            startActivity(
                                Intent(this@SignupActivity,
                                SigninActivity::class.java)
                            )

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("TAG", "createUserWithEmail:failure", task.getException())
                            Toast.makeText(this@SignupActivity, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                        }
                        // ...
                    }
                })
        }
    }
}


