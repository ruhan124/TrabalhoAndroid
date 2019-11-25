package com.ruhan.swapp;

/**
 * Classe de opção da pergunta
 */
public class Opcao {

    private String text;
    private boolean  isCorrect = false;

    /**
     * Função para obter o texto da opção
     * @return
     */
    public String getText() {
        return text;
    }

    public Opcao(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }
}
