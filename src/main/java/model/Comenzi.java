package model;

public class Comenzi {
    private Integer id;
    private String client;
    private String product;
    private Integer quantity;

    public Comenzi(Integer id, String client, String produs, Integer quantity) {
        this.id = id;
        this.client = client;
        this.product = produs;
        this.quantity = quantity;
    }

    public Comenzi(String client, String produs, Integer quantity) {
        this.client = client;
        this.product = produs;
        this.quantity = quantity;
    }

    public Comenzi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /***
     * metoda ce ne ajuta la creearea headerului tabelului
     * @return
     */
    public Object[] toRow(){
        return new String[]{this.id.toString(), this.client, this.product, this.quantity.toString()};
    }
}
