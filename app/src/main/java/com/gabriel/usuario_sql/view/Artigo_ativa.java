package com.gabriel.usuario_sql.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.usuario_sql.R;
import com.gabriel.usuario_sql.dao.DAO_conteudo;
import com.gabriel.usuario_sql.model.Conteudo;
import com.gabriel.usuario_sql.viewModel.Menu;
import com.gabriel.usuario_sql.viewModel.Menu_primario;

import java.util.ArrayList;
import java.util.List;

public class Artigo_ativa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artigo_tela);

        //Adicionar Menu
        Menu.addMenu(this,R.layout.menu_primario);
        Menu.redirecionar(this, Home_ativa.class, this.findViewById(R.id.btn_home_menu));
        Menu.redirecionar(this, Configuracao_ativa.class, this.findViewById(R.id.btn_config_menu));


        //Resgatando id do item cliclado
        Intent intent = getIntent();
        int id = intent.getIntExtra("id_conteudo", 0);

        //Buscando dados
        DAO_conteudo dao = new DAO_conteudo(this);
        Conteudo conteudo = dao.listar_by_id(id);
        dao.desconectar();


        //Exibindo titulo
        TextView titulo_conteudo = findViewById(R.id.titulo_conteudo);
        titulo_conteudo.setText(conteudo.getTitulo());

        //Exibindo artigo
        TextView texto_artigo = findViewById(R.id.texto_artigo);


        //Área de teste



        TableLayout tabela = new TableLayout(this);
        TableRow linha = new TableRow(this);

        TextView texto = new TextView(this);
        texto.setText("Testando");
        linha.addView(texto);

        tabela.addView(linha);


        ImageSpan imagem = new ImageSpan(this, R.drawable.banco_dados);


        Spannable spannable = new SpannableString(conteudo.getArtigo());
        spannable.setSpan(tabela, 0, 10, 0);
        texto_artigo.setText(spannable);


    }


}