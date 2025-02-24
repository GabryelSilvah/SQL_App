package com.gabriel.usuario_sql.viewModel;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gabriel.usuario_sql.R;
import com.gabriel.usuario_sql.view.Home_ativa;


public class Menu_primario extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public void irHome(View view){
        Intent intent = new Intent(getActivity(), Home_ativa.class);
        startActivity(intent);
    }

}