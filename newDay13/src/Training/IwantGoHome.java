package Training;
import java.util.Scanner;
import java.util.Random;

abstract class GameObject {
	protected int distance; // 한번이동거리
	protected int x, y; // 현재위치
	
	public GameObject(int startX, int startY, int distance)	 {//초기 위치와 이동 거리 설정
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	
	public int getX() { 
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) { // 좌표에 움직임 추가를 위해 x,y setter 생성
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean collide(GameObject p) { // 충돌했을때 true 리턴
		if(this.x == p.getX() && this.y == p.getY()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected abstract void move(int inputX, int inputY); // 이동 후의 새로운 위치로 x, y 변경
	protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴
}

class Bear extends GameObject {
	
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}

	protected void move(int inputX, int inputY) {
		if(!(getX() == 0 && inputX == -1)) { //bear가 맵 밖으로 나가려고할때 제외
			this.x += inputX; 
		}
		if(!(getY() == 0 && inputY == -1)) {
			this.y += inputY;
		}
	}
	
	protected char getShape() {
		return 'B';
	}
	
}

class Fish extends GameObject {
	Random rand = new Random();
	int randomMove;
	int cnt = 1;
	
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	
	protected void move(int x, int y) {
		if(cnt < 4) { // fish는 3번 이동금지
			cnt++;
			return;
		} else { // 2번 랜덤 한칸 이동
			randomMove = rand.nextInt(4);
			switch(randomMove) {
			case 0 :
				setX(getX() + 1);
				break;
			case 1 :
				setX(getX() - 1);
				break;
			case 2 :
				setY(getY() + 1);
				break;
			case 3 :
				setY(getY() - 1);
			}
			if(cnt == 5) { // 2번 이동하면 cnt를 다시 처음값 1로 초기화.
				cnt = 1;
				return;
			}
			cnt++;
		}
	}
	
	protected char getShape() {
		return '@';
	}
	
}
 



public class IwantGoHome {
	Scanner scan = new Scanner(System.in);
	char[][] map;
	Bear bear;
	Fish fish;
	int inputX = 0, inputY = 0;
	
	IwantGoHome() {
		run();
	}

	void showMap(Bear bear, Fish fish) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = '-';						   // 빈칸을 '-' 로 채운다.
				if(i == fish.getX() && j == fish.getY()) { // fish의 x,y좌표에
					map[i][j] = fish.getShape();		   // fish의 shape('@')를 넣는다.
				}
				if(i == bear.getX() && j == bear.getY()) { // 마찬가지로 bear도.
					map[i][j] = bear.getShape();		   // bear를 나중에 넣는 이유는 
				}										   // bear가 fish를 잡았을때
				System.out.print(map[i][j]);			   // @말고 B가 화면에 남기때문
			}
			System.out.println();
		}
	}
	
	void convertInput(String choice) {
		while(true) {						// 입력받은 이동에 맞춰 x,y값을 1시켜준다.
			if(choice.equals("a")) {
				inputY = -1;
				return;
			} else if(choice.equals("s")) {
				inputX = 1;
				return;
			}else if(choice.equals("w")) {
				inputX = -1;
				return;
			} else if(choice.equals("d")) {
				inputY = 1;
				return;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	
	void userControl(Bear bear, Fish fish) {
		System.out.print("왼쪽(a), 아래(s), 위(w), 오른쪽(d) >> ");
		convertInput(scan.next()); // 입력받은 값을 움직이는값 int로 변환하고
		bear.move(inputX, inputY);
		fish.move(0, 0);
		System.out.print("Bear: (" + bear.getX() + ", " + bear.getY() + ") \t"); // 좌표확인을위해
		System.out.println("Fish: (" + fish.getX() + ", " + fish.getY() + ")");  // 추가함
		
	}
	
	void run() {
		map = new char[10][20];

		bear = new Bear(0, 0, 1);
		fish = new Fish(5, 5, 1);

		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");

		while (true) {
			showMap(bear, fish);
			if(bear.collide(fish)) { // 두 객체가 충돌했을때 메세지 띄우고 종료
				System.out.println("Bear Wins!!");
				break;
			}
			userControl(bear, fish);
		}
	}

	public static void main(String[] args) {
		new IwantGoHome();
	}
}
