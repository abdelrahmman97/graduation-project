package com.android.aimedicalcare.ui.patient

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.aimedicalcare.*
import com.android.aimedicalcare.databinding.FragmentHomePatientBinding

class PatientFragment : Fragment() {

    private lateinit var patientViewModel: PatientViewModel
    private var _binding: FragmentHomePatientBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        patientViewModel =
            ViewModelProvider(this).get(PatientViewModel::class.java)

        _binding = FragmentHomePatientBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textGallery
//        patientViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val goToDiagnose: Button = binding.goToDiagnoseP
        val generateQrCode: Button = binding.generateQrBtnP
        val goTpTextDiagnose: Button = binding.diagnoseTextBtnP
        val viewMedicalHistory: Button = binding.viewMedicalHistoryP
        val addOldMedicalHistory: Button = binding.addOldMedicalHistoryBtnP

        goToDiagnose.setOnClickListener {
            val intent = Intent(activity, DiagnoseActivity::class.java)
            activity?.startActivity(intent)
        }

        goTpTextDiagnose.setOnClickListener {
            val intent = Intent(activity, TextDiagnoseActivity::class.java)
            activity?.startActivity(intent)
        }

        viewMedicalHistory.setOnClickListener {
            val intent = Intent(activity, MedicalHistoryActivity::class.java)
            activity?.startActivity(intent)
        }

        generateQrCode.setOnClickListener {
            val intent = Intent(activity, GenerateQRCodeActivity::class.java)
            activity?.startActivity(intent)
        }

        addOldMedicalHistory.setOnClickListener {
            val intent = Intent(activity, AddOldMedicalHistoryActivity::class.java)
            activity?.startActivity(intent)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}