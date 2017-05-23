package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alunoces
 */
public class LeituraDAO {
     private final PreparedStatement opNovaLeitura;

    public LeituraDAO() throws Exception {

        Connection conexao = ConnectionFactory.createConnection();
        opNovaLeitura = conexao.prepareStatement("INSERT INTO Leitura(unidade, local) VALUES(?,?)");

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
}
