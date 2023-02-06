package com.marcodev.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        btnBracketOpen.setOnClickListener{
            input.text = addToInputText("(")
        }

        btnBracketClosed.setOnClickListener{
            input.text = addToInputText(")")
        }

        btnZero.setOnClickListener {
            input.text = addToInputText("0")
        }

        btnOne.setOnClickListener {
            input.text = addToInputText("1")
        }

        btnTwo.setOnClickListener {
            input.text = addToInputText("2")
        }

        btnThree.setOnClickListener {
            input.text = addToInputText("3")
        }

        btnFour.setOnClickListener {
            input.text = addToInputText("4")
        }

        btnFive.setOnClickListener {
            input.text = addToInputText("5")
        }

        btnSix.setOnClickListener {
            input.text = addToInputText("6")
        }

        btnSeven.setOnClickListener {
            input.text = addToInputText("7")
        }

        btnEigth.setOnClickListener {
            input.text = addToInputText("8")
        }

        btnNine.setOnClickListener {
            input.text = addToInputText("9")
        }

        btnDot.setOnClickListener {
            input.text = addToInputText(".")
        }

        btnDivision.setOnClickListener {
            input.text = addToInputText("÷")
        }

        btnMultiply.setOnClickListener {
            input.text = addToInputText("x")
        }

        btnSubtraction.setOnClickListener {
            input.text = addToInputText("-")
        }

        btnAddiction.setOnClickListener {
            input.text = addToInputText("+")
        }

        btnEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(btnValue: String): String{
        return "${input.text}$btnValue";
    }

    private fun getInputExpression(): String{
        var expression = input.text.replace(Regex("÷"), "/");
        expression = expression.replace(Regex("x"), "*");

        return expression;
    }

    private fun showResult(){
        try {
            val expression = getInputExpression();
            val result = Expression(expression).calculate()

            if(result.isNaN()) {
                // Show Error Message
                output.text = "Error...";
                output.setTextColor(ContextCompat.getColor(this, R.color.red));
            } else {
                // Show Result
                output.text = DecimalFormat("0.#####").format(result).toString();
                output.setTextColor(ContextCompat.getColor(this, R.color.green));
            }
        } catch (e: Exception){
            // Show Error Message
            output.text = "Error...";
            output.setTextColor(ContextCompat.getColor(this, R.color.red));
        }
    }
}