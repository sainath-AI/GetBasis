package com.masai.sainath.getbasisapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.getbasisapp.Model.data.Data
import com.masai.sainath.getbasisapp.R
import com.masai.sainath.getbasisapp.databinding.ItemLayoutBinding

class cardadaptor(
    val list: List<Data>
) : RecyclerView.Adapter<cardholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardholder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return cardholder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: cardholder, position: Int) {
        val listdata = list[position]
        holder.setData(listdata)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class cardholder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {


    fun setData(data: Data) {
        itemLayoutBinding.Responsetext.text = data.text
        itemLayoutBinding.ResponseId.text = data.id
    }

}
