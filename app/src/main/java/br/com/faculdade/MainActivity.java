package br.com.faculdade;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.faculdade.adapter.DisciplinaAdapter;
import br.com.faculdade.dao.DisciplinaDAO;
import br.com.faculdade.models.Disciplina;

public class MainActivity extends AppCompatActivity {

    private ListView lstv_disciplina;
    private Disciplina disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstv_disciplina = (ListView) findViewById(R.id.lstv_disciplina);

        registerForContextMenu(lstv_disciplina);

        lstv_disciplina.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Disciplina disciplinaClicada = (Disciplina) adapter.getItemAtPosition(position);

                Intent irParaFormulario = new Intent(MainActivity.this, CadastroDisciplina.class);
                irParaFormulario.putExtra("disciplinaSelecionado", disciplinaClicada);
                startActivity(irParaFormulario);

            }
        });

        lstv_disciplina.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                disciplina = (Disciplina) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                DisciplinaDAO DAO = new DisciplinaDAO(MainActivity.this);
                DAO.deletar(disciplina);
                DAO.close();

                carregaLista();
                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista(){
        DisciplinaDAO dao = new DisciplinaDAO(this);

        List<Disciplina> disciplinas = dao.getLista();
        dao.close();

        int layout = R.layout.listagem_disciplina;

        DisciplinaAdapter adapter = new DisciplinaAdapter(disciplinas, this);

        lstv_disciplina.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();

        switch (itemClicado){
            case R.id.cadastro_disciplina:
                Intent CadastroDisciplina = new Intent(this, CadastroDisciplina.class);
                startActivity(CadastroDisciplina);
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
