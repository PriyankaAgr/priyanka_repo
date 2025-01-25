package org.java.coding;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
class Employee {
    Integer id;
    String name;
    String department;
    Double salary;
    Address address;

    public Employee(Integer id, String name, String department, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.address = address;
    }
    @Override
    public String toString() {
        return String.valueOf(id) + " " + name;
    }
}

@Getter
@Setter
class Address {
    String fullAddress;
    City city;

    public Address(String fullAddress, City city) {
        this.fullAddress = fullAddress;
        this.city = city;
    }
}

@Getter
@Setter
class City {
    long id;
    String city;

    public City(long id, String city) {
        this.id = id;
        this.city = city;
    }

}
public class ProblemSolving1 {
    public static void main(String[] args) {
        // TODO: Use optional class to get the city from this object
        Employee emp0 = new Employee(1, "E1", "sales", 123400, new Address("full address", null));
        Optional<City> getCity = Optional.ofNullable(emp0.getAddress().city);
        if (getCity.isPresent()) System.out.println(getCity.get().city);
        Employee emp1 = new Employee(1, "E1", "sales", 123400, null);
        Employee emp2 = new Employee(2, "E2", "sales", 1234, null);
        Employee emp3 = new Employee(3, "E3", "research", 45000, null);
        Employee emp4 = new Employee(4, "E4", "research", 1234, null);
        Employee emp5 = new Employee(5, "E5", "hr", 60000, null);
        Employee emp6 = new Employee(6, "E6", "hr", 1234, null);
        Employee emp7 = new Employee(7, "E7", "sales", 40000, null);
        Employee emp8 = new Employee(8, "E8", "research", 1234, null);
        List<Employee> empList = List.of(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8);
        //TODO: sum of sal by dept | give
        System.out.println(empList.stream().collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary))).entrySet()
                .stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get()
        );
    }
}
