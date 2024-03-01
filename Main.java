import java.io.*;
import java.util.*;
public class Main
{
    private FileInputStream input;
    private String in_filepath, out_filepath;
    private FileReader reader;
    private static int size = 52, cnt = 26;
    int[] dict = new int[size];

    public Main()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the input file path: ");
        in_filepath = in.nextLine();
        System.out.println("Enter the output file path: ");
        out_filepath = in.nextLine();
        read_File();
        write_File();
    }

    private void read_File()
    {
        try
        {
            input = new FileInputStream(in_filepath);
            int c;
            while ((c = input.read()) != -1)
            {
                if (c >= 'A' && c <= 'Z')
                {
                    dict[c - 'A']++;
                }
                if (c >= 'a' && c <= 'z')
                {
                    dict[c - 'a' + cnt]++;
                }
            }
            input.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File does not Exists");
        }
        catch (IOException ex)
        {
            System.out.println("File reading error" );
        }
    }

    private void write_File()
    {
        try
        {
            FileWriter fileWriter = new FileWriter(out_filepath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            int c;
            for(int i = 0; i < size; i++) {
                if (i < cnt) 
                {
                    c = i + 'A';
                } 
                else 
                {
                    c = i - 26 + 'a';
                }
                if (dict[i] != 0)
                    printWriter.print((char) c + " : " + dict[i] + "\n");
            }
            printWriter.close();
        }
        catch (IOException ex)
        {
            System.out.println("File writing error" );
        }

    }
    public static void main(String[] args)
    {
        Main main = new Main();
    }
}
