package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	
	private int studentNo;
	private String studentName;
	private int studentAge;
}
// 데이터를 담는 바구니 -> 데이터를 넣었다가 빼는 용도, DB랑 보통 매치함