package br.com.kimberlyplima.ifruit;

import android.os.Parcel;

public class Produto{
    private String textoProduto;
    private int quantidadeProduto;
    private int valorProduto;
    private String urlImagemProduto;
    private int id;

    public Produto( String textoProduto,
            int quantidadeProduto,
            int valorProduto,
            String urlImagemProduto,
            int id) {
        this.textoProduto = textoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
        this.urlImagemProduto = urlImagemProduto;
        this.id = id;

    }

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
        if(quantidadeProduto >= 1){
            this.quantidadeProduto = quantidadeProduto;
        } else {
            // Verificar se precisa lançar exceção
            System.out.println("Valor deve ser positivo!");
        }
    }

    public int getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(int valorProduto) {
        this.valorProduto = valorProduto;
    }
}
