package com.lazada;



import org.testng.annotations.Test;

import pageObject.BaseClass;
import pageObject.findBirdayelement;

@Test
public class TC02_findBirthday extends BaseClass {

	
public void findbirthday() {
	

	findBirdayelement fb= new findBirdayelement(driver);
	fb.profile();
	fb.birthday();
}}
