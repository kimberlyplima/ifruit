package br.com.kimberlyplima.ifruit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Produto> listaProdutosLoja;
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<Produto> listaProdutosLoja) {
        this.mContext = mContext;
        this.listaProdutosLoja = listaProdutosLoja;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder called.");

        Glide.with(mContext)
                .asBitmap()
                .load(listaProdutosLoja.get(position).getUrlImagemProduto())
                .into(holder.image);

        holder.imageName.setText(listaProdutosLoja.get(position).getTextoProduto());

        holder.textoValor.setText("R$: "+listaProdutosLoja.get(position).getValorProduto()+",00");

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, listaProdutosLoja.get(position).getTextoProduto(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mContext instanceof LojaVirtualActivity){
                    Toast.makeText(mContext, "Produto " + listaProdutosLoja.get(position).getTextoProduto() + " adicionado ao carrinho", Toast.LENGTH_SHORT).show();
                    ((LojaVirtualActivity) mContext).adicionarProdutoCarrinho(listaProdutosLoja.get(position));
                    holder.btnAddCart.setEnabled(false);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProdutosLoja.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        Button btnAddCart;
        TextView textoValor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            btnAddCart = itemView.findViewById(R.id.btn_add_cart);
            textoValor = itemView.findViewById(R.id.texto_valor);
        }
    }
}
