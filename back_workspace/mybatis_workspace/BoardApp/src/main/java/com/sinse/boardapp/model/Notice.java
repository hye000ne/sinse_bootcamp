package com.sinse.boardapp.model;

import lombok.Data;

@Data
public class Notice {
	private int notice_id;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int hit;
}