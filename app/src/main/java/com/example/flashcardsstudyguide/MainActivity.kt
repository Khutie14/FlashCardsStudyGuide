package com.example.flashcardsstudyguide

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //Align all the texts on the screen
            Column(
                //This is to make all the UI components central.
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.size(30.dp))
                Text(
                    text = "Welcome to History Challenge! Get ready to test how well you know your history. " +
                            "In this historical quiz, you are required to select true or false for each statement. " +
                            "Each question contains one point, if you get three or more correct answers your quiz was a success and if you get less than three, you must keep on practicing.",
                    //this is a the font size of the text above
                    fontSize = 15.sp,
                    //change the text above to bold
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(150.dp))
                Divider()
                Text(
                    text = "When you are ready you can click on the start button to begin",
                    //change the text above to bold
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.size(150.dp))
                Button(onClick = {
                    //Button to take you to the question screen
                    val Start = Intent(this@MainActivity, QuestionScreen::class.java)
                    //executing the start variable we declared using the internal function
                  startActivity(Start)
                })
                {
                    Text(text = "Start")


                }
            }
        }
    }
}