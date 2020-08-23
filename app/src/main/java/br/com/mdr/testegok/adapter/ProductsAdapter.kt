package br.com.mdr.testegok.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mdr.testegok.R
import br.com.mdr.testegok.databinding.ProductItemBinding
import br.com.mdr.testegok.model.business.Product
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

/**
 * @author Marlon D. Rocha
 * @since 22/08/20
 */

class ProductsAdapter: RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>(), AdapterItemsContract {

    private var products: MutableList<Product> = mutableListOf()

    @Suppress("UNCHECKED_CAST")
    override fun replaceItens(list: List<*>) {
        products = list as MutableList<Product>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.bind(product)
    }

    override fun getItemCount() = products.size

    class ProductViewHolder(private val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {

            Picasso.get()
                .load(product.imageURL)
                .placeholder(R.drawable.digio_logo)
                .error(R.drawable.ic_image_error)
                .into(binding.imgProduct, object: Callback {
                    override fun onSuccess() {
                        binding.showError = false
                    }
                    override fun onError(e: Exception?) {
                        binding.showError = true
                    }
                })
            binding.imgProduct.contentDescription = product.description
        }
    }
}