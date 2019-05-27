package br.com.kimberlyplima.ifruit;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String textoProduto;
    private int quantidadeProduto;
    private int valorProduto;
    private String urlImagemProduto;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImagemProduto() {
        return urlImagemProduto;
    }

    public void setUrlImagemProduto(String urlImagemProduto) {
        this.urlImagemProduto = urlImagemProduto;
    }

    public String getTextoProduto() {
        return textoProduto;
    }

    public void setTextoProduto(String textoProduto) {
        this.textoProduto = textoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(int valorProduto) {
        this.valorProduto = valorProduto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(valorProduto);
        dest.writeString(textoProduto);
        dest.writeInt(quantidadeProduto);
        dest.writeString(urlImagemProduto);
        dest.writeInt(id);
    }
}
