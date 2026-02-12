import java.io.*;

public class buffered {
    public static void main(String[] args) throws IOException{
        BufferedWriter Writer = new BufferedWriter(new FileWriter("example.txt"));
Writer.write("Hello World");Writer.append("Hii");
Writer.newLine();
Writer.append("Hii");
Writer.write("hi");
Writer.close();
    }
}
