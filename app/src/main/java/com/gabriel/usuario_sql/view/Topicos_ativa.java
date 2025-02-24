package com.gabriel.usuario_sql.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.gabriel.usuario_sql.R;
import com.gabriel.usuario_sql.dao.DAO_conteudo;
import com.gabriel.usuario_sql.dao.Estrutura_banco;
import com.gabriel.usuario_sql.model.Conteudo;
import com.gabriel.usuario_sql.viewModel.Adapter_home;
import com.gabriel.usuario_sql.viewModel.Menu;

import java.util.List;

public class Topicos_ativa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topicos_tela);

        //Adicionar Menu
        Menu.addMenu(this,R.layout.menu_primario);
        Menu.redirecionar(this, Home_ativa.class, this.findViewById(R.id.btn_home_menu));
        Menu.redirecionar(this, Configuracao_ativa.class, this.findViewById(R.id.btn_config_menu));
        Menu.redirecionar(this, Informacoes_ativa.class, this.findViewById(R.id.btn_infor_menu));

        //Resgatando dados enviados pela intent
        Intent intent = getIntent();
        int numeroCategoria = intent.getIntExtra("numero_card", 0);


        //Buscamdo dados
        DAO_conteudo dao = new DAO_conteudo(this);
        List<Conteudo> dados = dao.listar_all_titulos(numeroCategoria);
        dao.desconectar();


        //Configurando e exibindo lista na recyclerView
        RecyclerView recycler = findViewById(R.id.recycler_home);
        Adapter_home adapter = new Adapter_home(this, dados);
        recycler.setAdapter(adapter);

    }
}