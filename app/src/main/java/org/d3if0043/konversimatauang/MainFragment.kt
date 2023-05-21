package org.d3if0043.konversimatauang

import android.icu.util.IslamicCalendar.CalculationType
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.d3if0043.konversimatauang.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.usdFlagMain1.setImageResource(R.mipmap.ic_launcher_american_flag)
        binding.idrFlagMain2.setImageResource(R.mipmap.ic_launcher_indonesian_flag)
        binding.usdFlagMain2.setImageResource(R.mipmap.ic_launcher_american_flag)
        binding.idrFlagMain2.setImageResource(R.mipmap.ic_launcher_indonesian_flag)

        binding.mulaiBtn.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_convertionFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_mainFragment_to_aboutFragment
                )
                return true
            }

            R.id.menu_histori -> {
                findNavController().navigate(
                    R.id.action_mainFragment_to_historiFragment
                )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}