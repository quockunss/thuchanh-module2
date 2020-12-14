import java.io.Serializable;

public class Contact implements Serializable {
    private String phoneNumber;
    private String name;
    private String group;
    private String address;
    private String email;
    private String sex;

    public Contact(){}

    public Contact(String phoneNumber,String name,String group,String address, String email,String sex){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.email = email;
        this.group = group;
        this.sex = sex;

    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
