package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import dao.ComenziDAO;
import dao.ProductDAO;
import model.Client;
import model.Comenzi;
import model.Product;
public class ComenziBLL {

    private ComenziDAO comenziDAO;

    public ComenziBLL() {
        comenziDAO = new ComenziDAO();
    }

    /***
     * metoda specifica pentru comenzi ce apeleaza insert din abstract dao;
     */
    public void insert(Client x, Product y, int quantity) {
        ProductBLL productBLL = new ProductBLL();
        int z = y.getQuantity() - quantity;
        String a = String.valueOf(z);
        productBLL.update(y.getId(),"quantity",a);
        Comenzi comenzi = new Comenzi(x.getName(), y.getName(), quantity);
        comenziDAO.insertNewOrder(comenzi);
    }

    /***
     * metoda specifica pentru comenzi ce apeleaza delete din abstract dao;
     */
    public void deleteOrderById(int id) {
        comenziDAO.deleteById(id);
    }

    /***
     * metoda specifica pentru comenzi ce apeleaza update din abstract dao;
     */
    public void update(int id,String s1, String s2) {
        StringBuilder x = new StringBuilder();
        x.append(" " + s1 + "=\"" + s2 + "\"");
        comenziDAO.updateById(id,x.toString());
    }
    /***
     * metoda specifica pentru comenzi ce apeleaza findByID din abstract dao;
     */
    public Comenzi findComandaById(int id) {
        Comenzi st = comenziDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return st;
    }

    /***
     * metoda specifica pentru comenzi ce apeleaza findall-ul din abstract dao;
     */
    public List<Comenzi> findAll() {
        List<Comenzi> st = comenziDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("Something went wrong!!");
        }
        return st;
    }

}
