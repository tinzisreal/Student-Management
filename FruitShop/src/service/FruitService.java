/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Fruit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import utils.Validation;

/**
 *
 * @author lenovo
 */
public class FruitService {

    private final List<Fruit> fruitList = new ArrayList<>();

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public Fruit getFruitById(List<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    public void createFruit() {
        do {
            String fruitId = Validation.getInputString("Nhập mã trái cây (Fruit ID): ", "Mã không được trống!");
            Fruit fruit = getFruitById(fruitList, fruitId);

            if (fruit != null) {
                System.out.println("Mặt hàng này đã tồn tại! Hệ thống sẽ cộng số lượng");
                int quanity = Validation.checkIntegerInRange("so luong", "sai roi", 1, Integer.MAX_VALUE);
                fruit.setQuantity(quanity + fruit.getQuantity());
            } else {
                System.out.println("Mặt hàng này chưa tồn tại");
                String fruitName = Validation.getInputString("Nhap ten mat hang", "loi");
                double price = Validation.checkDoubleInRange("gia tien", "loi", 0, Double.MAX_VALUE);
                int quanity = Validation.checkIntegerInRange("nhap so luong", "sai roi", 1, Integer.MAX_VALUE);
                String origin = Validation.getInputString("nhap xuat xu", "sai roi");
                fruitList.add(new Fruit(fruitId, fruitName, origin, price, quanity));
            }
            System.out.println("Bạn có muốn tiếp tục không");
        } while (Validation.getInputYOrN());
    }

    public void shopping(Hashtable<String, List<Fruit>> ht) {
        if (ht.isEmpty()) {
            System.out.println("Chưa có đơn hàng");
            return;
        }
        for (String name : ht.keySet()) {
            System.out.println("Khách hàng " + name);
            displayOrder(ht.get(name));
            System.out.println("");
        }
    }

    private void displayOrder(List<Fruit> orderList) {
        double total = 0;
        System.out.printf("%-15s | %-10s | %-10s | %-10s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : orderList) {
            double amount = fruit.getPrice() * fruit.getQuantity();
            System.out.printf("%-15s | %-10d | %-10.1f$ | %-10.1f$\n", fruit.getFruitName(),
                    fruit.getQuantity(), fruit.getPrice(), amount);
            total += amount;
        }
        System.out.println("Tổng tiền: " + total + "$");
    }

    public void shopping(Hashtable<String, List<Fruit>> ht) {
        if (fruitList.isEmpty()) {
            System.err.println("Cửa hàng hiện tại đã hết hàng!");
            return;
        }
        
        List<Fruit> orderList = new ArrayList<>();
        do {
            displayListFruit(fruitList);
            int item = Validation.checkIntegerInRange("Chọn sản phẩm muốn mua (theo STT): ", 
                    "Vui lòng chọn đúng STT có trên màn hình!", 1, fruitList.size());
            Fruit fruitSelected = fruitList.get(item - 1);
            
            System.out.println("Bạn đã chọn: " + fruitSelected.getFruitName());
            int quantityBuy = Validation.checkIntegerInRange("Nhập số lượng muốn mua: ", 
                    "Kho chỉ còn " + fruitSelected.getQuantity() + " sản phẩm!", 1, fruitSelected.getQuantity());
            
            fruitSelected.setQuantity(fruitSelected.getQuantity() - quantityBuy);
            Fruit fruitInOrder = getFruitById(orderList, fruitSelected.getFruitId());
            
            if (fruitInOrder != null) {
                fruitInOrder.setQuantity(fruitInOrder.getQuantity() + quantityBuy);
            } else {
                orderList.add(new Fruit(fruitSelected.getFruitId(), fruitSelected.getFruitName(),fruitSelected.getOrigin(),
                        fruitSelected.getPrice(), quantityBuy));
            }
            System.out.println("Bạn có muốn tiếp tục mua không?");
        } while (Validation.getInputYOrN());
        
        displayOrder(orderList);
        String name = Validation.getInputString("Nhập tên của bạn để hoàn tất đơn hàng: ", "Tên không được trống!");
        ht.put(name, orderList);
        System.out.println("Đặt hàng thành công!");
    }
    
    
    private void displayListFruit(List<Fruit> lf) {
        int countItem = 1;
        System.out.printf("%-10s | %-15s | %-10s\n", "Item", "FruitName", "Price");
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() > 0) {
                System.out.printf("%-10s | %-15s | %-10s\n", countItem++, fruit.getFruitName(), fruit.getPrice());
            }
        }
    }
}
