package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColetaDAO {

    private final PreparedStatement opNovaColeta;

    public ColetaDAO() throws Exception {

        Connection conexao = ConnectionFactory.createConnection();
        opNovaColeta = conexao.prepareStatement("INSERT INTO Coleta(descricao, dat) VALUES(?,?)");

    }

    public void cria(Coleta novaColeta) throws Exception {
        try {
            opNovaColeta.clearParameters();
            opNovaColeta.setString(1, novaColeta.getDescricao());
            opNovaColeta.setDate(2, (Date) novaColeta.getData());
            opNovaColeta.executeUpdate();
            System.out.println("teste" + novaColeta.getData());
        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir nova Coleta!", ex);
        }
    }
}
