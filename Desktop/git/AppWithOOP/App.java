import java.util.Objects;
import java.util.Scanner;

/**
 * This is Application part of the program. There work business logics
 * @Author Shakhnoza Naimova
 * @version 1.0
 */
public class App {

    /**
     * This allQuestions field is used to manipulate questions list
     */
    static DatabaseForQuestions allQuestions = new DatabaseForQuestions();
    static String redColor = "\u001B[31m";

    // ANSI escape code to reset text color
    static String resetColor = "\u001B[0m";

    static {
        System.out.println("-------------------------------------------------------------------");
        System.out.println(redColor + "\t This is not going to production, only for testing" + resetColor);
        System.out.println("--------------------------------------------------------------------");
    }
    public static void main(String[] args) {

        /**
         * There are users list with authority, Teacher, Student, User.
         */


        User user1 = new User("Ali", "ali", Role.TEACHER);
        User user2 = new User("Vali", "+998912123232", Role.TEACHER);
        User user3 = new User("G'ani", "+998975677656", Role.USER);
        User user4 = new User("Lola", "+998971233230", Role.USER);
        User user5 = new User("Jim", "jim", Role.STUDENT);
        User[] list = new User[10];
        list[0] = user1;
        list[1] = user2;
        list[2] = user3;
        list[3] = user4;
        list[4] = user5;
        getAll(list);
        menu(list);
        
    }

    /**
     * This menu method is to show menu for user
     * @param list is used to identify if user is teacher or student
     */
    public static void menu(User[] list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------Welcome------------");
        boolean alive = true;
        do {
            System.out.println("1.Kirish");
            System.out.println("2.Registratsiya");
            System.out.println("0.Chiqish");
            System.out.print("\tEnter your option: ");
            int option = Integer.valueOf(scanner.nextLine());
            switch (option){
                case 1 -> kirish(list);
                case 2 -> registratsiya(list);
                case 0 -> alive = false;
                default -> System.out.println("You entered wrong input. Idiot:(");
            }
        } while (alive);
    }


    /**
     * Once user click on kirish, their credentials will be asked
     * @param list is used to identify is user is teahcer or student
     */


    private static void kirish(User[] list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------Kirish------------------");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < list.length; i++) {
            if (Objects.nonNull(list[i])) {
                if ((list[i].getPassword().equals(password)
                        && list[i].getName().equals(username))) {
                    System.out.println("Successfully logged in!!!");
                    if (list[i].getRole().equals(Role.TEACHER)){
                        menuForTeacher();
                    }else {
                        menuForStudentUser();
                    }
                    return;
                }
            }
        }
        System.out.println("Bunday user yo'q");
        //return null;
    }


    /**
     * If user is Student, this menuforstudents will appear
     */
    private static void menuForStudentUser() {
        Scanner scanner = new Scanner(System.in);
        boolean alive = true;
        while (alive){
            System.out.println("---------Menu For StudentUser------------");
            System.out.println("1.Start");
            System.out.println("2.Exit");
            System.out.print("\t Enter your choice: ");
            int choice = Integer.valueOf(scanner.nextLine());
            switch (choice){
                case 1 -> startQuestions();
                case 2 -> alive = false;
                default -> System.out.println("Wrong entry, IDIOT :(");
            }
        }
    }

    /**
     * When students start qustions, this method will work, give them questions, and store their results
     */
    public static void startQuestions() {
        Scanner scanner = new Scanner(System.in);
        String[][] userResult = new String[allQuestions.getQuestions().length][3];
        int correctAnswersCount = 0;
        Answer givenAnswer = new Answer();
        for (int i = 0; i < allQuestions.getQuestions().length; i++) {
            if (Objects.nonNull(allQuestions.getQuestions()[i])) {
                System.out.println((i + 1) + ". " + allQuestions.getQuestions()[i].getQuestion());
                System.out.println("1) " + allQuestions.getQuestions()[i].getAnswer1().getAnswer());
                System.out.println("2) " + allQuestions.getQuestions()[i].getAnswer2().getAnswer());
                System.out.println("3) " + allQuestions.getQuestions()[i].getAnswer3().getAnswer());
                System.out.println("4) " + allQuestions.getQuestions()[i].getAnswer4().getAnswer());
                System.out.print("\t Enter your answer: ");
                int answer = Integer.valueOf(scanner.nextLine());

                givenAnswer = switch (answer) {
                    case 1 -> allQuestions.getQuestions()[i].getAnswer1();
                    case 2 -> allQuestions.getQuestions()[i].getAnswer2();
                    case 3 -> allQuestions.getQuestions()[i].getAnswer3();
                    case 4 -> allQuestions.getQuestions()[i].getAnswer4();
                    default -> null;
                };
                userResult[i][0] = String.valueOf(allQuestions.getQuestions()[i].getQuestion());
                userResult[i][1] = String.valueOf(givenAnswer.getAnswer());
                userResult[i][2] = String.valueOf(givenAnswer.isCorrect());


                if (givenAnswer.isCorrect()) {
                    System.out.println("You find it correct!!!");
                    correctAnswersCount++;
                } else {
                    System.out.println("You find it this childish example wrong, IDIOT :( ");
                }

            }
        }
        System.out.println("---------Your result-------------");
        for (int i = 0; i < allQuestions.getQuestions().length; i++) {
            System.out.println((i+1)+ ") " +userResult[i][0] + " " + userResult[i][1] + " | " + userResult[i][2]);
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Overall Result: " + correctAnswersCount + " out of " + allQuestions.getQuestions().length);
        System.out.println("------------------------------------------------------");




    }

    /**
     * If user is not registered, they will register themselves, entering their information
     * @param list is used to add the registered user to users list
     */
    public static void registratsiya(User[] list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------Registration------------------");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < list.length; i++) {
            if (Objects.nonNull(list[i])){
                if (list[i].getPassword().equals(password)
                        && list[i].getName().equals(username)){
                    System.out.println("User already exist!!!");
                    return;
                }
            }
        }
        User newUser = new User(username, password, Role.STUDENT);
        list[indexToAdd(list)] = newUser;
        System.out.println("Successfully registered");
        getAll(list);
    }

    /**
     * If user is Teacher, this menu will appear, which enables teahcer to do more activities
     */
    private static void menuForTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------Menu For Teacher--------------");
        System.out.println("\t1) Create quiz");
        System.out.println("\t2) Delete quiz");
        System.out.println("\t3) Update quiz");
        System.out.println("\t4) List quiz");
        System.out.println("\t5) Exit");
        System.out.print("Enter your choice => ");
        int choice = Integer.valueOf(scanner.nextLine());
        switch (choice){
            case 1 -> createQuiz();
            case 2 -> deleteQuiz();
            case 3 -> updateQuiz();
            case 4 -> listQuiz();
            case 5 -> System.exit(0);
            default -> System.out.println("You entered wrong choice!!!");
        }
    }

    /**
     * This method will run if teacher chooses to update quiz, they choose index of quiz to update, than enter
     * new quiz, and the quiz will be added to quiz list
     */

    private static void updateQuiz() {
        Scanner scanner = new Scanner(System.in);
        showAllQuestions(allQuestions);
        System.out.print("Select the index to update: ");
        int idx = Integer.valueOf(scanner.nextLine());

        System.out.print("Enter quiz: ");
        String quiz = scanner.nextLine();
        System.out.print("Enter correct answer: ");
        String variant1 = scanner.nextLine();
        System.out.print("Enter variant 2: ");
        String variant2 = scanner.nextLine();
        System.out.print("Enter variant 3: ");
        String variant3 = scanner.nextLine();
        System.out.print("Enter variant 4: ");
        String variant4 = scanner.nextLine();
        Question newQuestion = new Question(quiz, new Answer(variant1, true),
                new Answer(variant2, false),
                new Answer(variant3, false),
                new Answer(variant4, false));

        allQuestions.getQuestions()[idx - 1] = newQuestion;

        showAllQuestions(allQuestions);
        menuForTeacher();
    }

    /**
     * If Teacher user want to check out all quizes
     * This method will work, and show all quizes list
     */
    private static void listQuiz() {
        showAllQuestions(allQuestions);
        menuForTeacher();
    }


    /**
     * When Teacher want to delete quiz, this method works
     * First all quizes will be shown
     * Teahcer chooses the index of quiz to delete
     * And enters the index
     * quiz will be deleted
     */
    private static void deleteQuiz() {
        Scanner scanner = new Scanner(System.in);
        showAllQuestions(allQuestions);
        System.out.print("Select the index to delete: ");
        int idx = Integer.valueOf(scanner.nextLine());
        allQuestions.getQuestions()[idx - 1] = null;
        showAllQuestions(allQuestions);
        menuForTeacher();


    }

    /**
     * This method is used to create quiz
     * Teacher enter the quiz
     * with all variants
     * that quiz be added to the list
     */
    public static void createQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quiz: ");
        String quiz = scanner.nextLine();
        System.out.print("Enter correct answer: ");
        String variant1 = scanner.nextLine();
        System.out.print("Enter variant 2: ");
        String variant2 = scanner.nextLine();
        System.out.print("Enter variant 3: ");
        String variant3 = scanner.nextLine();
        System.out.print("Enter variant 4: ");
        String variant4 = scanner.nextLine();
        Question newQuestion = new Question(quiz, new Answer(variant1, true),
                new Answer(variant2, false),
                new Answer(variant3, false),
                new Answer(variant4, false));


        Question[] newQuiz = new Question[allQuestions.getQuestions().length + 1];
        for (int i = 0; i < allQuestions.questions.length; i++) {
            newQuiz[i] = allQuestions.questions[i];
        }

        newQuiz[newQuiz.length -1] = newQuestion;
        //databaseForQuestions.questions = newQuiz;
        allQuestions.setQuestions(newQuiz);

        showAllQuestions(allQuestions);
        menuForTeacher();


    }

    /**
     * This method is used to identify at what index to add user
     * @param list count all the user
     * @return return the index from which user list is null
     */
    public static int indexToAdd(User[] list) {
        int idx = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i]==null){
                idx = i;
                break;
            }
        }
        return idx;
    }

    /**
     * This method is used to get the list of users
     * @param list will be used to show the user
     */
    public static void getAll(User[] list){

        System.out.println("-------------------List of registered users-------------------------");

        for (User user : list) {
            if (Objects.nonNull(user)) {
                System.out.println(user);
            }
        }
        System.out.println("=====================================================================");
    }

    /**
     * This method is used to show all quesitons from questions database
     * @param questions is used to get questions list
     */
    public static void showAllQuestions(DatabaseForQuestions questions){
        for (int i = 0; i < questions.getQuestions().length; i++) {
            if (Objects.nonNull(questions.getQuestions()[i])){
                System.out.println((i + 1) + ". " + allQuestions.getQuestions()[i].getQuestion());
                System.out.println("\t1) " + allQuestions.getQuestions()[i].getAnswer1().getAnswer());
                System.out.println("\t2) " + allQuestions.getQuestions()[i].getAnswer2().getAnswer());
                System.out.println("\t3) " + allQuestions.getQuestions()[i].getAnswer3().getAnswer());
                System.out.println("\t4) " + allQuestions.getQuestions()[i].getAnswer4().getAnswer());
            }
        }
    }


}
