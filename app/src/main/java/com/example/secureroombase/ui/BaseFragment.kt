package com.example.secureroombase.ui

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.domain.domain.Result

abstract class BaseFragment : Fragment() {

    private var loadingView: View? = null
    private var contextBase: Context? = null

    fun init(loadingView: View, context: Context) {
        this.loadingView = loadingView
        this.contextBase = context
    }

    fun <T : Any> handleResponse(response: Result<T?>, successAction: (T) -> Unit) {
        when (response) {
            Result.Loading -> {
                startProgress()
            }
            is Result.Success -> {
                stopProgress()
                response.value?.let {
                    successAction(it)
                }
            }
            is Result.Failure -> {
                stopProgress()
                response.e.message?.let { showErrorMessage(it) }
            }
            else -> {
            }
        }
    }

    private fun showErrorMessage(error: String) {
        contextBase?.let {
            Toast.makeText(contextBase, error, Toast.LENGTH_SHORT).show()
        }
    }

    fun showMessage(message: String) {
        contextBase?.let {
            Toast.makeText(contextBase, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun stopProgress() {
        loadingView?.visibility = View.GONE
    }

    private fun startProgress() {
        loadingView?.visibility = View.VISIBLE
    }

}