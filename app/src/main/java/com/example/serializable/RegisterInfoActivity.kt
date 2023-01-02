package com.example.serializable

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.imageview.ShapeableImageView

class RegisterInfoActivity : AppCompatActivity() {

    private lateinit var profilePicture: ShapeableImageView
    private val chooseImage = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Adding reference for UI
        profilePicture = findViewById(R.id.profileImage)
        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val age = findViewById<EditText>(R.id.etAge)
        val number = findViewById<EditText>(R.id.etNumber)
        val submitBtn = findViewById<Button>(R.id.btnSubmit)

        val editBtn = findViewById<Button>(R.id.editProfileImage)
        editBtn.setOnClickListener {

            pickImage()

        }
        submitBtn.setOnClickListener {

            val strImage = imageUri.toString()
            val strName = name.text.toString()
            val strEmail = email.text.toString()
            val strAge = age.text.toString()
            val strNumber = number.text.toString()

            val user = User(strImage, strName, strEmail, strAge, strNumber)


            Intent(this, ProfileActivity::class.java).also {
                it.putExtra("USER", user)
                startActivity(it)

            }

        }

    }

    private fun pickImage() {
        //Choose image from gallery
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, chooseImage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == chooseImage) {
            imageUri = data?.data
            profilePicture.setImageURI(imageUri)

        }
    }

}
