public class Employee {
    int employeeID = 0;
    String name;
    String DoB;
    int age;
    double salary;
    Employee(int employeeID,String name,String DoB, int age, double salary){
        this.employeeID = employeeID;
        this.name = name;
        this.DoB = DoB;
        this.age = age;
        this.salary = salary;
    }
    public int getAge(){
        return age;
    }
    public double getSalary(){
        return salary;
    }
    public String toString(){
        return "EID: "+employeeID+" \nName: "+name+" \nDoB: "+DoB+" \nAge: "+age+" \nSalary: "+salary;
    }
}
