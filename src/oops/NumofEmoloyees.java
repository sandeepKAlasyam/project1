package oops;

public class NumofEmoloyees {

    private int employees = 0;
    private String name;

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        NumofEmoloyees No = new NumofEmoloyees();
        NumofEmoloyees No1 = new NumofEmoloyees();
        No.setEmployees(123);
        No1.setName("Sandeep");
        System.out.println(No.getEmployees());
        System.out.println(No1.getName());

    }
}