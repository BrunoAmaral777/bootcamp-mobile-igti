package com.example.quizandroid;

public class Questions {

    private int idResposta;

    private boolean respostaCorreta;

    public Questions(int idResposta, boolean respostaCorreta) {
        //Define os valores por meio dos argumentos passado pelo construtor
        this.idResposta = idResposta;
        this.respostaCorreta = respostaCorreta;
    }

    // retorna o ID da questao passada
    public int getIdResposta() {
        return idResposta;
    }

    // define o ID a questao passada
    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
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
