import java.util.ArrayList;
import java.util.Scanner;

public class view {
    public static ArrayList<Contact> CONTACTS = new ArrayList<Contact>();
    public static void setListContacts(ArrayList<Contact> listContacts) {
        view.CONTACTS = listContacts;
    }
    public static ArrayList<Contact> getListContacts() {
        return CONTACTS;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contact contact = new Contact();
        Controller con = new Controller();
        int cases = 0;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1. Xem danh bạ");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng");
            try {
                cases = Integer.parseInt(sc.nextLine());
                switch (cases) {
                    case 1:
                        con.show();
                        break;
                    case 2:
                        con.addContact();
                        break;
                    case 3:
                        con.update();
                        break;
                    case 4:
                        con.delete();
                        break;
                    case 5:

                        break;
                    case 6:
                        IO.readData();
                        break;
                    case 7:
                        break;
                }
            } catch (Exception e) {
                System.out.println("nhập lại đê ");
            }
        } while (cases != 6);
    }
}