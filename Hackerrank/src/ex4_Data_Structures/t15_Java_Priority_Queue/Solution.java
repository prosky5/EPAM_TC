package ex4_Data_Structures.t15_Java_Priority_Queue;

import java.util.*;
import java.util.function.Function;

//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.PriorityQueue;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}


class Priorities {

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCGPA).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getID)
        );
//
//        PriorityQueue<Student> queue = new PriorityQueue<Student>(
//                Comparator.comparing(new Function<Student, Double>() {
//                    @Override
//                    public Double apply(Student student) {
//                        return student.getCGPA();
//                    }
//                }).reversed()
//                .thenComparing(new Function<Student, String>() {
//                    @Override
//                    public String apply(Student student) {
//                        return student.getName();
//                    }
//                })
//                .thenComparing(new Function<Student, Integer>() {
//                    @Override
//                    public Integer apply(Student student) {
//                        return student.getID();
//                    }
//                })
//        );

        List<Student> students = new ArrayList<Student>();

        for (String event : events) {
            String[] words = event.split(" ");
            if (words[0].equals("ENTER")) {
                String name = words[1];
                double cgpa = Double.parseDouble(words[2]);
                int id = Integer.parseInt(words[3]);

                queue.add(new Student(id, name, cgpa));

            } else {
                queue.poll();
            }
        }

        Student first = queue.poll();
        if (first == null) {
            return students;
        } else {
            while (first != null) {
                students.add(first);
                first = queue.poll();
            }
            return students;
        }

    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}