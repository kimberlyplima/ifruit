package br.com.kimberlyplima.ifruit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CarrinhoDeComprasActivity extends AppCompatActivity {

    private ArrayList<Produto> carrinhoAtualUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho_de_compras);
        Intent intent = getIntent();
        carrinhoAtualUsuario = getIntent().getParcelableArrayListExtra("carrinhoEstadoAtual");
        
    }
}
