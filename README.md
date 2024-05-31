# 김민준 202130203
## 5월 31일  
**JComponent**  
void setForeground(color) // 전경색 설정  
void setBackground(color) // 배경색 설정  
void setOpaque(boolean) // 불투명성 설정  
void setFont(Font) // 폰트 설정  
Font getFont() // 폰트 리턴  

JBUTTON으로 버튼을 생성 후 이미지를 추가하여 버튼에 마우스를 가져다 댔을 때와 클릭 시의 이미지를 바꿔보았다.  

JRadioButton으로 라디오버튼을 만들어보았다.  
```ButtonGroup g = new ButtonGroup(); // 버튼 그룹 객체 생성.```  

## 5월 24일
**이벤트 기반 프로그래밍**  
ㆍ이벤트가 발생하면 이벤트를 처리하는 루틴 실행.  
ㆍ실행될 코드는 사용자가 관여한 이벤트의 발생에 의해 전적으로 결정.  

※배치실행 : 프로그램의 개발자가 프로그램의 흐름을 결정하는 방식.(반대되는 개념.)  

「이벤트 종류」  
- 사용자의 입력 : 마우스 드래그, 클릭, 키보드 누름 등  
- 센서로부터 입력, 네트워크로부터 데이터 송수신  
- 다른 응용프로그램이나 다른 스레드로부터의 메세지  

「이벤트 객체」  
▶발생한 이벤트에 관한 정보를 가진 개체. > 이벤트 리스너에 전달됨.  
```
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) { // 버튼이 클릭될 때 호출되는 메소드
        JButton b = (JButton)e.getSource(); // 사용자가 클릭한 버튼 알아내기
        if(b.getText().equals("Action")) // 버튼의 문자열이 "Action"인지 비교
            b.setText("액션"); // JButton의 setText() 호출. 문자열변경
        else
            b.setText("Action"); // JButton의 setText() 호출. 문자열변경
    }
}
```

```
MyActionListener listener = new MyActionListener(); // 리스너 인스턴스 생성
btn.addActionListener(listener); //리스너 등록. Action 자리는 이벤트 명.
```  
**Key 이벤트와 포커스**  
ㆍ키 입력 시, 다음 세 경우 각각 Key 이벤트 발생.  
   └키를 누르는 순간  
   └누른 키를 떼는 순간  
   └누른 키를 떼는 순간(unicode키의 경우에만)  
ㆍ키 이벤트를 받을 수 있는 조건  
   └모든 컴포넌트  
   └현재 포커스를 가진 컴포넌트가 키 이벤트 독점  
ㆍ포커스  
   └컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한  
   └컴포넌트에 포커스 설정 방법 : 다음 2 라인 코드 필요  

「KeyEvent 객체의 메소드로 입력된 키 판별」
ㆍ키의 유니코드 문자 값 리턴
ㆍ유니코드 문자 키인 경우에만 의미 있음
ㆍ입력된 키를 판별하기 위해 문자 값과 비교하면 됨
```
public void keyPressed(KeyEvent e) {
    if(e.getKeyChar() == 'q')
        System.exit(0);
} // q키 누르면 프로그램 종료.
```


## 5월 17일

**배치 관리자**  
▶*FlowLayout 배치관리자*  
    └컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치. 다 차면 아래로 내려와 반복.  
▶*BorderLayout 배치관리자*  
    └컨테이너 공간을 동서남북,중앙 5개로 나눈 후 응용프로그램에서 지정한 영역에 컴포넌트 배치.  
▶*GridLayout 배치관리자*  
    └컨테이너를 프로그램에서 설정한 동일한 크기의 2차원 격자로 나눔. 좌에서 우로, 위에서 아래로 배치.  
▶*CardLayout*  
    └컨테이너의 공간에 카드를 쌓아 놓은 듯이 컴포넌트를 포개어 배치.

<code>setLayout(LayoutManager lm) // lm을 새로운 배치관리자로 설정.</code>  

**FlowLayout 생성**
```
container.setLayout(new FlowLayout()); // FlowLayout으로 생성.
container.add(new JButton("add")); // 버튼을 계속 만든다.
container.add(new JButton("sub"));
container.add(new JButton("mul"));
container.add(new JButton("div"));
container.add(new JButton("Calculate"));
```

<code>FlowLayout(컴포넌트 정렬 기준, 컴포넌트 간의 가로 간격, 컴포넌트 간의 세로 간격)</code>  

**BorderLayout 생성**  
```
contentPane.setLayout(new BorderLayout(30, 20));
contentPane.add(new JButton("Calculate"), BorderLayout.CENTER);
contentPane.add(new JButton("add"), BorderLayout.NORTH);
contentPane.add(new JButton("sub"), BorderLayout.SOUTH);
contentPane.add(new JButton("mul"), BorderLayout.EAST);
contentPane.add(new JButton("div"), BorderLayout.WEST);
```

<code>BorderLayout(컴포넌트 간의 가로 간격, 컴포넌트 간의 세로 간격)</code>  
<code>void add(컴포넌트 , BorderLayout.위치)</code>  
※위치에 EAST, WEST, SOUTH, NORTH, CENTER 를 넣을 수 있다.  

**GridLayout 생성**  
```
GridLayout(격자의 행수, 격자의 열수, 컴포넌트 좌우간격, 컴포넌트 상하간격)
```
**배치관리자 삭제**  
```
JPanel p = new JPanel();
p.setLayout(null); // JPanel p의 배치관리자 삭제
```

**배치관리자가 없는 컨테이너가 필요한 경우**  
*응용프로그램에서 직접 컴포넌트의 크기와 위치를 결정하고자 하는 경우*  
1. 컴포넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우  
2. 게임 프로그램과 같이 시간이나 마우스/키보드의 입력에 따라 컴포넌트들의 위치와 크기가 수시로 변하는 경우  
3. 여러 컴포넌트들이 서로 겹쳐 출력하고자 하는 경우  

**배치관리자가 없이 컴포넌트 삽입**  
ㆍ프로그램에서 컴포넌트의 절대 크기와 위치 설정  
ㆍ컴포넌트들이 서로 겹치게 할 수 있음  
```
void setSize(100, 40) // 컴포넌트 크기 설정 (가로, 세로), 100에 40으로 설정함.
void setLocation(50, 50) // 컴포넌트 위치 설정(x, y), 50 50으로 설정함.
void setBounds(50, 50, 100, 40) // 위치와 크기 동시 설정(x, y, 가로, 세로). 위의 값을 한번에 입력해 설정가능.
```

## 5월 3일
**컬렉션**  
요소라 불리는 가변 개수의 객체들의 저장소. = 배열과 비슷.  
컬렉션은 제너릭 기법으로 구현.  
▶제너릭 : 특정타입만을 다루지 않고, 여러 종류의 타입으로 변할 수 있도록 클래스나 메소드를 일반화 시키는 기법. (<구체적인 타입을 명시.>)  
<code> Vector<Integer> v = new Vector<Integer>(); </code>  

*벡터 Vector<특정타입>의 특성*  
ㆍ배열의 길이 제한 극복
ㆍ요소의 개수가 많아지면 자동 조절.
ㆍVector에 객체 삽입, 삭제 가능. (맨 뒤든 중간이든 삽입, 삭제 가능.)
```
Vector<Integer> v = new Vector<Integer>(5); ← 벡터 생성, 용량 5
v.add(5); ← 삽입  
v.add(-4);  
int n=v.size(); ← 요소 개수 n  
int c=v.capacity(); ← 벡터 용량 c  
v.add(1,100); ← 중간에 넣기  
Integer obj=v.get(1); ← 요소 얻기  
int i=obj.intValue(); ← 요소 얻은거 i에 넣기  
v.remove(1); ← 요소 지우기  
int last=v.lastElement(); ← 마지막 요소  
v.removeAllElements(); ← 모든 요소 지우기
```
Test.java에 연습을 해보았다. 자세한 내용은 **Test.java** 참조.  

▶ ArrayList<특정타입> ← 벡터와 거의 동일.  

**Iterator**  
Iterator<특정타입> 인터페이스
    └리스트 구조의 컬렉션에서 요소의 순차 검색을 위한 인터페이스.  

**HashMap**  
키(Key)와 값(Value)의 쌍으로 구성되는 요소를 다루는 컬렉션.  
<code>HashMap<특정타입, 특정타입></code>  
```
HashMap<String, String> h = new HashMap<String, String>(); ← 해시맵 생성
h.put("apple","사과"); ← apple 키와 사과 값의 쌍을 해시맵에 삽입
String kor = h.get("apple"); ← apple 키로 값을 검색함. kor에 값인 사과가 들어감.
```

**자바의 GUI**  
GUI : 사용자가 편리하게 입출력할 수 있도록 그래픽으로 화면 구성하고, 마우스나 키보드로 입력받을 수 있도록 하는 사용자 인터페이스.  

**Swing**  
자바의 GUI.
▶*컨테이너* : 다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트.  
▶*컴포넌트* : 컨테이너에 포함되어야 화면에 출력될 수 있는 GUI 객체.  
▶*최상위 컨테이너* : 다른 컨테이너에 포함 안돼도 화면 출력 가능. (JFrame, JDialog, JApplet)  
※최상위 컨테이너를 바닥에 깔고, 그 위에 컨테이너를 놓고, 다시 컴포넌트를 쌓아가는 방식. 이것이 GUI 프로그램의 작성 방식이다!!  

**Swing Frame**  
ㆍJFrame 클래스를 상속받은 클래스 작성.  
ㆍ프레임 크기 반드시 지정 : setSize() 호출  
ㆍ프레임을 화면에 출력하는 코드 반드시 필요 : setVisible(True) 호출.  
※ main() 은 스윙프레임을 생성하는 정도의 코드로 최소화.
[super()나 setTitle()로 타이틀 달기] > [컨텐트팬에 컴포넌트 달기] > [컨텐트팬 알아내기] > [컨텐트팬 변경]

## 4월19일
**메소드 오버라이딩 (Method Overriding)**  
▶서브클래스에서 슈퍼클래스의 메소드 중복 작성.(메소드 무시하기)  
▶슈퍼클래스의 메소드 무력화, 항상 서브클래스에 오버라이딩한 메소드가 실행되도록 보장됨.  
▶오버라이딩 조건 - 슈퍼클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성.  
※오버로딩과 차이점. 오버로딩은 이름만이 같아도 됨. 정적 바인딩임.  

**추상 클래스**  
*추상 메소드* : abstract로 선언된 메소드. 메소드의 코드는 없고 원형만 선언.  
<code>abstract public (이름)();</code>  

*추상 클래스* : 추상 메소드를 가지며, abstract로 선언된 클래스. 혹은 추상 메소드 없이 선언한 클래스. (추상 메소드를 가지고 있으면 무조건 abstract로 클래스가 선언돼야함.)  
    └ 추상 클래스는 온전한 클래스가 아니라 인스턴스를 생성할 수 없음.  

**인터페이스(Interface)**
*인터페이스* : 클래스가 구현해야 할 메소드들이 선언되는 추상형.  
<code>interface (이름) { ~ }</code>  
-인터페이스에는 필드(멤버 변수) 선언 불가.  
-인터페이스의 객체 생성 불가.  
-인터페이스 타입의 레퍼런스 변수 선언 가능.  

**『인터페이스의 구성요소』**
ㆍ상수 - public만 허용.  
ㆍ추상 메소드 - public abstract 생략 가능.  
ㆍdefault 메소드 - 인터페이스에 코드가 작성된 메소드. 인터페이스 구현하는 클래스에 자동 상속. public 접근 지정만 허용.  
ㆍprivate - 인터페이스 내에 메소드 코드가 작성돼야함. 호출은 인터페이스 내의 다른 메소드에 의해서만.  
ㆍstatic 메소드 - public, private 모두 지정 가능. 생략 시 public.  

**패키지와 모듈**  
*패키지* : 서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어놓은 디렉터리.  
    └ 하나의 응용프로그램은 한 개 이상의 패키지로 작성.  
    └ 패키지는 jar 파일로 압축할 수 있음.  
*모듈* : 여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너. 하나의 모듈을 하나의 .jmod 파일에 저장.  

「모듈화의 목적은 메모리 자원이 열악한 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기의 실행 이미지를 만들기 위해, 간략하고 최소한의 꼭 필요한 모듈로만 실행환경 구축하려고.」  

**패키지 사용법**  
▶ import 미사용 시 : <code>java.util.Date (이런 식.)</code>  
▶ import 사용 : <code>import java.util.Date;</code>  

**Object 클래스**  
모든 자바 클래스는 반드시 Object를 상속받도록 자동 컴파일. 모든 클래스의 슈퍼클래스.  

**Wrapper 클래스**  
데이터 타입을 클래스화 한 8개의 클래스를 통칭한다. (int, char, float 등등.)  
int의 경우 Integer, char의 경우엔 Character 등 풀네임으로 쓴다.

**박싱과 언박싱**  
ㆍ박싱 : 기본 타입의 값을 Wrapper 객체로 변환하는 것.  
└<code>Integer (이름) = Integer.valueOf(값);</code>  
ㆍ언박싱 : Wrapper 객체에 들어있는 기본 타입의 값을 빼내는 것.  
└<code>int (이름)=(Wrapper 객체이름).intValue();</code>  

## 4월12일
**접근 지정자**  
접근 지정자의 목적 : 클래스나 일부 멤버를 공개하여 다른 클래스에서 접근하도록 허용.  
    └ 객체 지향 언어의 캡슐화 정책은 멤버를 보호하는 것.  
*private < 디폴트 < protected < public*

ㆍpublic 「모든 클래스 허용」  
ㆍprotected 「같은 패키지 내의 다른 모든 클래스에게 허용」  
ㆍprivate 「동일 클래스 내에서만 허용」  

**Static 멤버의 생성**  
▶static 멤버는 클래스 당 하나만 생성되고 객체들에 의해 공유된다.  
▶static 멤버가 아닐 경우엔 객체마다 static 멤버가 아닌 멤버가 생긴다.  
▶클래스 이름으로 접근 가능. 객체의 멤버로 접근 가능.  
▶static 메소드는 오직 static 멤버만 접근 가능.  
▶this 사용 불가.  

**final**  
*final class "클래스 명"* - 더 이상 클래스 상속 불가능.  
*final 메소드* - 더 이상 오버라이딩 불가능. 상수랑 비슷한듯.  
*final "데이터타입" "상수이름"* - 상수 선언. 변화 시킬 수 없다.  

**상속**  
상속을 이용하면 중복을 제거하고 간결한 클래스 구조를 만들 수 있다.  

extends 로 선언. 부모 클래스는 *'슈퍼 클래스'*, 자식 클래스는 *'서브 클래스'*라고 한다.
```
class (부모 클래스) {
    ~~~
}

class (자식 클래스) extends (부모 클래스) {
    ~~~
}
```

**업캐스팅**  
upcasting : 슈퍼클래스 레퍼런스로 서브클래스 객체를 가리키는 현상.
```
class Person { }
class Student extends Person { }

Person p;
Student s = new Student();
p = s; // 업캐스팅.
```

**다운캐스팅**  
downcasting : 슈퍼클래스 레퍼런스를 서브클래스 레퍼런스에 대입.  

**instanceof 연산자**  
※업캐스팅된 레퍼런스는 어디의 어떤 클래스에 있는 객체를 가리키는지 파악하기 힘들다.  
    └instanceof 는 레퍼런스가 가리키는 객체를 식별할 때 쓰인다.  
```
(객체레퍼런스) instanceof (클래스타입)
```
## 4월5일
**2차원 배열**  
int (배열이름)[] = new int[2][5];  
    └ 2개의 파일 안에 5개의 파일이 또 있다고 생각하면 편하다.  
char (배열이름)[][] = {{'a','b','c',},{'d','e','f'}}; 【3x2 배열 생성.】  

**자바의 예외처리**  
*예외(Exception)* = 자바에서 실행 중 발생하는 에러.  
```
try {  
    예외가 발생할 가능성이 있는 실행문(try 블록)  
}  
catch (처리할 예외 타입 선언){  
    예외 처리문(catch 블록)  
}  
finally{  
    예외 발생 여부와 상관없이 무조건 실행되는 문장(finally 블록)  
}  
```
**이 세상은 일말의 거리낌도 없이, 이 모든 것이 『객체』다.**  
class : 객체 모양을 선언한 틀.  
자바 상속 > 상위의 클래스를 하위 클래스가 물려받음.  
객체지향 언어의 목적은 당연 생산성이다.  
    └ 실세계의 일을 보다 쉽게 프로그래밍하기 위함.  

클래스 생성과 생성자를 이용한 코드 제작을 연습했다. 예제는 src 안의 ***Test.java***이다. (전에 했던 코드들은 주석처리 해놓음.)

**생성자**  
▶ 생성자의 목적은 객체 생성 시 초기화를 하기 위함이다.  
▶ 생성자는 중복 가능. 여러개 생성 가능.  
▶ 생성자는 객체 생성시 한번만 호출.  
▶ 생성자는 리턴 타입 지정 X.  
생성자가 생성되지 않았을 경우, 컴파일러가 *자동 삽입* 해주는 듯 하다.

**this 레퍼런스**  
중복을 없애려고 사용하는 듯 하다. 생성자 내에서 가장 첫 줄에 있어야 함. *조금 이해하기 힘든 개념이다...*  

**메소드**  
ㆍ 자바의 모든 메소드는 반드시 클래스 안에 있어야 함(캡슐화 원칙)  
▶ 접근 지정자 : 다른 클래스에서 메소드 접근할 수 있는지 여부.  
▶ 리턴 타입 : 메소드가 리턴하는 값의 데이터 타입  
【오버로딩】 : 한 클래스 내에서 2개 이상의 이름이 같은 메소드 작성.  
    └ 메소드 이름이 동일해야 함.  
    └ 매개 변수의 개수가 다르가나, 타입이 달라야함.  

**가비지**  
가리키는 레퍼런스가 없는 객체.  
```
Person a, b;
a = new Person("이몽룡");
b = new Person("성춘향");

b = a;
```
이러면 b(성춘향이 들어가 있음)를 a(이몽룡이 들어가 있음)로 덮어서 넣어버렸고, 원래 b였던 "성춘향"은 버려지게되었다. 이건 *가비지*다.  
※**가비지 컬렉터**라는 가상의 무언가가 가비지를 자동 회수한다.
    └ System.gc();   =   가비지 컬렉션 작동.

## 3월29일
**여러가지**  
String = 문자열  
상수선언하려면 final (데이터타입) (상수이름) = (값).  
var = 아주 간편하게 타입 생략하고 변수 선언가능. 값을 비우면 오류!  
System.out.println = 키보드로 값 입력.  
scanner = 입력한 값을 읽어서 타입별로 리턴. 위에랑 같이 사용함.  

**연산자**  
ㆍ +, -, *, / (사칙연산) , % = 나누고 나머지 값 계산.  
ㆍ a++ , a-- (a를 1 증가,감소하고 계산되기 전의 값 반환.)  
ㆍ ++a , --a (a를 1 증가,감소한 값 반환.)  
ㆍ < ,> ,== , != (부등호와 등호. 같지 않은 경우 !=)  
ㆍ !a (a가 true면 false, false면 true)  
ㆍ a^b (a=b이면 false)  
ㆍ a||b(a와b 모두 false면 false) , a&&b (a,b 모두 true면 true)  
ㆍ (하나)?(둘):(셋) = 하나가 참이면 둘. 아니면 셋. (if-else)로 치환가능.  

**if**문과 **else**문을 배웠다. 그와 비슷한 **case와 switch**의 사용법도 배웠다. 실습이 더 필요할 듯 하다. ← 예시로 만들어본 if-else문 예제는 src 안의 ***Test.java***이다.

**for(초기문; 조건식; 반복 후 작업) { ~작업문~ }**  
반복문.

**배열(array)** : 인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료구조. 0부터 시작.  
*int (배열이름)[];* 또는 *int[] (배열이름);* ← 크기 지정 안됨 [] 안에 값 못 넣는다.  
*intArray = new int[5];* 또는 ***int (배열이름)[] = new int[5];*** 보통 이런 식으로 선언 하는듯.  
int intArray = new int[5]; (인덱스 0~4까지 5개 놓았음.)
intArray[2] = 5; (2번에 5 넣음. []안에 번호, = 뒤에 값을 넣어줌.)  
int n = intArray[3]; (2번의 값을 n에 넣음. 위에 보면 2번에는 5가 들어있음ㅋ.)  
※intArray[] 안에 음수 못 넣음.  
(배열이름).length 해서 배열값을 편하게 불러 받을 수 있다.

## 3월22일
새 프로젝트 생성 후 안의 디렉토리만 복사, 원래 쓰던 파일에 붙여넣기 했다. 이후 자바 파일을 Run 돌려보니 작동하는 걸 확인했다. 이후 프로그램 작성언어와 WORA, 컴파일에 대하여, 자바SE의 구성을 학습하였다. 아직은 아리송하다.

자바의 특성. 소스(.java)와 클래스(.class), 하나의 소스 파일에 여러 클래스를 작성 가능하다. 소스파일 이름과 클래스 이름은 같아야함. 어떤 클래스든 메인 메소드에서 시작. Ctrl + / 를 누르면 주석으로 전환된다.

8가지의 데이터 기본 타입을 다시금 알게 되었다.

Java 파일을 생성하고 **Window Powershall** 안에서 실행도 시켜보았다. cd ~로 자바 파일이 있는 프로젝트 파일에 들어가 자바 파일을 실행시켜 보았더니 잘 나왔다. (javac Foo.java → java Foo) 보아하니 탐색기 왼쪽 맨 위의 파일 탭에서 'Windows Powershall로 열기'를 누르면 간편히 실행된다. 처음 아는 사실이었다.

## 3월15일
**Github**를 통하여 클론을 이용, 내 컴퓨터에 여러 파일을 불러왔다.
여기서 불러온 것을 수정을 하여 변경된 사항을 Commit 하여 Github 자체에 업데이트를 하였다.

 **.gitignore**에서 올리고 싶지 않은 파일이나 디렉토리를 적어 올리지 않는 방법 또한 익혔다.
 (*.gif) < 이런 식으로 해당 확장자 전체를 올리지 않을 수도 있고, job/ 과 같이 디렉토리를 올리지 않을 수 있다.

 **Commit** 할 때에는 제목을 적어 commit 해야한다. Commit 하니 Github에서 변경된 사항이 업데이트 된 것을 확인할 수 있었다.

 **Java**를 VSCode에서 만들어보았다. 이클립스보다 간편하게 Java파일을 다루어볼 수 있었다. 자바 파일을 만들 때는 파일의 첫 글자를 대문자로 한다.(파스칼표기법이라나 뭐라나)

 ## 3월8일
 개행하려면 스페이스 2개 입력  
가나다  
라마바  

*이탤릭체* - **볼드** - ***이탤릭 + 볼드***  

리스트 <list>
1. 김민준
2. 김민준
8. 김민준
4. 김민준
5. 김민준

* 안양시
    * 동안구
        * 호계동
- 안양시
    - 만안구
        - 박달동