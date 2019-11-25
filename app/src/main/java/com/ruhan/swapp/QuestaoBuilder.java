package com.ruhan.swapp;

import com.ruhan.swapp.Questao;
import com.ruhan.swapp.NumOpcao;

import java.util.ArrayList;
import java.util.List;

public class QuestaoBuilder{

	public List<Questao> build() {
		List<Questao> questions = new ArrayList<>();
		questions.add(new Questao("A terra é redonda?")
				.addOption(NumOpcao.YES.getOption(), true)
				.addOption(NumOpcao.NO.getOption(), false)
		);

		questions.add(new Questao("Seu SO atual é Android?")
				.addOption(NumOpcao.YES.getOption(), true)
				.addOption(NumOpcao.NO.getOption(), false)
		);

		questions.add(new Questao("O sol é amarelo?")
				.addOption(NumOpcao.YES.getOption(), false)
				.addOption(NumOpcao.NO.getOption(), true)
		);

		questions.add(new Questao("A maior parte do oxigênio da Terra vem das árvores?")
				.addOption(NumOpcao.YES.getOption(), false)
				.addOption(NumOpcao.NO.getOption(), true)
		);

		questions.add(new Questao("Bebidas alcoolicas matam o cerebro?")
				.addOption(NumOpcao.YES.getOption(), false)
				.addOption(NumOpcao.NO.getOption(), true)
		);
		return questions;
	}
}