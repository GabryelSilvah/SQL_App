package com.gabriel.usuario_sql.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.usuario_sql.R;
import com.gabriel.usuario_sql.viewModel.Menu;

public class Informacoes_ativa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacoes_tela);


        //Adicionar Menu
        Menu.addMenu(this, R.layout.menu_primario);
        Menu.redirecionar(this, Home_ativa.class, this.findViewById(R.id.btn_home_menu));
        Menu.redirecionar(this, Configuracao_ativa.class, this.findViewById(R.id.btn_config_menu));
        Menu.redirecionar(this, Informacoes_ativa.class, this.findViewById(R.id.btn_infor_menu));

        //Add texto_sobre_app
        String texto = "Esse App foi desenvolvido visando o compartilhamento de conhecimento referente a bancos de dados.\n" +
                "\n" +
                "O App está modularizado em categorias, classificadas do básico ao avançado. Não sendo necessariamente que essas categorias tenham relação a níveis de dificuldade. Na verdade, a ideia é aprender conceitos e comandos SQL de acordo com a necessidade. Os básicos, são conceitos e comandos necessários para desenvolver uma aplicação simples. \n" +
                "\n" +
                "A depender do tipo de sistema que está sendo desenvolvido, comandos e conceitos mais específicos podem ser necessários. Tudo depende da sua regra de negócio a ser implementada. Obviamente, o desejável é ter um conhecimento mais aprofundado visando desenvolver sistemas mais robustos. \n" +
                "\n" +
                "Sobre a categoria recomendados, é usada para indicar conteúdo disponível no YouTube relacionado a algum tema de banco de dados. A recomendação contém o nome do autor, título do vídeo e link que pode ser copiado para busca.\n" +
                "\n" +
                "A tendencia do App é de melhorar a cada atualização. Buscando corrigir bugs, erros ortográficos, estilização do App e adição de novos tópicos.\n" +
                "\n" +
                "No mais, aproveite o App.\n";


        TextView texto_sobre_app = (TextView) findViewById(R.id.texto_sobre_app);
        texto_sobre_app.setText(texto);
    }
}