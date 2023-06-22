package com.sp.otp;

import java.util.*;

public class CreateOTP {
	
	public String generateOTP()
	{
		String s=null;
		List ar=new ArrayList();
		ar.add(0);
		ar.add(1);
		ar.add(2);
		ar.add(3);
		ar.add(4);
		ar.add(5);
		ar.add(6);
		ar.add(7);
		ar.add(8);
		ar.add(9);
		ar.add("a");
		ar.add("b");
		ar.add("c");
		ar.add("d");
		ar.add("e");
		ar.add("f");
		ar.add("g");
		ar.add("h");
		ar.add("i");
		ar.add("j");
		ar.add("k");
		ar.add("l");
		ar.add("m");
		ar.add("n");
		ar.add("o");
		ar.add("p");
		ar.add("q");
		ar.add("r");
		ar.add("s");
		ar.add("t");
		ar.add("u");
		ar.add("v");
		ar.add("w");
		ar.add("x");
		ar.add("y");
		ar.add("z");
		System.out.println("OTP generated");
		Collections.shuffle(ar);
		return s=ar.get(0)+""+ar.get(1)+""+ar.get(2)+""+ar.get(3)+""+ar.get(4)+""+ar.get(5);
	}

}
