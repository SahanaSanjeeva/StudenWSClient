package com.wsresclient.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
	private String type; 
	private Value value;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Quote{" +
					"type = '" + type + '\'' +
					", value = " + value + 
					"}";
	}
}
//json string
//Array   ["","",""]
//Map {"key1":1,"key2":"2"}
//array of maps 
/*[
	{
		key1:value1,
		key2:value2
	},
	{
		key1:value1,
		key2:value2
	}
]
		
map of arrays		

{
	"key":[{},"",""]

}

*/


