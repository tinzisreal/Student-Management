package entity;

import java.util.List;

public class Order {
    private String id;
    private String customerName;
    private List<Fruit> listFruit;

    public Order() {
    }

    public Order(String id, String customerName, List<Fruit> listFruit) {
        this.id = id;
        this.customerName = customerName;
        this.listFruit = listFruit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Fruit> getListFruit() {
        return listFruit;
    }

    public void setListFruit(List<Fruit> listFruit) {
        this.listFruit = listFruit;
    }
}
