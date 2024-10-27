package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import dao.ClientDAO;
import model.Client;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ClientBLL {
    private ClientDAO clientDAO;

    public ClientBLL() {
        clientDAO = new ClientDAO();
    }

    /***
     * metoda specifica pentru client ce apeleaza insert din abstract dao;
     */
    public void insert(Client newClient) {
//        StringBuilder s = new StringBuilder();
//        s.append(newClient.getId() + ",\"" + newClient.getName() + "\"," + "\"" + newClient.getAddress() + "\"," + "\"" + newClient.getEmail() + "\"," + newClient.getAge());
//        String value = s.toString();
//        System.out.println(value);
        clientDAO.insertTest(newClient);
        //clientDAO.formatForString(newClient);
    }

    /***
     * metoda specifica pentru client ce apeleaza delete din abstract dao;
     */
    public void deleteClientById(int id) {
        clientDAO.deleteById(id);
    }

    /***
     * metoda specifica pentru client ce apeleaza update din abstract dao;
     */
    public void update(int id,String s1, String s2) {
        StringBuilder x = new StringBuilder();
        x.append(" " + s1 + "=\"" + s2 + "\"");
        clientDAO.updateById(id,x.toString());
    }

    /***
     * metoda specifica pentru client ce apeleaza findById din abstract dao;
     */
    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return st;
    }

    /***
     * metoda specifica pentru client ce apeleaza findall-ul din abstract dao;
     */
    public List<Client> findAll() {
        List<Client> st = clientDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("Something went wrong!!");
        }
        return st;
    }

}
