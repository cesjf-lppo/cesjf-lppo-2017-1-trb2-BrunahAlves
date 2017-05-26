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

    public LeituraDAO() throws Exception {

        Connection conexao = ConnectionFactory.createConnection();
        opNovaLeitura = conexao.prepareStatement("INSERT INTO Leitura(unidade, loca) VALUES(?,?)");
        opBuscaPorLeituraColeta = conexao.prepareStatement("SELECT * FROM Leitura WHERE coleta = ?");
        opBuscaPorLocal = conexao.prepareStatement("SELECT coleta,loca FROM Leitura GROUP BY coleta");

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

            ResultSet resultado = opBuscaPorLeituraColeta.executeQuery();

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
}
