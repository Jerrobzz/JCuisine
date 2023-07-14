package com.example.jcuisineapp

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var edtname:EditText
    lateinit var edtemail:EditText
    lateinit var edtpassword:EditText
    lateinit var edtpassword2:EditText
    lateinit var btnregister:Button
    lateinit var edtlogin:TextView
    lateinit var progress:ProgressDialog
    lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edtname = findViewById(R.id.medtname)
        edtemail = findViewById(R.id.medtemail)
        edtpassword = findViewById(R.id.medtpassword)
        edtpassword2 = findViewById(R.id.medtpassword2)
        btnregister = findViewById(R.id.btnregister)
        edtlogin = findViewById(R.id.medtlogin)
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        btnregister.setOnClickListener {


            var email = edtemail.text.toString().trim()
            var password = edtpassword.text.toString().toString()
            var password2 = edtpassword2.text.toString().trim()
            var name = edtname.text.toString().trim()
            if (email.isEmpty()){
                edtemail.setError("Please fill this input")
                edtemail.requestFocus()
            } else if (password.isEmpty()){
                edtpassword.setError("Please fill this input")
                edtpassword.requestFocus()
            }else if (password2.isEmpty()){
                edtpassword2.setError("Please Fill this input")
                edtpassword2.requestFocus()
            }else if (name.isEmpty()){
                edtname.setError("Please Fill this input")
                edtname.requestFocus()}
            else if(password.length < 6 ){
                edtpassword.setError("Atleast 6 characters.")
                edtpassword.requestFocus()
            } else {

                progress.show()
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isComplete){
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        mAuth.signOut()
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()

                    } else {
                        displayMessage("ERROR", it.exception!!.message.toString())
                    }
                }
            }

        }
        edtlogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        fun displayMessage(title:String, message:String){
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(title)
            alertDialog.setMessage(message)
            alertDialog.setPositiveButton("Ok", null)
            alertDialog.create().show()
            }

    }

    private fun displayMessage(String: String, toString: String) {

    }
}