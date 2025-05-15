package com.example.flashcardsstudyguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardsstudyguide.ui.theme.FlashCardsStudyGuideTheme

class ScoreScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var reviewAnswers by remember { mutableStateOf(false) } //declaring the review variable
            var score = intent.getIntExtra("userScore", -1)//fetching score variable from get screen
            var totalquestions =
                intent.getIntExtra("totalQuestions", -1) //fetching totalquestions  variable
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Quiz complete")
                Spacer(modifier = Modifier.size(50.dp))
                if (score < 3) {
                    Text(
                        text = "Keep practising: $score/$totalquestions"

                    )//final results for users who got 3 and above
                } else Text(text = "Congratulations: $score/$totalquestions")//final result if below 3

                Row {
                    Button(onClick = {
                        reviewAnswers = true //when clicking the button review button must be true
                    }) {
                        Text(text = "Review answers")//This button will show all questions and answers
                    }

                    Button({ this@ScoreScreen.finishAffinity() }) {//close all activities
                        Text(text = "Exit")
                    }
                }
                Spacer(modifier = Modifier.size(30.dp))
                if (reviewAnswers) { //when the review button is true it will display answers below
                    Text(
                        text = "Nelson Mandela served as President of South Africa from 1994 to 1999: True\n" +
                                "The Boers were of British descent: False\n" +
                                "World War 1 ended on November 11, 1917: False\n" +
                                "The ancient city of Pompeii was destroyed by a tsunami: False\n" +
                                "Ancient Egypt was a major power in the Mediterranean world during the Roman Empire: False\n" ,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                        )
                }
            }
        }
    }
}





