import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try{
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max){
        try{
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
