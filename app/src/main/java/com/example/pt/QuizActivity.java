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

    private ArrayList<Soal> soalList;
    private int currentSoalIndex = 0;
    private TextView soalTextView;
    private RadioGroup pilihanRadioGroup;
    private Button nextButton;
    private TextView scoreTextView;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize UI components
        soalTextView = findViewById(R.id.soalTextView);
        pilihanRadioGroup = findViewById(R.id.pilihanRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        scoreTextView = findViewById(R.id.scoreTextView);

        // Load questions
        soalList = new ArrayList<>();
        loadSoal();

        // Display the first question
        displaySoal(currentSoalIndex);

        // Set up button click listener
        nextButton.setOnClickListener(v -> {
            // Get selected answer
            RadioButton selectedOption = findViewById(pilihanRadioGroup.getCheckedRadioButtonId());
            if (selectedOption != null) {
                String selectedAnswer = selectedOption.getText().toString();
                checkAnswer(selectedAnswer);
            } else {
                Toast.makeText(QuizActivity.this, "Pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Move to next question or end quiz
            if (currentSoalIndex < soalList.size() - 1) {
                currentSoalIndex++;
                displaySoal(currentSoalIndex);
            } else {
                Toast.makeText(QuizActivity.this, "Quiz selesai!", Toast.LENGTH_SHORT).show();
                scoreTextView.setText("Skor Akhir: " + score);
                nextButton.setEnabled(false); // Disable button when quiz is finished
            }
        });
    }

    private void loadSoal() {
        soalList.add(new Soal("Apa ibu kota Indonesia?", new String[]{"Jakarta", "Bandung", "Surabaya", "Medan"}, "Jakarta"));
        soalList.add(new Soal("Siapa penemu telepon?", new String[]{"Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Isaac Newton"}, "Alexander Graham Bell"));
        soalList.add(new Soal("Apa warna bendera Jepang?", new String[]{"Merah dan Putih", "Merah dan Biru", "Putih dan Hijau", "Merah dan Kuning"}, "Merah dan Putih"));
    }

    private void displaySoal(int index) {
        Soal currentSoal = soalList.get(index);
        soalTextView.setText(currentSoal.getSoal());

        // Clear and add options
        pilihanRadioGroup.clearCheck();
        pilihanRadioGroup.removeAllViews();
        for (String option : currentSoal.getPilihanJawaban()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            pilihanRadioGroup.addView(radioButton);
        }
    }

    private void checkAnswer(String selectedAnswer) {
        Soal currentSoal = soalList.get(currentSoalIndex);
        if (currentSoal.getJawabanBenar().equals(selectedAnswer)) {
            score++;
            Toast.makeText(QuizActivity.this, "Jawaban Benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(QuizActivity.this, "Jawaban Salah!", Toast.LENGTH_SHORT).show();
        }
        scoreTextView.setText("Skor: " + score);
    }

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
