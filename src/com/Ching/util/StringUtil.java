package com.Ching.util;

//�ִ�������
public class StringUtil {
//�п�
public static boolean isEmpty(String str) {
	//trim�ǰ�ǰ��ո�ȥ��
	if (str==null||"".equals(str.trim())) {
		return true;
	}
	else {
		return false;
	}
}	

//�зǿ�
	public static boolean isNotEmpty(String str) {
		if (str==null&&"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
