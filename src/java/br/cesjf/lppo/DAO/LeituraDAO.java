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

    public LeituraDAO() throws Exception {

        Connection conexao = ConnectionFactory.createConnection();
        opNovaLeitura = conexao.prepareStatement("INSERT INTO Leitura(unidade, local) VALUES(?,?)");
        opBuscaPorLeituraColeta = conexao.prepareStatement("SELECT * FROM Leitura WHERE coleta = ?");

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

    public List<Leitura> listByLeituradaColeta(int id) throws Exception {
        try {
            List<Leitura> LeituraColeta = new ArrayList<>();

        //    opBuscaPorLeituraColeta.setInt(1, coleta); verificar
            ResultSet resultado = opBuscaPorLeituraColeta.executeQuery();

            while (resultado.next()) {
                Leitura leituraColeta = new Leitura();

                leituraColeta.setId(resultado.getLong("id"));
                leituraColeta.setColeta(resultado.getInt("coleta"));
                leituraColeta.setLocal(resultado.getString("local"));
                leituraColeta.setLeitura(resultado.getFloat("leitura"));
                leituraColeta.setUnidade(resultado.getString("unidade"));
                leituraColeta.setAtualizacao(resultado.getTimestamp("atualizacao"));
                //leituracoleta.add(leituraColeta); verificar
            }

            // return leituracoleta;
            return null;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar os pedidos no banco!", ex);
        }

    }

    public List<Leitura> listByLocal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
