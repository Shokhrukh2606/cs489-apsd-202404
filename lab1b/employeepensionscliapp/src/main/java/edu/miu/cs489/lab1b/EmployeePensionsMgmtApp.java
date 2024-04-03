package edu.miu.cs489.lab1b;

import edu.miu.cs489.lab1b.model.Employee;
import edu.miu.cs489.lab1b.model.PensionPlan;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeePensionsMgmtApp {

    public static void main(String[] args) {
        Employee[] employees=new Employee[]{
                new Employee(1L,"Daniel", "Agar",LocalDate.of(2018, 1,17),105945.50,new PensionPlan("EX1089",LocalDate.of(2023,1,17),100.0)),
                new Employee(2L,"Benard", "Shaw",LocalDate.of(2019, 4, 3),197750.00,null),
                new Employee(3L,"Carly", "Agar",LocalDate.of(2014, 5,16),842000.75,new PensionPlan("SM2307",LocalDate.of(2019,11,4),1555.50)),
                new Employee(4L,"Wesley", "Schneider",LocalDate.of(2019,5,2),74500.00,null)
        };
       printEmployees(employees);
       printMonthlyUpcomingEnrollees(employees);
    }
    private static void printMonthlyUpcomingEnrollees(Employee[] employees){
        var monthlyUpcomingEnrollees=Arrays.stream(employees).filter(e->e.getPensionPlan()==null).filter(e->{
            LocalDate now = LocalDate.now( ZoneId.of( "America/Chicago" ) );
            //To get monthly upcoming enrollees we need to get employees between two date range subtracting 5 years from the first and last day of next month
            LocalDate fromPeriod=now.withMonth(now.getMonthValue()+1).withDayOfMonth(1).minusYears(5);
            LocalDate toPeriod=now.withMonth(now.getMonthValue()+1).withDayOfMonth(now.getMonth().length(now.isLeapYear())).minusYears(5);
            return e.getEmployementDate().isAfter(fromPeriod)&&e.getEmployementDate().isBefore(toPeriod);
        }).sorted(Comparator.comparing(Employee::getEmployementDate)).toList();
        System.out.println("Monthly Upcoming Enrollees");
        prettyJSON(monthlyUpcomingEnrollees);
    }

    private static void prettyJSON(List<Employee> monthlyUpcomingEnrollees) {
        long numEployees=monthlyUpcomingEnrollees.size();
        System.out.println("[");
        for (int i=0;i<numEployees;i++){
            if((i+1)<numEployees){
                System.out.printf("%s,\n",monthlyUpcomingEnrollees.get(i).toJSONString());
            }else {
                System.out.println(monthlyUpcomingEnrollees.get(i).toJSONString());
            }
        }
        System.out.println("]");
    }

    private static void printEmployees(Employee[] employees){
        if(employees!=null){
            if(employees.length>0){
                var sortedEmployees= Arrays.stream(employees)
                        .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary, Comparator.reverseOrder())).toList();
                System.out.println("List of employees");
                prettyJSON(sortedEmployees);
            }else {
                System.out.println("[]");
            }
        }else{
            System.out.println("Error: Invalid input data. Can not be Null");
        }
    }
}
