//Ismail Chapman
//2/12/2024
//CIS 1068 Assignment 3 Grades
//This program utilizes the scanner import to take inputs from the user to calculate a course grade.
// It also includes if/else statement to cap the course grade at 100 and to make sure it's not less than 0

import java.util.Scanner;

public class Grades {
    //=========main function=========
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//==========weight for three components==========================================//
        // Homework weights
        System.out.println("Homework weight? ");
        double weightHW = scanner.nextDouble();

        // Exam 1 weight
        System.out.println("Exam 1 weight? ");
        double weightExam1 = scanner.nextDouble();

        // Calculate Exam 2 weight
        double weightExam2 = 100 - weightHW - weightExam1;
        System.out.println("\nUsing weights of " + weightHW + " " + weightExam1 + " " + weightExam2);
//=====Grades for homework ==========================//
        // Homework details
        System.out.println("\nHomework:");
        System.out.println("Number of assignments? ");
        int numHW = scanner.nextInt();

        System.out.println("Average Homework grade? ");
        double HWgrade = scanner.nextDouble();

        System.out.println("Number of late days used? ");
        int lateDay = scanner.nextInt();

        System.out.println("Labs attended? ");
        int numLabs = scanner.nextInt();

        // Calculate weighted homework grade
        double weightedHWgrade = calWeightedHWGrade(numHW, HWgrade, lateDay, numLabs, weightHW);
        double totalPointsHomework = (HWgrade * numHW) + (numLabs * 4);

        System.out.println("\nTotal points = " + totalPointsHomework + " / 140");
        System.out.println("Weighted score = " + weightedHWgrade);


//========Grade for exam 1=====================================//
        // Exam 1
        System.out.println("\nExam 1:");
        System.out.println("Score? ");
        double examScore1 = scanner.nextDouble();
        System.out.println("Curve? ");
        double curve1 = scanner.nextDouble();

        // Calculate weighted exam score for Exam 1
        double weightedExamScore1 = calWeightedExamScore(examScore1, curve1, weightExam1);
        System.out.println("\nTotal points = " + (examScore1 + curve1) + " / 100");
        System.out.println("Weighted score = " + weightedExamScore1);
//==========Grade for exam 2 =========================================//
        // Exam 2
        System.out.println("\nExam 2:");
        System.out.println("Score? ");
        double examScore2 = scanner.nextDouble();
        System.out.println("Curve? ");
        double curve2 = scanner.nextDouble();

        // Calculate weighted exam score for Exam 2
        double weightedExamScore2 = calWeightedExamScore(examScore2, curve2, weightExam2);
        System.out.println("\nTotal points = " + (examScore2 + curve2) + " / 100");
        System.out.println("Weighted score = " + weightedExamScore2);
//==========Total Grade==============================================//
        // Calculate Total Grade
        double totalGrade = calTotalGrade(weightedHWgrade, weightedExamScore1, weightedExamScore2);
        System.out.println("\nCourse grade = " + totalGrade);


        scanner.close();
    }
    //=====method for HW grade=============================
    private static double calWeightedHWGrade(int numHW, double HWgrade, int lateDay, int numLabs, double weightHW) {
        if (HWgrade < 0) {
            HWgrade = 0;
        }

        // Calculate total points for homework
        double totalPointsHomework = HWgrade * numHW - lateDay * 0.5;

        // Calculate weighted homework score
        return totalPointsHomework / (numLabs * 4 + numHW * 10) * weightHW;
    }
    //=======method for exam grade=======================================================
    private static double calWeightedExamScore(double score, double curve, double weightExam) {
        if (score < 0) {
            score = 0;
        }

        // Cap exam scores at 100
        score = Math.min(score + curve, 100);

        // Calculate weighted exam score
        return score * weightExam / 100;
    }

    // Method to calculate total grade
    private static double calTotalGrade(double homeworkGrade, double exam1, double exam2) {
        return homeworkGrade + exam1 + exam2;
    }
}
