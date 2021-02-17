package MusicXML;

public class Keys {
	char[] keyArr = new char[6];
	
	public Keys(String[] singleStaff) {
		char[] tmp;
		for (int i = 0; i < singleStaff.length; i++) {
			tmp = singleStaff[i].toCharArray();
			keyArr[i] = tmp[0];
		}
	}
	
	public char[] getAllKeys() {
		return keyArr;
	}
	
	public char getKeyInString(int string) {
		return keyArr[string];
	}
	
}
