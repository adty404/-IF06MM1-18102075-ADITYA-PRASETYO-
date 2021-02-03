package com.ppb.aditya_prasetyo18102075.praktikum13.ui.myquotes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ppb.aditya_prasetyo18102075.praktikum13.CoroutineContextProvider
import com.ppb.aditya_prasetyo18102075.praktikum13.QuoteAdapter
import com.ppb.aditya_prasetyo18102075.praktikum13.R
import com.ppb.aditya_prasetyo18102075.praktikum13.TokenPref
import com.ppb.aditya_prasetyo18102075.praktikum13.`interface`.MainView
import com.ppb.aditya_prasetyo18102075.praktikum13.api.MainPresenter
import com.ppb.aditya_prasetyo18102075.praktikum13.databinding.FragmentMyQuotesBinding
import com.ppb.aditya_prasetyo18102075.praktikum13.helper.REQUEST_ADD
import com.ppb.aditya_prasetyo18102075.praktikum13.model.Login
import com.ppb.aditya_prasetyo18102075.praktikum13.model.Quote
import com.ppb.aditya_prasetyo18102075.praktikum13.model.Token
import com.ppb.aditya_prasetyo18102075.praktikum13.ui.QuoteAddUpdateActivity
import kotlinx.android.synthetic.main.fragment_my_quotes.*
import org.jetbrains.anko.support.v4.onRefresh

class MyQuotesFragment : Fragment(), MainView {
    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: QuoteAdapter
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
        Bundle?
    ): View? = inflater.inflate(R.layout.fragment_my_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMyQuotesBinding.bind(view)
        binding.recyclerviewMyQuotes.layoutManager = LinearLayoutManager(activity)
        tokenPref = TokenPref(requireActivity())
        token = tokenPref.getToken()
        adapter = QuoteAdapter(requireActivity())
        binding.recyclerviewMyQuotes.adapter = adapter
        presenter = MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getMyQuotes(token.token)

        binding.fab.setOnClickListener {
            val intent = Intent(requireActivity(),
                QuoteAddUpdateActivity::class.java)
            startActivityForResult(intent, REQUEST_ADD)
        }

        swiperefresh.onRefresh {
            progressbar.visibility = View.INVISIBLE
            presenter.getMyQuotes(token.token)
        }
    }
    override fun onResume() {
        super.onResume()
        presenter.getMyQuotes(token.token)
    }

    override fun showMessage(messsage: String) {
        Toast.makeText(requireActivity(),messsage, Toast.LENGTH_SHORT).show()
    }
    override fun resultQuote(data: ArrayList<Quote>) {
        quotes.clear()
        adapter.listQuotes = data
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        progressbar.visibility = View.INVISIBLE
        swiperefresh.isRefreshing = false
    }
    override fun resultLogin(data: Login) {
    }

}