package com.gabriel.usuario_sql.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.gabriel.usuario_sql.view.Home_ativa;

public class Btn_menu {


    public void irHome(View view, Context contexto){
        Intent intent = new Intent(contexto, Home_ativa.class);
        contexto.startActivity(intent);
    }
}
