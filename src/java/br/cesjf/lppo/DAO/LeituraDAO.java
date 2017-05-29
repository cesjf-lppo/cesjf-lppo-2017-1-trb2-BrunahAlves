package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alunoces
 */
public class LeituraDAO {

    private final PreparedStatement opNovaLeitura;
    private final PreparedStatement opBuscaPorLeituraColeta;
    private final PreparedStatement opBuscaPorLocal;
    private final PreparedStatement opBuscaPorLeitura;

    public LeituraDAO() throws Exception {

        Connection conexao = ConnectionFactory.createConnection();
        opNovaLeitura = conexao.prepareStatement("INSERT INTO Leitura(unidade, loca) VALUES(?,?)");
        opBuscaPorLeituraColeta = conexao.prepareStatement("SELECT * FROM Leitura WHERE coleta = ?");
        opBuscaPorLocal = conexao.prepareStatement("SELECT * FROM Leitura");
        opBuscaPorLeitura = conexao.prepareStatement("SELECT * FROM Leitura WHERE id= ?");

    }

    public void cria(Leitura novaLeitura) throws Exception {
        try {
            opNovaLeitura.clearParameters();
            opNovaLeitura.setString(1, novaLeitura.getUnidade());
            opNovaLeitura.setString(2, novaLeitura.getLocal());
            opNovaLeitura.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir nova Leitura!", ex);
        }
    }

    public List<Leitura> listByLeituradaColeta(Integer id) throws Exception {
        try {
            List<Leitura> listaLeituraColeta = new ArrayList<>();

            opBuscaPorLeituraColeta.setInt(1, id);
            ResultSet resultado = opBuscaPorLeituraColeta.executeQuery();

            while (resultado.next()) {
                Leitura leituraColeta = new Leitura();

                leituraColeta.setId(resultado.getInt("id"));
                leituraColeta.setColeta(resultado.getInt("coleta"));
                leituraColeta.setLocal(resultado.getString("loca"));
                leituraColeta.setLeitura(resultado.getFloat("leitura"));
                leituraColeta.setUnidade(resultado.getString("unidade"));
                leituraColeta.setAtualizacao(resultado.getTimestamp("atualizacao"));
                listaLeituraColeta.add(leituraColeta);
            }

             return listaLeituraColeta;

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar as leituras no banco!", ex);
        }

    }

    public List<Leitura> listByLocal() throws Exception {
         try {
            List<Leitura> listaPorLocal = new ArrayList<>();

            ResultSet resultado = opBuscaPorLocal.executeQuery();

            while (resultado.next()) {
                Leitura coletaPorLocal = new Leitura();

                coletaPorLocal.setColeta(resultado.getInt("coleta"));
                coletaPorLocal.setLocal(resultado.getString("loca"));

                listaPorLocal.add(coletaPorLocal);
            }

             return listaPorLocal;

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar as leituras no banco!", ex);
        }
    }

    public Leitura getByLeitura(Integer id) throws Exception {
        try {
            Leitura leitura = null;
            opBuscaPorLeitura.clearParameters();
            opBuscaPorLeitura.setInt(1, id);

            ResultSet resultado = opBuscaPorLeitura.executeQuery();

            if (resultado.next()) {
                leitura = new Leitura();

                leitura.setId(resultado.getInt("id"));
                leitura.setColeta(resultado.getInt("coleta"));
                leitura.setLocal(resultado.getString("loca"));
                leitura.setLeitura(resultado.getFloat("leitura"));
                leitura.setUnidade(resultado.getString("unidade"));
                leitura.setAtualizacao(resultado.getTimestamp("atualizacao"));
            }
            return leitura;

        } catch (SQLException ex) {
            throw new Exception("Erro ao buscar os pedidos no banco!", ex);
        }
        
    }
}
