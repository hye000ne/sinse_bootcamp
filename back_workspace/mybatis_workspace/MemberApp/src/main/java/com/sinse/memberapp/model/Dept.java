package com.sinse.memberapp.model;

import java.util.List;

import lombok.Data;

@Data
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	private List<Emp> empList;
}
