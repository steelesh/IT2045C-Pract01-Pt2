import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        String ID = "";
        String name = "";
        String desc = "";
        String cost = "";
        try{
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                String str = String.format("%-3sID#", ID);
                String str1 = String.format("%-6sName",name);
                String str2 = String.format("%-8sDesc.", desc);
                String str3 = String.format("%-11sCost", cost);
                System.out.println(str + str1 + str2 + str3);
                System.out.println("===================================================");
                while(reader.ready()){
                    rec = reader.readLine();
                    System.out.println("   " + rec);
                }
                reader.close();
                System.out.println("\n\nData File read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}