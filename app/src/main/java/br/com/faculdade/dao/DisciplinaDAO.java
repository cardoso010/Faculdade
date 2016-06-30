package br.com.faculdade.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.faculdade.models.Disciplina;

/**
 * Created by cardoso on 26/04/16.
 */
public class DisciplinaDAO extends SQLiteOpenHelper{

    private static final String DATABASE = "Faculdade";
    private static final int VERSAO = 1;

    public DisciplinaDAO(Context context) {
        super(context, DATABASE, null, VERSAO);

    }

    public void salvar(Disciplina disciplina) {
        ContentValues values = new ContentValues();
        values.put("nome", disciplina.getNome());
        values.put("periodo", disciplina.getPeriodo());
        values.put("primeira_prova", disciplina.getPrimeiraProva());
        values.put("segunda_prova", disciplina.getSegundaProva());
        values.put("primeiro_trabalho", disciplina.getPrimeiroTrabalho());
        values.put("segundo_trabalho", disciplina.getSegundoTrabalho());

        getWritableDatabase().insert("Disciplinas", null, values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE Disciplinas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT UNIQUE NOT NULL," +
                "periodo INTEGER NOT NULL," +
                "primeira_prova REAL," +
                "segunda_prova REAL," +
                "primeiro_trabalho REAL," +
                "segundo_trabalho REAL);";

        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String ddl = "DROP TABLE IF EXISTS Disciplinas";
        db.execSQL(ddl);
        this.onCreate(db);
    }

    public List<Disciplina> getLista() {
        String[] colunas =  {"id", "nome", "periodo", "primeira_prova", "segunda_prova", "primeiro_trabalho", "segundo_trabalho"};
        Cursor cursor = getWritableDatabase().query("Disciplinas", colunas, null, null, null, null, null);

        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

        while (cursor.moveToNext()) {
            Disciplina disciplina = new Disciplina();

            disciplina.setId(cursor.getInt(0));
            disciplina.setNome(cursor.getString(1));
            disciplina.setPeriodo(cursor.getInt(2));
            disciplina.setPrimeiraProva(cursor.getFloat(3));
            disciplina.setSegundaProva(cursor.getFloat(4));
            disciplina.setPrimeiroTrabalho(cursor.getFloat(5));
            disciplina.setSegundoTrabalho(cursor.getFloat(6));

            disciplinas.add(disciplina);
        }

        return disciplinas;
    }

    public void deletar(Disciplina disciplina) {
        String[] args = {Integer.toString(disciplina.getId())};
        getWritableDatabase().delete("Disciplinas", "id=?", args);
    }

    public void alterar(Disciplina disciplina) {
        ContentValues values = new ContentValues();

        values.put("nome", disciplina.getNome());
        values.put("periodo", disciplina.getPeriodo());
        values.put("primeira_prova", disciplina.getPrimeiraProva());
        values.put("segunda_prova", disciplina.getSegundaProva());
        values.put("primeiro_trabalho", disciplina.getPrimeiroTrabalho());
        values.put("segundo_trabalho", disciplina.getSegundoTrabalho());

        String[] args  = { String.valueOf(disciplina.getId()) };
        getWritableDatabase().update("Disciplinas", values, "id=?", args);
    }
}
