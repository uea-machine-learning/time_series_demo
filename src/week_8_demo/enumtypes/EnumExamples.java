package week_8_demo.enumtypes;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Use this class to do the enum exercise sheet
 Task 1:
 1.Add an enum typeColour to the classEnumExample.Colour should have at least the seven colours of the rainbow.
 2.Write and test a static method to print out all the possible enum values and ordinal positionsofGradeandColour
 
 */
public class EnumExamples {




enum Grade{
FIRST(70), TWO_ONE(60), TWO_TWO(50), THIRD(40), FAIL(0);
	final int boundary;
	Grade(int x){
		boundary=x;
	}       
}


    
}
