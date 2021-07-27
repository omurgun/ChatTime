package com.omurgun.chattime.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.omurgun.chattime.databinding.ActivityPhoneLoginBinding
import java.util.concurrent.TimeUnit

class PhoneLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mVerificationId: String
    private lateinit var resendToken: ForceResendingToken
    private lateinit var callbacks: OnVerificationStateChangedCallbacks
    private var firebaseUser: FirebaseUser? = null
    private lateinit var btnNext:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        println("phone login")
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneLoginBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()
        init()
//        if (firebaseUser != null) {
//            startActivity(Intent(this, SetUserInfoActivity::class.java))
//        }

        btnNext.setOnClickListener {
            if (binding.btnNext.text.toString() == "Next") {
                val phone = "+" + binding.edCodeCountry.text.toString() + binding.edPhone.text.toString()
                startPhoneNumberVerification(phone)
            } else {

                verifyPhoneNumberWithCode(mVerificationId, "1234")
            }
        }

        callbacks = object : OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                println("onVerificationCompleted: Complete")
                signInWithPhoneAuthCredential(phoneAuthCredential)

            }

            override fun onVerificationFailed(e: FirebaseException) {
                println("onVerificationFailed: " + e.message)
            }

            override fun onCodeSent(
                verificationId: String,
                token: ForceResendingToken
            ) {
                println("onCodeSent:$verificationId")
                mVerificationId = verificationId
                resendToken = token
                binding.btnNext.text = "Confirm"
                binding.edCodeCountry.isEnabled = false
                binding.edPhone.isEnabled = false
            }
        }
    }

    private fun init()
    {

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseUser = firebaseAuth.currentUser
        btnNext = binding.btnNext
    }

    private fun startPhoneNumberVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyPhoneNumberWithCode(verificationId: String, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this,
                OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        println("signInWithCredential:success")
                        startActivity(
                            Intent(
                                this@PhoneLoginActivity,
                                MainActivity::class.java
                            )
                        )
                    } else {
                        println("signInWithCredential:failure")
                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            println("onComplete: Error Code")
                        }
                    }
                })
    }

}