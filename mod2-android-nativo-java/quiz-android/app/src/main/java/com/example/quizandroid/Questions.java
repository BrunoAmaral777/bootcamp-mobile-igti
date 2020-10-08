package com.example.quizandroid;

public class Questions {

    private int idQuestao;

    private boolean respostaCorreta;

    public Questions(int idQuestao, boolean respostaCorreta) {
        //Define os valores por meio dos argumentos passado pelo construtor
        this.idQuestao = idQuestao;
        this.respostaCorreta = respostaCorreta;
    }

    // retorna o ID da questao passada
    public int getIdQuestao() {
        return idQuestao;
    }

    // define o ID a questao passada
    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    // retorna a resposta correta da questao
    public boolean isRespostaCorreta() {
        return respostaCorreta;
    }

    // define a resposta correta da questao
    public void setRespostaCorreta(boolean respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
}
