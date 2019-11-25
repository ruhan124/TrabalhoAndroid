package com.ruhan.swapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

	public static List<Questao> questions = new ArrayList<>();
	private final QuestaoBuilder questionsBuilder = new QuestaoBuilder();
	private Questao question = null;

	private int screenIndex = 0;
	private TextView tvQuestion;
	private EditText etAnswer;

	@SuppressLint("ClickableViewAccessibility")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		questions = questionsBuilder.build();

		ConstraintLayout screen = findViewById(R.id.screen);
		tvQuestion = findViewById(R.id.tvQuestion);
		etAnswer = findViewById(R.id.etAnswer);

		screen.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
			@Override
			public void onSwipeTop(){ // Não
				super.onSwipeTop();
				if (question.getResposta() == null) {
					question.setResposta(NumOpcao.NO.getOption());
					Toast.makeText(getApplicationContext(), getString(R.string.resposta_escolhida, getString(R.string.nao)), Toast.LENGTH_LONG).show();
				} else if (question.getResposta() != null) {
					Toast.makeText(getApplicationContext(), getString(R.string.questao_respondida), Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onSwipeBottom(){ // Sim / Confirmar
				super.onSwipeBottom();
				if (question.getResposta() == null) {
					question.setResposta(NumOpcao.YES.getOption());
					Toast.makeText(getApplicationContext(), getString(R.string.resposta_escolhida, getString(R.string.sim)), Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onSwipeRight(){
				super.onSwipeRight();
				loadQuestion("right");
			}

			@Override
			public void onSwipeLeft(){
				super.onSwipeLeft();
				loadQuestion("left");
			}
		});
	}

	private void loadQuestion(String direction){
		resetIndexIfOut();

		question = questions.get(this.screenIndex);
		tvQuestion.setText(question.getQuestion());

		if (direction.equals("right")){
			nextQuestion();
		}

		if (direction.equals("left")){
			prevQuestion();
		}

	}

	private void resetIndexIfOut(){
		if (screenIndex > (questions.size() - 1) || screenIndex < (questions.size() - 1)) {
			screenIndex = 0;
		}
	}


	private void prevQuestion(){
		screenIndex--;
	}

	private void nextQuestion(){
		screenIndex++;
	}
}