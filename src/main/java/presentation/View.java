package presentation;

import bll.ClientBLL;
import bll.ComenziBLL;
import bll.ProductBLL;
import com.itextpdf.text.DocumentException;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import model.Bill;
import model.Client;
import model.Comenzi;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame implements ActionListener {
    JTable table;
    JFrame frame;
    JButton clientButton;
    JButton productButton;
    JButton orderButton;
    JLabel deleteLable;
    JLabel idDeleteLable;
    JTextField deleteTextField;
    JButton deleteButton;

    JLabel updateLable;
    JLabel idUpdate1Lable;
    JTextField update1TextField;
    JLabel idUpdate2Lable;
    JLabel idUpdate3Lable;
    JTextField getUpdate3TextField ;
    JTextField update2TextField;
    JTextField update3TextField;
    JButton updateButton;

    JLabel addNewLable;
    JLabel idNewLable;
    JLabel c1;
    JLabel c2;
    JLabel c3;
    JLabel c4;
    JLabel c5;
    JTextField x1,x2,x3,x4,x5;
    int index = 0;


    JButton insertButton;
    DefaultTableModel model;


    public View(){
        frame = new JFrame("Maxim Francesco");
        frame.setLayout(null);

        insertButton = new JButton("Insert New Client");
        insertButton.setBounds(400,460,200,30);
        insertButton.addActionListener(this);
        frame.add(insertButton);

        addNewLable = new JLabel("Add New Client");
        addNewLable.setBounds(460,370,200,30);
        frame.add(addNewLable);

        x1 = new JTextField();
        x1.setBounds(270,425,30,20);
        frame.add(x1);

        x2 = new JTextField();
        x2.setBounds(350,425,80,20);
        frame.add(x2);

        x3 = new JTextField();
        x3.setBounds(520,425,120,20);
        frame.add(x3);

        x4 = new JTextField();
        x4.setBounds(700,425,120,20);
        frame.add(x4);

        x5 = new JTextField();
        x5.setBounds(230,425,20,20);
        frame.add(x5);

        c1 = new JLabel("ID :");
        c1.setBounds(250,420,100,30);
        frame.add(c1);

        c2 = new JLabel("Name :");
        c2.setBounds(300,420,100,30);
        frame.add(c2);

        c3 = new JLabel("Address :");
        c3.setBounds(450,420,100,30);
        frame.add(c3);

        c4 = new JLabel("Email :");
        c4.setBounds(650,420,100,30);
        frame.add(c4);

        c5 = new JLabel("Age :");
        c5.setBounds(200,420,100,30);
        frame.add(c5);

        updateLable = new JLabel("Update Client");
        updateLable.setBounds(860,370,200,30);
        frame.add(updateLable);

        idUpdate1Lable = new JLabel("ID Client : ");
        idUpdate1Lable.setBounds(830,390,200,30);
        frame.add(idUpdate1Lable);

        update1TextField = new JTextField();
        update1TextField.setBounds(900,397,70,20);
        frame.add(update1TextField);

        update2TextField = new JTextField();
        update2TextField.setBounds(885,422,70,20);
        frame.add(update2TextField);

        idUpdate2Lable = new JLabel("Update : ");
        idUpdate2Lable.setBounds(830,415,200,30);
        frame.add(idUpdate2Lable);

        update3TextField = new JTextField();
        update3TextField.setBounds(885,447,70,20);
        frame.add(update3TextField);

        idUpdate3Lable = new JLabel("Field : ");
        idUpdate3Lable.setBounds(830,440,200,30);
        frame.add(idUpdate3Lable);


        updateButton = new JButton("update");
        updateButton.setBounds(860,470,80,30);
        updateButton.addActionListener(this);
        frame.add(updateButton);

        deleteButton = new JButton("delete");
        deleteButton.setBounds(60,455,80,30);
        deleteButton.addActionListener(this);
        frame.add(deleteButton);

        deleteTextField = new JTextField();
        deleteTextField.setBounds(95,417,70,20);
        frame.add(deleteTextField);

        idDeleteLable = new JLabel("ID Client : ");
        idDeleteLable.setBounds(30,410,200,30);
        frame.add(idDeleteLable);

        deleteLable = new JLabel("Delete Client");
        deleteLable.setBounds(60,370,200,30);
        frame.add(deleteLable);

        model = new DefaultTableModel();

        table = new JTable(model);
        table.setBounds(0,0,600,300);
        table.disable();
        retrieveProperties(new Client());


        ClientBLL clientBLL = new ClientBLL();
        List<Client> clientList = clientBLL.findAll();
        for(Client c: clientList){
            String[] s = (String[]) c.toRow();
            for(String s1: s)
                System.out.println(s1);
            System.out.println("" +
                    "\n");
            model.insertRow(model.getRowCount(), c.toRow());
        }


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100,50,800,300);
        scrollPane.setVisible(true);
        frame.add(scrollPane);

        //scrollPane.setVisible(false);

        clientButton = new JButton("Client");
        clientButton.setBounds(0,0,100,30);
        clientButton.addActionListener(this);
        frame.add(clientButton);

        productButton = new JButton("Product");
        productButton.setBounds(100,0,100,30);
        productButton.addActionListener(this);
        frame.add(productButton);

        orderButton = new JButton("Order");
        orderButton.setBounds(200,0,100,30);
        orderButton.addActionListener(this);
        frame.add(orderButton);

        frame.setSize(1000,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    /***
     * metoda ce primeste o lista de obiecte si imi seteaza header-ul tabelului prin reflection
     * @param *obiecte
     */
    public void retrieveProperties(Object object) {
       // System.out.println(object.getClass().getName());
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
//                table.addColumn(new TableColumn(0,field.getName()));
                model.addColumn(field.getName());

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    /***
     * metoda action listener
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == productButton){
            c2.setText("Name:");
            c1.setText("ID:");
            c4.setVisible(true);
            x4.setVisible(true);
            c5.setVisible(true);
            x5.setVisible(true);
            index = 1;
            deleteLable.setText("Delete Product");
            idDeleteLable.setText("ID Product: ");

            model = new DefaultTableModel();
            table.setModel(model);
            retrieveProperties(new Product());

            ProductBLL productBLL = new ProductBLL();
            List<Product> productList = productBLL.findAll();

            for(Product c: productList){
//            System.out.println(c);
                String[] s = (String[]) c.toRow();
                model.insertRow(model.getRowCount(), c.toRow());
            }


            addNewLable.setText("Add New Product");
            c5.hide();
            x5.hide();
            c3.setText("Price:");
            c4.setText("Quantity");
            insertButton.setText("Add New Product");

            updateLable.setText("Update Product");
            idUpdate1Lable.setText("ID Product:");

        }

        if(e.getSource() == orderButton){
            index = 2;
            deleteLable.setText("Delete Order");
            idDeleteLable.setText("ID Order:");

            addNewLable.setText("Add New Order");
            c1.setText("NR:");

            c3.setText("Produs ID:");
            c4.hide();
            x4.hide();
            c5.hide();
            x5.hide();

            c2.setText("Client ID:");

            insertButton.setText("Place New Order");

            updateLable.setText("Update Order");
            idUpdate1Lable.setText("ID Order");


            model = new DefaultTableModel();
            table.setModel(model);
            retrieveProperties(new Comenzi());

            ComenziBLL comenziBLL = new ComenziBLL();
            List<Comenzi> comenziList = comenziBLL.findAll();

            for(Comenzi c: comenziList){
                String[] s = (String[]) c.toRow();
                model.insertRow(model.getRowCount(), c.toRow());
            }

        }

        if(e.getSource() == clientButton){
            c2.setText("Name:");
            c1.setText("ID:");
            c4.setVisible(true);
            x4.setVisible(true);
            c5.setVisible(true);
            x5.setVisible(true);
            index = 0;
            deleteLable.setText("Delete Client");
            idDeleteLable.setText("ID Client: ");

            addNewLable.setText("Add New Client");
            c5.setVisible(true);
            x5.setVisible(true);
            c3.setText("Address:");
            c4.setText("Email:");
            insertButton.setText("Add New Client");

            updateLable.setText("Update Client");
            idUpdate1Lable.setText("ID Client:");

            model = new DefaultTableModel();
            table.setModel(model);
            retrieveProperties(new Client());

            ClientBLL clientBLL = new ClientBLL();
            List<Client> clientList = clientBLL.findAll();

            for(Client c: clientList){
                String[] s = (String[]) c.toRow();
                model.insertRow(model.getRowCount(), c.toRow());
            }

        }
        if(e.getSource() == deleteButton){
            String input1 = deleteTextField.getText();
            int inp = Integer.parseInt(input1);
            if(index == 0){
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.deleteClientById(inp);
                model = new DefaultTableModel();
                table.setModel(model);
                retrieveProperties(new Client());


                List<Client> clientList = clientBLL.findAll();

                for(Client c: clientList){
                    String[] s = (String[]) c.toRow();
                    model.insertRow(model.getRowCount(), c.toRow());
                }
            }else{
                if(index == 1){
                    ProductBLL productBLL = new ProductBLL();
                    productBLL.deleteProductById(inp);
                    model = new DefaultTableModel();
                    table.setModel(model);
                    retrieveProperties(new Client());
                    List<Product> productList = productBLL.findAll();

                    for(Product c: productList){
                        String[] s = (String[]) c.toRow();
                        model.insertRow(model.getRowCount(), c.toRow());
                    }
                }else{
                    if(index == 2){
                        ComenziBLL comenziBLL = new ComenziBLL();
                        comenziBLL.deleteOrderById(inp);
                        model = new DefaultTableModel();
                        table.setModel(model);
                        retrieveProperties(new Comenzi());
                        List<Comenzi> comenziList = comenziBLL.findAll();

                        for(Comenzi c: comenziList){
                            String[] s = (String[]) c.toRow();
                            model.insertRow(model.getRowCount(), c.toRow());
                        }
                    }
                }
            }
        }
        if(e.getSource() == updateButton){
            String input1 = update1TextField.getText();
            int inp = Integer.parseInt(input1);
            String input2 = update2TextField.getText();
            String input3 = update3TextField.getText();
            if(index == 0){
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.update(inp,input2,input3);
                model = new DefaultTableModel();
                table.setModel(model);
                retrieveProperties(new Client());
                List<Client> clientList = clientBLL.findAll();
                for(Client c: clientList){
                    String[] s = (String[]) c.toRow();
                    model.insertRow(model.getRowCount(), c.toRow());
                }
            }else{
                if(index == 1){
                    ProductBLL productBLL = new ProductBLL();
                    productBLL.update(inp,input2,input3);
                    model = new DefaultTableModel();
                    table.setModel(model);
                    retrieveProperties(new Product());
                    List<Product> productList = productBLL.findAll();
                    for(Product c: productList){
                        String[] s = (String[]) c.toRow();
                        model.insertRow(model.getRowCount(), c.toRow());
                    }
                }else{
                    if(index == 2){
                        ComenziBLL comenziBLL = new ComenziBLL();
                        comenziBLL.update(inp,input2,input3);
                        model = new DefaultTableModel();
                        table.setModel(model);
                        retrieveProperties(new Comenzi());
                        List<Comenzi> comenziList = comenziBLL.findAll();
                        for(Comenzi c: comenziList){
                            String[] s = (String[]) c.toRow();
                            model.insertRow(model.getRowCount(), c.toRow());
                        }
                    }
                }
            }
        }
        if(e.getSource() == insertButton){
            System.out.println("sunt aici");
            String input1 = x1.getText();
            int inp = Integer.parseInt(input1);
            String input2 = x2.getText();
            String input3 = x3.getText();
            String input4;
            int inp2 = 0;
            if(index == 0){
                input4 = x4.getText();
                String input5 = x5.getText();
                inp2 = Integer.parseInt(input5);
                ClientBLL clientBLL = new ClientBLL();
                Client client = new Client(inp, input2, input3,input4, inp2);
                clientBLL.insert(client);
                model = new DefaultTableModel();
                table.setModel(model);
                retrieveProperties(new Client());
                List<Client> clientList = clientBLL.findAll();
                for(Client c: clientList){
                    String[] s = (String[]) c.toRow();
                    model.insertRow(model.getRowCount(), c.toRow());
                }

            }else{
                if(index == 1) {
                    input4 = x4.getText();
                    ProductBLL productBLL = new ProductBLL();
                    Product product = new Product(inp, input2, Integer.parseInt(input3), Integer.parseInt(input4));
                    productBLL.insert(product);
                    model = new DefaultTableModel();
                    table.setModel(model);
                    retrieveProperties(new Product());
                    List<Product> productList = productBLL.findAll();
                    for (Product c : productList) {
                        String[] s = (String[]) c.toRow();
                        model.insertRow(model.getRowCount(), c.toRow());
                    }
                }else{
                    if(index == 2){
                        ComenziBLL comenziBLL = new ComenziBLL();
                        ProductBLL productBLL = new ProductBLL();
                        ClientBLL clientBLL = new ClientBLL();
                        Client x = clientBLL.findClientById(Integer.parseInt(input2));
                        System.out.println("AICI1:" + x);
                        Product y = productBLL.findProductById(Integer.parseInt(input3));
                        System.out.println("AICI2:" + y);
                        int valid = y.getQuantity() - inp;
                        if(valid > 0) {
                            comenziBLL.insert(x, y, inp);
                            model = new DefaultTableModel();
                            table.setModel(model);
                            retrieveProperties(new Comenzi());
                            List<Comenzi> comenziList = comenziBLL.findAll();
                            for (Comenzi c : comenziList) {
                                String[] s = (String[]) c.toRow();
                                model.insertRow(model.getRowCount(), c.toRow());
                            }
                            try {
                                Bill bill = new Bill(x, y, inp);
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            } catch (DocumentException ex) {
                                throw new RuntimeException(ex);
                            }
                        }else{

                        }
                    }
                }
            }

        }
    }
}

