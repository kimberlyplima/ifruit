package br.com.kimberlyplima.ifruit;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class LojaVirtualActivity extends AppCompatActivity {

    private static final String TAG = "LojaVirtualActivity";

//    private ArrayList<String> imageNames = new ArrayList<>();
//    private ArrayList<String> imageUrls = new ArrayList<>();
    private ArrayList<Produto> listaProdutosLoja = new ArrayList<>();
    private ArrayList<Produto> carrinhoComprasUsuario = new ArrayList<>();
    // public static ArrayList<Produto> carrinhoComprasUsuario = new ArrayList<>();
    //ver a possibilidade do carrinho ser static para ser acessado por todas as activities!!!!!!
    private ImageButton buttonRedirecionarCarrinho;
    private ImageButton buttonRedirecionarPerfilUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_logada);

        Log.d(TAG,"entrou inicio LojaVirtualActivity");

        iniciarLoja();

        //colocar aqui o on click listener do botao que direciona para o carrinho de compras, passando o atual carrinhoComprasUsuario:
        buttonRedirecionarCarrinho = findViewById(R.id.imageButtonCarrinho);
        buttonRedirecionarCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LojaVirtualActivity.this , CarrinhoDeComprasActivity.class);
                intent.putParcelableArrayListExtra("carrinhoEstadoAtual",carrinhoComprasUsuario);
                startActivity(intent);
            }
        });

        buttonRedirecionarPerfilUsuario = findViewById(R.id.imageButtonPerfil);
        buttonRedirecionarPerfilUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LojaVirtualActivity.this , PerfilUsuarioActivity.class));
            }
        });
    }

    private void iniciarLoja() {
        int cont = 0;
        Produto produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("Bananas");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("Maçãs");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("14");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("12");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("1");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("2");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("3");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("4");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto();
        produto.setQuantidadeProduto(1);
        produto.setTextoProduto("5");
        produto.setValorProduto(60);
        produto.setUrlImagemProduto("https://i.imgur.com/ZcLLrkY.jpg");
        produto.setId(cont++);
        listaProdutosLoja.add(produto);




        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,listaProdutosLoja);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        verificaCarrinhoUsuario(adapter);
    }

    private void verificaCarrinhoUsuario(RecyclerViewAdapter adapter) {
        for(int i = 0 ; i < listaProdutosLoja.size() ; i++){
            if (carrinhoComprasUsuario.contains(listaProdutosLoja.get(i))){
                //desabilitar o botao assim que carregar a loja baseado no carrinho do usuario
            }
        }
    }

    public void adicionarProdutoCarrinho(Produto produtoAdicionarCarrinho){
        carrinhoComprasUsuario.add(produtoAdicionarCarrinho);
    }
}
