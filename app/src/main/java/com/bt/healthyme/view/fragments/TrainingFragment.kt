package com.bt.healthyme.view.fragments

import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bt.healthyme.R
import com.bt.healthyme.databinding.FragmentTrainingBinding
import com.bt.healthyme.managers.SharedPreferencesManager
import com.bt.healthyme.model.TrainingModel
import com.bt.healthyme.utils.DataBaseHelper
import com.bt.healthyme.view.adapters.TrainingsAdapter
import org.koin.android.ext.android.inject

class TrainingFragment : BaseFragment() {

    private lateinit var binding: FragmentTrainingBinding
    private var mDb: SQLiteDatabase? = null
    private var dataBaseHelper: DataBaseHelper? = null
    private var cursor: Cursor? = null
    private val sharedPreferencesManager: SharedPreferencesManager by inject()
    private val trainingsAdapter: TrainingsAdapter by inject()
    private val trainingList: ArrayList<TrainingModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDatabase()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.trainingRecyclerView.adapter = trainingsAdapter
        binding.trainingRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val dividerItemDecoration = DividerItemDecoration(
            binding.trainingRecyclerView.context,
            (binding.trainingRecyclerView.layoutManager as LinearLayoutManager).orientation
        )
        binding.trainingRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun setupDatabase() {

        dataBaseHelper = DataBaseHelper(requireContext())
        mDb = try {
            dataBaseHelper?.writableDatabase
        } catch (mSQLException: SQLException) {
            throw mSQLException
        }
    }

    override fun setupClicks() {
        with(binding) {
            results.setOnClickListener {
                findNavController().navigate(R.id.action_trainingFragment_to_statisticsFragment)
            }

            handsTraining.setOnClickListener {
                when (sharedPreferencesManager.typeOfTraining) {
                    1 -> {
                        trainingList.clear()

                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 1 AND Part = 4 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }

                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    2 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 2 AND Part = 4 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    3 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 3 AND Part = 4 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }


                }
            }
            legsTraining.setOnClickListener {
                when (sharedPreferencesManager.typeOfTraining) {
                    1 -> {
                        trainingList.clear()

                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 1 AND Part = 3 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }

                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    2 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 2 AND Part = 3 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    3 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 3 AND Part = 3 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }


                }

            }
            shouldersTraining.setOnClickListener {
                when (sharedPreferencesManager.typeOfTraining) {
                    1 -> {
                        trainingList.clear()

                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 1 AND Part = 5 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }

                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    2 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 2 AND Part = 5 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    3 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 3 AND Part = 5 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }


                }
            }
            backTraining.setOnClickListener {
                when (sharedPreferencesManager.typeOfTraining) {
                    1 -> {
                        trainingList.clear()

                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 1 AND Part = 1 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }

                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    2 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 2 AND Part = 1 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    3 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 3 AND Part = 1 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }


                }
            }
            chestTraining.setOnClickListener {

                when (sharedPreferencesManager.typeOfTraining) {
                    1 -> {
                        trainingList.clear()

                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 1 AND Part = 2 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }

                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    2 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 2 AND Part = 2 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }
                    3 -> {
                        trainingList.clear()
                        cursor = mDb?.rawQuery(
                            "SELECT * FROM backTrainForWeightGain WHERE Type = 3 AND Part = 2 ORDER BY RANDOM() LIMIT 5",
                            null
                        )
                        cursor?.moveToFirst()

                        while (cursor?.isAfterLast == false) {
                            trainingList.add(
                                TrainingModel(
                                    trainingName = cursor?.getString(1),
                                    trainingRepeats = cursor?.getString(2)
                                )
                            )
                            cursor?.moveToNext()
                        }
                        trainingsAdapter.trainingItems = trainingList
                        trainingsAdapter.notifyDataSetChanged()
                    }


                }
            }
        }
    }
}