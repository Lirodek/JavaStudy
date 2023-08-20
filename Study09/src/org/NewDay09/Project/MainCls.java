package org.NewDay09.Project;

import java.util.Scanner;


// ------------------ Model ---------------
class Music {
   // 가수, 노래
   private String type;
   private String song;
   public Music(String song, String type) {
      this.type = type;
      this.song = song;
   }
   
   public String getSong() {
      return song;
   }

   public void play() {
      System.out.printf("%s type의 %s가 실행됩니다. ", type, song);
   }
}

class DanceMusic extends Music {
   private String name;
   public DanceMusic(String name, String song, String type) {
      super(song, type);
      this.name = name;
   }
   @Override
   public void play() {
      super.play();
      System.out.printf("가수는 %s입니다.\n", name);
   }
}

class NCSMusic extends Music {
   public NCSMusic(String song, String type) {
      super(song, type);
   }
   
   @Override
   public void play() {
      super.play();
      System.out.println("No Copyrignt Sound!");
   }
}

class DataAccessModel {
   public static final int MAX = 12;
   private Music[] musicList = new Music[MAX];
   private int top = 0;
   
   public void appendMusic(Music music) {
      // 음악 추가 - top이 MAX이상이면 추가 불가능.
      if(music != null) {
         musicList[top++] = music;
         System.out.println(">>> 음악 추가 성공 : " + music.getSong());
      }
   }
   public Music removeMusic(int idx) {
      // top이 0이하이면 제거가 불가능.
      Music music = musicList[idx];
      for(int i = idx; i<top-1; i++) {
         musicList[i] = musicList[i+1];
      }
      top--;
      musicList[top]=null;
      return music;
   }
   public Music findMusic(Music music) {
      // 음악 검색
      Music findMusic = null;
      for(int i=0; i<top; i++) {
         if((music.getSong()).equals(musicList[i].getSong()) ) {
            findMusic = musicList[i];
         }
      }
      
      return findMusic;
   }
   public Music[] getAllMuic() {
      // 모든 음악 실행
      return musicList;
   }
}
// ---------------- end of Model -------------------
//객체간의 데이터를 바인딩 해주는 클래스
class R{
	public static int choice;
	public static Music music;
	public static Music[] musicList;
	
	public static ViewPage menu = new Menu();
	public static ViewPage input = new Input();
	public static ViewPage list = new MusicList();
	public static ViewPage deletMusic = new DeleteMusic();
	
	public static DataAccessModel dam = new DataAccessModel();
}

// ----------------- View (화면에 보여지는 내용) ------------------
class ViewPage {
   // 뷰페이지 구현 하는 부분 -모든 뷰들의 부모
	protected final Scanner scan = new Scanner(System.in);
	public void display() {
		
	}
}
class Menu extends ViewPage{
	@Override
	public void display() {
		System.out.println("------------------MENU------------------");
		System.out.println("1.음악삽입 2.모든음악실행 3.음악제거 4.음악찾기 5.종료");
		int choice = scan.nextInt();
	}
}
class Input extends ViewPage{
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("------------------노래추가------------------");
		System.out.println("노래 제목 : ");
		String title = scan.next();
		System.out.println("노래 제목 : ");
		String name = scan.next();
		R.music = new NCSMusic(title,name);
	}
}
class OutPut extends ViewPage{
	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display();
	}
}
class MusicList extends ViewPage{
	@Override
	public void display() {
		System.out.println("------------------노래목록------------------");
		for(Music music:R.musicList) {
			music.play();
		}
	}
}
class DeleteMusic extends ViewPage{
	@Override
	public void display() {
		System.out.println("------------------노래삭제------------------");

		super.display();
	}
}

class ViewContainer {
   // 뷰를 실행하는 부분
	public void run(ViewPage view) {
		view.display();
	}
}
//----------------- End of View (화면에 보여지는 내용) ------------

// ------------------ Controller (제어문) ----------------
class MusicPlayer {
   // 제어하는 곳
	ViewContainer vc =new ViewContainer();
	
	public void action() {
		if(R.choice==0) {
			vc.run(R.menu);
		}
		switch(R.choice) {
		case 1: vc.run(R.input);break;
		case 2: vc.run(R.list);break;
		case 3: vc.run(R.deletMusic);break;
		case 4: System.out.println("준비중...");break;
		case 5: System.out.println("끝.");System.exit(0);break;
		}
		R.choice = 0;
		action();
	}
}
//------------------ End of Controller (제어문) ----------

public class MainCls {
   public static void main(String[] args) {
	   MusicPlayer player = new MusicPlayer();
	   player.action();
      
   }
}