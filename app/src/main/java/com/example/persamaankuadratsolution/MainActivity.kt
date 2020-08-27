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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//Menu utama
        setSupportActionBar(findViewById(R.id.my_toolbar))//Mengaktifkan action bar
        //Variabel
        val A =findViewById<EditText>(R.id.A)//Kolom koefisien x kuadrat
        val b= findViewById<EditText>(R.id.b)//Kolom koefisien x
        val c = findViewById<EditText>(R.id.c)//Kolom konstanta
        val hitung = findViewById<Button>(R.id.hitung)//Tombol hitung
        val hasil_x1 = findViewById<TextView>(R.id.hasil_x1)//Kolom hasil akar pertama
        val hasil_x2 = findViewById<TextView>(R.id.hasil_x2)//Kolom hasil akar kedua
        val clear = findViewById<Button>(R.id.clear)//Tombol kosongkan
        //Ketika menekan tombol hitung
        hitung.setOnClickListener {
            if(A.length() == 0 || b.length()==0 || c.length()==0 ) {//Jika kolomnya ada yang kosong
               //Menginflasi dialog dengan view kustom
               val alertView = LayoutInflater.from(this).inflate(R.layout.alert, null);
               //Pembangun dialog peringatan
               val mBuilder = AlertDialog.Builder(this).setView(alertView)
               //Tunjukkan dialog
               val mAlertDialog = mBuilder.show()
               //Tombol ok
               alertView.okBut.setOnClickListener {
                   //Menghilangkan dialog
                   mAlertDialog.dismiss()
                }
            }
            else
            {//Mencari hasilnya
                val a = A.text.toString().toDouble()
                val B = b.text.toString().toDouble()
                val C = c.text.toString().toDouble()
                val x1 = (-B + sqrt(diskri(a,B,C))) / (2 * a)//Rumus ABC
                val x2 = (-B - sqrt(diskri(a,B,C))) / (2 * a)//Rumus ABC
                hasil_x1.setText(x1.toString())//Menampilkan hasil ke layar
                hasil_x2.setText(x2.toString())//Menampilkan hasil ke layar
            }
        }
        //Ketika menekan tombol bersihkan
        clear.setOnClickListener {
            A.setText("")
            b.setText("")
            c.setText("")
        }
    }
}
//Fungsi buat nyari diskriminan
fun diskri(a:Double,b:Double,c:Double):Double
{
    return (b*b-4*a*c)
}
//val = konstanta var = variabel