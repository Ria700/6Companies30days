// https://practice.geeksforgeeks.org/problems/run-length-encoding/1/#

// Run Length Encoding

// Given a string, Your task is to  complete the function encode 
// that returns the run length encoded string for the given string.

class GfG
 {
	String encode(String str)
	{
          //Your code here
          String newS="";
          int st = 0, en = 1;
          while(st<str.length()){
              while(en<str.length() && (str.charAt(en) == str.charAt(st))){
                  en++;
              }
              
              int code = (en-st);
              newS += str.charAt(st);
              newS += code;
              st=en;
              en++;
          }
          
          return newS;
	}
	
 }
