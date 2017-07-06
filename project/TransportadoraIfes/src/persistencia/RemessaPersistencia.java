/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Remessa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class RemessaPersistencia {
    
    public int insertRecord(Remessa remessa, java.sql.Connection con) throws Exception{
        int codRemessa = 0;
        try {
            String insertRemessa = "INSERT INTO remessa VALUES(0, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertRemessa, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, remessa.getCodViagem());
            stmt.setInt(2, remessa.getCodDeposito());
            stmt.setString(3, remessa.getNumRemessa());
            stmt.setString(4, remessa.getDataEntrega() + " " + remessa.getHoraEntrega());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                codRemessa = generatedKeys.getInt(1);
            
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
        return codRemessa;
    }
}
