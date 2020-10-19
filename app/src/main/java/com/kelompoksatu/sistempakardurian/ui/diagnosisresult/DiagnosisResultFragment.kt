package com.kelompoksatu.sistempakardurian.ui.diagnosisresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kelompoksatu.sistempakardurian.R
import com.kelompoksatu.sistempakardurian.databinding.FragmentDiagnosisResultBinding

class DiagnosisResultFragment : Fragment() {

    private lateinit var binding: FragmentDiagnosisResultBinding
    private val args: DiagnosisResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiagnosisResultBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.diagnosis = args.diagnosis

        binding.mbSelesai.setOnClickListener {
            findNavController().navigate(R.id.action_diagnosisResultFragment_to_homeFragment)
        }
    }

}