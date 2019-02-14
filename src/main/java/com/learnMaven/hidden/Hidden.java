package com.learnMaven.hidden;


public class Hidden {

   public static String apiKey; 
   public static String apiId;

   public static void setHiddenVars (){
        apiKey = "bbc002e5";
        apiId =  "tt3896198";
   }
    
   public static String getApiKey(){
       return apiKey;
   }

   public static String getApiId(){
       return apiId;
   }
    
}