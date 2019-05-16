package codekernel.com.quizz.Model;

public class Question {

    public String question,option1,option2,getOption3,getOption4,annswer;

    public Question(String question, String option1, String option2, String getOption3, String getOption4, String annswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.getOption3 = getOption3;
        this.getOption4 = getOption4;
        this.annswer = annswer;
    }

    public Question(){}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getGetOption3() {
        return getOption3;
    }

    public void setGetOption3(String getOption3) {
        this.getOption3 = getOption3;
    }

    public String getGetOption4() {
        return getOption4;
    }

    public void setGetOption4(String getOption4) {
        this.getOption4 = getOption4;
    }

    public String getAnnswer() {
        return annswer;
    }

    public void setAnnswer(String annswer) {
        this.annswer = annswer;
    }
}

