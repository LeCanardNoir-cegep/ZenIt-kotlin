package org.lecanardnoir.zenit

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(msg = Message("Android", "Jetpack Compose"), GetAssetImage("r2d2.jpg" ))
        }
    }
}

data class Message(val author:String, val body:String)

@Composable
fun MessageCard(msg:Message, imgBit:ImageBitmap?){
    Row(
        modifier = Modifier.fillMaxWidth(1f).fillMaxHeight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            imgBit!!,
            contentDescription = "Profile",
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        )
        Column {
            Text(text =msg.author)
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard(){
    val opt = BitmapFactory.Options()
    opt.inPreferredConfig = Bitmap.Config.ARGB_8888
    MessageCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!"),
        GetAssetImage(fileName = "r2d2.jpg")
    )
}

@Composable
fun GetAssetImage(fileName:String):ImageBitmap?{
    var bit:ImageBitmap? = null
    val assets = LocalContext.current.assets;
    try {
        val f = assets.open("images/$fileName")
        bit = BitmapFactory.decodeStream(f).asImageBitmap()
    }catch (e:Exception){
        Log.e("GetAssetImage", "fileName: " + e.message)
    }
    return bit ?: throw IllegalArgumentException("Image inexistante")
}