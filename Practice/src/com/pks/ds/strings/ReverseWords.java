package com.pks.ds.strings;

/**
Algorithm:

1) Reverse the individual words, we get the below string.
     "i ekil siht margorp yrev hcum"
2) Reverse the whole string from start to end and you get the desired output.
     "much very program this like i"

**/
public class ReverseWords {
	
	public static void main(String[] args) {
		String s = "getting good at coding needs a lot of practice";
	
		char[] chars = s.toCharArray();
		for (int i = 0, j = 0 ; i <= chars.length -1 ; i++){
			if(chars[i] == ' '){
				reverse(chars, j, i -1 );
				j = i + 1;
			} else if(i == chars.length -1){
				reverse(chars, j, i );
			}
		}
		
		reverse(chars, 0, chars.length -1);
		System.out.println(chars);
		
		
	}
	
	public static void reverse(char[] chars, int start, int end){
		char temp;
		while(start < end){
			temp = chars[start];
			chars[start ++] = chars[end];
			chars[end --] = temp;
		}
		
	}

}
