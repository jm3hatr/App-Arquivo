package com.example.apparquivo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class AquisicaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquisicao);

        // link para os Procedimentos e Normas
        TextView linkText = (TextView) findViewById(R.id.link_textview);
        linkText.setMovementMethod(LinkMovementMethod.getInstance());
    }




    /**
     * Este método é chamado quando o botão ENVIAR è clicado
     */
    public void fazerPedido(View view) {

        // 1. Identificacao
        EditText nomeField = (EditText) findViewById(R.id.nomeTxt);
        String nome = nomeField.getText().toString();

        EditText moradaField = (EditText) findViewById(R.id.moradaTxt);
        String morada = moradaField.getText().toString();

        EditText telefoneField = (EditText) findViewById(R.id.telefoneTxt);
        String telefone = telefoneField.getText().toString();

        EditText faxField = (EditText) findViewById(R.id.faxTxt);
        String fax = faxField.getText().toString();

        EditText emailField = (EditText) findViewById(R.id.emailTxt);
        String email = emailField.getText().toString();


        // 2.1 Datas
        EditText dataInicialField = (EditText) findViewById(R.id.data_inicial_Txt);
        String dataInicial = dataInicialField.getText().toString();

        EditText dataFinalField = (EditText) findViewById(R.id.data_final_Txt);
        String dataFinal = dataFinalField.getText().toString();


        // 2.2 Elementos de recuperacao
        CheckBox registosCheckBox = (CheckBox) findViewById(R.id.registos_checkbox);
        boolean registosCheck = registosCheckBox.isChecked();

        CheckBox indicesCheckBox = (CheckBox) findViewById(R.id.indices_checkbox);
        boolean indicesCheck = indicesCheckBox.isChecked();

        CheckBox catalogosCheckBox = (CheckBox) findViewById(R.id.catalogos_checkbox);
        boolean catalogosCheck = catalogosCheckBox.isChecked();

        CheckBox outrosElementosCheckBox = (CheckBox) findViewById(R.id.outros_checkbox);
        boolean outrosCheck = outrosElementosCheckBox.isChecked();

        EditText outrosElementosField = (EditText) findViewById(R.id.outros_checkTxt);
        String outrosElementos = outrosElementosField.getText().toString();


        // 2.3 Metragem
        EditText metragemActualField = (EditText) findViewById(R.id.metragem_actualTxt);
        String metragemActual = metragemActualField.getText().toString();

        EditText crescimentoAnualField = (EditText) findViewById(R.id.crescimento_anualTxt);
        String crescimentoAnual = crescimentoAnualField.getText().toString();


        // 2.4 Nº e tipo de unidades de instalacao
        EditText livrosField = (EditText) findViewById(R.id.livrosTxt);
        String livros = livrosField.getText().toString();

        EditText macosField = (EditText) findViewById(R.id.macosTxt);
        String macos = macosField.getText().toString();

        EditText pastasField = (EditText) findViewById(R.id.pastasTxt);
        String pastas = pastasField.getText().toString();

        EditText caixasField = (EditText) findViewById(R.id.caixasTxt);
        String caixas = caixasField.getText().toString();

        EditText outrosUnidadesField = (EditText) findViewById(R.id.outras_unidadesTxt);
        String outrosUnidades = outrosUnidadesField.getText().toString();


        // 2.5 Estado de conservacao
        CheckBox bomCheckBox = (CheckBox) findViewById(R.id.bom_checkbox);
        boolean bomCheck = bomCheckBox.isChecked();

        CheckBox regularCheckBox = (CheckBox) findViewById(R.id.regular_checkbox);
        boolean regularCheck = regularCheckBox.isChecked();

        CheckBox mauCheckBox = (CheckBox) findViewById(R.id.mau_checkbox);
        boolean mauCheck = mauCheckBox.isChecked();

        EditText mauField = (EditText) findViewById(R.id.mauTxt);
        String mauDescricao = mauField.getText().toString();


        // 3.1 Localizacao
        CheckBox caveCheckBox = (CheckBox) findViewById(R.id.cave_checkbox);
        boolean caveCheck = caveCheckBox.isChecked();

        CheckBox sotaoCheckBox = (CheckBox)findViewById(R.id.sotao_checkbox);
        boolean sotaoCheck = sotaoCheckBox.isChecked();

        CheckBox armazemCheckBox = (CheckBox) findViewById(R.id.armazem_checkbox);
        boolean armazemCheck = armazemCheckBox.isChecked();

        CheckBox outraLocalizacaoCheckBox = (CheckBox) findViewById(R.id.outra_localizacao_checkBox);
        boolean outraLocalizacaoCheck = outraLocalizacaoCheckBox.isChecked();

        EditText outraLocalizacaoField = (EditText) findViewById(R.id.outra_localizacaoTxt);
        String outraLocalizacao = outraLocalizacaoField.getText().toString();


        // 3.2 Instalacao
        CheckBox estantesCheckBox = (CheckBox) findViewById(R.id.estantes_checkbox);
        boolean estantesCheck = estantesCheckBox.isChecked();

        CheckBox caixotesCheckBox = (CheckBox) findViewById(R.id.caixotes_checkbox);
        boolean caixotesCheck = caixotesCheckBox.isChecked();

        CheckBox chaoCheckBox = (CheckBox) findViewById(R.id.caixotes_checkbox);
        boolean chaoCheck = chaoCheckBox.isChecked();


        // 4. Observacoes
        EditText observacoesField = (EditText) findViewById(R.id.observacoesTxt);
        String observacoes = observacoesField.getText().toString();


        /**
         * criar intent para enviar e-mail
         **/

        String mensagemEmail = criarPedido(nome, morada, telefone, fax, email, dataInicial, dataFinal, registosCheck, indicesCheck, catalogosCheck, outrosCheck, outrosElementos, metragemActual, crescimentoAnual,
                livros, macos, pastas, caixas, outrosUnidades, bomCheck, regularCheck, mauCheck, mauDescricao, caveCheck, sotaoCheck, armazemCheck, outraLocalizacaoCheck, outraLocalizacao,
                estantesCheck, caixotesCheck, chaoCheck, observacoes);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: info@adporto.dglab.gov.pt"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido de Aquisição de Arquivos de " + nome);
        intent.putExtra(Intent.EXTRA_TEXT, mensagemEmail);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /** aqui cria o pedido completo para ser chamado no evento Onclick criado em cima
     *
     * Irá conter os campos com Nome, Morada, Telefone, etc
     **/
    private String criarPedido(String nome, String morada, String telefone, String fax, String  email, String dataInicial, String dataFinal,
                               boolean temRegistos, boolean temIndices, boolean temCatalogos, boolean temOutrosElementos, String outrosElementos,
                               String actual, String crescimentoAnual, String livros, String macos, String pastas, String caixas, String outrosUnidades,
                               boolean bom, boolean regular, boolean mau, String mauText, boolean cave, boolean sotao, boolean armazem, boolean outraLocalizacao, String outraLocalizacaoTxt,
                               boolean estantes, boolean caixotes, boolean chao, String observacoes) {


        String mensagemEmail = "Pedido de Aquisição de Arquivos\n";
        mensagemEmail += "\n" + getString(R.string.pedido_nome, nome);
        mensagemEmail += "\n" + getString(R.string.pedido_morada, morada);
        mensagemEmail += "\n" + getString(R.string.pedido_telefone, telefone);
        mensagemEmail += "\n" + getString(R.string.pedido_fax, fax);
        mensagemEmail += "\n" + getString(R.string.pedido_email, email) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_data_inicial, dataInicial);
        mensagemEmail += "\n" + getString(R.string.pedido_data_final, dataFinal) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_registos, temRegistos);
        mensagemEmail += "\n" + getString(R.string.pedido_indices, temIndices);
        mensagemEmail += "\n" + getString(R.string.pedido_catalogos, temCatalogos);
        mensagemEmail += "\n" + getString(R.string.pedido_outros_elementos, temOutrosElementos);
        mensagemEmail += "\n" + getString(R.string.pedido_outros_elementos_txt, outrosElementos) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_metragem_actual, actual);
        mensagemEmail += "\n" + getString(R.string.pedido_crescimento_anual, crescimentoAnual) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_livros, livros);
        mensagemEmail += "\n" + getString(R.string.pedido_macos, macos);
        mensagemEmail += "\n" + getString(R.string.pedido_pastas, pastas);
        mensagemEmail += "\n" + getString(R.string.pedido_caixas, caixas);
        mensagemEmail += "\n" + getString(R.string.pedido_outros_unidades, outrosUnidades) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_bom, bom);
        mensagemEmail += "\n" + getString(R.string.pedido_regular, regular);
        mensagemEmail += "\n" + getString(R.string.pedido_mau, mau);
        mensagemEmail += "\n" + getString(R.string.pedido_mau_texto, mauText) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_cave, cave);
        mensagemEmail += "\n" + getString(R.string.pedido_sotao, sotao);
        mensagemEmail += "\n" + getString(R.string.pedido_armazem, armazem);
        mensagemEmail += "\n" + getString(R.string.pedido_outra_localizao, outraLocalizacao);
        mensagemEmail += "\n" + getString(R.string.pedido_outra_localizacao_texto, outraLocalizacaoTxt) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_estantes, estantes);
        mensagemEmail += "\n" + getString(R.string.pedido_caixotes, caixotes);
        mensagemEmail += "\n" + getString(R.string.pedido_chao, chao) + "\n";

        mensagemEmail += "\n" + getString(R.string.pedido_observacoes, observacoes);



        return mensagemEmail;
    }

}
