package com.coderdream.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;  

public class JacksonUtil {

    public static void main(String[] args) throws IOException {  
        String s = "{\"name\":123}";       
        ObjectMapper mapper = new ObjectMapper();  
        //unmarshalling (reading JSON)    
        User a = mapper.readValue(s, User.class);          
        //marshalling (reading JSON)  
        //{"name":123}  
        System.out.println(mapper.writeValueAsString(a));  
  
    }  
}

class User {
    int age;  
    int name;  
  
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getName() {  
        return name;  
    }  
  
    public void setName(int name) {  
        this.name = name;  
    } 
}
