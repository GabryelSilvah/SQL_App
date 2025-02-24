package com.gabriel.usuario_sql.viewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabriel.usuario_sql.R;
import com.gabriel.usuario_sql.model.Conteudo;

import java.util.List;


public class Adapter_home extends RecyclerView.Adapter<Holder_home> {

    public Adapter_home(Context contexto, List<Conteudo> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }


    List<Conteudo> lista;
    Context contexto;

    @NonNull
    @Override
    public Holder_home onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(contexto)
                .inflate(R.layout.cardview_home, parent, false);

        return new Holder_home(view, contexto);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_home holder, int position) {
        holder.texto.setText(lista.get(position).getTitulo());
        holder.conteudo = lista;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
