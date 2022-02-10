package com.mobilist.fcommerce.ui.main_product_screen

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.mobilist.fcommerce.app.data.entity.product.toProductMainItem
import com.mobilist.fcommerce.base.BaseViwModel
import com.mobilist.fcommerce.data.model.ProductMainItemModel
import com.mobilist.fcommerce.services.repo.product.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainProductViewModel @Inject constructor(application: Application,var productRepositoryImpl: ProductRepositoryImpl) : BaseViwModel(application)  {
    var productList = MutableLiveData<List<ProductMainItemModel>>()
    var error = MutableLiveData<Boolean>()
    var isLoading = MutableLiveData(false)

    private fun showData(list:List<ProductMainItemModel>){
        productList.value=list
    }
    fun getDataFromSql(){
        isLoading.value=true
        launch {
            val myData=productRepositoryImpl.allProductFromMainFragment().map { it.toProductMainItem() }
            showData(myData)
            isLoading.value=false
        }
    }
}