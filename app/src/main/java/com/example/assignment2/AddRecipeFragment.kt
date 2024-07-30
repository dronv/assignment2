package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import android.widget.Toast

class AddRecipeFragment : Fragment(R.layout.fragment_add_recipe) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recipeNameEditText: EditText = view.findViewById(R.id.edRecipeName)
        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)
        val spinner: Spinner = view.findViewById(R.id.spinner)
        val addButton: Button = view.findViewById(R.id.BtnAdd)
        var flag : String = "Vegetables"
        var options = arrayOf("Vegetables", "Meat")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(context, "Nothing selected for ingridents", Toast.LENGTH_SHORT).show()
            }
        }
    addButton.setOnClickListener {
            val recipeName = recipeNameEditText.text.toString()
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = view.findViewById(selectedRadioButtonId)
            val recipeType = radioButton.text.toString()
            val selectedSpinnerItem = spinner.selectedItem.toString()

            if (recipeName.isEmpty()) {
                Toast.makeText(context, "Recipe name cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(
                context,
                "Recipe added: $recipeName, Type: $recipeType, Category: $selectedSpinnerItem",
                Toast.LENGTH_LONG
            ).show()

            recipeNameEditText.text.clear()
            radioGroup.clearCheck()
            spinner.setSelection(0)
        }

    }
}
