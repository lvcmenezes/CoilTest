package de.rewe.coiltest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.android.synthetic.main.item_offer.view.*

class OffersAdapter : ListAdapter<Offer, OffersViewHolder>(OfferDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OffersViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_offer, parent, false)
    )

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class OffersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(offer: Offer) {
        itemView.productName.text = offer.product
        itemView.productAddress.text = offer.address
        itemView.productImage.load(offer.imageUrl)
        itemView.productImage.requestLayout()
    }
}

object OfferDiffCallback: DiffUtil.ItemCallback<Offer>() {
    override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean = oldItem == newItem

}