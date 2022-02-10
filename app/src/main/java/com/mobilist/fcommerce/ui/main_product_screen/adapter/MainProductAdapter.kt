package com.mobilist.fcommerce.ui.main_product_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilist.fcommerce.data.model.ProductMainItemModel
import com.mobilist.fcommerce.databinding.ProductItemBinding

class MainProductAdapter(val productList:ArrayList<ProductMainItemModel>) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.view.model=productList[position]
    }
    fun updateList(newList:List<ProductMainItemModel>){
        productList.clear();
        productList.addAll(newList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return productList.count()
    }
}