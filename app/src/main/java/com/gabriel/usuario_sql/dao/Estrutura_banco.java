package com.gabriel.usuario_sql.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.widget.TableLayout;

import com.gabriel.usuario_sql.model.Conteudo;

public class Estrutura_banco {

    //Declaração de variáveis
    private SQLiteDatabase conexao;

    //Construtor da classe
    public Estrutura_banco(Context contexto) {
        Conexao_db banco = new Conexao_db();
        banco.conectar(contexto);
        this.conexao = banco.instancia;
    }


    public void tabela_conteudo() {

        String sql = "CREATE TABLE IF NOT EXISTS conteudo(" +
                "id_cont INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "titulo CHAR(50) NOT NULL," +
                "artigo TEXT," +
                "categoria INTEGER);";

        this.conexao.execSQL(sql);
    }


    public void tabela_estilizacao() {

        String sql = "CREATE TABLE IF NOT EXISTS estilizacao( " +
                "id_estil INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "propriedade CHAR (30) NOT NULL," +
                "start INTEGER NOT NULL," +
                "end INTEGER NOT NULL);";

        this.conexao.execSQL(sql);

    }

    public void preCarregarDados(Context contexto) {


        String sqlSelect = "SELECT * FROM conteudo WHERE titulo = 'Introdução'";
        Cursor cursor = this.conexao.rawQuery(sqlSelect, null);


        if (cursor.getCount() == 0) {

            String conteudo_introducao = "Banco de dados é qualquer meio que permite guardar dados. Desde de uma simples agenda até um sistema digital, ou seja, pode ser físico ou digital. \n" +
                    "\n" +
                    "No decorrer da história diversas maneiras de armazenar dados foram criadas e utilizadas por décadas. Um exemplo bem comum são as pastas de documentos guardadas em instantes da maioria das escolas. Essas pastas, de forma organizada, guardam diferentes informações importantes de vários alunos. Todavia, mesmo essa forma de guardar dados sendo eficaz não é muito eficiente. \n" +
                    "\n" +
                    "É trabalhoso armazenar dados em papel, dificultando a procura, ficando mais suscetível a perdas e danos. Essa é apenas uma das variadas formas que existem de armazenar dados, e a maioria delas possuem em comum os mesmos problemas citados antes.\n" +
                    "\n" +
                    "Após diversas tentativas de criar uma forma que seja eficiente e que também atinja os mesmos resultados benéficos ou melhores, foi criado os bancos de dados relacionais. \n" +
                    "\n" +
                    "Bancos de dados relacional é um uma forma de guardar os dados digitalmente, organizados no formato de linhas e colunas. As linhas são chamadas de registros. Cada registro, ou seja, uma linha, pode representa uma pessoa, animal ou objeto diferente. Já as colunas representam as caracteriza que cada linha possui.\n" +
                    "\n" +
                    "Exemplo:\n" +
                    "\n" +
                    "Imagine que você necessite salvar as informações de um aluno em um banco de dados relacional. Você decide que serão necessários guardam apenas 3 informações, nome do aluno, nome da mãe e turma. \n" +
                    "\n" +
                    "Cada uma dessas informações citadas será uma coluna diferente. Cada aluno adicionado será um novo registro, ou seja, uma nova linha. Todos os alunos adicionados terão os mesmo três atributos das colunas, porém cada um terá uma informação diferente para cada um desses atributos.\n" +
                    "\n" +
                    "\n" +
                    "Todos têm nome, mas não é o mesmo nome. Todos têm uma mãe com um nome, mas se não forem irmãos o nome da mãe será diferente. Todos têm uma turma, mas não significa que seja a mesma turma. Então, todos têm os mesmos atributos, mas podem ser informações/registros, diferentes para cada um desses atributos/colunas.\n" +
                    "\n" +
                    "Esse tipo de banco de dados é denominado relacional porque os dados podem ser armazenados em várias tabelas diferentes, mas que os dados possuem algum relacionamento/vínculo entre se. Separar esses dados em várias tabelas é uma estratégia de organização que ajuda a diminuir duplicidade, obtém ganho de desempenho, cria integridade dos dados, entre outros benefícios que também poderiam ser citados.\n" +
                    "\n" +
                    "Um banco de dados é criado e manipulado através de uma linguagem chamada SQL. Ela é formada por comandos, ou melhor dizendo, palavras especificadas que foram reservadas nessa linguagem. \n" +
                    "Para usar esses comandos SQL é necessário um programa chamado SGBD (sistema gerenciador de banco de dados). Os SQBDs disponibilizam uma área para digitar os comandos, além disso ele permite uma visualização de todos os bancos criados, também permite que você consiga criar modelos visuais/gráficos das tabelas. Esses modelos funcionam como um rascunho antes que de fato os comandos sejam digitados e executados para criação e inserção de dados.\n" +
                    "\n" +
                    "Os comandos SQL foram divididos em categorias:\n" +
                    "\n" +
                    "\n" +
                    "DDL = São comandos usados para criar e configurar o banco de dados.\n" +
                    "\n" +
                    "DQL = São comandos usados para buscar/consultar dados.\n" +
                    "\n" +
                    "DML = São comandos usados para manipular, inserindo, alterando ou deletando dados.\n" +
                    "\n" +
                    "DCL = São comandos usados para dar permissão de acesso para usuários, ou então, revoga-los/retirar a permissão.\n" +
                    "\n" +
                    "TCL = Usados para o controle de transações, ou seja, controlar a execução de comandos na base de dados. Isso permite que se algum comando falhar você consiga voltar ao estado antes da falha.\n" +
                    "\n";

            String conteudo_banco_ser = "Esse é um assunto relativamente simples para quem já tem conhecimento na área de T.I. Entretanto, é necessário explicar e exemplificar esse conceito para que o próximo tópico, denominado banco de dados embarcados, possa ser compreendido.\n" +
                    "\n" +
                    "\n" +
                    "Banco de dados em servidores é um sistema hospedado, ou seja, armazenado na internet e que ficam online para ter seus dados acessados por usuários através de sites ou aplicativos.\n" +
                    "\n" +
                    "Detalhando, a maioria dos sites e aplicativo que utilizam internet possuem um banco de dados instalado em um servidor. Esse banco de dados armazena informações necessárias para atingir o objetivo do aplicativo ou site.\n" +
                    "\n" +
                    "Tomando como exemplo, uma rede social armazena no básico do básico, nome do usuário, senha, email e foto de perfil. Uma rede social é um sistema que necessariamente precisa de internet para se conectar com outros usuários e disponibilizar informações sobre as pessoas ali conectadas. Para que o aplicativo ou site consiga exibir essas informações para outros usuários da rede, faz-se necessário que esse banco de dados esteja em um local que esteja sempre disponível para ser acessado pelo sistema. \n" +
                    "\n" +
                    "Esse local é os servidores. Os servidores nada mais são que computadores em alguma empresa que tem como proposito armazenar sistemas/aplicativos que possam ser disponibilizados via internet todo vez que o usuário precisar.\n" +
                    "\n" +
                    "Os bancos de dados em servidores têm como característica o acesso por múltiplos usuários. Isso significa que eles permitem, através de algum aplicativo/site, que mais de uma pessoa acesse ao mesmo tempo esse banco de dados. Esse acesso pode ser para buscar dados, criar novos dados, alterar os já existentes ou excluir.\n" +
                    "\n" +
                    "Os bancos de dados para servidores/online mais utilizados são:\n" +
                    "\n" +
                    "Bancos Relacional\n" +
                    "\n" +
                    "1.\tMySQl\n" +
                    "2.\tPostGreSQL\n" +
                    "3.\tSQL server\n" +
                    "4.\tOracle\n" +
                    "5.\tMariaDB\n" +
                    "6.\tDB2\n" +
                    "\n" +
                    "Bancos NoSql\n" +
                    "\n" +
                    "1.\tCassandra\n" +
                    "2.\tMongoDb\n" +
                    "3.\tRedis\n" +
                    "\n";

            String conteudo_embarcados = "Os bancos de dados embarcados, são bancos que armazena dados localmente em um dispositivo. Esse dispositivo pode ser um celular, relógio inteligente, tranca de segurança, drones, robôs, entre outros dispositivos.\n" +
                    "\n" +
                    "Esse tipo de banco de dados é recomendado para armazenar dados que não serão utilizados por mais de um usuário. Ou seja, o usuário que vai utilizar é o único a ter acesso aos dados armazenados nesse tipo de banco. Sendo assim, o acesso à internet não será necessário, visto que que todos os dados já estarão embutidos no banco de dados do dispositivo.\n" +
                    "\n" +
                    "Esse tipo de banco de dados não utiliza de conexão com a internet (TC/IP), até mesmo porque ele não possui esse recurso. Não tem suporte a múltiplos usuários, permitindo apenas uma conexão por vez. É uma ótima opção para dispositivos com pouca memória pelo fato de ser extremamente leve e rápido.\n" +
                    "\n" +
                    "No desenvolvimento de aplicativos para smartphones(celulares), o SQLite é o mais utilizado. Ele é um banco de dados embarcado, leve e rápido para armazenamento de dados locais. Além do SQLite, existem outras opções, como por exemplo:\n" +
                    "\n" +
                    "\n" +
                    "1.\tH2 \n" +
                    "2.\tHSQLDB (hypersql) \n" +
                    "3.\tFirebird\n" +
                    "4.\tInterbase\n" +
                    "\n";


            String conteudo_create = "Antes de começar a digitar comandos SQL para manipular um banco de dados, será necessário a instalação de um SGBD específico para o banco de dados que você estará utilizando. Como o MySql é o banco de dados mais comum de ser utilizado por quem tá começado, o SQGB necessário para ele será o WORKBENCH.\n" +
                    "\n" +
                    "\n" +
                    "Link de instalação:\n" +
                    "NO YouTube, pesquise por (Como instalar o MySQL e o WorkBench - Windows) do canal “FVA Educação”.\n" +
                    "\n" +
                    "\n" +
                    "Para criar um banco é usado o comando \"CREATE DATABASE\", escrevendo após o comando o nome que você deseja para seu banco de dados.\n" +
                    "\n" +
                    "Exemplo:\n" +
                    "\n" +
                    "\n" +
                    "CREATE DATABASE lojas_americanas;\n" +
                    "\n" +
                    "\n" +
                    "Com esse simples comando digitado em um gerenciador de banco de dados (SGBD) e colocado para ser executado, temos a base de dados criada. \n" +
                    "\n" +
                    "Outro comando é importante de ser usado após criar o banco, “USE”. O comando “USE” seguido do nome do banco vai indicar que você deseja usar aquele banco para executar os próximos comandos. Isso é necessário porque em um SGBD pode ter várias bases de dados criada por você.\n" +
                    "\n" +
                    "Exemplo:\n" +
                    "\n" +
                    "USE lojas_americanas;\n" +
                    "\n" +
                    "Essa forma de criar o banco de dados é a mais simples e funciona perfeitamente para quem tá começando. Entretanto, com o tempo você perceberá a necessidade de configurar algumas coisas na hora da criação da base de dados, mas que não deve ser uma preocupação na sua cabeça nesse momento. Faça o simples, aprenda o simples e evolua um passo de cada vez.\n" +
                    "\n" +
                    "Quando você já estiver confortável com a linguagem SQL experimente começar a colocar essas configurações que vou citar agora. \n" +
                    "\n" +
                    "CREATE DATABASE lojas_americanas\n" +
                    "CHARACTER SET utf8mb4;\n" +
                    "\n" +
                    "Como bem sabemos, existem vários idiomas espalhados pelo mundo. Todo idioma tem seu alfabeto, podendo ele ter letras diferentes do nosso idioma, o português. O alfabeto japonês, chines, árabe são exemplos de idiomas que utilizam letra bem diferentes. É devido a essa diferença que temos que especificar para o banco de dados com qual “alfabeto” estamos trabalhando.\n" +
                    "\n" +
                    "O comando CHARACTER SET permite que você diga os caracteres de qual idioma você deseja usar, ou seja, letras e símbolos que sua base de dados utilizará. Já o utf8mb4 é o próprio conjunto de caracteres/letras que estaremos utilizando nesse banco de dados.\n" +
                    "\n" +
                    "\n";

            String conteudo_create_table = "Antes de seguir, certifique-se de que você está utilizando o banco de dados. Isso pode ser feito usando o comando “USE” seguido do nome do banco que será utilizado. Outra ressalva, após executar um comando exclua a linha do mesmo. Pois, ao criar um novo comando e colocar para ser executado ele executar todos os comandos escritos, inclusive o antigo que já foi executado. Se você estiver utilizando o WORKBENCH ele te dar a opção de executar todos os comandos escritos ou apenas a linha onde o ponteiro do mouse estar. Para executar todos utilize o primeiro raio, utilize o segundo raio para executar apenas um comando ⚡⚡.\n" +
                    "\n" +
                    "Para criar uma tabela utiliza-se o comando “CREATE TABLE”, após o comando digite o nome da tabela. Após o nome adicione um sinal de parêntese e coloque um ponto-vírgula no final.\n" +
                    "\n" +
                    "\n" +
                    "EXEMPLO 1:\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE clientes_americanas  ();\n" +
                    "\n" +
                    "\n" +
                    "Esse exemplo citado não é o comando completo, se você executar ele ocorrerá um erro. Isso porque é necessário adicionar as colunas da tabela. Essas colunas são adicionadas dentro do sinal de parêntese.\n" +
                    "\n" +
                    "\n" +
                    "Por questão de organização, antes de criar as colunas, aperte a tecla ENTER duas vezes dentro do sinal de parêntese. Agora, dentro do parêntese digite o nome da coluna e coloque o tipo de dados (texto, numérico, data, ...). Se for adicionar mais de uma coluna, faça a separação com uma vírgula.\n" +
                    "\n" +
                    "Exemplo 2:\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE clientes_americanas  (\n" +
                    "nome char(40),\n" +
                    "cpf int,\n" +
                    "data_nasc data\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "Esse exemplo é bem simplista, e a ideia é essa mesma. Não há motivo para ensinar boas maneiras de criar uma tabela ou criar a tabela mais robusta possível. Esse é o primeiro passo para quem tá começando, e tudo que importa nessa etapa é ver tudo acontecendo.\n" +
                    "\n" +
                    "\n" +
                    "Esse método mostrado criará a tabela, porém quando você já estiver confortável com esse comando SQL, experimente aperfeiçoar a criação das suas novas tabelas com os métodos que serão demostrados.\n" +
                    "\n" +
                    "Exemplo 3:\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE clientes_americanas  (\n" +
                    "id int primary key auto_increment not null,\n" +
                    "nome char(40) not null,\n" +
                    "cpf int,\n" +
                    "data_nasc data not null\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "Talvez você possa se assustar com as novas informações adicionadas. Mas, não tenha essa preocupação na mente. Como eu bem disse, se você utilizar o exemplo 1 já vai funcionar.\n" +
                    "\n" +
                    "\n" +
                    "Então por que utilizar esse exemplo 2?\n" +
                    "\n" +
                    "\n" +
                    "Porque queremos garantir que nosso banco de dados funcione da melhor maneira possível. Quando o comando “not null” é utilizado na criação das colunas da tabela, ele significa que aquele campo não pode receber um valor nulo. Ou seja, você não pode deixar aquele espaço vazio, terá obrigatoriamente que preencher o campo.\n" +
                    "\n" +
                    "\n" +
                    "Quando a coluna id for acrescentada significa que você está criando um identificador para cada registro/linha da tabela. É similar ao número do documento rg que temos. Cada registro/linha tem o seu identificador, isso possibilitará a busca de um registro/linha especifica apenas informando o id dele. O nome técnico para isso é chave primaria (Primary key) e será explicado nos próximos tópicos.\n" +
                    "\n";


            String conteudo_insert = "Para inserir dados em uma tabela utiliza-se o comando “INSERT INTO” seguido do nome da tabela onde os dados serão inseridos. Na sequência, utiliza-se também o comando “VALUES” seguido do sinal de parêntese com ponto-vírgula no final.\n" +
                    "\n" +
                    "Exemplo 1:\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO clientes_americanas VALUES ();\n" +
                    "\n" +
                    "\n" +
                    "Esse comando não está completo, ocorrerá um erro caso tente executar.\n" +
                    "\n" +
                    "Para completar o comando é necessário informar os dados/valores que serão armazenados na tabela. Isso é feito dentro do sinal de parêntese. Se o valor que você deseja armazenar for do tipo texto então deverá ser inserido entre aspas “”, se for do tipo numérico não são necessárias as aspas. \n" +
                    "\n" +
                    "Atenção, os dados devem ser inseridos na mesma ordem das colunas criadas com o comando “CREATE TABLE”.\n" +
                    "\n" +
                    "Exemplo 2:\n" +
                    "\n" +
                    "INSERT INTO lojas_americanas \n" +
                    "VALUES (1, ”Gabriel”, 05839469395, ”2025-01-31”);\n" +
                    "\n" +
                    "\n" +
                    "Como pode ser observado, comecei adicionando o valor para a coluna id, depois para nome, cpf e por último a data. Seguindo a ordem em que as colunas foram criadas e separando cada valor com um virgula. \n" +
                    "\n" +
                    "Talvez você se pergunte por qual motivo a data está entre aspas se é do tipo numérico. Nesse contexto, data não é do tipo numérico porque se for observado bem os períodos de números da data são separados um traço, ou seja, um caractere que não é considerado um número e por tanto é armazenado entre aspas. \n" +
                    "\n" +
                    "Note também que a data começa pelo ano, depois mês e por último dia. Está nesse formato porque o banco de dados é projetado para o sistema de datas americano.\n" +
                    "\n" +
                    "Há outra forma de adicionar os dados. Nessa outra forma dizemos os nomes das colunas em que queremos adicionar os dados. Isso é uma boa opção quando queremos adicionar dados apenas em algumas colunas específicas. \n" +
                    "\n" +
                    "Exemplo 3:\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO lojas_americanas \n" +
                    "(id, nome, data_nasc)\n" +
                    "VALUES (1,”Gabriel”,”2025-01-31”);\n" +
                    "\n" +
                    "Nesse exemplo não adicionamos valor para a coluna cpf, já que as colunas que especificamos foram id, nome e data_nasc.\n" +
                    "\n" +
                    "Mas, caso não informe alguma coluna e essa coluna que você não informou tiver sido criada como “not null”, então o insert into irá falhar porque foi dito que o campo dessa coluna não pode ficar em branco.\n" +
                    "\n" +
                    "Nesse exemplo 3 cpf não foi informada, e nesse caso realmente podemos deixa ela sem ser informada porque na sua criação não foi dito que ela era “not null”.\n" +
                    "\n" +
                    "Concluindo, o comando “INSERT INTO” é usado para adicionar novos registros/linhas na tabela. Tendo assim o que chamamos de popular com dados as tabelas.\n";


            String conteudo_tipos = "Antes de criar as tabelas é necessário conhecer os tipos de dados, pois ao criamos as colunas da tabela precisamos informar o tipo do dado que será guardado. \n" +
                    "\n" +
                    "Vou cita os mais usados, mas saiba que a lista é grande e que não é necessário que você precisa saber todos. Você saber todos vai ajudar a controlar a quantidade de memória usada para armazenar as informações com maior precisão, mas o fato de não saber todos os tipos não impede de seu banco funcionar.\n" +
                    "\n" +
                    "Exemplo 1:\n" +
                    "\n" +
                    "\n" +
                    "Numérico: \n" +
                    "•\tINT ou INTEGER: Usado para dizer que é um número e que esse número não tem casa decimal, ou seja, não possui número após a virgula.\n" +
                    "\n" +
                    "\n" +
                    "•\tDOUBLE: Usado para dizer que é um número e que possui casas após a virgula.\n" +
                    "\n" +
                    "\n" +
                    "•\tFLOAT: Tem a mesma funcionalidade do DOUBLE, dize que é um número e que tem número após virgula. Entretanto, o FLOAT tem um limite menor de números que ele pode guardar na memória.\n" +
                    "\n" +
                    "\n" +
                    "TEXTO:\n" +
                    "•\tCHAR: Usado para definir que o dado armazenado será do tipo texto e necessitando que você diga quantos caractere/letras no máximo pode ter. Ele separa um tamanho fixo na memória. O espaço separado sempre vai estar lá, independentemente de você usar ou não todo esse espaço separado.\n" +
                    "\n" +
                    "•\t\n" +
                    "VARCHAR: Faz a mesma coisa que o “CHAR”, com a diferença que o “VARCHAR” é um tamanho dinâmico. Isso significa que se você separou um espaço para armazenar no máximo 100 caracteres/letras, mas só usou 60 ele vai eliminar os outros espaços não usados.\n" +
                    "\n" +
                    "\n" +
                    "DATA:\n" +
                    "•\tDATE: Guarda a data no formato americano, ano, mês e dia.\n" +
                    "•\tTIME: Guarda horas, minuto e segundos.\n" +
                    "•\tDATETIME: Guarda a data mais horas, minutos e segundos.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Esses são exemplos dos tipos mais usados, porém faça sua pesquisa por fora e descobrirá que existe vários outros tipos. O uso de cada tipo depende sempre do tipo de dado a ser guardado, da sua necessidade e disponibilidade de memória.\n" +
                    "\n";

            String conteudo_primary = "CHAVE PRIMARIA (PRIMARY KEY)\n" +
                    "\n" +
                    "Chave primaria (PRIMARY KEY) é a forma que utilizamos para identificar um registro/linha na tabela. Isso é feito através de uma coluna criada e que por padrão damos o nome de ID, mas poderia ser qualquer outro nome.\n" +
                    "\n" +
                    "Exemplo 1:\n" +
                    "\n" +
                    "CREATE TABLE clientes_americanas (\n" +
                    "id int primary key auto_increment,\n" +
                    "nome char(40),\n" +
                    "cidade char(5)\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "O objetivo de ter um identificador (ID) para cada linha/registro é para atender uma necessidade que é sempre recorrente.\n" +
                    "\n" +
                    "Imagine que você quer listar os nomes dos clientes em uma tabela, então você utiliza o comando “SELECT” e uma lista com nomes será exibida.\n" +
                    "\n" +
                    "No entanto, o que acontece se você quiser exibi apenas um nome especifico nessa tabela? \n" +
                    "\n" +
                    "Você poderia utilizar o comado “WHERE nome = ‘Gabriel’” junto com o “SELECT” passado o nome que você deseja listar. Porém, se existir mais de um cliente com o mesmo nome então será exibido todos os registros/linhas que possuem o mesmo nome.\n" +
                    "\n" +
                    "Para resolver isso é que utilizamos a chave primaria. A chave primaria é uma coluna que geralmente utiliza números como identificador. Para ser um identificador o valor precisa ser único.\n" +
                    "\n" +
                    "Então se um cliente tem o número 2 como identificador (ID) o correto seria nenhum outro cliente têm esse identificador (ID) na tabela. Se você utilizar o mesmo identificador (ID) para outros cliente não ocorrerá nenhum erro, mas aí você volta para aquele mesmo problema de antes, onde quando você tenta procurar um nome existente vários outros cliente com o nome igual serão listados. Nesse caso, identificadores (ID) iguais.\n" +
                    "\n" +
                    "Exemplo 2:\n" +
                    "\n" +
                    "\n" +
                    "Tabela clientes_americanas\n" +
                    "\n" +
                    "ID | nome  | cidade\n" +
                    "1  | Ana   | GO\n" +
                    "2  | Maria | DF\n" +
                    "3  | Lydia | GO\n" +
                    "\n" +
                    "\n" +
                    "CHAVE ESTRANGEIRA (FOREIGN KEY)\n" +
                    "\n" +
                    "A chave estrangeira é uma chave primaria de outra tabela. Confuso, né?! Mas, vou explicar melhor.\n" +
                    "\n" +
                    "No segundo exemplo tinhas uma tabela chamada clientes. Nessa tabela tinhas uma coluna chamada cidade. Podemos perceber que Ana e Lydia são das mesmas cidades, e com essas informações podemos pressupor que se tivéssemos várias outras pessoas nessas tabelas e elas fossem da mesma cidade então a coluna cidade teria vários valores repetidos, nomes da mesma cidade em vários registros/linhas.\n" +
                    "\n" +
                    "Pensando e pensando surgi uma ideia, e se criássemos uma tabela separada com o objetivo de guarda apenas os nomes das cidades. Criamos uma chave primaria para cada uma das cidades e toda vez que precisamos colocar na tabela clientes_americanas a cidade onde a pessoa mora colocaremos o identificador (ID) ao invés de colocar o nome da cidade.\n" +
                    "\n" +
                    "Exemplo 3:\n" +
                    "\n" +
                    "\n" +
                    "Tabela cidades:\n" +
                    "ID | nome_cidade \n" +
                    "20 | DF \n" +
                    "23 | GO\n" +
                    "18 | MG\n" +
                    "\n" +
                    "\n" +
                    "Tabela clientes_americanas\n" +
                    "ID | nome  | cidade\n" +
                    "1  | Ana   | 23\n" +
                    "2  | Maria | 20\n" +
                    "3  | Lydia | 23\n" +
                    "\n" +
                    "\n" +
                    "O que aconteceu aqui foi que na tabela clientes usamos o ID da tabela cidades para dizer em qual cidade aquela pessoa mora. Esse ID colocado na coluna cidade é o que chamamos de chaves estrangeira (FOREIGN KEY) porque é uma chave que vem de fora, ou seja, uma chave primaria de outra tabela.\n" +
                    "\n" +
                    "Utilizar esse método de criar uma tabela separada e usar o ID dessa tabela como referência para os valores é uma estratégia brilhante. Você consegue evitar de repetir dados desnecessários e consegue deixar cada informação diferente separada em tabelas diferentes, mas possuindo um relacionamento entre se. E é por causa desse relacionamento que esse tipo de banco de dados é conhecido como banco de dados relacional.\n" +
                    "\n" +
                    "Vale apena mencionar que para mudar usar uma coluna como chave estrangeira de outra tabela, deve ser devidamente informada na hora da criação da tabela que aquela coluna é uma referência para o ID de outra tabela.\n" +
                    "\n" +
                    "Exemplo 4:\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE clientes_americanas (\n" +
                    "id int primary key auto_increment,\n" +
                    "nome char(40),\n" +
                    "cidade int),\n" +
                    "FOREIGN KEY(cidade) references cidades (id)\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "Nesse exemplo, criamos a coluna cidade do tipo int, já que será inserido um valor numérico.\n" +
                    "Utilizamos o comando “FOREIGN KEY” com o nome da coluna que armazenará a chave estrangeira. Depois utilizamos outro comando “REFERENCES” passando o nome da tabela de onde vai vim a chave estrangeira e passando dentro do parente a coluna (ID) dessa tabela que de fato virará chave estrangeira em outra tabela. \n";

            String conteudo_select = "Esse é sem dúvida o comando mais usado. Seu objetivo é selecionar/listar os dados armazenados. Seu funcionamento inicial é relativamente simples e fácil de entender.\n" +
                    "\n" +
                    "Exemplo 1:\n" +
                    "\n" +
                    "\n" +
                    "SELECT * FROM clientes_americanas;\n" +
                    "\n" +
                    "\n" +
                    "Com esse comando do exemplo 1 uma lista será exibida com todos os dados da tabela cliente. Claro, somente se tiver dados inseridos, senão exibirá uma lista vazia.\n" +
                    "\n" +
                    "Entendendo a estrutura, o comando principal aqui é o “SELECT” que significa que você quer selecionar. Após isso você deve informar quais as colunas que você deseja selecionar. Podemos perceber que eu utilizei um asterisco *, ele significa que eu quero selecionar todas as colunas. Em seguida, utilizei o comando “FROM” que significa de qual lugar você quer selecionar os dados. Eu quero selecionar os dados da tabela clientes.\n" +
                    "\n" +
                    "Então a leitura desse comando ficaria assim: selecione todos as colunas da tabela clientes.\n" +
                    "\n" +
                    "Digamos agora que eu não precise de todas as colunas, apenas da coluna id e da coluna nome.\n" +
                    "\n" +
                    "Exemplo 2:\n" +
                    "\n" +
                    "\n" +
                    "SELECT id, nome FROM clientes;\n" +
                    "\n" +
                    "\n" +
                    "Com essa escrita estamos especificando que queremos apenas as colunas id e nome da tabela clientes.\n" +
                    "\n" +
                    "Em uma terceira situação, digamos que não queremos listar todos os clientes, apenas um cliente em especifico. O cliente com id 2.\n" +
                    "\n" +
                    "Exemplo 3:\n" +
                    "\n" +
                    "\n" +
                    "SELECT * FROM clientes WHERE id = 2;\n" +
                    "\n" +
                    "\n" +
                    "Com essa escrita estamos dizendo que queremos selecionar todas as colunas da tabela cliente, onde o id seja igual 2. Se houver algum registro/linha com id igual a 2, então ele exibirá, senão mostrará uma lista vazia.\n" +
                    "\n" +
                    "Esse comando “WHERE” faz parte de um conjunto de comandos que são usados para filtrar a pesquisa na hora fazer um “SELECT”. Esses filtros serão abordados em tópicos mais adiante.\n";

            String conteudo_update = "Esse comando é utilizado para fazer alterações de dados já cadastrados. \n" +
                    "\n" +
                    "Imagina uma tabela de clientes onde um dos clientes se chama João Benedito. Porém, o nome do João foi escrito errado, na verdade seu nome é João Pedro. Como poderia ser corrigido o nome do João depois de já cadastrado?\n" +
                    "\n" +
                    "Nessa situação o comando “UPDATE” é o herói da história.\n" +
                    "\n" +
                    "Exemplo 1:\n" +
                    "\n" +
                    "\n" +
                    "UPDATE clientes_americanas\n" +
                    "SET nome = “João Pedro” \n" +
                    "WHERE id = 2;\n" +
                    "\n" +
                    "\n" +
                    "Fazendo a leitura do comando: Atualize na tabela clientes, colocando na coluna nome o valor João Pedro, onde o identificador (ID) da linha/registro seja igual a 2.\n" +
                    "\n" +
                    "Analisando o comando escrito, começamos com o comando “UPDATE” que significa atualizar ou alterar. \n" +
                    "\n" +
                    "Dizemos em qual tabela queremos alterar. \n" +
                    "Com o comando “SET” dizemos qual coluna terá seu valor alterado.\n" +
                    "E agora o mais importante, com o comando WHERE dizemos qual linha/registro queremos alterar. \n" +
                    "\n" +
                    "CUIDADO, não utilize o comando “UPDATE” sem o comando “WHERE”. Se você usar sem ele você estará alterando todos as linhas/registro da tabela. Isso significa que se você tem 100 clientes cadastrados e coloca para alterar o nome para João Pedro sem usar o comando “WHERE” ele vai alterar todos os nomes.\n" +
                    "\n" +
                    "Exemplo 2:\n" +
                    "\n" +
                    "\n" +
                    "UPDATE clientes \n" +
                    "SET nome = “João Pedro”, cidade = “DF”\n" +
                    "WHERE id = 2;\n" +
                    "\n" +
                    "\n" +
                    "Nesse segundo exemplo é demostrado que pode alterar mais de uma coluna ao mesmo tempo separando por virgula cada coluna.\n" +
                    "\n" +
                    "ATENÇÂO, estou falando de alterar mais de uma coluna e não sobre alterar mais de uma linha/registro.\n" +
                    "\n" +
                    "Para cita mais um exemplo, imagine um banco de dados de uma conta bancaria. Na tabela chamada clientes_caixa tem 3 colunas. Uma chamada nome, outra chamada saldo e última id.\n" +
                    "\n" +
                    "Uma das clientes cadastradas nesse banco da caixa tem o nome de Lurdes, seu saldo é de R$ 300 reais e o id 7.\n" +
                    "\n" +
                    "Lurdes precisou pagar uma conta de R$ 40 reais utilizando o dinheiro que estava em sua conta. Isso significa que o saldo dela precisa ser alterado.\n" +
                    "\n" +
                    "Exemplo 3:\n" +
                    "\n" +
                    "\n" +
                    "UPDATE cliente_caixa\n" +
                    "SET saldo = 260\n" +
                    "WHERE id = 7;\n" +
                    "\n" +
                    "\n" +
                    "Com esse comando o saldo dela na conta será atualizado. \n" +
                    "\n" +
                    "Gostaria de deixar claro que nesse último exemplo eu tentei ser didático e mostrar de forma simples um dos processos que acontece em contas bancárias. Bem, o que quero dizer é, o que acontece por trás de um sistema bancário é a utilização de um comando “UPDATE” para alterar o saldo da conta, mas não pense que é somente isso ou que o novo valor do saldo é passado desse jeito que foi mostrado, ou seja, não é digitado o novo valor manualmente.\n" +
                    "\n" +
                    "Concluindo, toda vez que for necessário alterar alguma informação em algum registro/linha da tabela, o comando “UPDATE” será utilizado, passando para ele a coluna junto com o novo valor a ser alterado e não esquecendo de dizer em qual linha esse valor será alterado.\n" +
                    "\n";

            String conteudo_delete = "Esse é um dos comandos mais simples e também um dos mais perigosos. O comando “DELETE FROM” é utilizado para excluir registros da tabela. No entanto, assim como o “UPDATE” precisava do comando “WHERE” o “DELETE” também precisa.\n" +
                    "\n" +
                    "Exemplo 1;\n" +
                    "\n" +
                    "\n" +
                    "DELETE FROM clientes WHERE id = 2;\n" +
                    "\n" +
                    "\n" +
                    "Lendo o comando, delete da tabela clientes o registro/linha que tive o id igual a 2;\n" +
                    "\n" +
                    "Tudo que você precisa após escrever “DELETE FROM” e passar o nome da tabela e utilizar o “WHERE” para dizer qual registro/linha deseja excluir.\n" +
                    "\n" +
                    "Todavia, esse comando é perigoso porque se você digitar “DELETE FROM clientes” sem usar “WHERE” todos os registros da tabela serão deletados. Imagina você trabalhando como administrador de banco de dados na caixa econômica e utilizar esse comando e apagar a conta de todos os clientes. Se a empresa não tiver um backup/cópia de segurança, você está ferrado.\n" +
                    "\n" +
                    "Por sorte a maioria das empresas sabem o perigo de utilizar esse comando de forma indevida e cria configurações de segurança para que esse comando não seja executado sem a devida necessidade e quando executado que seja apenas por usuários com senioridade.\n";


            String conteudo_join = "Esse é um comando usado junto com o “SELECT” e seu objetivo e listar os dados de duas tabelas ao mesmo tempo que possuem algum vínculo.\n" +
                    "\n" +
                    "Esse é um momento em que você precisará fazer um pouquinho de esforço mental para entender esse comando.\n" +
                    "\n" +
                    "Com o comando “JOIN” podemos listar dados de uma tabela mais que fazem referência a uma segunda tabela. O detalhe aqui é a palavra referência. Se resgatamos alguns conceitos já explicados anteriormente vamos lembrar que referência é uma palavra relacionada a chaves primarias e chaves estrangeiras.\n" +
                    "\n" +
                    "As chaves estrangeiras são utilizadas para informar que o valor que está sendo inserido é uma referência ao id de algum registro/linha de outra tabela. Como no exemplo que citado onde na coluna cidade da tabela clientes tinha a chave estrangeira do nome da cidade que estava em outra tabela. \n" +
                    "\n" +
                    "Exemplo 1:\n" +
                    "\n" +
                    "Tabela clientes:\n" +
                    "\u202C\n" +
                    "Id,\tnome,\tcidade\n" +
                    "1,\tAna,\t23\n" +
                    "2,\tAlice,\t18\n" +
                    "3,\tJessica,\t20\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Tabela cidades:\n" +
                    "\n" +
                    "Id_cid, nome_cidade \n" +
                    "20, DF\n" +
                    "23, Go\n" +
                    "18, MG\n" +
                    "\n" +
                    "\n" +
                    "Se usarmos somente “SELECT” listar os dados da tabela cliente então os dados vão aparecer exatamente do jeito que está no exemplo 1. Porém, ao listar a tabela clientes, na coluna cidade não queremos que apareça o número da chave estrangeira, mas sim o nome da cidade.\n" +
                    "\n" +
                    "Exemplo 2:\n" +
                    "\n" +
                    "\n" +
                    "SELECT * FROM clientes\n" +
                    "INNER JOIN cidades\n" +
                    "ON clientes.cidade = cidades.id_cidade;\n" +
                    "\n" +
                    "\n" +
                    "É nessa situação que o comando “JOIN” entra em ação. Como pode ser visto no exemplo 2, ele está sendo usado para buscar dados em duas tabelas diferentes ao mesmo tempo.\n" +
                    "\n" +
                    "O comando “INNER” que aparece significa que queremos achar somente os valores que possuem alguma igualdade e unir os dados da tabela 1 com a tabela 2. Os números que estão na coluna id da tabela cidades são exatamente os mesmos números que estão na coluna cidade da tabela clientes. Por tanto na hora que o “SELECT” for executado ele vai retorna todos os dados pressentes nas duas tabelas.\n" +
                    "\n" +
                    "Exemplo 3:\n" +
                    "\n" +
                    "\n" +
                    "Id, nome, cidade, nome_cidade, id_cidade\n" +
                    "1, Alice, 18, MG, 18\n" +
                    "2, Jessica, 23, GO, 23\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "O “ON” que aparece na última linha é o comando que diz quais colunas de quais tabelas devem ter os valores iguais.\n" +
                    "\n" +
                    "\n" +
                    "Eu citei o “INNER JOIN” que é o mais comum de ser usado, porém existem mais dois. “LEFT JOIN” e “RIGHT JOIN”. LEFT significa esquerda e RIGHT direito. \n" +
                    "O “INNER JOIN” só exibe registro/linhas quando ela existe uma coluna em ambas as tabelas que possuem o mesmo valor. Criando assim um vínculo entre as duas tabelas. Os registros/linhas que não possuem vínculos não serão exibidos.\n" +
                    "\n" +
                    "O “LEFT JOIN” ele exibe todos os registros/linhas que possuem vinculo de igualdade, porém ele também mostra os dados da tabela da esquerda que não possuem vinculo. \n" +
                    "\n" +
                    "\n" +
                    "Id, nome, cidade, nome_cidade, id_cidade\n" +
                    "1, Alice, 18, MG, 18\n" +
                    "2, Jessica, 23, GO, 23\n" +
                    "3, Ana, null, null, null\n" +
                    "\n" +
                    "O “RIGHT JOIN” ele exibe todos os registros/linhas que possuem vinculo de igualdade, porém ele também mostra os dados da tabela da direita que não possuem vinculo.\n" +
                    "\n" +
                    "\n" +
                    "Id___|__nome____|_cidade_| nome_cid_|_id_cid_|\n" +
                    "1__ _|____Alice___|___18___|____ MG__|___18___|\n" +
                    "2__  |___Jessica_|___23___|____ GO__|___23___|\n" +
                    "Null |____null____|__null___|_____DF__|¬¬___20___|\n" +
                    "\n" +
                    "\n" +
                    "Em alguns tipos de banco de dados existe o “FULL JOIN”. Ele pega todos os dados das duas tabelas, direita e esquerda, independentemente de terem vinculo de igualdade ou não.\n" +
                    "\n" +
                    "\n" +
                    "Id_  |__nome___|_cidade_| nome_cidade_|_id_cidade_|\n" +
                    "1__  |__Alice__|___18___|____ MG______|_____18____|\n" +
                    "2__  |_Jessica_|___23___|____ GO______|_____23____|\n" +
                    "3    |   Ana   |_ null__|__  null     |¬¬__  null   |\n" +
                    "null |  null   |_ null__|__   DF      |¬¬__   20    |\n";


            //Remendações

            String recomendacao_criar_banco_andreia = "Canal: Professora Andréia Maciel\n" +
                    "\n" +
                    "Título Vídeo: Criando Banco, tabelas e diagrama no Mysql Workbench\n" +
                    "\n" +
                    "Link: https://youtu.be/2yGrUwBSFaA?feature=shared\n";


            String recomendacao_insert_andreia = "Canal: Professora Andréia Maciel\n" +
                    "\n" +
                    "Título Vídeo: DML - Insert Into\n" +
                    "\n" +
                    "Link: https://youtu.be/WhHo3HK74uA?feature=shared\n";


            String recomendacao_select_andreia = "Canal: Professora Andréia Maciel\n" +
                    "\n" +
                    "Título Vídeo: Consultas - select sql\n" +
                    "\n" +
                    "Link: https://youtu.be/6gCF5bSIqYI?feature=shared\n";


            String recomendacao_update_delete_andreia = "Canal: Professora Andréia Maciel\n" +
                    "\n" +
                    "Título Vídeo: DML - Update e delete\n" +
                    "\n" +
                    "Link: https://youtu.be/PLI_lTwr8GE?feature=shared\n";


            String recomendacao_join_mirian = "Canal: Miriam TechCod\n" +
                    "\n" +
                    "Título Vídeo: Como fazer inner Join e outer join no MYSQL\n" +
                    "\n" +
                    "Link: https://youtu.be/Is2LL6xL0iI?feature=shared\n";

            String recomendacao_modelagem_miriam = "Canal: Miriam TechCod\n" +
                    "\n" +
                    "Título Vídeo: Modelagem de dados - modelo conceitual, lógico e físico\n" +
                    "\n" +
                    "Link: https://youtu.be/8CkMX2qXgdY?feature=shared\n";


            String recomendacao_transacoes_andreia = "Canal: Professora Andréia Maciel\n" +
                    "\n" +
                    "Título Vídeo: DTL - Linguagem de Transações de Dados\n" +
                    "\n" +
                    "Link: https://youtu.be/SJETGdkLyQ8?feature=shared\n";


            //Criando obejto com dados
            Conteudo introducao = new Conteudo(1, "Introdução", conteudo_introducao);
            Conteudo banco_sevidores = new Conteudo(2, "Banco de dados em servidores", conteudo_banco_ser);
            Conteudo banco_embarcado = new Conteudo(3, "Banco de dados embarcado", conteudo_embarcados);
            Conteudo create_database = new Conteudo(4, "Criar banco (CREATE DATABASE)", conteudo_create);
            Conteudo tipos_dados = new Conteudo(5, "Tipos de dados (Texto, númerico, data)", conteudo_tipos);
            Conteudo create_table = new Conteudo(6, "Criar tabela (CREATE TABLE)", conteudo_create_table);
            Conteudo primary_key = new Conteudo(7, "Chaves (PRIMARY KEY, FOREIGN KEY", conteudo_primary);
            Conteudo insert_into = new Conteudo(8, "Inserir (INSERT INTO)", conteudo_insert);
            Conteudo select = new Conteudo(9, "listar (SELECT)", conteudo_select);
            Conteudo update = new Conteudo(10, "Alterar (UPDATE)", conteudo_update);
            Conteudo delete_from = new Conteudo(11, "Excluir (DELETE FROM)", conteudo_delete);
            Conteudo chave_composta = new Conteudo(12, "Primary Key composta por duas colunas", "Em breve...");
            Conteudo modelagem = new Conteudo(13, "Modelagem (MER)", "Em breve...");
            Conteudo drop = new Conteudo(14, "Apagar tabela (DROP)", "Em breve...");
            Conteudo join = new Conteudo(15, "Dados entre tabelas (JOIN)", conteudo_join);
            Conteudo cardinalidade = new Conteudo(16, "Cardinalidade (1:1, 1:n e n:n)", "Em breve...");
            Conteudo filtros = new Conteudo(17, "Filtros select", "Em breve...");
            Conteudo group_by = new Conteudo(18, "Listar por grupo (GROUP BY)", "Em breve...");
            Conteudo count = new Conteudo(19, "Obter totais de linhas (COUNT)", "Em breve...");
            Conteudo views = new Conteudo(20, "Views", "Em breve...");
            Conteudo select_into = new Conteudo(21, "Criar tabela com resultado de uma pesquisa (SELECT INTO)", "Em breve...");
            Conteudo alter_table = new Conteudo(22, "Alterar tabela (ALTER TABLE)", "Em breve...");
            Conteudo controle_acesso = new Conteudo(23, "Controle de Acesso (GRANT, DENY e REVOKE)", "Em breve...");
            Conteudo controle_transacoe = new Conteudo(24, "Controle de Transações (COMMIT, ROOLLBACK e BEGIN)", "Em breve...");
            Conteudo truncate = new Conteudo(25, "Excluir todos os dados da tabela (TRUNCATE)", "Em breve...");
            Conteudo triggers = new Conteudo(25, "Gatilhos (TRIGGERS)", "Em breve...");


            Conteudo createDataBase_andrea = new Conteudo(26, "Criar criar base de dados", recomendacao_criar_banco_andreia);
            Conteudo insert_andrea = new Conteudo(27, "Como fazer insert", recomendacao_insert_andreia);
            Conteudo select_andrea = new Conteudo(28, "Com usar select", recomendacao_select_andreia);
            Conteudo update_delete_andrea = new Conteudo(29, "Como usar UPDATE e DELETE", recomendacao_update_delete_andreia);
            Conteudo inner_join_miriam = new Conteudo(30, "Como usar INNER JOIN", recomendacao_join_mirian);
            Conteudo modelagem_miriam = new Conteudo(31, "Criar Modelagem e Cardinalidade", recomendacao_modelagem_miriam);
            Conteudo transaction = new Conteudo(32, "Processo de Transações", recomendacao_transacoes_andreia);


            //Inserindo no banco de dados
            String sql = "INSERT INTO conteudo (titulo,artigo,categoria)  VALUES" +
                    " ('" + introducao.getTitulo() + "','" + introducao.getArtigo() + "',0)," +
                    " ('" + banco_sevidores.getTitulo() + "','" + banco_sevidores.getArtigo() + "',0)," +
                    " ('" + banco_embarcado.getTitulo() + "','" + banco_embarcado.getArtigo() + "',0)," +
                    " ('" + create_database.getTitulo() + "','" + create_database.getArtigo() + "',0)," +
                    " ('" + tipos_dados.getTitulo() + "','" + tipos_dados.getArtigo() + "',0)," +
                    " ('" + create_table.getTitulo() + "','" + create_table.getArtigo() + "',0)," +
                    " ('" + insert_into.getTitulo() + "','" + insert_into.getArtigo() + "',0)," +
                    " ('" + select.getTitulo() + "','" + select.getArtigo() + "',0)," +
                    " ('" + update.getTitulo() + "','" + update.getArtigo() + "',0)," +
                    " ('" + delete_from.getTitulo() + "','" + delete_from.getArtigo() + "',0)," +
                    " ('" + primary_key.getTitulo() + "','" + primary_key.getArtigo() + "',0)," +
                    " ('" + join.getTitulo() + "','" + join.getArtigo() + "',1)," +
                    " ('" + chave_composta.getTitulo() + "','" + chave_composta.getArtigo() + "',1)," +
                    " ('" + modelagem.getTitulo() + "','" + modelagem.getArtigo() + "',1)," +
                    " ('" + drop.getTitulo() + "','" + drop.getArtigo() + "',1)," +
                    " ('" + join.getTitulo() + "','" + join.getArtigo() + "',1)," +
                    " ('" + cardinalidade.getTitulo() + "','" + cardinalidade.getArtigo() + "',1)," +
                    " ('" + group_by.getTitulo() + "','" + group_by.getArtigo() + "',1)," +
                    " ('" + count.getTitulo() + "','" + count.getArtigo() + "',1)," +
                    " ('" + views.getTitulo() + "','" + views.getArtigo() + "',1)," +
                    " ('" + alter_table.getTitulo() + "','" + alter_table.getArtigo() + "',1)," +
                    " ('" + select_into.getTitulo() + "','" + select_into.getArtigo() + "',1)," +
                    " ('" + controle_acesso.getTitulo() + "','" + controle_acesso.getArtigo() + "',2)," +
                    " ('" + controle_transacoe.getTitulo() + "','" + controle_transacoe.getArtigo() + "',2)," +
                    " ('" + truncate.getTitulo() + "','" + truncate.getArtigo() + "',2)," +
                    " ('" + createDataBase_andrea.getTitulo() + "','" + createDataBase_andrea.getArtigo() + "',3)," +
                    " ('" + insert_andrea.getTitulo() + "','" + insert_andrea.getArtigo() + "',3)," +
                    " ('" + select_andrea.getTitulo() + "','" + select_andrea.getArtigo() + "',3)," +
                    " ('" + update_delete_andrea.getTitulo() + "','" + update_delete_andrea.getArtigo() + "',3)," +
                    " ('" + inner_join_miriam.getTitulo() + "','" + inner_join_miriam.getArtigo() + "',3)," +
                    " ('" + modelagem_miriam.getTitulo() + "','" + modelagem_miriam.getArtigo() + "',3)," +
                    " ('" + transaction.getTitulo() + "','" + transaction.getArtigo() + "',3);";

            this.conexao.execSQL(sql);
        }

    }


}
