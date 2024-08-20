package com.example.koinz_recyclerview
//
//import CenteredSpacingItemDecoration
//import android.graphics.drawable.ClipDrawable.HORIZONTAL
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//import androidx.recyclerview.widget.GridLayoutManager
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
//        val gridLayoutManager = GridLayoutManager(this, 3,)
//        recyclerView.layoutManager = gridLayoutManager
//
//        val dataList = listOf("Staff", "Rude Attitude", "Points", "Points", "Rude Attitude")
//        val adapter = MyAdapter(dataList)
//        recyclerView.adapter = adapter
//
//
//
//
//    }
//}

/*                  Working without Recycler View           */
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_view)

        val buttonStaff1 = findViewById<Button>(R.id.button_staff_1)
        val buttonRude1 = findViewById<Button>(R.id.button_rude_1)
        val buttonPoints1 = findViewById<Button>(R.id.button_points_1)
        val buttonPoints2 = findViewById<Button>(R.id.button_points_2)
        val buttonRude2 = findViewById<Button>(R.id.button_rude_2)

        val buttons = listOf(buttonStaff1, buttonRude1, buttonPoints1, buttonPoints2, buttonRude2)

        for (button in buttons) {
            button.setOnClickListener {
                resetButtonStyles(buttons)

                button.background = ContextCompat.getDrawable(this, R.drawable.button_selected_bg)
            }
        }

        val textInputLayout = findViewById<TextInputLayout>(R.id.review_input)
        val editText = findViewById<TextInputEditText>(R.id.review_input_edit_text)

        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                textInputLayout.isHintEnabled = false
            } else {
                textInputLayout.isHintEnabled = true
            }
        }

    }

    private fun resetButtonStyles(buttons: List<Button>) {
        for (button in buttons) {
            button.background = ContextCompat.getDrawable(this, R.drawable.button_bg)
        }
    }
}
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
//        val gridLayoutManager = GridLayoutManager(this, 3)  // Single column
//        recyclerView.layoutManager = gridLayoutManager
//
//        val dataList = listOf(
//            ButtonItem("Staff"),
//            ButtonItem("Rude Attitude"),
//            ButtonItem("Points"),
//            ButtonItem("Points"),
//            ButtonItem("Rude Attitude")
//        )
//
//        val adapter = ButtonAdapter(dataList)
//        recyclerView.adapter = adapter
//    }
//}
