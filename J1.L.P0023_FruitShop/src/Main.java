import bo.FruitManager;
import entity.Order;
import java.util.ArrayList;
import java.util.List;
import utils.Validation;

public class Main {

    // 1. Phương thức khởi chạy chính (Public)
    public static void main(String[] args) {
        List<Order> listOrder = new ArrayList<>();
        FruitManager manager = new FruitManager();
        int choice = 0;

        do {
            displayMenu(); // Gọi hàm bổ trợ giao diện ngay phía dưới
            choice = Validation.checkIntegerInRange("Lựa chọn của bạn: ", 
                    "Vui lòng chọn từ 1 đến 4!", 1, 4);
            
            switch (choice) {
                case 1: 
                    manager.createFruit(); 
                    break;
                case 2: 
                    manager.viewOrder(listOrder); 
                    break;
                case 3: 
                    manager.shopping(listOrder); 
                    break;
                case 4: 
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                    break;
            }
        } while (choice != 4);
    }

    // 2. Helper hiển thị giao diện Menu chính (Đóng gói Private nội bộ)
    private static void displayMenu() {
        System.out.println("\n=== HỆ THỐNG QUẢN LÝ CỬA HÀNG TRÁI CÂY ===");
        System.out.println("1. Tạo sản phẩm trái cây");
        System.out.println("2. Xem danh sách đơn hàng đã bán");
        System.out.println("3. Mua sắm (Khách hàng)");
        System.out.println("4. Thoát");
    }
}
