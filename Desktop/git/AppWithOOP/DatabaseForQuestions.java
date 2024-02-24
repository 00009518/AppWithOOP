/**
 * This class is used to work with questions
 */
public class DatabaseForQuestions {
    Question question1 = new Question("2 + 3 = ",
            new Answer("5", true),
            new Answer("4", false),
            new Answer("11", false),
            new Answer("7", false)
    );
    Question question2 = new Question("7 + 3 = ",
            new Answer("5", false),
            new Answer("4", false),
            new Answer("10", true),
            new Answer("7", false)
    );
    Question question3 = new Question("2 * 3 = ",
            new Answer("5", false),
            new Answer("4", false),
            new Answer("11", false),
            new Answer("6", true)
    );
    Question question4 = new Question("123 + 321 = ",
            new Answer("5", false),
            new Answer("444", true),
            new Answer("11", false),
            new Answer("7", false)
    );
    Question question5 = new Question("8 * 8 = ",
            new Answer("5", false),
            new Answer("64", true),
            new Answer("11", false),
            new Answer("7", false)
    );
    Question question6 = new Question("36 + 4 = ",
            new Answer("5", false),
            new Answer("40", true),
            new Answer("11", false),
            new Answer("7", false)
    );Question question7 = new Question("22 + 33 = ",
            new Answer("5", false),
            new Answer("4", false),
            new Answer("11", false),
            new Answer("55", true)
    );
    Question question8 = new Question("11 * 11 = ",
            new Answer("5", false),
            new Answer("4", false),
            new Answer("121", true),
            new Answer("7", false)
    );
    Question question9 = new Question("12 * 12 = ",
            new Answer("5", false),
            new Answer("144", true),
            new Answer("11", false),
            new Answer("7", false)
    );
    Question question10 = new Question("(12 + 21) * 2 = ",
            new Answer("66", true),
            new Answer("4", false),
            new Answer("11", false),
            new Answer("7", false)
    );

    Question[] questions = {
            question1,
            question2,
            question3,
            question4,
            question5,
            question6,
            question7,
            question8,
            question9,
            question10
    };

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
