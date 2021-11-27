import java.util.Scanner;

public class competitor {
    public static void main(String[] args) {
        CompetitorList check = new CompetitorList();
        FileIO newFile = new FileIO();
        newFile.input("competitor.txt", check);
        String report = check.allCompetitors()
                      + "\n" + "STATISTICAL:" + "\n"
                      + check.overallScore1st()
                      + check.numOfCompetitors()
                      + check.averageAge()
                      + check.frequencyLevel()
                      + check.frequencyScore();
        newFile.output("Report Of ZJCcompetitor.txt",report);
        for (int i = 0; i < 3;i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input the competitor number of the competitor detail you expect to know:");
            String id = scanner.next();
            if (check.isIDExist(id) == null) {
                System.out.println("Sorry, there is no such competitor number. Try again please.");
            }else {
                System.out.println(check.isIDExist(id));
                break;
            }
        }
    }
}
