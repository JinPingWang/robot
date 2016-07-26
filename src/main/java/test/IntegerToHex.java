package test;

public class IntegerToHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 32;
		System.out.println(toHex(i));
		System.out.println(toBinary(i));
	}
	
	private static String toHex(int i){
		char ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		StringBuilder sb = new StringBuilder();
		while(i>0){
			sb.append(ch[i%16]);
			i = i/16;
		}
		String result = "0x" + sb.reverse().toString();
		return result;
	}
	
	private static String toBinary(int i){
		char ch[] = {'0', '1'};
		StringBuilder sb = new StringBuilder();
		while(i>0){
			sb.append(ch[i%2]);
			i = i/2;
		}
		String result = "0" + sb.reverse().toString();
		return result;
	}
}
