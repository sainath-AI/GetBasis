package com.masai.sainath.getbasisapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.masai.sainath.getbasisapp.R
import com.masai.sainath.getbasisapp.adaptor.cardadaptor
import com.masai.sainath.getbasisapp.Model.Status
import com.masai.sainath.getbasisapp.Model.data.Data
import com.masai.sainath.getbasisapp.viewmodel.CardViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var cardViewModel: CardViewModel
    private var list = emptyList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardViewModel = ViewModelProviders.of(this).get(CardViewModel::class.java)

        cardViewModel.getData().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    list = it.data?.data!!
                    val adaptor = cardadaptor(list)
                    viewPager.adapter = adaptor
//
                }
            }
        })
    }
}