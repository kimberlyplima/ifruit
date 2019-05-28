package br.com.kimberlyplima.ifruit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterCarrinhoCompras extends RecyclerView.Adapter<RecyclerViewAdapterCarrinhoCompras.ViewHolder> {

    private ArrayList<Produto> carrinhoComprasUsuario;
    private Context mContext;

    public RecyclerViewAdapterCarrinhoCompras(Context mContext, ArrayList<Produto> carrinhoComprasUsuario) {
        this.mContext = mContext;
        this.carrinhoComprasUsuario = carrinhoComprasUsuario;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listcesta,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(carrinhoComprasUsuario.get(position).getUrlImagemProduto())
                .into(holder.image);

        holder.descricaoCombo.setText(carrinhoComprasUsuario.get(position).getTextoProduto());

        holder.quantidade.setText(carrinhoComprasUsuario.get(position).getQuantidadeProduto() + "");

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, carrinhoComprasUsuario.get(position).getTextoProduto(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return carrinhoComprasUsuario.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView descricaoCombo;
        RelativeLayout parentLayout;
        ImageView imagePlus;
        ImageView imageMinus;
        TextView quantidade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMinus = itemView.findViewById(R.id.imageMinus);
            quantidade = itemView.findViewById(R.id.quantidade);
            imagePlus = itemView.findViewById(R.id.imagePlus);
            image = itemView.findViewById(R.id.image);
            descricaoCombo = itemView.findViewById(R.id.descricao_combo);
            parentLayout = itemView.findViewById(R.id.parent_layout_carrinho);
        }
    }
}
