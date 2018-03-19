 package com.hassan.cryptography;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Main {

	private static ArrayList<Character> first = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
	private static ArrayList<Character> second = new ArrayList<Character>(Arrays.asList('q', 'a', 'z', 'w', 's', 'x',
			'e', 'd', 'c', 'r', 'f', 'v', 't', 'g', 'b', 'y', 'h', 'n', 'u', 'j', 'm', 'i', 'k', 'o', 'l', 'p'));

	public static void main(String[] args) {
		String sub = JOptionPane.showInputDialog("Enter message and it will be ciphered via substitution");
		for (Character c : sub.toCharArray()) {
			System.out.print(Character.isSpaceChar(c) ? ' ' : second.get(first.indexOf(c)));
		}

		String caesar = JOptionPane.showInputDialog("Enter message and it will be ciphered via the Caesar method");
		int shift = Integer.valueOf(JOptionPane.showInputDialog("Enter the amount to shift"));
		System.out.println();
		for (int c : caesar.toCharArray()) {
			int lowercase = (Character.isLowerCase((char) c) ? (char) c : Character.toLowerCase((char) c));
			int index = first.indexOf((char) lowercase) + shift % 26;
			if (Character.isSpaceChar((char) c)) {
				System.out.print(' ');
			} else if (c == lowercase) {
				System.out.print(first.get(index % 26));
			} else {
				System.out.print(Character.toUpperCase(first.get(index % 26)));
			}

		}
		
		String decoded = JOptionPane.showInputDialog("Enter message and it be decoded via the Caesar method by shift: " + shift);
		System.out.println();
		for (int c : decoded.toCharArray()) {
			int lowercase = (Character.isLowerCase((char) c) ? (char) c : Character.toLowerCase((char) c));
			int index = first.indexOf((char) lowercase) - shift % 26;
			if (Character.isSpaceChar((char) c)) {
				System.out.print(' ');
			} else if (c == lowercase) {
				System.out.print(first.get(index % 26));
			} else {
				System.out.print(Character.toUpperCase(first.get(index % 26)));
			}

		}
	}

}
