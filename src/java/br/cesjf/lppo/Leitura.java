package br.cesjf.lppo;

import java.util.Date;


/**
 *
 * @author Bruna Alves
 */
public class Leitura {
    private Long id;
    private int coleta;
    private String local;
    private float leitura;
    private String unidade;
    private Date atualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getColeta() {
        return coleta;
    }

    public void setColeta(int coleta) {
        this.coleta = coleta;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public float getLeitura() {
        return leitura;
    }

    public void setLeitura(float leitura) {
        this.leitura = leitura;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }
    
    
    
}
