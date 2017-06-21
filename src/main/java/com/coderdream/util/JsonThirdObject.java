package com.coderdream.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonThirdObject {

	private int age = 81;

	private String name = "Michael Caine";

	private List<String> messages;

	public JsonThirdObject() {
		this.messages = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1733920964620607839L;
			{
				add("You wouldn't hit a man with no trousers..");
				add("At this point, I'd set you up with a..");
				add("You know, your bobby dangler, giggle stick,..");
			}
		};
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	/**
	 * <pre>
	 * {
	"age": 52,
	"name": "Jim Carrey",
	"jsnFO": {
	    "age": 76,
	    "name": "Morgan Freeman",
	    "jsnSO": {
	        "age": 83,
	        "name": "Clint Eastwood",
	        "jsnTO": {
	            "age": 81,
	            "name": "Michael Caine",
	            "messages": [
	                "You wouldn't hit a man with no trousers..",
	                "At this point, I'd set you up with a..",
	                "You know, your bobby dangler, giggle stick,.."
	            ]
	        },
	        "messages": [
	            "This is the AK-47 assault..",
	            "Are you feeling lucky..",
	            "When a naked man's chasing a.."
	        ]
	    },
	    "messages": [
	        "I once heard a wise man say..",
	        "Well, what is it today? More..",
	        "Bruce... I'm God. Circumstances have.."
	    ]
	},
	"messages": [
	    "Hey, maybe I will give you..",
	    "Excuse me, I'd like to..",
	    "Brain freeze. Alrighty Then I just.."
	]
	}
	 * 
	 * 
	 * </pre>
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Json jsonObj = new Json();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Convert Java object to JSON format and save to file");

		try {
			mapper.writeValue(new File("c:\\jackson.json"), jsonObj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Getter and setter

}

class JsonSecondObject {

	private int age = 83;

	private String name = "Clint Eastwood";

	private JsonThirdObject jsnTO = new JsonThirdObject();

	private List<String> messages;

	public JsonSecondObject() {
		this.messages = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7259077804882381773L;

			{
				add("This is the AK-47 assault..");
				add("Are you feeling lucky..");
				add("When a naked man's chasing a..");
			}
		};
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JsonThirdObject getJsnTO() {
		return jsnTO;
	}

	public void setJsnTO(JsonThirdObject jsnTO) {
		this.jsnTO = jsnTO;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}

class JsonFirstObject {

	private int age = 76;

	private String name = "Morgan Freeman";

	private JsonSecondObject jsnSO = new JsonSecondObject();

	private List<String> messages;

	public JsonFirstObject() {
		this.messages = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2412837190201933482L;
			{
				add("I once heard a wise man say..");
				add("Well, what is it today? More..");
				add("Bruce... I'm God. Circumstances have..");
			}
		};
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JsonSecondObject getJsnSO() {
		return jsnSO;
	}

	public void setJsnSO(JsonSecondObject jsnSO) {
		this.jsnSO = jsnSO;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}

class Json {

	private int age = 52;

	private String name = "Jim Carrey";

	private JsonFirstObject jsnFO = new JsonFirstObject();

	private List<String> messages;

	public Json() {
		this.messages = new ArrayList<String>() {
			private static final long serialVersionUID = 3487765915776135035L;
			{
				add("Hey, maybe I will give you..");
				add("Excuse me, I'd like to..");
				add("Brain freeze. Alrighty Then I just..");
			}
		};
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JsonFirstObject getJsnFO() {
		return jsnFO;
	}

	public void setJsnFO(JsonFirstObject jsnFO) {
		this.jsnFO = jsnFO;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
