public class Test {
	public static void main(String[] args) {
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.print(i + "*" + j + "=" + i*j);
				System.out.print('\t');
			}
			System.out.println();
		}
	}
}


/* import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("월(1~12)을 입력하시오.");
        int month = scanner.nextInt();
        if (month >= 1 && month <= 3) {
            System.out.println("1분기입니다.");    
        }
        else if (month >=4 && month <=6) {
            System.out.println("2분기입니다.");
            
        }
        else if (month >=7 && month <=9) {
            System.out.println("3분기입니다.");
            
        }
        else if (month >=10 && month <=12) {
            System.out.println("4분기 입니다.");}
            
        else { System.out.println("잘못 입력된 숫자입니다.");}
        scanner.close();
    }
}

/* //case문 연습.
switch (month) {
    case 3: case 4: case 5:
        System.out.println("봄입니다.");
        break;
    case 6: case 7: case 8:
        System.out.println("여름입니다.");
        break;
    case 9: case 10: case 11:
        System.out.println("가을입니다.");
        break;
    case 12: case 1: case 2:
        System.out.println("겨울입니다.");
        break;
    default:
        System.out.println("잘못된 입력입니다.");
}
*/