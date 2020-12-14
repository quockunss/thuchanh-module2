

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void csvWriterContact(String path, Contact contact) {
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            if (!file.exists()) {
                System.out.println("File not exits");
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            fileWriter.append(contact.getPhoneNumber());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(contact.getName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(contact.getGroup());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(contact.getAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(contact.getEmail());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(contact.getSex());
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void csvWriterContactUpdate(String path, ArrayList<Contact> contact) {
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            if (!file.exists()) {
                System.out.println("File not exits");
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);

            for (int i = 0; i < contact.size(); i++) {
                fileWriter.write(contact.get(i).getPhoneNumber());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(contact.get(i).getName());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(contact.get(i).getGroup());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(contact.get(i).getAddress());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(contact.get(i).getEmail());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(contact.get(i).getSex());
                fileWriter.write(NEW_LINE_SEPARATOR);
                fileWriter.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static ArrayList<Contact> readData() {
        ArrayList<Contact> listContact = new ArrayList<Contact>();
        String fileIn = "contact.csv";
        String line = null;

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileIn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null))
                    break;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            String[] temp = line.split(COMMA_DELIMITER);
            String phoneNumber = temp[0];
            String name = temp[1];
            String group = temp[2];
            String address = temp[3];
            String email = temp[4];
            String sex = temp[5];
            listContact.add(new Contact(phoneNumber, name
                    , group, address, email, sex));
        }
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return listContact;
    }
}