package org.d3ifcool4035.praassesment


import android.content.ActivityNotFoundException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import org.d3ifcool4035.praassesment.databinding.FragmentMainBinding
import org.d3ifcool4035.praassesment.databinding.FragmentPersegiPanjangBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PersegiPanjangFragment : Fragment() {

    private var luasPersegiPanjang = 0
    private var kelilingPersegiPanjang = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(
            inflater, R.layout.fragment_persegi_panjang, container, false
        )
        binding.buttonHitungPersegiPanjang.setOnClickListener {
            var p = etPanjang.text.toString()
            var l = etLebar.text.toString()

            luasPersegiPanjang = (p.toInt() * l.toInt())
            kelilingPersegiPanjang= (2 * (p.toInt()+l.toInt()))

            tvLuasPersegiPanjang.text = luasPersegiPanjang.toString()
            tvKelilingPersegiPanjang.text = kelilingPersegiPanjang.toString()
        }
        binding.buttonSharePersegiPanjang.setOnClickListener {
            var shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setText(getString(R.string.share_data,luasPersegiPanjang,kelilingPersegiPanjang))
                .setType("text/plain").intent
            try {
                startActivity(shareIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context,"Kosong!", Toast.LENGTH_SHORT).show()
            }
        }
//        binding.luasPP = luasPersegiPanjang
//        binding.kelilingPP = kelilingPersegiPanjang
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("Luas", luasPersegiPanjang)
        outState.putInt("Keliling", kelilingPersegiPanjang)
        super.onSaveInstanceState(outState)
    }


}
