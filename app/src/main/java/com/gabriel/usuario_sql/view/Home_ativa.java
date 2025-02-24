package com.gabriel.usuario_sql.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.gabriel.usuario_sql.R;
import com.gabriel.usuario_sql.dao.Estrutura_banco;
import com.gabriel.usuario_sql.viewModel.Menu;
import com.gabriel.usuario_sql.viewModel.Menu_primario;

import java.util.ArrayList;
import java.util.List;


public class Home_ativa extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_tela);

        //Adicionar Menu
        Menu.addMenu(this,R.layout.menu_primario);
        Menu.redirecionar(this, Home_ativa.class, this.findViewById(R.id.btn_home_menu));
        Menu.redirecionar(this, Configuracao_ativa.class, this.findViewById(R.id.btn_config_menu));
        Menu.redirecionar(this, Informacoes_ativa.class, this.findViewById(R.id.btn_infor_menu));


        //Criando tabelas
        Estrutura_banco estrutura = new Estrutura_banco(this);
        estrutura.tabela_conteudo();
        estrutura.preCarregarDados(this);

        //Redirecionar para os tópicos da categoria escolhida
        GridLayout grade_view = findViewById(R.id.grade_cardView);
        clickItemHome(grade_view);


    }


    public void clickItemHome(GridLayout grade) {

        for (int i = 0; i < grade.getChildCount(); i++) {

            CardView card = (CardView) grade.getChildAt(i);

            int numeroCard = i;
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Home_ativa.this, Topicos_ativa.class);
                    intent.putExtra("numero_card", numeroCard);
                    startActivity(intent);

                }
            });


        }


    }

}