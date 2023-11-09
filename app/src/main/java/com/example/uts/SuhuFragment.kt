package com.example.uts

import android.annotation.SuppressLint
import android.os.Bundle
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

/**
 * A simple [Fragment] subclass.
 * Use the [SuhuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuhuFragment : Fragment() {
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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_suhu, container, false)

        var inputSuhu = _view.findViewById<EditText>(R.id.inputSuhu)
        var spinnerSuhu = _view.findViewById<Spinner>(R.id.myspinner)
        var btn_cal = _view.findViewById<Button>(R.id.btn_calculate)
        var hasil_nilai = _view.findViewById<TextView>(R.id.tv_hasil)
        var headerAtas = _view.findViewById<TextView>(R.id.header1)
        var headerBawah = _view.findViewById<TextView>(R.id.header2)


        btn_cal.setOnClickListener {
            // 3
            var nilai = inputSuhu.text.toString().toDouble()
            var hasil = 0.0

            if(pilihan.equals(0)){ // tambah
                hasil=(nilai*9/5)+32
                headerAtas.text = "Celcius"
                headerBawah.text = "Fahrenheit"

            }else if(pilihan.equals(1)){
                hasil = (nilai-32)*5/9
                headerAtas.text = "Fahrenheit"
                headerBawah.text = "Celcius"
            }
            val hasilAkhir = String.format("%.4f",hasil)
            hasil_nilai.text = hasilAkhir

        }

        spinnerSuhu.setOnItemSelectedListener(
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
         * @return A new instance of fragment SuhuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SuhuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}