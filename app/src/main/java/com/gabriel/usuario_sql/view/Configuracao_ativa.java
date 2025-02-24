package com.gabriel.usuario_sql.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.gabriel.usuario_sql.R;
import com.gabriel.usuario_sql.viewModel.Menu;

public class Configuracao_ativa extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracao_tela);


        //Adicionar Menu
        Menu.addMenu(this,R.layout.menu_primario);
        Menu.redirecionar(this, Home_ativa.class, this.findViewById(R.id.btn_home_menu));
        Menu.redirecionar(this, Configuracao_ativa.class, this.findViewById(R.id.btn_config_menu));

    }

}