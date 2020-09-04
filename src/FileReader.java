import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner; // Import the Scanner class to read text files

public class FileReader {
    public static void main(String[] args) {
        try {
            File myObj = new File("test.txt");
            Scanner myReader = new Scanner(myObj);
            List<String> result = new ArrayList<String>();
            int max_length = 30;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = line.split("[, ?\".@;:/()$#^~`^!'\\\\%*\\-+=()_\n&<>{}\\]\\[]+");
                for (String word : words) {
                    if (word.length() > max_length){
                        word = word.substring(0, max_length);
                    }
                    if (result.isEmpty())
                    {
                        result.add(word);
                    }
                    else if (result.get(0).length() < word.length())
                    {
                        result.clear();
                        result.add(word);
                    }
                    else if (result.get(0).length() == word.length())
                    {
                        result.add(word);
                    }
                }
            }
            List<String> noDupRes = new ArrayList<String>();
            for (String element : result) {
                if (!noDupRes.contains(element)) {
                    noDupRes.add(element);
                }
            }
            for (String word : noDupRes)
            {
                System.out.println(word);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            e.printStackTrace();
        }
    }
}
