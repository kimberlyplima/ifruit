package br.com.kimberlyplima.ifruit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;

public class CarrinhoDeComprasActivity extends AppCompatActivity {

    private ArrayList<Produto> carrinhoAtualUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho_de_compras);
        String carrinhoString = getIntent().getStringExtra("carrinhoEstadoAtual");
        System.out.println("Carrinho que chegou "+carrinhoString);

        String[] array = carrinhoString.split("</produto>");



        System.out.println("array 0 : "+array[0]);
        System.out.println("array 0 : "+array[1]);
        System.out.println("array 0 : "+array[2]);

        String[] array2 = array[0].split("<separacao>");

        String[] array3 = array[1].split("<separacao>");

        System.out.println("array2 0 : " + array2[0]);

        System.out.println("array3[1] : " + array3[1]);
//        System.out.println("array2 1 : "+array2[1]);
//        System.out.println("array2 2 : "+array2[2]);
//        System.out.println("array2 3 : "+array2[3]);
//        System.out.println("array2 4 : "+array2[4]);



//        for (Produto p: carrinhoAtualUsuario) {
//            System.out.println("produto aqui Carrinho: "+ p.getTextoProduto() + p.getQuantidadeProduto());
//        }
    }
}
