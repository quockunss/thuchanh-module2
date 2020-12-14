import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {
    Scanner sc = new Scanner(System.in);

    public void addContact(){
            System.out.println("Nhập thông tin: ");
            try {
                System.out.println("Tên thuê bao : ");
                String name = sc.nextLine();

                System.out.println("số điện thoại : ");
                String phoneNumber = sc.nextLine();

                System.out.println("nhóm : ");
                String group = sc.nextLine();

                System.out.println("địa chỉ: ");
                String address = sc.nextLine();

                System.out.println("email: ");
                String email = sc.nextLine();

                System.out.println("giới tính: ");
                String Sex = sc.nextLine();

                Contact contact = new Contact();
                view.CONTACTS.add(contact);
                IO.csvWriterContact("contact.csv", contact);
            } catch (InputMismatchException em){
                System.out.println("Nhập sai, xin chọn lại chức năng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    public void show(){
        System.out.println("Danh bạ");
        String header = String.format("%s%30s%30s%30s%30s%30s", "Số điện thoại","Nhóm","Tên","Giới tính","Địa chỉ","Email");
        System.out.println(header);
        for(Contact contact : view.CONTACTS){
            String infor = String.format("%s%30s%30s%30s%30s%30s", contact.getPhoneNumber(),contact.getGroup(),contact.getName(),contact.getSex(),contact.getAddress(),contact.getEmail());
            System.out.println(infor);
        }
    }

    public void delete(){
        try {
            System.out.println("Nhập mã sản phẩm cần xóa: ");
            String phoneNumber = sc.nextLine();
            Contact contact = null;
            for (Contact con : view.CONTACTS){
                if (con.getPhoneNumber() == phoneNumber){
                    contact = con;
                    break;
                }
            }
            view.CONTACTS.indexOf(contact);
            view.CONTACTS.remove(view.CONTACTS.indexOf(contact));
            if (contact == null){
                System.out.println("số điện thoại không tồn tại, xin hãy nhập lại ");
            }
        } catch(Exception e) {
            System.out.println("số điện thoại không tồn tại, xin hãy nhập lại ");
        }
        IO.csvWriterContactUpdate("product.csv",view.CONTACTS);
    }


    public void update(){
        try {
            System.out.println("Nhập số điện thoại sửa: ");
            String phoneNumber = sc.nextLine();
            Contact contact = null;
            for(Contact con : view.getListContacts()){
                if(con.getPhoneNumber() == phoneNumber) {
                    contact = con;
                    break;
                }
            }
            if (contact == null){
                System.out.println("số điện thoại không tồn tại, mời nhập lại: ");
            }
            System.out.println("Thông tin thuê bao");
            String header = String.format("%s%30s%30s%30s%30s","nhóm","Tên","giới tính","địa chỉ","Email");
            System.out.println(header);
            String infor = String.format("%s%30s%30s%30s%30s", contact.getGroup(),contact.getName(),contact.getSex(),contact.getAddress(),contact.getEmail() );
            System.out.println(infor);
            for (int i = 0; i < view.CONTACTS.size(); i++){
                if (view.CONTACTS.get(i).getPhoneNumber() == phoneNumber){
                    sc.nextLine();

                    System.out.println("Tên nhóm: ");
                    String group = sc.nextLine();

                    System.out.println("tên: ");
                    String name = sc.nextLine();

                    System.out.println("giới tính: ");
                    String sex = sc.nextLine();

                    System.out.println("địa chỉ:");
                    String address = sc.nextLine();

                    System.out.println("Email:");
                    String email = sc.nextLine();

                    view.CONTACTS.get(i).setGroup(group);
                    view.CONTACTS.get(i).setName(name);
                    view.CONTACTS.get(i).setSex(sex);
                    view.CONTACTS.get(i).setAddress(address);
                    view.CONTACTS.get(i).setEmail(email);

                }
            }
        } catch (InputMismatchException em){
            System.out.println("Nhập sai, xin chọn lại chức năng");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        IO.csvWriterContactUpdate("contact.csv",  view.CONTACTS);
    }


}



