package br.com.faculdade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.faculdade.dao.DisciplinaDAO;
import br.com.faculdade.models.Disciplina;
import br.com.faculdade.helpers.DisciplinaHelper;

public class CadastroDisciplina extends AppCompatActivity {

    private DisciplinaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_disciplina);

        Intent intent = getIntent();
        final Disciplina disciplinaParaSerAlterada = (Disciplina) intent.getSerializableExtra("disciplinaSelecionado");

        helper = new DisciplinaHelper(this);

        //Valores do xml
        Button btn_salvar = (Button) findViewById(R.id.btn_salvar);
        Button btn_cancelar = (Button) findViewById(R.id.btn_cancelar);

        if(disciplinaParaSerAlterada != null){
            btn_salvar.setText("Alterar");
            helper.colocaAlunoNoFormulario(disciplinaParaSerAlterada);
        }

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disciplina disciplina = helper.getDisciplinaOnForm();

                DisciplinaDAO dao = new DisciplinaDAO(CadastroDisciplina.this);

                if(disciplinaParaSerAlterada == null){
                    //salva disciplina
                    dao.salvar(disciplina);
                }else{
                    disciplina.setId(disciplinaParaSerAlterada.getId());
                    dao.alterar(disciplina);
                }

                //fecha a conexao do db
                dao.close();

                //volta apos salvar
                finish();
            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
