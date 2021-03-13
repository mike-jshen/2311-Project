package MusicXML;

public class DrumKeys {
	
	private char[] keyArr = new char[6];

	public DrumKeys(String[] singleStaff) {
		char[] tmp;
		for (int i = 0; i < singleStaff.length; i++) {
			tmp = singleStaff[i].toCharArray();
			keyArr[i] = tmp[0];
		}
	}

	public char[] getAllKeys() {
		return keyArr;
	}

	public String getKeyInString(int string) {
		return Character.toString(keyArr[string]);
	}

}
