package org.example.dsa;

import java.util.*;
import java.util.stream.Collectors;


/**
 * M1
 * M2 E1 E2       M3
 * E3 M5         M4 E4 E5
 * E7         M6 E6
 * E8
 **/

class Manager extends Employee {

    double cumulativeSal;
    double noOfReportees = 0;


    public Manager(int empId, String empName, double sal, Manager reportingTo, String role) {
        super(empId, empName, sal, reportingTo, role, true);
    }

    public double getSal() {
        return super.getSal();
    }


    public String getEmpName() {
        return super.getEmpName();
    }


    public int getEmpId() {
        return super.getEmpId();
    }

    public double getCumulativeSal() {
        return cumulativeSal;
    }

    public void setCumulativeSal(double cumulativeSal) {
        this.cumulativeSal = cumulativeSal;
    }

    public double getNoOfReportees() {
        return noOfReportees;
    }
}

class Employee {
    private int empId;
    private String empName;
    private double sal;
    private Manager reportingTo;
    private String role;
    private boolean isManager;

    public Employee(int empId, String empName, double sal, Manager reportingTo, String role, boolean isManager) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.reportingTo = reportingTo;
        this.role = role;
        this.isManager = isManager;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Manager getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(Manager reportingTo) {
        this.reportingTo = reportingTo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public Employee getEmployeeFromId(Integer id) {
        return (this.empId == id) ? this : null;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", sal=" + sal +
                ", reportingTo='" + reportingTo + '\'' +
                ", role='" + role + '\'' +
                ", isManager=" + isManager +
                '}';
    }
}

class TrieNode {
    int noOfReportees;
    boolean isManager;
    double salary;
    double cumulativeSalary; // To store the cumulative salary of the node including its descendants

    TrieNode() {
        this.noOfReportees = 0;
        this.isManager = false;
        this.salary = 0;
        this.cumulativeSalary = 0;
    }
}


public class ManagerTrieExp {

    public static void main(String[] args) {
        Manager m1 = new Manager(1, "M1", 9000.00, null, "Manager");
        Manager m2 = new Manager(5, "M2", 8000.00, m1, "manager");
        Employee e1 = new Employee(2, "E1", 1000.00, m1, "Developer", false);
        Employee e2 = new Employee(3, "E2", 2000.00, m2, "Developer", false);
        Manager m3 = new Manager(4, "M3", 7000.00, m2, "manager");
        Employee e3 = new Employee(6, "E3", 3000.00, m2, "Developer", false);
        Manager m5 = new Manager(7, "M5", 5000.00, m3, "manager");
        Employee e4 = new Employee(8, "E4", 3000.00, m3, "Developer", false);
        Manager m4 = new Manager(10, "M4", 6000.00, m3, "manager");
        Manager m6 = new Manager(11, "M6", 5000.00, m3, "manager");

        Manager m8 = new Manager(14, "M8", 9000.00, m4, "manager");
        Employee e5 = new Employee(9, "E5", 4000.00, m4, "Developer", false);
        Employee e6 = new Employee(12, "E6", 1000.00, m4, "Developer", false);
        Employee e7 = new Employee(13, "E7", 1000.00, m4, "Developer", false);
        Employee e8 = new Employee(15, "E8", 1000.00, m8, "Developer", false);
        List<Employee> empList = List.of(m1, m2, m3, m4, m5, m6, m8, e1, e2, e3, e4, e5, e6, e7, e8);
        TrieDS trie = new TrieDS(m1);
        Map<Manager, List<Employee>> empMap = trie.createTrieDS(empList);
        for (Map.Entry<Manager, List<Employee>> entry : empMap.entrySet()) {
            System.out.print(entry.getKey().getEmpName()+"-------->");
            System.out.println(entry.getValue().stream().map(Employee::getEmpName).collect(Collectors.joining(",")));
        }
        trie.setReportees(empMap);

        trie.calculateCumulativeSalary();
        double maxSalMgr = trie.calculateMaxAvgSal(empList);
        System.out.println(maxSalMgr);
    }
}

class TrieDS {
    Manager root;
    Map<Manager, List<Employee>> reportees = new HashMap<>();

    TrieDS(Manager node) {
        this.root = node;
    }

    public void setReportees(Map<Manager, List<Employee>> reportees) {
        this.reportees.putAll(reportees);
    }

    public Map<Manager, List<Employee>> createTrieDS(List<Employee> empList) {
        Map<Manager, List<Employee>> hm = new HashMap<>();
        for (Employee emp : empList) {
            Manager reporter = emp.getReportingTo();
            if (reporter == null && emp.isManager()) {
                hm.put((Manager) emp, new ArrayList<>());
            } else {

                List<Employee> list = hm.getOrDefault(reporter, new ArrayList<>());
                list.add(emp);
                hm.put(reporter, list);
            }

        }
        return hm;
    }

    public void calculateCumulativeSalary() {
        calculate(root);
    }

    /**
     * M1 //1
     * M2 E1//2
     * E2 E3         M3 //3
     * M4  M5 M6 E4 //4
     * M8  E5 E6 E7  //4
     * E8
     **/

    // Helper method for DFS traversal to calculate the cumulative weight
    public double[] calculate(Manager node) {
        node.cumulativeSal = node.getSal();// Start with the node's own sal
        node.noOfReportees = 1;        if (!node.isManager()) {
            return new double[]{node.getSal(), node.noOfReportees};
        }
        if (reportees.get(node) == null) {
            return new double[]{node.cumulativeSal, node.getNoOfReportees()};
        }
        for (Employee emp : reportees.get(node)) {
            if (emp.isManager()) {
                double[] countAndSum = calculate((Manager) emp);
                node.cumulativeSal += countAndSum[0];// Add the cumulative weight of the child nodes
                node.noOfReportees += countAndSum[1];
            } else {
                node.cumulativeSal += emp.getSal();// Add the cumulative weight of the child nodes
                node.noOfReportees += 1;

            }
        }
        return new double[]{node.cumulativeSal, node.getNoOfReportees()};
    }

    public double calculateMaxAvgSal(List<Employee> empList) {
        // Map<String, Double> avgSal = new HashMap<>();
        // Employee res;
       /* for(Manager mgr : empMap.keySet()){
            System.out.println(mgr.empName+"->"+mgr.getCumulativeSal()+"->"+mgr.noOfReportees);
            avgSal.put(mgr.getEmpName(), mgr.getCumulativeSal() / mgr.noOfReportees);
        }*/
       /* empList.stream().filter(Employee::isManager).map(mgr->(Manager)mgr).forEach(mgr -> {
            System.out.println(mgr.getEmpName() + "->" + mgr.getCumulativeSal() + "->" + mgr.noOfReportees);
            avgSal.put(mgr.getEmpName(), Double.valueOf(mgr.getCumulativeSal() / mgr.noOfReportees));
        });*/
        double res = empList.stream().filter(Employee::isManager).map(mgr -> (Manager) mgr).map(mgr -> {
            return (double) Double.valueOf(mgr.getCumulativeSal() / mgr.noOfReportees);
        }).max(Comparator.reverseOrder()).get();

        // return avgSal.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

        return res;
    }
}



