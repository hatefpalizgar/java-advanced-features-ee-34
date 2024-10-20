package com.sda.p27_streams.no1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example01 {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        var jane = new Employee("Jane Deer", 40);
        var jack = new Employee("Jack Hill", 39);
        var snow = new Employee("Snow White", 30);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = Arrays.asList(hr, accounting);

        // use Streams API to print the employees in each department
        departments.stream()  // Stream<Department>
                .map(d -> d.getEmployees()) // Stream<List<Employee>>
                .forEach(
                        list -> list.forEach(e -> System.out.println(e.getName()))
                );

        // second solution:
        departments.stream()  // Stream<Department>
                .flatMap(department -> department.getEmployees().stream()) // Stream<Employee>
                .forEach(e -> System.out.println(e.getName()));


        // use Streams API to create a Map<Integer, List<Employee>> that groups employees by their age
        // e.g. [30 -> {e1,e2,e3}]
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream()) // Stream<Employee>
                .collect(Collectors.groupingBy(e -> e.getAge()));

        // TODO: What is the goal of below code?
        departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
                .ifPresent(e -> System.out.println(e.getName()));
    }
}


/**
 *
 * @see com.sda.p27_streams.no2.Example02
 * */
