package patterns.composite;

public final class Main {

    private Main() {

    }

    public static void main(String[] args) {
        Team team = new Team();

        Developer javaDeveloper = new JavaDeveloper();
        Developer pythonDeveloper = new PythonDeveloper();
        Developer goDeveloper = new GoDeveloper();

        team.addDeveloper(javaDeveloper);
        team.addDeveloper(pythonDeveloper);
        team.addDeveloper(goDeveloper);
        team.createProject();
    }

}
