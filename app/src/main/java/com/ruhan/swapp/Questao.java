package com.ruhan.swapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Questao {

	private String question;
	private List<Opcao> opcoes = new ArrayList<>();
	private Resposta resposta;

	public String getQuestion() {
		return question;
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public Questao(String question) {
		this.question = question;
	}

	public Questao addOption(String text, boolean isCorrect) {
		if (this.opcoes.size() > 2) {
			Log.e("Pergunta", "A pergunta excedeu o limite de duas opções");
		}
		this.opcoes.add(new Opcao(text, isCorrect));
		return this;
	}

	public void setResposta(String resposta) {
		this.resposta = new Resposta(resposta);
	}

	public Resposta getResposta() {
		return this.resposta;
	}

	public boolean verifyAnswer(String answer) {
		if (opcoes.isEmpty()) {
			return false;
		}

		return opcoes.contains(new Opcao(answer, true));
	}
}
