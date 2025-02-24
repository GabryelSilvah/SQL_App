package com.gabriel.usuario_sql.viewModel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.usuario_sql.R;

public class Menu {

    private Menu() {
    }

    public static String LEFT = "left";
    public static String RIGHT = "right";
    public static String CENTER = "center";
    public static String BOTTOM = "bottom";

    public static void addMenu(AppCompatActivity atividade, int viewMenu) {
        //Inflar menu
        LinearLayout container = (LinearLayout) atividade.findViewById(R.id.container_menu);
        LayoutInflater inflater = LayoutInflater.from(atividade);
        inflater.inflate(viewMenu, container, true);
    }


    public static void redirecionar(AppCompatActivity atividade, Class destino, View item) {

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (atividade.getClass().equals(destino)) {
                    Toast.makeText(atividade, "Você já está nessa aba", Toast.LENGTH_LONG).show();
                } else {

                    Intent intent = new Intent(atividade, destino);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    atividade.startActivity(intent);

                }
            }
        });
    }


}
