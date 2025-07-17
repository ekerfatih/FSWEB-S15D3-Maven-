package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicateEmployees;

    public static void main(String[] args) {

        List<Employee> list = new LinkedList<>();

        Employee e = new Employee(1, "Fatih", "Eker");
        Employee e2 = new Employee(2, "Batuhan", "Korkmaz");
        Employee e3 = new Employee(3, "Okan", "Açıksöz");
        Employee e8 = new Employee(3, "Okan", "Açıksöz");
        Employee e9 = new Employee(3, "Okan", "Açıksöz");
        Employee e4 = new Employee(4, "Samet", "Dökmeci");
        Employee e5 = new Employee(4, "Samet", "Dökmeci");
        Employee e6 = new Employee(6, "Mesut", "Cherry");
        Employee e7 = new Employee(7, "Mesut", "Kiraz");

        list.add(e);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        list.add(e7);
        list.add(e8);
        list.add(e9);
        List<Employee> duplicates = findDuplicates(list);
        Map<Integer, Employee> findUniques = findUniques(list);
        List<Employee> removeDuplicates = findDuplicates(list);
        System.out.println(duplicates);
        System.out.println(findUniques);
        System.out.println(findUniques);
    }


    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicateEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicateEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicateEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }
}