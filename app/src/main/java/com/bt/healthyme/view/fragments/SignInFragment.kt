package com.bt.healthyme.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bt.healthyme.R
import com.bt.healthyme.databinding.FragmentSignInBinding
import com.bt.healthyme.managers.SharedPreferencesManager
import com.bt.healthyme.model.StatisticModel
import com.bt.healthyme.viewModels.SignInViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class SignInFragment : BaseFragment() {
    private lateinit var binding: FragmentSignInBinding
    private val signInViewModel: SignInViewModel by viewModel()
    private val sharedPreferencesManager: SharedPreferencesManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = signInViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!sharedPreferencesManager.isFirstEnter) {
            findNavController().navigate(R.id.action_signInFragment_to_trainingFragment)
        } else {
            sharedPreferencesManager.isFirstEnter = false
        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun setupClicks() {

        with(binding) {
            startButton.setOnClickListener {
                when {
                    !viewModel?.nameLiveData?.value.isNullOrEmpty()
                            && !viewModel?.heightLiveData?.value.isNullOrEmpty()
                            && !viewModel?.weightLiveData?.value.isNullOrEmpty()
                            && !viewModel?.ageLiveData?.value.isNullOrEmpty() -> {
                        val sdf = SimpleDateFormat("yyyy.MM.dd")
                        val currentDate: String = sdf.format(Date())
                        sharedPreferencesManager.statistics = arrayListOf(
                            StatisticModel(
                                date = currentDate,
                                height = viewModel?.heightLiveData?.value.toString(),
                                weight = viewModel?.weightLiveData?.value.toString(),
                                age = viewModel?.ageLiveData?.value.toString()
                            )
                        )
                        findNavController().navigate(R.id.action_signInFragment_to_trainingFragment)
                    }
                    viewModel?.nameLiveData?.value.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), "Введіть ваше ім'я!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    viewModel?.heightLiveData?.value.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), "Введіть ваш зріст!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    viewModel?.weightLiveData?.value.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), "Введіть вашу вагу!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    viewModel?.ageLiveData?.value.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), "Введіть ваш вік!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            weightGainButton.setOnClickListener {
                sharedPreferencesManager.typeOfTraining = 2
            }
            weightLossButton.setOnClickListener {
                sharedPreferencesManager.typeOfTraining = 3
            }
            muscleButton.setOnClickListener {
                sharedPreferencesManager.typeOfTraining = 1
            }
        }
    }
}