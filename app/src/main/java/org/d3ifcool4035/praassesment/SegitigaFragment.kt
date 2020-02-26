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
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3ifcool4035.praassesment.databinding.FragmentPersegiPanjangBinding
import org.d3ifcool4035.praassesment.databinding.FragmentSegitigaBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SegitigaFragment : Fragment() {

    private var luasSegitiga = 0
    private var kelilingSegitiga = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(
            inflater, R.layout.fragment_segitiga, container, false
        )
        binding.buttonHitungSegitiga.setOnClickListener {
            var alas = etAlas.text.toString()
            var tinggi = etTinggi.text.toString()

            luasSegitiga = (alas.toInt() * tinggi.toInt()) / 2
//            kelilingSegitiga = Math.sqrt((alas.toDouble()*alas.toDouble())+(tinggi.toDouble()*tinggi.toDouble()))
        }

        binding.buttonShareSegitiga.setOnClickListener {
            var shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setText(getString(R.string.share_data,luasSegitiga,luasSegitiga))
                .setType("text/plain").intent
            try {
                startActivity(shareIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context,"Kosong!", Toast.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("Luas", luasSegitiga)
        outState.putInt("Keliling", kelilingSegitiga)
        super.onSaveInstanceState(outState)
    }

}
