/*컬렉션 Iterator 메소드 연습.
import java.util.*;
public class Test {
    public static void main(String[] args) { 
    Vector<Integer> v = new Vector<Integer>(); 
        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2, 100);

    Iterator<Integer> it = v.iterator(); 

    while(it.hasNext()) {
        int n = it.next();
        System.out.println(n);
        }

    int sum = 0;
    it = v.iterator();

    while(it.hasNext()) {
        int n = it.next();
        sum += n; 
        }

    System.out.println("벡터 정수 합 : " + sum);
    }
}


/* 컬렉션 벡터 연습
import java.util.Vector;
public class Test {
public static void main(String[] args) {
    Vector<Integer> v = new Vector<Integer>();
        v.add(5);
        v.add(4);
        v.add(-1);

        v.add(2, 100);

    System.out.println("벡터 안의 요소 수 : " + v.size()); 
    System.out.println("벡터의 용량 : " + v.capacity()); 
    
    for(int i=0; i<v.size(); i++) {
        int n = v.get(i);
        System.out.println(n);
    }

    int sum = 0;
    for(int i=0; i<v.size(); i++) {
        int n = v.elementAt(i);
        sum += n;
    }
    System.out.println("벡터 안의 정수 합 : " + sum);
    }
}


/* super활용 colorpoint 연습
class Point {
    private int x, y;
    public Point() {
        this.x = this.y = 0;
    }
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}

class ColorPoint extends Point {
    private String color;
    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }
    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }
}

public class Test {
    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 6, "blue");
        cp.showColorPoint();
    }
}
        

/* this 색깔 연습.
class Point {
    private int x, y;
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}

class ColorPoint extends Point { 
    private String color;
    public void setColor(String color) {
    this.color = color;
    }
    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }
}

public class Test {
    public static void main(String [] args) {
        Point p = new Point();
            p.set(1, 2);
            p.showPoint();
        ColorPoint cp = new ColorPoint(); 
            cp.set(3, 4);
            cp.setColor("red");
            cp.showColorPoint();
    }
}
    

/*public class Test {
    public static void main(String[] args) {
        Calc a = new Calc();
        int foo = a.n;
        System.out.println(foo);
        int bar = Calc.m;
        System.out.println(bar);

        System.out.println(Calc.abs(-5));
        System.out.println(Calc.max(10, 8));
        System.out.println(Calc.min(-3, -8));
    }
}

class Calc {
    int n = 100;
    static int m = 200;

    public static int abs(int a) { return a>0?a:-a; }
    public static int max(int a, int b) { return (a>b)?a:b; }
    public static int min(int a, int b) { return (a>b)?b:a; }
    }

/*public class Test {
    public static void main(String[] args) {
        Circle [] c; 
        c = new Circle[5];
            for(int i=0; i<c.length; i++)
        c[i] = new Circle(i); 
            for(int i=0; i<c.length; i++)
        System.out.print((int)(c[i].getArea()) + " ");
        }
    }

class Circle {
    int radius;
    public Circle(int radius) {
    this.radius = radius;
    }
    public double getArea() {
    return 3.14*radius*radius;
    }
    }

/* this 책이름 연습
public class Test {
    String title;
    String author;
    void show() { System.out.println(title + " " + author); }
    
    public Test() {
        this("", "");
        System.out.println("생성자 호출됨");
    }
    public Test(String title) {
        this(title, "작자미상");
    }
    public Test(String title, String author) {
        this.title = title; this.author = author;
    }

    public static void main(String [] args) {
        Test littlePrince = new Test("어린왕자", "생텍쥐페리");
        Test loveStory = new Test("춘향전");
        Test emptyBook = new Test();
        loveStory.show();
    }
}

/* 책이름 연습
public class Test {
    String title;
    String author;

    public Test(String t) {
        title = t; author = "작자 미상";
    }
    public Test(String t, String a){
        title = t; author = a;
    }

    public static void main(String[] args) {
        Test littlePrince = new Test("어린왕자", "생텍쥐페리");
        Test loveStory = new Test("춘향전");
        System.out.println(littlePrince.title + " " + littlePrince.author);
        System.out.println(loveStory.title + " " + loveStory.author);
    }
    
}

/* 자바피자 자바도넛 연습
public class Test {
    int radius;
    String name;

    public Test() {
        radius = 1; name = "";
    }
    public Test(int r, String n) {
        radius = r; name = n;
    }
    public double getArea(){
        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Test pizza = new Test(10, "자바피자");
        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area);

        Test donut = new Test();
        donut.name = "자바도넛";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);
    }
}

/* get연습
import java.util.Scanner;

    public class Test {
        public static void main(String[] args) {
            Rectangle rect = new Rectangle(); // 객체 생성
            Scanner scanner = new Scanner(System.in);
            System.out.print("두 변의 길이를 입력하시오.");
            rect.width = scanner.nextInt();
            rect.height = scanner.nextInt();
            System.out.println("사각형의 면적은 " + rect.getArea());
            scanner.close();
        }
}

    class Rectangle {
        int width;
        int height;
        public int getArea() {
            return width*height;
        }
    }

/* 나눔수 나뉨수 연습
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dividend;
		int divisor;	
		
		System.out.print("나뉨수를 입력하시오:"); 
		dividend = scanner.nextInt();
		System.out.print("나눗수를 입력하시오:"); 
		divisor = scanner.nextInt();
		try {
			System.out.println(dividend+"를 "+divisor+"로 나누면 몫은 "
					+dividend/divisor+"입니다.");
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다!");			
		}
		finally {
			scanner.close();
		}
	}
}


/*
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


/* if문 연습
import java.util.Scanner;
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