import java.io.*;

public class App {
    public static void main(String[] args) {
        File myFile = new File("src/myFile.txt");

        System.out.println("Can read: " + myFile.canRead());
        System.out.println("Can write: " + myFile.canWrite());
        System.out.println("Name file: " + myFile.getName());

        // Ghi Dữ Liệu
        try {
            FileWriter fileWriter = new FileWriter(myFile);
        // Su Dung bufferWrite thong qua
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello everyone!!!");
            bufferedWriter.newLine();
            bufferedWriter.write("Hi!");
            bufferedWriter.close(); // Dong File

//            fileWriter.write("Hello");
//            fileWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        // Đọc Dữ Liệu
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Doc Dong line khi khong con dong doc nua
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

//        System.out.println(myFile.delete()); // Xoa File
    }
}
