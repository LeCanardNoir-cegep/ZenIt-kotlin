package org.lecanardnoir.zenit

import android.app.Application
import android.content.res.AssetManager.AssetInputStream
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import org.lecanardnoir.zenit.ui.theme.ZenItTheme
import java.io.File
import java.io.InputStream

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(msg = Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author:String, val body:String)

@Composable
fun MessageCard(msg:Message){
    Row {
        Image(rememberImage, contentDescription = "Profile")
        Column {
            Text(text =msg.author)
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}
