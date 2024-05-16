package com.exterro;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Keep_Notess")
public class Keep {

	@Id
	private int id;
	private String A[];

	

	public Keep(String A[]) {
		super();
		this.A = A;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String[] getA() {
		return A;
	}
	
	public void setA(String[] a) {
		A = a;
	}
	@Override
	public String toString() {
		return "Keep [id=" + id + ", A=" + Arrays.toString(A) + "]";
	}
	
	
	
	

}
