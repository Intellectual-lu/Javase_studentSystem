import java.util.Scanner;

/**
 * 测试类，用于测试各项功能
 */
public class test {
    public static void main(String[] args) {
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.welcome();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            studentSystem.showMenu();
            choice = Util.getInputNumber("请输入操作编号:",scanner);
            switch (choice){
                case 1:
                    studentSystem.showAll();
                    break;
                case 2:
                    studentSystem.addStudent();
                    break;
                case 3:
                    studentSystem.findBySid();
                    break;
                case 4:
                    studentSystem.findByName();
                    break;
                case 5:
                    studentSystem.removeBySid();
                    break;
                case 6:
                    studentSystem.modifyBySid();
                    break;
                case 0:
                    studentSystem.exit();
                    return;
                default:
                    System.out.println("输入错误，重新输入");
                    break;
            }
        }while (true);
    }
}
