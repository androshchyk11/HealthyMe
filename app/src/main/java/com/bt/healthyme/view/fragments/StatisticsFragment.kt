package com.bt.healthyme.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bt.healthyme.R
import com.bt.healthyme.databinding.FragmentSignInBinding
import com.bt.healthyme.databinding.FragmentStatisticsBinding
import com.bt.healthyme.managers.SharedPreferencesManager
import com.bt.healthyme.model.StatisticModel
import com.bt.healthyme.view.activities.MainActivity
import com.bt.healthyme.view.adapters.StatisticsAdapter
import com.bt.healthyme.view.dialogs.AddStatisticDialog
import com.bt.healthyme.viewModels.SignInViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class StatisticsFragment : BaseFragment() {

    private lateinit var binding: FragmentStatisticsBinding
    private val sharedPreferencesManager: SharedPreferencesManager by inject()
    private val statisticsAdapter: StatisticsAdapter by inject()
    private var statisticsList: ArrayList<StatisticModel>? = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_statistics, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDefaultValues()
        setupRecyclerView()
    }

    private fun setupDefaultValues() {
        statisticsList = sharedPreferencesManager.statistics
        statisticsAdapter.items = statisticsList
        statisticsAdapter.notifyDataSetChanged()
    }

    private fun setupRecyclerView() {
        binding.statisticsRecyclerView.adapter = statisticsAdapter
        binding.statisticsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val dividerItemDecoration = DividerItemDecoration(
            binding.statisticsRecyclerView.context,
            (binding.statisticsRecyclerView.layoutManager as LinearLayoutManager).orientation
        )
        binding.statisticsRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun setupClicks() {
        binding.addBtn.setOnClickListener {
            AddStatisticDialog.show(
                activity as MainActivity,
                parentFragmentManager
            ) {
                statisticsList?.add(it)
                sharedPreferencesManager.statistics = statisticsList
                statisticsAdapter.items = statisticsList
                statisticsAdapter.notifyDataSetChanged()
            }
        }
    }
}