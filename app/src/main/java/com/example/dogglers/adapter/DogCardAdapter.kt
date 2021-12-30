package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val data: List<Dog> = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val image: ImageView = view!!.findViewById(R.id.item_image)
        val name: TextView = view!!.findViewById(R.id.item_name)
        val age: TextView = view!!.findViewById(R.id.item_age)
        val hobby: TextView = view!!.findViewById(R.id.item_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getLayout(), parent, false)
        return DogCardViewHolder(view)
    }

    private fun getLayout(): Int {
        return when (layout) {
            Layout.GRID -> R.layout.grid_list_item
            else -> R.layout.vertical_horizontal_list_item
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dog = data[position]
        holder.image.setImageResource(dog.imageResourceId)
        holder.name.text = dog.name
        val resources = context?.resources
        holder.age.text = resources?.getString(R.string.dog_age, dog.age)
        holder.hobby.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
