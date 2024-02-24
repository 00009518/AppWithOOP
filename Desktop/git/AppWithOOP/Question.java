/**
 * This class is used to create questions
 */
public class Question {
    private String question;
    private Answer[] answers = new Answer[4];
    private Answer answer1 = answers[0];
    private Answer answer2 = answers[1];
    private Answer answer3 = answers[2];
    private Answer answer4 = answers[3];


    public Question() {
    }

    public Question(String question, Answer answer1, Answer answer2, Answer answer3, Answer answer4) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public Answer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(Answer answer1) {
        this.answer1 = answer1;
    }

    public Answer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(Answer answer2) {
        this.answer2 = answer2;
    }

    public Answer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(Answer answer3) {
        this.answer3 = answer3;
    }

    public Answer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(Answer answer4) {
        this.answer4 = answer4;
    }
}
