package com.example.pt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private ArrayList<Soal> soalList; // List of questions
    private int currentSoalIndex = 0;  // To track the current question
    private TextView soalTextView;
    private RadioGroup pilihanRadioGroup;
    private Button nextButton;
    private TextView scoreTextView;
    private int score = 0;  // Variable to track the score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize UI elements
        soalTextView = findViewById(R.id.soalTextView);
        pilihanRadioGroup = findViewById(R.id.pilihanRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        scoreTextView = findViewById(R.id.scoreTextView);

        // Initialize soal list
        soalList = new ArrayList<>();
        loadSoal();

        // Show the first question
        displaySoal(currentSoalIndex);

        // Handle next button click
        nextButton.setOnClickListener(v -> {
            // Check answer for current question
            RadioButton selectedOption = findViewById(pilihanRadioGroup.getCheckedRadioButtonId());
            if (selectedOption != null) {
                String selectedAnswer = selectedOption.getText().toString();
                checkAnswer(selectedAnswer);
            }

            // Move to the next question
            if (currentSoalIndex < soalList.size() - 1) {
                currentSoalIndex++;
                displaySoal(currentSoalIndex);
            } else {
                // Finish quiz
                Toast.makeText(QuizActivity.this, "Quiz Selesai!", Toast.LENGTH_SHORT).show();
                // Optionally, you can show final score or move to another screen
                scoreTextView.setText("Final Score: " + score);
            }
        });
    }

    // Load a list of questions
    private void loadSoal() {
        // Example soal and options
        soalList.add(new Soal("Apa ibu kota Indonesia?", new String[]{"Jakarta", "Bandung", "Surabaya", "Medan"}, "Jakarta"));
        soalList.add(new Soal("Siapa penemu telepon?", new String[]{"Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Isaac Newton"}, "Alexander Graham Bell"));
        soalList.add(new Soal("Apa warna bendera Jepang?", new String[]{"Merah dan Putih", "Merah dan Biru", "Putih dan Hijau", "Merah dan Kuning"}, "Merah dan Putih"));
        soalList.add(new Soal("Siapa penemu lampu pijar?", new String[]{"Thomas Edison", "Nikola Tesla", "Albert Einstein", "Isaac Newton"}, "Thomas Edison"));
        soalList.add(new Soal("Apa ibu kota Amerika Serikat?", new String[]{"Washington D.C.", "New York", "Los Angeles", "Chicago"}, "Washington D.C."));
        soalList.add(new Soal("Siapa penemu komputer?", new String[]{"Charles Babbage", "Alan Turing", "Bill Gates", "Steve Jobs"}, "Charles Babbage"));
        soalList.add(new Soal("Apa nama planet terdekat dengan Matahari?", new String[]{"Merkurius", "Venus", "Mars", "Bumi"}, "Merkurius"));
    }

    // Display question and options
    private void displaySoal(int index) {
        Soal currentSoal = soalList.get(index);
        soalTextView.setText(currentSoal.getSoal());

        // Clear previous radio buttons
        pilihanRadioGroup.clearCheck();
        pilihanRadioGroup.removeAllViews();

        // Add new options dynamically
        for (String option : currentSoal.getPilihanJawaban()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            pilihanRadioGroup.addView(radioButton);
        }
    }

    // Check answer and update score
    private void checkAnswer(String selectedAnswer) {
        Soal currentSoal = soalList.get(currentSoalIndex);
        if (currentSoal.getJawabanBenar().equals(selectedAnswer)) {
            score++;
            Toast.makeText(QuizActivity.this, "Jawaban Benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(QuizActivity.this, "Jawaban Salah!", Toast.LENGTH_SHORT).show();
        }
    }

    // Soal class to store question, options, and correct answer
    static class Soal {
        private String soal;
        private String[] pilihanJawaban;
        private String jawabanBenar;

        public Soal(String soal, String[] pilihanJawaban, String jawabanBenar) {
            this.soal = soal;
            this.pilihanJawaban = pilihanJawaban;
            this.jawabanBenar = jawabanBenar;
        }

        public String getSoal() {
            return soal;
        }

        public String[] getPilihanJawaban() {
            return pilihanJawaban;
        }

        public String getJawabanBenar() {
            return jawabanBenar;
        }
    }
}
