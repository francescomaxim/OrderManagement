package model;
public class Client {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private Integer age;

    public Client() {
    }

    public Client(int id, String name, String address, String email, int age) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public Client(String name, String address, String email, Integer age) {
        super();
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", age=" + age
                + "]";
    }
    /***
     * metoda ce ne ajuta la creearea headerului tabelului
     * @return
     */
    public Object[] toRow() {
        return new String[]{this.getId().toString(), this.getName(), this.getAddress(), this.getEmail(), this.getAge().toString()};
    }

}
