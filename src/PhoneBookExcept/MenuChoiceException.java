package PhoneBookExcept;

public class MenuChoiceException extends Exception {
	int worongChoice;
	public MenuChoiceException(int choice) {
		super("잘못된 선택이 이뤄졌습니다.");
		worongChoice =choice;
	}
	public void showWrongChoice() {
		System.out.println(this.worongChoice+"에 해당하는 선택은 존재하지 않습니다.");
	}
}
