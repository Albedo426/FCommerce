package com.mobilist.fcommerce.ui.main_product_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilist.fcommerce.R
import com.mobilist.fcommerce.databinding.MainProductFragmentBinding
import com.mobilist.fcommerce.ui.login_screen.LoginViewModel
import com.mobilist.fcommerce.ui.main_product_screen.adapter.MainProductAdapter
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.WithFragmentBindings
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@AndroidEntryPoint
class MainProductFragment() : Fragment() {
    private var _binding: MainProductFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainProductViewModel by viewModels()
    private   var productAdapter= MainProductAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainProductFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainFragmentRecy.layoutManager= GridLayoutManager(context,2)
        binding.mainFragmentRecy.adapter=productAdapter
        observe()
        viewModel.getDataFromSql()
    }

    private fun observe() {
        viewModel.productList.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.mainFragmentRecy.visibility=View.VISIBLE
                productAdapter.updateList(it)
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(context, "bir hata meydana geldi", Toast.LENGTH_SHORT).show()
                }
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    binding.progressBarMainFragment.visibility=View.VISIBLE
                    binding.mainFragmentRecy.visibility=View.GONE
                }else{
                    binding.progressBarMainFragment.visibility=View.GONE
                }
            }
        })

    }
}