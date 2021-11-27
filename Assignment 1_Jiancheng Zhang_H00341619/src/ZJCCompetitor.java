import java.util.Arrays;

public class ZJCCompetitor {
    private String    id;
    private Name      name;
    private String    level;
    private String    country;
    private String    age;
    private Integer[] scores ;

    public ZJCCompetitor(String id, Name n, String level, String country, String age, Integer[] scores){
        this.id      =id;
        this.name    =n;
        this.level   =level;
        this.country =country;
        this.age     =age;
        this.scores  =scores;
    }

    public double getOverallScore() {
        int max = scores[0];
        int maxIndex = 0;
        int min = scores[0];
        int minIndex = 0;

        for(int index = 0; index < scores.length; index++){
            if (scores[index] >= max) {
                max = scores[index];
                maxIndex = index;
            }
            if ((scores[index] <= min)&&(index != maxIndex)) {
                min = scores[index];
                minIndex = index;
            }
        }

        double sum = 0;
        for(int index = 0; index < scores.length; index++){
            if (!(index==maxIndex || index==minIndex)){
                sum += scores[index];
            }
        }
        return sum/(scores.length-2);
    }

    public String getFullDetails(){
        return "Competitor number: "+ id +"\n"
                          +"Name: "+name.getFullName()+"\n"
                          +"Age: "+age+"\n"
                          +"Scores: "+getScoreArray()+"\n"
                          +"Overall score: "+String.format("%.1f",getOverallScore())+"\n"
                          +"Level: "+level+"\n"
                          +"Country: "+country+"\n";
    }

    public String getShortDetails(){
        return "CN " + getId()
                     + " (" + name.getInitials()
                     + ") has overall score "
                     + String.format("%.1f",getOverallScore()) + ".";
    }

    public String getId() {
        return id;
    }

    public Name   getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getCountry() {
        return country;
    }

    public String getAge() {
        return age;
    }

    public String getScoreArray() {
        String scoreArray = Arrays.toString(scores);
        return scoreArray.substring(1,scoreArray.length()-1);
    }

    public Integer[] getScores() { return scores; }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setScores(Integer[] scores) {
        this.scores = scores;
    }
}
