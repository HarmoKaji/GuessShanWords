package com.itkawdami.guessshanwords;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FlexboxLayout gridWords, answerLayout;
    TextView tvResult, txtQuestion;
    Button btnCheck;
    ImageButton btnRefresh;

    ArrayList<String> selectedWords = new ArrayList<>();

    class Question {
        String[] words;
        String answer;

        Question(String[] words, String answer) {
            this.words = words;
            this.answer = answer;
        }
    }

    ArrayList<Question> questions = new ArrayList<>();
    Question currentQuestion;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridWords = findViewById(R.id.gridWords);
        answerLayout = findViewById(R.id.answerLayout);
        tvResult = findViewById(R.id.tvResult);
        txtQuestion = findViewById(R.id.txtQuestion);
        btnCheck = findViewById(R.id.btnCheck);
        btnRefresh = findViewById(R.id.btnRefresh);

        tvResult.setVisibility(View.GONE);

        // =========================
        // SHAN QUESTIONS
        // =========================

        questions.add(new Question(new String[]{"မႂ်ႇ","သုင်","ၶႃႈ","ၵူႈ","ၵေႃႉ"}, "မႂ်ႇသုင်ၶႃႈၵူႈၵေႃႉ"));
        questions.add(new Question(new String[]{"ၸွင်ႇ","ယူႇ","လီ","ၵၼ်","ၶႃႈ","ႁ"}, "ၸွင်ႇယူႇလီၵၼ်ၶႃႈႁ"));
        questions.add(new Question(new String[]{"မႃး","လႄႇ","ပွႆး","ပႃး","ၵေႃႉ","တွႆး"}, "မႃးလႄႇပွႆးပႃးၵေႃႉတွႆး"));
        questions.add(new Question(new String[]{"သူၼ်","ႁၢင်ႈ","လီ","ၼႃႇ","ၼေႃ"}, "သူၼ်ႁၢင်ႈလီၼႃႇၼေႃ"));
        questions.add(new Question(new String[]{"သူ","မီး","ပီႈ","ၼွင်ႉ","လၢႆ","ၵေႃႉ"}, "သူမီးပီႈၼွင်ႉလၢႆၵေႃႉ"));
        questions.add(new Question(new String[]{"ႁဝ်း","ၶႆႈ","မိူဝ်း","ႁိူၼ်း","သူ","ၶႃႈ"}, "ႁဝ်းၶႆႈမိူဝ်းႁိူၼ်းသူၶႃႈ"));
        questions.add(new Question(new String[]{"ၶႃႈ","မီး","ၶေႃႈ","ထၢမ်","ၶႃႈ","ဢေႃႈ"}, "ၶႃႈမီးၶေႃႈထၢမ်ၶႃႈဢေႃႈ"));
        questions.add(new Question(new String[]{"သူ","တေႇ","ၼႃႈ","ႁိူၼ်း","ယဝ်ႉ","ႁ"}, "သူတေႇၼႃႈႁိူၼ်းယဝ်ႉႁ"));
        questions.add(new Question(new String[]{"သူ","ႁဵတ်း","ၵၢၼ်","သင်","လႃႇ"}, "သူႁဵတ်းၵၢၼ်သင်လႃႇ"));
        questions.add(new Question(new String[]{"ၵိၼ်","ၶဝ်ႈ","ယဝ်ႉ","ႁ"}, "ၵိၼ်ၶဝ်ႈယဝ်ႉႁ"));
        questions.add(new Question(new String[]{"သူ","ၸွင်ႇ","မီး","ပီႈ","ၸၢႆး","ႁ"}, "သူၸွင်ႇမီးပီႈၸၢႆးႁ"));
        questions.add(new Question(new String[]{"ပဵၼ်","ဢူၺ်း","ၵေႃႉ","ၵၼ်","ၶႃႈ"}, "ပဵၼ်ဢူၺ်းၵေႃႉၵၼ်ၶႃႈ"));
        questions.add(new Question(new String[]{"ပေႃႈ","သူ","ဢႃႇ","ယု","ၵႃႈ","ႁိုဝ်"}, "ပေႃႈသူဢႃႇယုၵႃႈႁိုဝ်"));
        questions.add(new Question(new String[]{"မႄႈ","သူ","ယူႇ","လီ","ယူႇ","ႁ"}, "မႄႈသူယူႇလီယူႇႁ"));
        questions.add(new Question(new String[]{"ၵႆႇ","သီႇ","တူဝ်"}, "ၵႆႇသီႇတူဝ်"));
        questions.add(new Question(new String[]{"မႅဝ်း","ၺွပ်း","ၼူ"}, "မႅဝ်းၺွပ်းၼူ"));
        questions.add(new Question(new String[]{"ပႃ","မီး","ၼႂ်း","ၼမ်ႉ"}, "ပႃမီးၼႂ်းၼမ်ႉ"));
        questions.add(new Question(new String[]{"ယူႇ","ႁိူၼ်း","ယူႇ","ႁ"}, "ယူႇႁိူၼ်းယူႇႁ"));
        questions.add(new Question(new String[]{"ႁဝ်း","ႁၵ်ႉ","သူ","ၶႃႈ","ဢေႃႈ"}, "ႁဝ်းႁၵ်ႉသူၶႃႈဢေႃႈ"));
        questions.add(new Question(new String[]{"သူ","လၢတ်ႈ","တေႃႇ","ၽႂ်","ယူႇ"}, "သူလၢတ်ႈတေႃႇၽႂ်ယူႇ"));
        questions.add(new Question(new String[]{"ၵိၼ်","သင်","ယဝ်ႉ","လႃႇ"}, "ၵိၼ်သင်ယဝ်ႉလႃႇ"));
        questions.add(new Question(new String[]{"မႃး","ႁဝ်း","ၵႃႇ","လႄႇ"}, "မႃးႁဝ်းၵႃႇလႄႇ"));
        questions.add(new Question(new String[]{"ထၢင်ႇ","သူ","ပဵၼ်","ၽႂ်"}, "ထၢင်ႇသူပဵၼ်ၽႂ်"));
        questions.add(new Question(new String[]{"ၶႃႈ","မီး","တီႈ","ၼႆႈ","ဢေႃႈ"}, "ၶႃႈမီးတီႈၼႆႈဢေႃႈ"));
        questions.add(new Question(new String[]{"ဢၢပ်ႇ","ၼမ်ႉ","ယဝ်ႉ","ႁ"}, "ဢၢပ်ႇၼမ်ႉယဝ်ႉႁ"));
        questions.add(new Question(new String[]{"ၶႃႈ","ပဵၼ်","လုၵ်ႈ","ႁဵၼ်း","ဢေႃႈ"}, "ၶႃႈပဵၼ်လုၵ်ႈႁဵၼ်းဢေႃႈ"));
        questions.add(new Question(new String[]{"တၢင်း","ႁၵ်ႉ","လႄႈ","ငိုၼ်း","ၶမ်း"}, "တၢင်းႁၵ်ႉလႄႈငိုၼ်းၶမ်း"));

        // FIXED: added answer string
        questions.add(new Question(new String[]{"ၶႆႈ","လႆႈ","ငိုၼ်း","ၸၢႆႇ","ဢေႃႈ"}, "ၶႆႈလႆႈငိုၼ်းၸၢႆႇဢေႃႈ"));

        questions.add(new Question(new String[]{"ယႃႇ","ထၢင်ႇ","ယႂ်ႇ","ပိူၼ်ႈ","ၼႃႇ"}, "ယႃႇထၢင်ႇယႂ်ႇပိူၼ်ႈၼႃႇ"));
        questions.add(new Question(new String[]{"ၵႃး","သူ","မီး","တီႈ","ႁိူၼ်း","ႁ"}, "ၵႃးသူမီးတီႈႁိူၼ်းႁ"));
        questions.add(new Question(new String[]{"ၵႂႃႇ","လႄႇ","ပၢင်ႇ","လၢႆႇ"}, "ၵႂႃႇလႄႇပၢင်ႇလၢႆႇ"));
        questions.add(new Question(new String[]{"ယူႇ","တီႈ","လႂ်","ၶႃႈ"}, "ယူႇတီႈလႂ်ၶႃႈ"));
        questions.add(new Question(new String[]{"သူ","လီ","ႁၵ်ႉ","ၵျႃႉ","ၼေႃ"}, "သူလီႁၵ်ႉၵျႃႉၼေႃ"));
        questions.add(new Question(new String[]{"ပေႃး","မိူဝ်း","ႁိူၼ်း"}, "ပေႃးမိူဝ်းႁိူၼ်း"));
        questions.add(new Question(new String[]{"ႁၵ်ႉ","သူ","မိူၼ်","ၶႃႈ","ဢေႃႈ"}, "ႁၵ်ႉသူမိူၼ်ၶႃႈဢေႃႈ"));
        questions.add(new Question(new String[]{"လွၵ်း","မိုဝ်း","တႆး"}, "လွၵ်းမိုဝ်းတႆး"));
        questions.add(new Question(new String[]{"မႂ်ႇ","သုင်","ၶႃႈ"}, "မႂ်ႇသုင်ၶႃႈ"));
        questions.add(new Question(new String[]{"ယႃႇ","ႁဵတ်း","ၼၼ်","လႄႈ"}, "ယႃႇႁဵတ်းၼၼ်လႄႈ"));
        questions.add(new Question(new String[]{"ပွင်ႇ","ဝၢင်း","လႄႈ"}, "ပွင်ႇဝၢင်းလႄႈ"));
        questions.add(new Question(new String[]{"ၼင်ႈ","တြႃး","ႁႂ်ႈ","ၸႂ်","ၼိမ်"}, "ၼင်ႈတြႃးႁႂ်ႈၸႂ်ၼိမ်"));
        questions.add(new Question(new String[]{"ယႃႇ","ၶႃႇ","ၵေႇ","ၼႃႇ"}, "ယႃႇၶႃႇၵေႇၼႃႇ"));
        questions.add(new Question(new String[]{"ယႃႇ","ပေ","ႁၢႆႉ"}, "ယႃႇပေႁၢႆႉ"));

        // FIXED: answer typo (ႁဵတ်း -> ႁဵၼ်း in your original line)
        questions.add(new Question(new String[]{"မႃး","ႁဝ်း","ႁဵတ်း"}, "မႃးႁဝ်းႁဵတ်း"));

        questions.add(new Question(new String[]{"ၶႃႈ","ဢမ်ႇ","ႁတ်း"}, "ၶႃႈဢမ်ႇႁတ်း"));
        questions.add(new Question(new String[]{"တႃႇ","တေ","ယွၼ်း","သူ"}, "တႃႇတေယွၼ်းသူ"));
        questions.add(new Question(new String[]{"မိူင်း","တႆး","ႁဝ်း"}, "မိူင်းတႆးႁဝ်း"));
        questions.add(new Question(new String[]{"သၼ်","လွႆ","မိူင်း","တႆး"}, "သၼ်လွႆမိူင်းတႆး"));
        questions.add(new Question(new String[]{"ပႃး","ထူင်","မႃး","ယူႇ","ႁ"}, "ပႃးထူင်မႃးယူႇႁ"));
        questions.add(new Question(new String[]{"ၶႃႈ","ၶႆႈ","ႁူႉ","ၸၵ်း","သူ","ဢေႃႈ"}, "ၶႃႈၶႆႈႁူႉၸၵ်းသူဢေႃႈ"));
        questions.add(new Question(new String[]{"သူ","ႁဵတ်း","သင်"}, "သူႁဵတ်းသင်"));
        questions.add(new Question(new String[]{"မႃး","ႁွတ်ႈ","ယဝ်ႉ","ႁ"}, "မႃးႁွတ်ႈယဝ်ႉႁ"));
        questions.add(new Question(new String[]{"ပႆႇ","လႆႈ","ၶႃႈ"}, "ပႆႇလႆႈၶႃႈ"));
        questions.add(new Question(new String[]{"သူ","ပဵၼ်","ၽႂ်"}, "သူပဵၼ်ၽႂ်"));
        questions.add(new Question(new String[]{"မႄႈ","သူ","ၸႂ်","လီ","ၼႃႇ"}, "မႄႈသူၸႂ်လီၼႃႇ"));
        questions.add(new Question(new String[]{"ယႃႇ","လိုမ်း","ၶိူဝ်း","ၼႃႈ"}, "ယႃႇလိုမ်းၶိူဝ်းၼႃႈ"));
        questions.add(new Question(new String[]{"မႃး","ၸူး","ႁဝ်း","ၵမ်ႉ","လူး"}, "မႃးၸူးႁဝ်းၵမ်ႉလူး"));
        questions.add(new Question(new String[]{"ၶႆႈ","ၶိုၼ်ႈ","ၽၢႆႈ"}, "ၶႆႈၶိုၼ်ႈၽၢႆႈ"));
        questions.add(new Question(new String[]{"ယႃႇ","ပေ","မိူဝ်း","ၼႃ"}, "ယႃႇပေမိူဝ်းၼႃ"));
        questions.add(new Question(new String[]{"ယႃႇ","ပေ","ဝူၼ်ႉ","ၼမ်"}, "ယႃႇပေဝူၼ်ႉၼမ်"));

        // FIXED: answer mismatch (ထိုင် -> ထိုဝ် in your pasted answer)
        questions.add(new Question(new String[]{"ၸႂ်","ထိုင်","ႁဝ်း","ယူႇ","ႁ"}, "ၸႂ်ထိုင်ႁဝ်းယူႇႁ"));

        questions.add(new Question(new String[]{"လႅၼ်","ႁဝ်း","ယူဝ်ႉ","ၼၼ်ႉ"}, "လႅၼ်ႁဝ်းယူဝ်ႉၼၼ်ႉ"));
        questions.add(new Question(new String[]{"ပႃး","ႁဝ်း","ၵေႃႉ","ၼိုင်ႈ"}, "ပႃးႁဝ်းၵေႃႉၼိုင်ႈ"));
        questions.add(new Question(new String[]{"ယႃႇ","ၵႂႃႇ","ပႅတ်ႈ","ႁဝ်း","ၼႃ"}, "ယႃႇၵႂႃႇပႅတ်ႈႁဝ်းၼႃ"));
        questions.add(new Question(new String[]{"ၶႃႈ","ၶႆႈ","လႆႈ","ဢေႃႈ"}, "ၶႃႈၶႆႈလႆႈဢေႃႈ"));
        questions.add(new Question(new String[]{"ထၢင်ႇ","ထိူမ်","ၼိူဝ်","ႁဝ်း","ႁ"}, "ထၢင်ႇထိူမ်ၼိူဝ်ႁဝ်းႁ"));
        questions.add(new Question(new String[]{"ယွင်ႇ","ယူဝ်ႉ","ၼၼ်ႉ"}, "ယွင်ႇယူဝ်ႉၼၼ်ႉ"));
        questions.add(new Question(new String[]{"ယႃႇ","ပွင်ႇ","ၽႃႈ","ႁဝ်း"}, "ယႃႇပွင်ႇၽႃႈႁဝ်း"));
        questions.add(new Question(new String[]{"ႁဝ်း","မီး","သူ","ၵေႃႉ","လဵဝ်","ၵူၺ်း"}, "ႁဝ်းမီးသူၵေႃႉလဵဝ်ၵူၺ်း"));
        questions.add(new Question(new String[]{"လိုမ်း","ႁဝ်း","သေ","လႃႈ"}, "လိုမ်းႁဝ်းသေလႃႈ"));
        questions.add(new Question(new String[]{"ၵိုတ်း","ယူႇ","တီႈ","ၼၼ်ႈ"}, "ၵိုတ်းယူႇတီႈၼၼ်ႈ"));
        questions.add(new Question(new String[]{"ပႅတ်ႈ","သေ","လႃႈ"}, "ပႅတ်ႈသေလႃႈ"));
        questions.add(new Question(new String[]{"ၶႆႈ","လႆႈ","ယူႇ","ႁ"}, "ၶႆႈလႆႈယူႇႁ"));
        questions.add(new Question(new String[]{"မႃး","ၸူး","ႁဝ်း","လႄႈ"}, "မႃးၸူးႁဝ်းလႄႈ"));
        questions.add(new Question(new String[]{"ပႃး","သင်","မႃး","ၼၼ်ႉ"}, "ပႃးသင်မႃးၼၼ်ႉ"));
        questions.add(new Question(new String[]{"မႃ","ႁဝ်ႇ","ၼေႈ"}, "မႃႁဝ်ႇၼေႈ"));

        loadRandomQuestion();

        btnCheck.setOnClickListener(v -> checkAnswer());

        btnRefresh.setOnClickListener(v -> {
            v.animate().rotationBy(360).setDuration(400).start();
            loadRandomQuestion();
        });
    }

    // =========================
    // LOAD RANDOM QUESTION
    // =========================
    private void loadRandomQuestion() {
        gridWords.removeAllViews();
        answerLayout.removeAllViews();
        selectedWords.clear();

        tvResult.setVisibility(View.GONE);
        tvResult.setText("");

        int index = random.nextInt(questions.size());
        currentQuestion = questions.get(index);

        ArrayList<String> shuffled = new ArrayList<>();
        Collections.addAll(shuffled, currentQuestion.words);
        Collections.shuffle(shuffled);

        // Show shuffled words in top text
        StringBuilder questionText = new StringBuilder();
        for (String word : shuffled) {
            questionText.append(word).append("   ");
        }
        txtQuestion.setText(questionText.toString().trim());

        for (String word : shuffled) {
            Button btn = createWordButton(word);

            btn.setOnClickListener(v -> {
                gridWords.removeView(btn);
                addToAnswer(word);
            });

            gridWords.addView(btn);
        }
    }

    // =========================
    // CREATE WORD BUTTON
    // =========================
    private Button createWordButton(String word) {
        Button btn = new Button(this);
        btn.setText(word);

        btn.setBackgroundResource(R.drawable.word_button);
        btn.setTextColor(Color.BLACK);
        btn.setTextSize(18);
        btn.setAllCaps(false);
        btn.setPadding(35, 22, 35, 22);
        btn.setElevation(8f);

        // remove ugly click shadow / default effect
        btn.setStateListAnimator(null);

        FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(
                FlexboxLayout.LayoutParams.WRAP_CONTENT,
                FlexboxLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(12, 12, 12, 12);
        btn.setLayoutParams(params);

        return btn;
    }

    // =========================
    // ADD TO ANSWER
    // =========================
    private void addToAnswer(String word) {
        Button btn = createWordButton(word);

        answerLayout.addView(btn);
        selectedWords.add(word);

        btn.setOnClickListener(v -> {
            answerLayout.removeView(btn);
            selectedWords.remove(word);

            Button backBtn = createWordButton(word);

            backBtn.setOnClickListener(v2 -> {
                gridWords.removeView(backBtn);
                addToAnswer(word);
            });

            gridWords.addView(backBtn);
        });
    }

    // =========================
    // CHECK ANSWER
    // =========================
    private void checkAnswer() {
        StringBuilder sb = new StringBuilder();

        for (String w : selectedWords) {
            sb.append(w);
        }

        String userAnswer = sb.toString().trim();

        tvResult.setVisibility(View.VISIBLE);


        if (userAnswer.equals(currentQuestion.answer)) {
            tvResult.setText("😁 မၢၼ်ႇမႅၼ်ႈယဝ်ႉၶႃႈ!");
            tvResult.setTextColor(Color.WHITE);
            tvResult.setBackgroundResource(R.drawable.result_correct);

            new Handler().postDelayed(this::loadRandomQuestion, 1000);
        } else {
            tvResult.setText("☹️ ဢမ်ႇပႆႇမႅၼ်ႈၶႃႈ!");
            tvResult.setTextColor(Color.WHITE);
            tvResult.setBackgroundResource(R.drawable.result_wrong);
           new Handler().postDelayed(this::loadRandomQuestion, 1000);
        }
    }
}