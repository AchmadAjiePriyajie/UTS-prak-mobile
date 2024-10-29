package lat.pam.utsproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Retrieve views by their IDs
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val etFoodName = findViewById<TextView>(R.id.etFoodName)
        val etServings = findViewById<EditText>(R.id.etServings)
        val etName = findViewById<EditText>(R.id.etName)
        val etNotes = findViewById<EditText>(R.id.etNotes)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        // Retrieve the data passed from the previous activity
        val foodName = intent.getStringExtra("foodName") ?: "No food selected"
        etFoodName.text = foodName

        // Set up the button click listener
        btnOrder.setOnClickListener {
            // Retrieve user inputs
            val servings = etServings.text.toString()
            val orderingName = etName.text.toString()
            val notes = etNotes.text.toString()

            // Create and show a confirmation dialog
            showOrderConfirmationDialog(foodName, servings, orderingName, notes)
        }
    }

    private fun showOrderConfirmationDialog(foodName: String, servings: String, orderingName: String, notes: String) {
        // Build the dialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirm Your Order")
        builder.setMessage("Food Name: $foodName\nServings: $servings\nOrdered By: $orderingName\nNotes: $notes")

        // Set positive button action
        builder.setPositiveButton("Confirm") { dialog, _ ->
            // Action on confirm
            Toast.makeText(this, "Order confirmed!", Toast.LENGTH_SHORT).show()
            dialog.dismiss() // Dismiss the dialog
            finish()
        }

        // Set negative button action
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss() // Just dismiss the dialog
        }

        // Create and show the dialog
        val dialog = builder.create()
        dialog.show()
    }
}
