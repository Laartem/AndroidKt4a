package com.esiea.androidkt4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.esiea.androidkt4a.R
import com.esiea.androidkt4a.data.local.models.Question
import com.esiea.androidkt4a.data.local.models.QuestionList
import com.esiea.androidkt4a.injection.APIService
import com.esiea.androidkt4a.injection.RestClient
import kotlinx.android.synthetic.main.activity_a_p_i.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIActivity : AppCompatActivity() {
    private var mApiService: APIService? = null

    private var mAdapter: ListAdapter?= null;
    private var mQuestions: MutableList<Question> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = RestClient.client.create(APIService::class.java)

        listRecyclerView!!.layoutManager = LinearLayoutManager(this)

        mAdapter = ListAdapter(this, mQuestions, R.layout.question_item)
        listRecyclerView!!.adapter = mAdapter

        fetchQuetionList()
    }

    private fun fetchQuetionList() {
        val call = mApiService!!.fetchQuestions("android");
        call.enqueue(object : Callback<QuestionList> {

            override fun onResponse(call: Call<QuestionList>, response: Response<QuestionList>) {

                Log.d(TAG, "Total Questions: " + response.body()!!.items!!.size)
                val questions = response.body()
                if (questions != null) {
                    mQuestions.addAll(questions.items!!)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<QuestionList>, t: Throwable) {
                Log.e(TAG, "Got error : " + t.localizedMessage)
            }
        })
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}