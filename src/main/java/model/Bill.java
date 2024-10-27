package model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class Bill {
    private int id;
    private Client client;
    private Product product;
    private int quantity;


    public Bill(int id, Client client, Product productList) throws FileNotFoundException, DocumentException {
        this.id = id;
        this.client = client;
        this.product = product;
    }
    public Bill(){

    }
    public Bill(Client client, Product productList, int quantity) throws FileNotFoundException, DocumentException {
        this.client = client;
        this.product = productList;
        this.quantity = quantity;
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Paragraph s = new Paragraph("Client Name: " + client.getName());
        s.add(new Chunk("\nProduct Name:" + productList.getName()));
        s.add(new Chunk("\nQuantity : " + quantity));
        s.add(new Chunk("\nPrice : " + quantity * productList.getPrice()));
        Chunk chunk = new Chunk(s.toString(), font);

        document.add(s);
        document.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProductList() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", client=" + client +
                ", product=" + product +
                '}';
    }
}
