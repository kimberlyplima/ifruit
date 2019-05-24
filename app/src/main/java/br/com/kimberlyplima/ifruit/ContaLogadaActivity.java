package br.com.kimberlyplima.ifruit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ContaLogadaActivity extends AppCompatActivity {

    private static final String TAG = "ContaLogadaActivity";

//    private ArrayList<String> imageNames = new ArrayList<>();
//    private ArrayList<String> imageUrls = new ArrayList<>();
    private ArrayList<Produto> listaProdutosLoja = new ArrayList<>();
    private ArrayList<Produto> carrinhoComprasUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_logada);

        Log.d(TAG,"entrou inicio ContaLogadaActivity");

        iniciarLoja();
    }

    private void iniciarLoja() {
        Produto produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("Bananas");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("Maçãs");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        listaProdutosLoja.add(produto);




        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,listaProdutosLoja);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void adicionarProdutoCarrinho(Produto produtoAdicionarCarrinho){
        carrinhoComprasUsuario.add(produtoAdicionarCarrinho);
    }
}
