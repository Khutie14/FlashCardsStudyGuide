package com.example.flashcardsstudyguide

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardsstudyguide.ui.theme.FlashCardsStudyGuideTheme

class QuestionScreen() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //Defining variables
            val totalQuestions = 5 //Total number of question
            var isQuizComplete by remember { mutableStateOf(false) } // Tracks if the quiz is completed
            var currentQuestionIndex by remember { mutableStateOf(0) } // Tracks the current question
            var userScore by remember { mutableStateOf(0) } // Stores the user's score
            var resultMessage by remember { mutableStateOf("") } // Stores feedback for the user
            var areButtonsDisabled by remember { mutableStateOf(false) } // Disables button after an answer is selected
            val quizQuestions = arrayOf(
                // Array of quiz questions
                "Nelson Mandela served as President of South Africa from 1994 to 1999", // True
                "The Boers were of British descent", // False
                "World War 1 ended on November 11, 1917", // False
                "The ancient city of Pompeii was destroyed by a tsunami", // False
                "Ancient Egypt was a major power in the Mediterranean world during the Roman Empire", // False)
            )
            val correctAnswers =
                arrayOf(true, false, false, false, false) // Array of correct answers

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {


                // Check if the quiz is ongoing
                if (!isQuizComplete && currentQuestionIndex < totalQuestions) {
                    Text(text = quizQuestions[currentQuestionIndex]) // display the current question
                    Spacer(modifier = Modifier.height(50.dp)) // Add spacing
                    Text(text = resultMessage) // Display feedback
                    Spacer(modifier = Modifier.height(50.dp)) // Add more spacing

                    Row {
                        // Button for "True"
                        Button(
                            onClick = {
                                if (correctAnswers[currentQuestionIndex]) { // If the answer is correct
                                    resultMessage = "Correct!"
                                    userScore++ // Increment the score
                                } else {
                                    resultMessage = "Incorrect!"
                                }
                                areButtonsDisabled = true // Disable buttons after selection
                            },
                            enabled = !areButtonsDisabled // Enable/disable buttons based on state
                        ) {
                            Text(text = "True") //Label for the button
                        }

                        // Buttons for "False"
                        Button(
                            onClick = {
                                if (!correctAnswers[currentQuestionIndex]) { // If the answer is correct
                                    resultMessage = "Correct!"
                                    userScore++
                                } else {
                                    resultMessage = "Incorrect!"
                                }
                                areButtonsDisabled = true // Disable buttons after selection
                            },
                            enabled = !areButtonsDisabled // Enable/disable buttons based on state
                        ) {
                            Text(text = "False") //Label for the button
                        }
                    }

                    // Button for "Next"
                    Button(
                        onClick = {
                            currentQuestionIndex++ // Move to the next question
                            resultMessage = "" // Clear the feedback
                            areButtonsDisabled = false // Re-enable the buttons
                            if (currentQuestionIndex >= totalQuestions) { // Check if the quiz is completed
                                isQuizComplete = true
                            }
                        }
                    ) {
                        Text(text = "Next")
                    }
                }
            }


// Check if the quiz is complete
            if (isQuizComplete) {
                val goToScoreScreen = Intent(this@QuestionScreen, ScoreScreen::class.java)
                goToScoreScreen.putExtra("userScore", userScore)// Pass the score screen
                goToScoreScreen.putExtra(
                    "totalQuestions",
                    totalQuestions
                ) // Pass the total questions
                startActivity(goToScoreScreen) // Navigate to the score screen
            }
        }
    }
}