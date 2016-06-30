package br.com.faculdade.helpers;

import android.widget.EditText;

import br.com.faculdade.CadastroDisciplina;
import br.com.faculdade.R;
import br.com.faculdade.bo.UtilBO;
import br.com.faculdade.models.Disciplina;

/**
 * Created by cardoso on 26/04/16.
 */
public class DisciplinaHelper {
    private EditText edt_nome;
    private EditText edt_periodo;
    private EditText edt_primeiraprova;
    private EditText edt_segundaprova;
    private EditText edt_primeirotrabalho;
    private EditText edt_segundotrabalho;

    public DisciplinaHelper(CadastroDisciplina cadastroDisciplina) {
        edt_nome = (EditText) cadastroDisciplina.findViewById(R.id.edt_disciplina);
        edt_periodo = (EditText) cadastroDisciplina.findViewById(R.id.edt_periodo);
        edt_primeiraprova = (EditText) cadastroDisciplina.findViewById(R.id.edt_primeira_prova);
        edt_segundaprova = (EditText) cadastroDisciplina.findViewById(R.id.edt_segunda_prova);
        edt_primeirotrabalho = (EditText) cadastroDisciplina.findViewById(R.id.edt_primeiro_trabalho);
        edt_segundotrabalho = (EditText) cadastroDisciplina.findViewById(R.id.edt_segundo_trabalho);
    }

    //Pega a Disciplina do formulario
    public Disciplina getDisciplinaOnForm(){
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(edt_nome.getText().toString());
        disciplina.setPeriodo(Integer.valueOf(UtilBO.ReturnZero(edt_periodo.getText().toString())));
        disciplina.setPrimeiraProva(Float.valueOf(UtilBO.ReturnZero(edt_primeiraprova.getText().toString())));
        disciplina.setSegundaProva(Float.valueOf(UtilBO.ReturnZero(edt_segundaprova.getText().toString())));
        disciplina.setPrimeiroTrabalho(Float.valueOf(UtilBO.ReturnZero(edt_primeirotrabalho.getText().toString())));
        disciplina.setSegundoTrabalho(Float.valueOf(UtilBO.ReturnZero(edt_segundotrabalho.getText().toString())));
        return disciplina;
    }

    public void colocaAlunoNoFormulario(Disciplina disciplinaParaSerAlterada) {
        edt_nome.setText(disciplinaParaSerAlterada.getNome());
        edt_periodo.setText(Integer.toString(disciplinaParaSerAlterada.getPeriodo()));
        edt_primeiraprova.setText(Float.toString(disciplinaParaSerAlterada.getPrimeiraProva()));
        edt_segundaprova.setText(Float.toString(disciplinaParaSerAlterada.getSegundaProva()));
        edt_primeirotrabalho.setText(Float.toString(disciplinaParaSerAlterada.getPrimeiroTrabalho()));
        edt_segundotrabalho.setText(Float.toString(disciplinaParaSerAlterada.getSegundoTrabalho()));

    }
}
