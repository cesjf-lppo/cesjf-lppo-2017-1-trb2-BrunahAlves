package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColetaDAO {

    private final PreparedStatement opNovaColeta;
    private final PreparedStatement opListarColeta;

    public ColetaDAO() throws Exception {

        Connection conexao = ConnectionFactory.createConnection();
        opNovaColeta = conexao.prepareStatement("INSERT INTO Coleta(descricao, dat) VALUES(?,?)");
        opListarColeta = conexao.prepareStatement("SELECT id, descricao,dat FROM Coleta");

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

    public List<Coleta> listByColeta() throws Exception {
        try {
            List<Coleta> coleta = new ArrayList<>();

            ResultSet resultado = opListarColeta.executeQuery();

            while (resultado.next()) {
               Coleta novaColeta = new Coleta();
                     
                novaColeta.setId(resultado.getInt("id"));
                novaColeta.setDescricao(resultado.getString("descricao"));
                novaColeta.setData(resultado.getTimestamp("dat"));
                coleta.add(novaColeta);
            }
            return coleta;

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar as coletas no banco!", ex);
        }
    
    }
}
