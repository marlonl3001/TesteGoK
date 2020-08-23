package br.com.mdr.testegok.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import br.com.mdr.testegok.databinding.SpotItemBinding
import br.com.mdr.testegok.model.business.SpotLight
import com.squareup.picasso.Picasso

/**
 * @author Marlon D. Rocha
 * @since 22/08/20
 */

class SpotlightsAdapter: PagerAdapter(), AdapterItemsContract {

    private var spots: MutableList<SpotLight> = mutableListOf()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount() = spots.size

    @Suppress("UNCHECKED_CAST")
    override fun replaceItens(list: List<*>) {
        spots = list as MutableList<SpotLight>
        notifyDataSetChanged()
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SpotItemBinding.inflate(layoutInflater, parent, false)
        val spot = spots[position]

        Picasso.get().load(spot.bannerURL).into(binding.imgSpotlight)
        binding.imgSpotlight.contentDescription = spot.description

        parent.addView(binding.root)

        return binding.root
    }
}