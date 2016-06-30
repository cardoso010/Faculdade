package br.com.faculdade.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.faculdade.R;
import br.com.faculdade.models.Disciplina;

/**
 * Created by cardoso on 10/05/16.
 */
public class DisciplinaAdapter extends BaseAdapter{

    private List<Disciplina> disciplinas;
    private Activity activity;

    public DisciplinaAdapter(List<Disciplina> disciplinas, Activity activity) {
        this.disciplinas = disciplinas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return disciplinas.size();
    }

    @Override
    public Object getItem(int position) {
        return disciplinas.get(position);
    }

    @Override
    public long getItemId(int position) {
        Disciplina disciplina = disciplinas.get(position);
        return disciplina.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Disciplina disciplina = disciplinas.get(position);

        LayoutInflater inflater = activity.getLayoutInflater();

        View linha = inflater.inflate(R.layout.listagem_disciplina, null);

        TextView txtNome = (TextView) linha.findViewById(R.id.txtNome);
        txtNome.setText(disciplina.getNome());
        TextView txtMedia = (TextView) linha.findViewById(R.id.txtMedia);
        txtMedia.setText(disciplina.media());
        if(Float.parseFloat(disciplina.media()) < 6.0){
            txtMedia.setTextColor(Color.RED);
        }else{
            txtMedia.setTextColor(Color.GREEN);
        }

        return linha;
    }
}
