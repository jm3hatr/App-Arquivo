package com.example.apparquivo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VisitaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    String record = "";
    String record2 = "";
    String record3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);

        //String array
        final String[] opcoes = getResources().getStringArray(R.array.spinner_grupo);

        //Spinner grupo 1
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner_grupo01);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes);
        spinner1.setAdapter(adapter);

        //Spinner grupo 2
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner_grupo02);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes);
        spinner2.setAdapter(adapter2);

        //Spinner grupo 3
        Spinner spinner3 = (Spinner)findViewById(R.id.spinner_grupo03);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes);
        spinner3.setAdapter(adapter3);

        /** spinners Grupo 1 **/
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        record = opcoes[0];
                        break;

                    case 1:
                        record = opcoes[1];
                        break;

                    case 2:
                        record = opcoes[2];
                        break;

                    case 3:
                        record = opcoes[3];
                        break;

                    case 4:
                        record = opcoes[4];
                        break;

                    case 5:
                        record = opcoes[5];
                        break;

                    case 6:
                        record = opcoes[6];
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        record2 = opcoes[0];
                        break;

                    case 1:
                        record2 = opcoes[1];
                        break;

                    case 2:
                        record2 = opcoes[2];
                        break;

                    case 3:
                        record2 = opcoes[3];
                        break;

                    case 4:
                        record2 = opcoes[4];
                        break;

                    case 5:
                        record2 = opcoes[5];
                        break;

                    case 6:
                        record2 = opcoes[6];
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        record3 = opcoes[0];
                        break;

                    case 1:
                        record3 = opcoes[1];
                        break;

                    case 2:
                        record3 = opcoes[2];
                        break;

                    case 3:
                        record3 = opcoes[3];
                        break;

                    case 4:
                        record3 = opcoes[4];
                        break;

                    case 5:
                        record3 = opcoes[5];
                        break;

                    case 6:
                        record3 = opcoes[6];
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }







    /**
     * Este método é chamado quando o botão ENVIAR è clicado
     */

    public void fazerPedidoVisita (View view) {

        // 1. Organismo proponente
        EditText nomeField = (EditText) findViewById(R.id.nome_txt);
        String nome = nomeField.getText().toString();

        EditText moradaField = (EditText) findViewById(R.id.morada_txt);
        String morada = moradaField.getText().toString();

        EditText pessoaField = (EditText) findViewById(R.id.pessoa_responsavel_txt);
        String pessoa = pessoaField.getText().toString();

        EditText telefoneField = (EditText) findViewById(R.id.telefone_txt);
        String telefone = telefoneField.getText().toString();

        EditText telemovelField = (EditText) findViewById(R.id.telemovel_txt);
        String telemovel = telemovelField.getText().toString();

        EditText emailVisitaField = (EditText) findViewById(R.id.email_txt);
        String email = emailVisitaField.getText().toString();


        // 2.1 Informaçoes Grupo 1
        EditText numeroPessoas01Field = (EditText) findViewById(R.id.numero_pessoas_txt);
        String numeroPessoas01 = numeroPessoas01Field.getText().toString();

        EditText dataPretendida01Field = (EditText) findViewById(R.id.data_pretendida_txt);
        String dataPretendida01 = dataPretendida01Field.getText().toString();

        EditText horaPretendida01Field = (EditText) findViewById(R.id.hora_pretendida_txt);
        String horaPretendida01 = horaPretendida01Field.getText().toString();

        //TextView com a opção escolhida no spinner do grupo 1
        TextView mostrarResultado01 = (TextView)findViewById(R.id.mostrar_resultado01);
        mostrarResultado01.setText(record);


        // 2.2 Informações Grupo 2
        EditText numeroPessoas02Field = (EditText) findViewById(R.id.numero_pessoas_grupo2_txt);
        String numeroPessoas02 = numeroPessoas02Field.getText().toString();

        EditText dataPretendida02Field = (EditText) findViewById(R.id.data_pretendida_grupo2_txt);
        String dataPretendida02 = dataPretendida02Field.getText().toString();

        EditText horaPretendida02Field = (EditText) findViewById(R.id.hora_pretendida_grupo2_txt);
        String horaPretendida02 = horaPretendida02Field.getText().toString();

        //TextView com a opção escolhida no spinner do grupo 2
        TextView mostrarResultado02 = (TextView)findViewById(R.id.mostrar_resultado02);
        mostrarResultado02.setText(record2);


        // 2.3 Infromações Grupo 3
        EditText numeroPessoas03Field = (EditText) findViewById(R.id.numero_pessoas_grupo3_txt);
        String numeroPessoas03 = numeroPessoas03Field.getText().toString();

        EditText dataPretendida03Field = (EditText) findViewById(R.id.data_pretendida_grupo3_txt);
        String dataPretendida03 = dataPretendida03Field.getText().toString();

        EditText horaPretendida03Field = (EditText) findViewById(R.id.hora_pretendida_grupo3_txt);
        String horaPretendida03 = horaPretendida03Field.getText().toString();

        //TextView com a opção escolhida no spinner do grupo 3
        TextView mostrarResultado03 = (TextView)findViewById(R.id.mostrar_resultado03);
        mostrarResultado03.setText(record3);





        /**
         * criar intent para enviar e-mail
         **/

        String mensagemEmail = criarPedido(nome, morada, pessoa, telefone, telemovel, email, numeroPessoas01, dataPretendida01, horaPretendida01, record, numeroPessoas02, dataPretendida02, horaPretendida02, record2,
                numeroPessoas03, dataPretendida03, horaPretendida03, record3);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: jm3.hatr@hotmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido de Visita de " + nome);
        intent.putExtra(Intent.EXTRA_TEXT, mensagemEmail);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }





    private String criarPedido (String nome, String morada, String pessoa, String telefone, String telemovel, String email, String numeroPessoas01, String dataPretendida01, String horaPretendida01, String resultado, String numeroPessoas02,
                                String dataPretendida02, String horaPretendida02, String resultado2, String numeroPessoas03, String dataPretendida03, String horaPretendida03, String resultado3) {

        String mensagemEmail = "Pedido de Visita\n";
        mensagemEmail += "\n" + getString(R.string.pedido_nome, nome);
        mensagemEmail += "\n" + getString(R.string.pedido_morada, morada);
        mensagemEmail += "\n" + getString(R.string.pedido_pessoa_responsavel, pessoa);
        mensagemEmail += "\n" + getString(R.string.pedido_telefone, telefone);
        mensagemEmail += "\n" + getString(R.string.pedido_telemovel, telemovel);
        mensagemEmail += "\n" + getString(R.string.pedido_email, email) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_numero_pessoas, numeroPessoas01);
        mensagemEmail += "\n" + getString(R.string.pedido_data_pretendida, dataPretendida01);
        mensagemEmail += "\n" + getString(R.string.pedido_hora_pretendida, horaPretendida01);
        mensagemEmail += "\n" + getString(R.string.pedido_acao_esperada, resultado) + "\n\n -\n";

        //Grupo 2
        mensagemEmail += "\nGrupo 2";
        mensagemEmail += "\n" + getString(R.string.pedido_numero_pessoas, numeroPessoas02);
        mensagemEmail += "\n" + getString(R.string.pedido_data_pretendida, dataPretendida02);
        mensagemEmail += "\n" + getString(R.string.pedido_hora_pretendida, horaPretendida02);
        mensagemEmail += "\n" + getString(R.string.pedido_acao_esperada, resultado2) + "\n";

        //Grupo 3
        mensagemEmail += "-\nGrupo 3";
        mensagemEmail += "\n" + getString(R.string.pedido_numero_pessoas, numeroPessoas03);
        mensagemEmail += "\n" + getString(R.string.pedido_data_pretendida, dataPretendida03);
        mensagemEmail += "\n" + getString(R.string.pedido_hora_pretendida, horaPretendida03);
        mensagemEmail += "\n" + getString(R.string.pedido_acao_esperada, resultado3);


        return mensagemEmail;
    }

}
