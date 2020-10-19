package com.kelompoksatu.sistempakardurian.ui.ask

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kelompoksatu.sistempakardurian.R
import com.kelompoksatu.sistempakardurian.data.model.Prediction
import com.kelompoksatu.sistempakardurian.data.request.Symptomps
import com.kelompoksatu.sistempakardurian.databinding.ActivityAskBinding
import com.kelompoksatu.sistempakardurian.util.Utils
import com.kelompoksatu.sistempakardurian.util.hide
import com.kelompoksatu.sistempakardurian.util.show
import com.kelompoksatu.sistempakardurian.util.snackbar
import kotlinx.android.synthetic.main.activity_ask.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AskActivity : AppCompatActivity() {

    private val viewModel by viewModel<AskViewModel>()
    private lateinit var binding: ActivityAskBinding
    private lateinit var bottomSheetBehaviour: BottomSheetBehavior<ViewGroup>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ask)
        binding.lifecycleOwner = this
        initView()
        observeLiveData()
    }

    private fun initView() {
        with(binding) {
            bottomSheetBehaviour = BottomSheetBehavior.from(layoutBottomSheet)
            btnTanya.setOnClickListener { ask() }
            layoutContent.setOnClickListener { collapseBottomSheet() }
        }
    }

    private fun observeLiveData() {
        viewModel.prediction.observe(this, Observer {
            Log.d("cek", it.message)
            onDataLoaded(it.prediction)
        })
    }

    private fun onDataLoaded(prediction: Prediction) {
        progressBar.hide()
        expandBottomSheet()
        binding.prediction = prediction
//        viewModel.insertDiagnose(this,prediction)
//
//        Log.d("cek",viewModel.getAllDiagnose(this).toString())
    }

    private fun ask() {
        val jenis = binding.edtJenis.text.toString()
        val gejala = mutableListOf<String>()
        val cfuser = mutableListOf<Double>()
        gejala.add(binding.edtGejala1.text.toString())
        gejala.add(binding.edtGejala2.text.toString())
        gejala.add(binding.edtGejala3.text.toString())
        cfuser.add(binding.edtCfuser1.text.toString().toDouble())
        cfuser.add(0.0)
        cfuser.add(0.0)
        cfuser.add(0.0)
        cfuser.add(0.0)
        cfuser.add(0.0)
        cfuser.add(0.0)
        cfuser.add(binding.edtCfuser2.text.toString().toDouble())
        cfuser.add(binding.edtCfuser3.text.toString().toDouble())
        if (jenis.isEmpty().not()) {
            progressBar.show()
            val symptomps = Symptomps(Utils.generateRandomInt(10),jenis,gejala,cfuser)
            viewModel.diagnose(symptomps)
        } else {
            layout_content.snackbar(getString(R.string.masukan_pertanyaan))
        }
    }

    private fun expandBottomSheet() {
        bottomSheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun collapseBottomSheet() {
        bottomSheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun onBackPressed() {
        if (bottomSheetBehaviour.state == BottomSheetBehavior.STATE_EXPANDED) {
            collapseBottomSheet()
        } else {
            super.onBackPressed()
        }
    }

}
