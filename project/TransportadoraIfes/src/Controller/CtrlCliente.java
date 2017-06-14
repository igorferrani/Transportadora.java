/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.HashMap;
import Model.Cliente;
import persistencia.ClientePersistencia;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlCliente {
    
    public HashMap novoCliente() throws Exception{
        HashMap<String, String> ret = new HashMap();
        try {
            ClientePersistencia clientePersistencia = new ClientePersistencia();
            Cliente cliente = new Cliente();
            cliente.setNomCliente("Igor");
            if(clientePersistencia.insereCliente(cliente)){
                ret.put("success", "ok");
                ret.put("message", "Novo cliente inserido com sucesso");
            } else {
                ret.put("success", "failed");
                ret.put("message", "Não foi possível inserir o novo cliente");
            }
            return ret;
        } catch (Exception e){
            ret.put("success", "error");
            ret.put("message", e.getMessage());
            return ret;
        }
    }
}
