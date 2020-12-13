package com.soul.base.juc.level05;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ��N�Ż�Ʊ��ÿ��Ʊ����һ�����
 * ͬʱ��10�����ڶ�����Ʊ
 * ��дһ��ģ�����
 *
 * ��������ĳ�����ܻ������Щ���⣿
 * �ظ����ۣ��������ۣ�
 *
 * ʹ��Vector����Collections.synchronizedXXX
 * ����һ�£������ܽ��������
 *
 * �������A��B����ͬ���ģ���A��B��ɵĸ��ϲ���Ҳδ����ͬ���ģ���Ȼ��Ҫ�Լ�����ͬ��
 * ������������ж�size�ͽ���remove������һ������ԭ�Ӳ���
 *
 * ʹ��ConcurrentQueue��߲�����
 *
 */
public class T20_TicketSeller4 {
	static Queue<String> tickets = new ConcurrentLinkedQueue<>();
	
	
	static {
		for(int i=0; i<1000; i++) tickets.add("Ʊ ��ţ�" + i);
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			new Thread(()->{
				while(true) {
					String s = tickets.poll();
					if(s == null) break;
					else System.out.println("������--" + s);
				}
			}).start();
		}
	}
}