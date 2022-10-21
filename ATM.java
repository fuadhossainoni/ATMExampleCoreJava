package com.oni;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {

		int [] accounts = {123,234,345,456,567,678,789};
		int [] pins = {234,345,456,567,678,789,890};
		int [] balance = {0,0,0,0,0,0,0};
		Scanner sc = new Scanner(System.in);
		while (true) {
			int acn,pin;
			System.out.print("Enter Account Number: ");
			acn = sc.nextInt();
			System.out.print("Enter PIN: ");
			pin = sc.nextInt();
			for(int i=0; i<accounts.length; i++) {
				int n;
				if(acn==accounts[i]) {
					n=i;	//n'th user
					if(pins[n]==pin) {
						while (true) {
							System.out.print("\n1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.Change PIN\n5.Log Out\n");
							System.out.print("Enter Choice : ");
							int ch=sc.nextInt();
							if(ch==5) {
								System.out.println("You have been successfully logged out.");
								break;
							}
							else if(ch==1) {
								System.out.println("Your Balance is: "+balance[n]);
							}
							else if(ch==2) {
								while (true) {
									System.out.print("Enter amount to withdraw: ");
									int temp = sc.nextInt();
									if(temp<=balance[n]) {
										if(temp%500==0) {
											balance[n]-=temp;
											System.out.println("You have successfully withdrawn: "+temp);
											System.out.println("Your new balance: "+balance[n]);
											break;
										}
										else{
											System.out.println("Enter multiple of 500 please");
											break;
										}

									}
									else {
										System.out.println("Insufficient balance.");
										break;
									}
								}

							}
							else if(ch==3) {
								System.out.print("Enter amount to be deposited: ");
								int temp = sc.nextInt();
								balance[n]+=temp;
								System.out.println("You have successfully deposited: "+temp);
								System.out.println("Your Balance is: "+balance[n]);
							}
							else if(ch==4) {
								System.out.print("Enter new PIN ");
								pins[n]=sc.nextInt();
								System.out.println("Your PIN is successfully changed.");
							}
						}
					}
					else {
						System.out.println("Wrong Account Number or PIN.");
					}
				}
			}
//			sc.close();
		}
	}
}
