package com.example.travelphotoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    var currentImage:Int=1
    var names= arrayOf("Char Minar","Golden Temple -First view","Golden Temple -Another View","Hawa Mahal","India Gate")
     lateinit var image:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.getActionBar()
//        setSupportActionBar(findViewById(R.id.my_toolbar))
        setContentView(R.layout.activity_main)
        val next=findViewById<ImageButton>(R.id.btnNext)
        val prev=findViewById<ImageButton>(R.id.btnPrevious)
val txtName=findViewById<TextView>(R.id.txtName)
        next.setOnClickListener{
//next image
            var idCurrentImageString="pic$currentImage"
//i have to get the integer address associated with each view
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha=0f
            currentImage=(5+currentImage)%5+1;

            var idImageToShowString="pic$currentImage"
//i have to get the integer address associated with each view
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f
            txtName.text=names[currentImage-1]
        }
        prev.setOnClickListener {
//prev image
            var idCurrentImageString="pic$currentImage"
//i have to get the integer address associated with each view
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha=0f
            if(currentImage!=1){
                currentImage=(5+currentImage-1)%5;
            }else{
                currentImage=5
            }

            var idImageToShowString="pic$currentImage"
//i have to get the integer address associated with each view
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f
            txtName.text=names[currentImage-1]
        }
    }
}