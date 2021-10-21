package com.example.parsinglocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    val images=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readeJson()
    }
    fun readeJson()
    {
        var json:String?=null
        try {
            val inputStream:InputStream=assets.open("data.json")
            json=inputStream.bufferedReader().use { it.readText() }
            val jsonArray=JSONArray(json)

            for (image in 0..jsonArray.length()-1){
                var ob=jsonArray.getJSONObject(image)
                Log.d("imageURL",ob.getString("url"))
                val url=ob.getString("url")
                images.add(url)
            }

            Log.d("imageURL",images.toString())
            recyclerView.adapter=RVAdapter(images)
            recyclerView.layoutManager= LinearLayoutManager(this)

        }catch (e:IOException){
            print(e)
        }
    }
}