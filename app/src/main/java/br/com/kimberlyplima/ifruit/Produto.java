package br.com.kimberlyplima.ifruit;

public class Produto {
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
}
