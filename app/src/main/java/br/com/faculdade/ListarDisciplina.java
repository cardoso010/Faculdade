package br.com.faculdade;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.faculdade.dao.DisciplinaDAO;
import br.com.faculdade.models.Disciplina;

public class ListarDisciplina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_disciplina);

        ListView lstv_disciplina = (ListView) findViewById(R.id.lstv_disciplina);

        DisciplinaDAO dao = new DisciplinaDAO(this);

        List<Disciplina> disciplinas = dao.getLista();
        dao.close();

        final ArrayAdapter<Disciplina> adapter = new ArrayAdapter<Disciplina>(this, android.R.layout.simple_list_item_1, disciplinas);

        lstv_disciplina.setAdapter(adapter);

        lstv_disciplina.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Toast.makeText(ListarDisciplina.this, "Click na posicao " + position, Toast.LENGTH_SHORT).show();
            }
        });

        lstv_disciplina.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adpater, View view, int position, long id) {
                Toast.makeText(ListarDisciplina.this, "Click longo " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}
