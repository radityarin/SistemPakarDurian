package com.kelompoksatu.sistempakardurian.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelompoksatu.sistempakardurian.data.model.Diagnosis
import com.kelompoksatu.sistempakardurian.databinding.ItemDiagnosisHistoryBinding
import com.kelompoksatu.sistempakardurian.databinding.ItemSymptompsBinding
import com.kelompoksatu.sistempakardurian.ui.diagnosis.model.Symptomp

class DiagnosisHistoryViewHolder(val binding: ItemDiagnosisHistoryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Diagnosis) {
        binding.diagnosis = model
    }

    companion object {
        fun from(parent: ViewGroup): DiagnosisHistoryViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemDiagnosisHistoryBinding = ItemDiagnosisHistoryBinding.inflate(inflater, parent, false)
            return DiagnosisHistoryViewHolder(binding)
        }
    }
}