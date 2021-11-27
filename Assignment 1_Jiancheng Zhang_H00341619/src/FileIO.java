import java.io.*;
import java.util.Scanner;

public class FileIO {
    public void input(String fileName, CompetitorList cList) {
        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, it seems that " + fileName + " not exist. Please try again.");
            System.exit(0);
        }
        String in;
        while (scanner.hasNextLine()) {
            in = scanner.nextLine();
            if (!in.isBlank()){
                try {
                    String[] section = in.split(",");
                    String id = section[0].replace(" ", "");
                    String name = section[1].trim();
                    String level = section[2].replace(" ", "");
                    String country = section[3].trim();
                    String age = section[4].replace(" ", "");
                    int n = 0;
                    Integer[] scores = new Integer[5];
                    if (section.length == 10) {
                        for (int s = 5; s < section.length; s++) {
                            scores[n] = Integer.parseInt(section[s].trim());
                            n++;
                        }
                        ZJCCompetitor c = new ZJCCompetitor(id, new Name(name), level, country, age, scores);
                        cList.addCompetitors(c);
                    }else {
                        System.out.println("Lack or duplication some information or comma in " + in);
                    }
                } catch (NumberFormatException scores){
                    String error = "There are some useless information or duplication comma" + scores.getMessage();
                    System.out.println(error);
                } catch (ArrayIndexOutOfBoundsException section){
                    String error = "There are wrong information in this line: " + in +section.getMessage();
                    System.out.println(error);
                }
            }
        }
    }
    public void output(String fileName, String someText) {
        try {
            FileWriter out = new FileWriter(fileName);
            PrintWriter output = new PrintWriter(out);
            output.print(someText);
            output.close();
        } catch (FileNotFoundException f) {
            System.out.println("Access denied.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
