package edu.unicauca.aplimovil.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.aplimovil.composetutorial.ui.theme.ComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(
                        msg = Message("Maria", "Hola this is the body")
                    )
                }

            }

        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message){

    Row(modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact Profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = msg.author,

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }


}

@Preview
@Composable
fun PreviewMessageCard(){
    ComposeTutorialTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(
                msg = Message("Maria", "Hello this is the body")
            )
        }

    }

}