/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Armazem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Igor Ferrani
 */
public class ArmazemPersistencia {
    
    public ArrayList selectAllRecords() throws Exception{
        Statement stmt = null;
        java.sql.Connection con = null;
        ArrayList list = new ArrayList();
        try {
            ConnectionBd connectionBd = new ConnectionBd();
            con = connectionBd.getConnection();
            
            String sql = "SELECT * FROM armazem";
            
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Armazem armazem = new Armazem();
                armazem.setCodArmazem(rs.getInt("codArmazem"));
                armazem.setNomArmazem(rs.getString("nomArmazem"));
                list.add(armazem);
            }
            rs.close();
            stmt.close();
            con.close();
            
            return list;
            
        } catch (SQLException e){
            throw new Exception(">> Error SQLException (ArmazemPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception(">> Error Exception (ArmazemPersistencia): " + e.getMessage());
        }
    }
}
