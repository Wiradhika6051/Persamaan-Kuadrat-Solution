package com.example.persamaankuadratsolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.alert.view.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//Menu utama
        //Variabel
        val A =findViewById<EditText>(R.id.A)
        val b= findViewById<EditText>(R.id.b)
        val c = findViewById<EditText>(R.id.c)
        val hitung = findViewById<Button>(R.id.hitung)
        val hasil_x1 = findViewById<TextView>(R.id.hasil_x1)
        val hasil_x2 = findViewById<TextView>(R.id.hasil_x2)
        //Ketika menekan tombol hitung
        hitung.setOnClickListener {
            if(A.length() == 0 || b.length()==0 || c.length()==0 ) {
               //Inflate the dialog with custom view
               val alertView = LayoutInflater.from(this).inflate(R.layout.alert, null);
               //alert dialog builder
               val mBuilder = AlertDialog.Builder(this).setView(alertView)
               //show dialog
               val mAlertDialog = mBuilder.show()
               //Ok Button
               alertView.okBut.setOnClickListener {
                   //dismiss dialog
                   mAlertDialog.dismiss()
                }
            }
            else
            {
                val a = A.text.toString().toDouble()
                val B = b.text.toString().toDouble()
                val C = c.text.toString().toDouble()
                val x1 = (-B + sqrt(diskri(a,B,C))) / (2 * a)
                val x2 = (-B - sqrt(diskri(a,B,C))) / (2 * a)
                hasil_x1.setText(x1.toString())
                hasil_x2.setText(x2.toString())
            }
        }
    }
}
//Fungsi buat nyari diskriminan
fun diskri(a:Double,b:Double,c:Double):Double
{
    return (b*b-4*a*c)
}
//val = konstanta var = variabel