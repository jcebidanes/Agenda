package com.cebidanes.agenda.converter;

import com.cebidanes.agenda.modelo.Aluno;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

/**
 * Created by jcebidanes on 28/11/2016.
 */

public class AlunoConverter {

    public String converteParaJSON(List<Aluno> alunos) {
        JSONStringer js = new JSONStringer();

        try {
            js.array();
            for (Aluno aluno : alunos) {
                js.object();
                js.key("nome").value(aluno.getNome());
                js.key("nota").value(aluno.getNota());
                js.endObject();
            }
            js.endArray();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return js.toString();
    }
}
