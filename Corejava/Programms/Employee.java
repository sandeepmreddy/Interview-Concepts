public class Employee {
    private String empName;
    private int empAge;
    Employee(String empName,int empAge)
    {
        this.empName =empName;
        this.empAge = empAge;
    }
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

}
