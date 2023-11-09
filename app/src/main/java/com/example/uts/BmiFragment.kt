package com.example.uts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
var pilihan = 0

/**
 * A simple [Fragment] subclass.
 * Use the [BmiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BmiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_bmi, container, false)

        var tinggi = _view.findViewById<EditText>(R.id.tinggi)
        // 2. edt 2
        var berat = _view.findViewById<EditText>(R.id.berat)
        // 3. spinner
        var spinnerBmi = _view.findViewById<Spinner>(R.id.myspinner)
        // 4. button
        var btn_cal = _view.findViewById<Button>(R.id.btn_calculate)
        // 5. textview
        var hasil_nilai = _view.findViewById<TextView>(R.id.tv_hasil_nilai)

        var hasil_perkiraan = _view.findViewById<TextView>(R.id.tv_hasil_perkiraan)
        //endregion

        btn_cal.setOnClickListener {
            // 3
            val nilai1 = tinggi.text.toString().toDouble()
            val nilai2 = berat.text.toString().toDouble()
            var hasil = 0.0

            if(pilihan.equals(0)){ //
                hasil = nilai2 / (nilai1*nilai1)
            }

            else if( pilihan.equals(1)){
                hasil = nilai2-5 / (nilai1*nilai1)
            }

            if(hasil < 18.5){
                hasil_perkiraan.text = "Underweight"
            }else if(hasil<0){
                hasil_perkiraan.text = "Really?"
            }else if(hasil >=18.5 && hasil < 24.9){
                hasil_perkiraan.text = "Healthy"
            }else if(hasil >=24.9 && hasil < 30){
                hasil_perkiraan.text = "Overweight"
            }else if(hasil >=30){
                hasil_perkiraan.text = "Suffering from Obesity"
            }

            val hasilAkhir = String.format("%.4f",hasil)
            hasil_nilai.text = hasilAkhir

        }

        spinnerBmi.setOnItemSelectedListener(
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    pilihan = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            })

        return _view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BmiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BmiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}