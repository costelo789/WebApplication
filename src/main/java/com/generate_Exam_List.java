package com;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;import org.json.JSONArray;
import org.json.JSONObject;

public class generate_Exam_List {
    Map<String, Integer> numberMapping = new HashMap<>();
    public static Map<Double, Double> rt_List;
    public static Map<Double, Double> rt_Total;
    
    public static ConcurrentHashMap<Double, Double> generateAttendanceCountList(JSONArray rs){
        rt_List=new ConcurrentHashMap<>();
        for (int i = 0; i < rs.length(); i++) {
            JSONObject jsonobject = rs.getJSONObject(i);
          
            rt_List.put(jsonobject.getDouble("studentid"), jsonobject.getDouble("attendance_count"));
        }
        return (ConcurrentHashMap<Double, Double>) rt_List;    }
    public static ConcurrentHashMap<Double, Double> generateSessionCountList(JSONArray rs){
         rt_Total=new ConcurrentHashMap<>();
        for (int i = 0; i < rs.length(); i++) {
            JSONObject jsonobject = rs.getJSONObject(i);
            rt_Total.put(jsonobject.getDouble("modulesid"), jsonobject.getDouble("session_count"));
          
            
        }
        return (ConcurrentHashMap<Double, Double>) rt_Total;
        
    }
    
    public static JSONArray verifyExamList(){
        double threshold = 0.5;
        rt_Total.forEach((moduleid,session_count ) -> {
            rt_List.forEach((studentid,attendance_count ) -> {
                double result = attendance_count / session_count;
                rt_List.put(studentid, result);
                System.out.println(studentid + " => " + attendance_count);
                System.out.println("Result: "+result);
            });
           System.out.println(moduleid + " => " + session_count);
       });
        
        Iterator<Double> it1 = rt_List.keySet().iterator();
       while(it1.hasNext()){
           Double key = it1.next();
           System.out.println("Map Value:"+rt_List.get(key));
           if(rt_List.get(key)<threshold) {
               rt_List.remove(key);
           }
       }
        
        
        
        rt_List.forEach((studentid,attendance_count ) -> {
            System.out.println("verify");
            System.out.println(studentid + " => " + attendance_count);
            
       });
        
        
        JSONArray output = new JSONArray();
        JSONArray hold = new JSONArray();
        Iterator<Double> it2 = rt_List.keySet().iterator();
       while(it2.hasNext()){
           Double key = it2.next();
           hold = Communicate_MySQL_Assistant.listAccountById((int)Math.round(key));
           output.put(hold.get(0));
       }
        return output;    
    }
}