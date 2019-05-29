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
        //quantidade sempre 1 na loja virtual!
        int cont = 0;
        Produto produto;
        produto = new Produto("Maças",1,60,
                "https://static3.tcdn.com.br/img/img_prod/450860/muda_de_maca_gala_climas_frios_ou_amenos_1m_enxertadas_566_1_20160122151735.jpg",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Bananas",1,90,
                "https://www.infoescola.com/wp-content/uploads/2010/04/banana_600797891.jpg",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Jaboticaba",1,80,
                "data:image/jpeg;base64,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",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Pera",1,100,
                "https://static3.tcdn.com.br/img/img_prod/450860/muda_de_pera_d_agua_ou_europeia_1m_enxertada_676_1_20160122173052.jpg",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Goiaba",1,40,
                "https://muffatosupermercados.vteximg.com.br/arquivos/ids/246437-400-400/0000000000857.jpg?v=636809240498000000",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Uva",1,60,
                "http://www.caminhodovinho.tur.br/wp-content/uploads/2016/03/Os-benef%C3%ADcios-do-consumo-di%C3%A1rio-de-uvas-caminho-do-vinho.jpg",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Morango",1,95,
                "https://i0.wp.com/biosom.com.br/blog/wp-content/uploads/2016/02/morango.jpg?ssl=1",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Melao",1,95,
                "https://www.mundoboaforma.com.br/wp-content/uploads/2016/02/melo-620x330.jpg",cont++);
        listaProdutosLoja.add(produto);

        produto = new Produto("Tomate",1,95,
                "https://www.infoescola.com/wp-content/uploads/2011/01/tomate_345187874.jpg",cont++);
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
