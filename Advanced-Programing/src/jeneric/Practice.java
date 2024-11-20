package jeneric;

import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private String major;
    private int year;
    private double gradeAverage;

    public Student(String name, String major, int year, double gradeAverage) {
        this.name = name;
        this.major = major;
        this.year = year;
        this.gradeAverage = gradeAverage;
    }

    public String getName() {
        return name;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    @Override
    public String toString() {
        return name + ", " + major + ", " + year + ", " + gradeAverage;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gradeAverage, other.gradeAverage);
    }
}

public class Practice {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String major = data[1].trim();
                int year = Integer.parseInt(data[2].trim());
                double gradeAverage = Double.parseDouble(data[3].trim());
                students.add(new Student(name, major, year, gradeAverage));
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류 발생: " + e.getMessage());
        }

        // 학생 정보를 모두 출력
        System.out.println("저장된 학생 목록:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
