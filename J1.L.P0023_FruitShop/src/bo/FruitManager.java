package bo;

import entity.Fruit;
import entity.Order;
import java.util.ArrayList;
import java.util.List;
import utils.Validation;

public class FruitManager {

    // 1. Attributes (Dùng Interface List chuẩn OOP)
    private final List<Fruit> fruitList = new ArrayList<>();

    // 2. Constructor (Khởi tạo sẵn dữ liệu mẫu để demo)
    public FruitManager() {
        fruitList.add(new Fruit("1", "Táo Mỹ", 10, 50, "USA"));
        fruitList.add(new Fruit("2", "Xoài Cát", 5, 100, "Vietnam"));
    }

    // 3. Chức năng 1: Tạo sản phẩm trái cây (Public)
    public void createFruit() {
        do {
            String fruitId = Validation.getInputString("Nhập mã trái cây (Fruit ID): ", "Mã không được trống!");
            Fruit fruit = getFruitById(fruitList, fruitId); // Gọi hàm bổ trợ ngay phía dưới
            
            if (fruit != null) {
                System.out.println("Mã đã tồn tại! Hệ thống sẽ cộng dồn số lượng.");
                int quantity = Validation.checkIntegerInRange("Nhập số lượng thêm: ", 
                        "Số lượng phải lớn hơn 0!", 1, Integer.MAX_VALUE);
                fruit.setQuantity(fruit.getQuantity() + quantity);
            } else {
                String fruitName = Validation.getInputString("Nhập tên trái cây: ", "Tên không được trống!");
                double price = Validation.checkDoubleInRange("Nhập giá: ", 
                        "Giá phải lớn hơn 0!", 0.1, Double.MAX_VALUE);
                int quantity = Validation.checkIntegerInRange("Nhập số lượng: ", 
                        "Số lượng phải lớn hơn 0!", 1, Integer.MAX_VALUE);
                String origin = Validation.getInputString("Nhập nguồn gốc (Origin): ", "Nguồn gốc không được trống!");
                fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            }
            System.out.println("Bạn có muốn tiếp tục tạo sản phẩm không?");
        } while (Validation.getInputYOrN());
    }

    // Helper của chức năng 1: Tìm kiếm trái cây bằng ID (Private)
    private Fruit getFruitById(List<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) return fruit;
        }
        return null;
    }

    // 4. Chức năng 2: Xem danh sách hóa đơn (Public)
    public void viewOrder(List<Order> listOrder) {
        if (listOrder.isEmpty()) {
            System.out.println("Chưa có hóa đơn nào được tạo!");
            return;
        }
        for (Order order : listOrder) {
            System.out.println("Mã hóa đơn: " + order.getId());
            System.out.println("Khách hàng: " + order.getCustomerName());
            displayOrder(order.getListFruit());
            System.out.println("");
        }
    }

    // Helper của chức năng 2: Chi tiết hóa đơn và tính tổng tiền (Private)
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

    // 5. Chức năng 3: Mua sắm dành cho khách hàng (Public)
    public void shopping(List<Order> listOrder) {
        if (fruitList.isEmpty()) {
            System.out.println("Cửa hàng hiện tại đã hết hàng!");
            return;
        }
        
        List<Fruit> orderList = new ArrayList<>();
        do {
            displayListFruit(fruitList); // Gọi hàm bổ trợ hiển thị danh sách kho ngay phía dưới
            int item = Validation.checkIntegerInRange("Chọn sản phẩm muốn mua (theo STT): ", 
                    "Vui lòng chọn đúng STT có trên màn hình!", 1, fruitList.size());
            Fruit fruitSelected = fruitList.get(item - 1);
            
            System.out.println("Bạn đã chọn: " + fruitSelected.getFruitName());
            int quantityBuy = Validation.checkIntegerInRange("Nhập số lượng muốn mua: ", 
                    "Kho chỉ còn " + fruitSelected.getQuantity() + " sản phẩm!", 1, fruitSelected.getQuantity());
            
            // Khấu trừ số lượng trong kho của cửa hàng
            fruitSelected.setQuantity(fruitSelected.getQuantity() - quantityBuy);
            Fruit fruitInOrder = getFruitById(orderList, fruitSelected.getFruitId()); // Gọi lại helper getFruitById ở trên
            
            if (fruitInOrder != null) {
                fruitInOrder.setQuantity(fruitInOrder.getQuantity() + quantityBuy);
            } else {
                orderList.add(new Fruit(fruitSelected.getFruitId(), fruitSelected.getFruitName(), 
                        fruitSelected.getPrice(), quantityBuy, fruitSelected.getOrigin()));
            }
            System.out.println("Bạn có muốn tiếp tục mua không?");
        } while (Validation.getInputYOrN());
        
        displayOrder(orderList); // Gọi lại helper displayOrder ở trên
        String name = Validation.getInputString("Nhập tên của bạn để hoàn tất đơn hàng: ", "Tên không được trống!");
        String orderId = String.valueOf(listOrder.size() + 1);
        listOrder.add(new Order(orderId, name, orderList));
        System.out.println("Đặt hàng thành công!");
    }

    // Helper của chức năng 3: In danh sách trái cây còn hàng (Private)
    private void displayListFruit(List<Fruit> lf) {
        int countItem = 1;
        System.out.printf("%-10s | %-15s | %-15s | %-10s\n", "Item", "Fruit Name", "Origin", "Price");
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() > 0) {
                System.out.printf("%-10d | %-15s | %-15s | %-10.1f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }
}
