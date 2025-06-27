package com.gn.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GuestBook {
	private String name;
	private String msg;
	private LocalDateTime date;
	
}
