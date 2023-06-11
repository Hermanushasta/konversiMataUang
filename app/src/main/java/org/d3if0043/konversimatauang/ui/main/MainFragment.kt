package org.d3if0043.konversimatauang.ui.main

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import org.d3if0043.konversimatauang.R
import org.d3if0043.konversimatauang.databinding.FragmentMainBinding
import org.d3if0043.konversimatauang.network.ApiStatus
import org.d3if0043.konversimatauang.network.BenderaApi

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var myAdapter: MainAdapter

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        myAdapter = MainAdapter()

        with(binding.recycleView) {
            adapter = myAdapter
            setHasFixedSize(true)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }



//        binding.usdFlagMain1.setImageResource(R.mipmap.ic_launcher_american_flag)
//        binding.idrFlagMain2.setImageResource(R.mipmap.ic_launcher_indonesian_flag)
//        binding.usdFlagMain2.setImageResource(R.mipmap.ic_launcher_american_flag)
//        binding.idrFlagMain2.setImageResource(R.mipmap.ic_launcher_indonesian_flag)

        binding.mulaiBtn.setOnClickListener {
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

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }

            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                    requestNotificationPermission()
//                }
            }

            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }


}