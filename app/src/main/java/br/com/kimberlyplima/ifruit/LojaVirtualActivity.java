package br.com.kimberlyplima.ifruit;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class LojaVirtualActivity extends AppCompatActivity {

    private static final String TAG = "LojaVirtualActivity";

//    private ArrayList<String> imageNames = new ArrayList<>();
//    private ArrayList<String> imageUrls = new ArrayList<>();
    // public static ArrayList<Produto> carrinhoComprasUsuario = new ArrayList<>();
    //ver a possibilidade do carrinho ser static para ser acessado por todas as activities!!!!!!

    private ArrayList<Produto> listaProdutosLoja = new ArrayList<>();
    private ArrayList<Produto> carrinhoComprasUsuario = new ArrayList<>();
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
                intent.putExtra("carrinhoEstadoAtual", customStringify(carrinhoComprasUsuario));
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

    private String customStringify(ArrayList<Produto> carrinhoComprasUsuario) {
        String sb = "";
        for (Produto p: carrinhoComprasUsuario) {
            sb += p.getId() + "<separacao>" + p.getTextoProduto() + "<separacao>" + p.getQuantidadeProduto() + "<separacao>" + p.getUrlImagemProduto() + "<separacao>" + p.getValorProduto()+"</produto>";
        }
        return sb;
    }

    private void iniciarLoja() {
        int cont = 0;
        Produto produto;
        produto = new Produto("Macas",1,60,
                "https://i.imgur.com/ZcLLrkY.jpg",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Bananas",1,90,
                "https://i.imgur.com/ZcLLrkY.jpg",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Teste",1,80,
                "https://i.imgur.com/ZcLLrkY.jpg",cont++);
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
        System.out.println("Produto adicionado : "+ produtoAdicionarCarrinho.getTextoProduto() + " quantidade : " + produtoAdicionarCarrinho.getQuantidadeProduto());
        carrinhoComprasUsuario.add(produtoAdicionarCarrinho);
    }
}
