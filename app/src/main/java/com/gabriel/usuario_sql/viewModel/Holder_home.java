package com.gabriel.usuario_sql.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabriel.usuario_sql.model.Conteudo;
import com.gabriel.usuario_sql.view.Artigo_ativa;
import com.gabriel.usuario_sql.R;

import java.util.List;

public class Holder_home extends RecyclerView.ViewHolder implements View.OnClickListener {

    Context contexto;
    ImageView imagem;
    TextView texto;
    List<Conteudo> conteudo;

    public Holder_home(@NonNull View itemLista, Context contexto) {
        super(itemLista);

        this.contexto = contexto;
        this.imagem = itemLista.findViewById(R.id.imagem_topico);
        this.texto = itemLista.findViewById(R.id.texto_topico);

        itemLista.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(contexto, Artigo_ativa.class);
        intent.putExtra("id_conteudo", conteudo.get(getAdapterPosition()).getId());
        contexto.startActivity(intent);
    }
}
