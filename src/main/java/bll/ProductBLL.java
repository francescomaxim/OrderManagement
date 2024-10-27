package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import dao.ProductDAO;
import model.Product;
public class ProductBLL {

    private ProductDAO productDAO;

    public ProductBLL() {
        productDAO = new ProductDAO();
    }

    /***
     * metoda specifica pentru product ce apeleaza insert-ul din AbstractDAO
     * @param newProduct
     */
    public void insert(Product newProduct) {
//        StringBuilder s = new StringBuilder();
//        s.append(newProduct.getId() + ",\"" + newProduct.getName() + "\"," + newProduct.getPrice() + "," + newProduct.getQuantity());
//        String value = s.toString();
//        System.out.println(value);
//        productDAO.insertTest(value);
        productDAO.insertTest(newProduct);
    }
    /***
     * metoda specifica pentru product ce apeleaza delete-ul din AbstractDAO
     */
    public void deleteProductById(int id) {
        productDAO.deleteById(id);
    }

    /***
     * metoda specifica pentru product ce apeleaza update-ul din AbstractDAO
     */
    public void update(int id,String s1, String s2) {
        StringBuilder x = new StringBuilder();
        x.append(" " + s1 + "=\"" + s2 + "\"");
        productDAO.updateById(id,x.toString());
    }
    /***
     * metoda specifica pentru product ce apeleaza findById-ul din AbstractDAO
     */
    public Product findProductById(int id) {
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return st;
    }

    /***
     * metoda specifica pentru product ce apeleaza findall-ul din AbstractDAO
     */
    public List<Product> findAll() {
        List<Product> st = productDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("Something went wrong!!");
        }
        return st;
    }

}
