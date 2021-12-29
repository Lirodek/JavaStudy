package Training;
abstract class PairMap{
	protected String keyArray[];//키들을 저장하는배열 cl
	protected String valueArray[];//value들을 저장하는 배열 cl
	abstract String get(String key);//키 값을 가진 value리턴, 없으면 null리턴 cl
	abstract void put(String key, String value);//key와 value를 쌍으로 저장, 기존에 키가 없으면 값을 밸류로 수정
	abstract String delete(String key);//키 값을 가진 아이템 밸류와 함께 삭제 삭제된 밸류값 리턴
	abstract int length();//현재 아이템의 개수 리턴
}
class Dicitionary extends PairMap{
	int cnt=0;
	int n=0;
	String[] keyArray = new String[100];
	String[] valueArray = new String[100];
	Dicitionary(int n){
		this.n = n;
	}
	
	@Override
	String get(String key) {
		int i=0;
		for(i =0; i<n;i++) {
			if(key.equals(null)) return keyArray[i];
			if(this.keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}
		return valueArray[i];
	}

	@Override
	void put(String key, String value) {
		for(int i=0;i<cnt;i++) {
			if(keyArray[i].equals(key)) {
				valueArray[i] = value;
			}
		}
		keyArray[cnt] = key;
		valueArray[cnt] = value;
		cnt++;
	}

	@Override
	String delete(String key) {
		for(int i =0; i<cnt;i++) {
			if(this.keyArray[i].equals(key)) {
				keyArray[i] =null;
				valueArray[i] = null;
			}
		}
			return key;
	}

	@Override
	int length() {
		return cnt;
	}
	
}
public class Training5 {

	public static void main(String[] args) {
		Dicitionary dic = new Dicitionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 "+dic.get("이재문"));
		System.out.println("황기태의 값은 "+dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 null");


	}

}
