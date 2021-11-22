package com.android.aimedicalcare.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.aimedicalcare.DiagnoseActivity
import com.android.aimedicalcare.MedicalHistoryActivity
import com.android.aimedicalcare.TextDiagnoseActivity
import com.android.aimedicalcare.databinding.FragmentHomeBinding
import com.google.zxing.integration.android.IntentIntegrator

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val goToDiagnose: Button = binding.goToDiagnose
        val goTpTextDiagnose: Button = binding.diagnoseTextBtn
        val scanQrCode: Button = binding.scanQrBtn
        val pndngDiagnose: Button = binding.checkPendingDiagnoseBtn

        goToDiagnose.setOnClickListener {
            val intent = Intent(activity, DiagnoseActivity::class.java)
            activity?.startActivity(intent)

        }

        goTpTextDiagnose.setOnClickListener {
            val intent = Intent(activity, TextDiagnoseActivity::class.java)
            activity?.startActivity(intent)
        }

        pndngDiagnose.setOnClickListener {
            val intent = Intent(activity, MedicalHistoryActivity::class.java)
            activity?.startActivity(intent)
        }

        scanQrCode.setOnClickListener {
            val scan = IntentIntegrator.forSupportFragment(this)
            scan.initiateScan()

        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode== Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(activity, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(activity, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}