package br.cesjf.lppo;

import java.util.Date;



/**
 *
 * @author Bruna Alves
 */
public class Coleta {
    private int id;
    private String descricao;
    private Date data;

  

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
