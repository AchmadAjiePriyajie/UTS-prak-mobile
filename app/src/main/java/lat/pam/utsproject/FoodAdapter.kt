package lat.pam.utsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FoodAdapter(
    private val foodList: List<Food>,
    private val onItemClick: (Food) -> Unit // Click listener
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)
        holder.itemView.setOnClickListener {
            onItemClick(food) // Trigger the click listener
        }
    }

    override fun getItemCount(): Int = foodList.size

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(food: Food) {
            // Bind food data to the UI elements in item_food layout
            // Example:
            itemView.findViewById<TextView>(R.id.foodName).text = food.name
            itemView.findViewById<TextView>(R.id.foodDescription).text = food.description
            itemView.findViewById<ImageView>(R.id.foodImage).setImageResource(food.imageResourceId)
        }
    }
}