import java.util.ArrayList;
    /**
     * This class is the to store competitors in an ArrayList
     * and is used  to give information of competitors in various ways.
     * @author Jiancheng Zhang
     */
    public class CompetitorList {
        private ArrayList<ZJCCompetitor> competitorsList = new ArrayList<>();
    /**
     * Creates a CompetitorList object with nothing.
     */
        public CompetitorList() {

        }
    /**
     * Add a competitor into the list and check whether there is a same primary key.
     * @param c is a competitor that going to be added.
     * if the id isn't exist in list then add,
     * or get the name of the competitor who has a same id and print it.
     */
        public void addCompetitors(ZJCCompetitor c) {
            String id = c.getId();
            String cList = isIDExist(id);
            if (cList == null) {
                this.competitorsList.add(c);
            }else {
                String error = "";
                for (ZJCCompetitor x : competitorsList){
                    if (x.getId().equals(id)){
                        error += x.getId() + " " + x.getName().getFullName();
                    }
                }
                System.out.println("Duplicate primary key(Competitor number): The " + id + " is belong to the competitor below: " + error);
            }
        }
    /**
     * check if there is a id in the competitor list.
     * @param id is the id need to search.
     * @return null if the id that looking for doesn't in list.
     * otherwise the short details of the competitor with that id if there it is.
     */
        public String isIDExist(String id){
            for (ZJCCompetitor c : competitorsList){
                if (c.getId().equals(id)){
                    return c.getShortDetails();
                }
            }
            return null;
        }

    /**
     * To create a formative long string of information of every competitors.
     * @return a table of information of all competitors in the list
     */
        public String allCompetitors() {
            String a = "Competitors table:\n";
            StringBuilder table = new StringBuilder("Number\tName\t\t\tLevel\t\tCountry\t\tAge\tScores\n");
            for (ZJCCompetitor c : competitorsList) {
                    table.append(c.getId())
                         .append("\t").append(c.getName().getFullName())
                         .append("\t").append("\t").append(c.getLevel())
                         .append("\t").append("\t").append(c.getCountry())
                         .append("\t").append("\t").append(c.getAge())
                         .append("\t").append(c.getScoreArray())
                         .append("\t").append("\n");
            }
            for (ZJCCompetitor c : competitorsList) {
                    table.append("\n" + "Full details for ")
                         .append(c.getId()).append("\n")
                         .append(c.getFullDetails());
            }
            for (ZJCCompetitor c : competitorsList) {
                    table.append("\n" + "Short details for ")
                         .append(c.getId()).append("\n")
                         .append(c.getShortDetails()).append("\n");
            }
            return a + table;
        }

        /**
         * to find out who got the highest overall score and
         * maybe there are more than one competitor got the same score
         * @return the competitors who have the highest overall score
         * @exception IndexOutOfBoundsException which means the input data has problem,
         * wrong file or no data meet requirements
         */
        public String overallScore1st(){
            try {
                double smax = competitorsList.get(0).getOverallScore();
                String a = "\n" + "The person who has the highest overall score is ";
                String b = "\n" + "The competitors below got same highest overall score: ";
                String name = competitorsList.get(0).getName().getFullName();
                for (ZJCCompetitor c : competitorsList) {
                    if (smax < c.getOverallScore()) {
                        smax = c.getOverallScore();
                        name = c.getName().getFullName();
                    }
                }
                int i = 0;
                for (ZJCCompetitor c : competitorsList) {
                    if (smax == c.getOverallScore()){
                        b += c.getName().getFullName() + ", ";
                        i++;
                    }
                }
                if (i == 0){
                    return a + name + " with a score of " + String.format("%.1f", smax) + " ." + "\n";
                }else {
                    return b + "and the overall score is " + String.format("%.1f", smax) + " ." + "\n";
                }
            } catch (IndexOutOfBoundsException index){
                System.out.println("There is no competitor in list! " + index.getMessage());
                System.exit(1);
            }
            return null;
        }

        /**
         * knowing how many competitors there are.
         * @return a string to show this information
         */
        public String numOfCompetitors(){
            String a = "There are ";
            String b = " competitors in this game.";
            return a + competitorsList.size() + b + "\n";
        }

        /**
         * get the average age of all competitors.
         * I turned age into double first and reserve one digital of the result.
         * @return a string to show this information
         */
        public String averageAge(){
            int age = 0;
            for (ZJCCompetitor c : competitorsList) {
                age += Integer.parseInt(c.getAge());
            }
            double avgage = age * 1.0 / competitorsList.size();
            return "The average age of competitors is " + String.format("%.1f",avgage) + " years old." + "\n";
        }

        /**
         * this is to count how many competitor in each level.
         * @return a long sentence that give the number of level.
         */
        public String frequencyLevel(){
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            for (ZJCCompetitor zjcc : competitorsList) {
                switch (zjcc.getLevel().toUpperCase()) {
                    case "COMMON":
                        a++;
                        break;
                    case "UNCOMMON":
                        b++;
                        break;
                    case "RARE":
                        c++;
                        break;
                    case "LEGENDARY":
                        d++;
                        break;
                }
            }
            String report = "There are "
                          + a + " common level competitors, "
                          + b + " uncommon level competitors, "
                          + c + " rare level competitors and "
                          + d + " legendary level competitor.";
            return report + "\n";
        }

        /**
         * here used a same method in lecture that consider the value of scores as the index of an array.
         * @return a small table of how many scores in each value.
         */
        public String frequencyScore() {
            int[] freqScore = new int[6];
            for (ZJCCompetitor c : competitorsList) {
                for (int s : c.getScores()) {
                    freqScore[s]++;
                }
            }
            String report = "The following individual scores were awarded:"
                          + "\n"
                          + "Scores:   \t\t"+"0"+"\t"+"1"+"\t"+"2"+"\t"+"3"+"\t"+"4"+"\t"+"5"
                          + "\n"
                          + "Frequency: ";
            for (int value : freqScore) {
                report += "\t" + value;
            }
            return report;
        }
    }
