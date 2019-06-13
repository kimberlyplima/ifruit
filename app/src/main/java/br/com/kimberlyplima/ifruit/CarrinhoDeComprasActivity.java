package br.com.kimberlyplima.ifruit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;

public class CarrinhoDeComprasActivity extends AppCompatActivity {

    private ArrayList<Produto> carrinhoAtualUsuario = new ArrayList<>();
    Button btnFinalizarCompra;
    ImageButton btnHome;
    DatabaseReference referenciaBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho_de_compras);


        String carrinhoString = getIntent().getStringExtra("carrinhoEstadoAtual");
        System.out.println("Carrinho que chegou "+carrinhoString);

        String[] array = carrinhoString.split("</produto>");
        for (String s : array) {
            if(!s.equals("".trim())){
                String[] arrayAux = s.split("<separacao>");

                System.out.println("aaaa " + arrayAux[0] + arrayAux[1] + arrayAux[2] + arrayAux[3] + arrayAux[4]);

                carrinhoAtualUsuario.add(new Produto(arrayAux[1],Integer.parseInt(arrayAux[2]), Integer.parseInt(arrayAux[4]), arrayAux[3], Integer.parseInt(arrayAux[0]) ));
            }
        }

        btnFinalizarCompra = findViewById(R.id.btn_finalizar_compra);
        btnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarCompra();
            }
        });

        btnHome = findViewById(R.id.imageButtonHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CarrinhoDeComprasActivity.this , LojaVirtualActivity.class));
            }
        });
        initRecyclerView();


        //referenciaBD = FirebaseDatabase.getInstance().getReference("carrinhos");
    }

    public void aumentarQuantidadeProduto(Produto p){
        System.out.println("entrou produto p ;:" + p.getTextoProduto() + "qtd : " + p.getQuantidadeProduto());
        p.setQuantidadeProduto(p.getQuantidadeProduto() + 1);
    }

    public void diminuirQuantidadeProduto(Produto p){
        p.setQuantidadeProduto(p.getQuantidadeProduto() - 1);
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapterCarrinhoCompras adapter = new RecyclerViewAdapterCarrinhoCompras(this,carrinhoAtualUsuario);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void finalizarCompra(){
        referenciaBD.setValue(carrinhoAtualUsuario);
    }
}
