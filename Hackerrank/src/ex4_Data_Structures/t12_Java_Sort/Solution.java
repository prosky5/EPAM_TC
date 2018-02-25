package ex4_Data_Structures.t12_Java_Sort;

import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
//        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class Solution
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = Double.parseDouble(in.next());
//            in.nextLine();

            studentList.add(new Student(id, fname, cgpa));

            testCases--;
        }

        studentList.sort(new SpecialSort());

        for(Student st: studentList){
            System.out.println(st.getFname());
        }

    }
}

class SpecialSort implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() == s2.getCgpa()) {
            if (s1.getFname().equals(s2.getFname())) {
                return s2.getId() > s1.getId() ? 1 : -1;
            }
            return s1.getFname().compareTo(s2.getFname());
        }
        return s2.getCgpa() > s1.getCgpa() ? 1 : -1;
    }
}