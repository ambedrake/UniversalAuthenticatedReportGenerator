package com.roguedevstudios.uarg.JSON.Parser.Serializer;
/********************************************
*  Float[] Variable Deserializer			*
*   File Name: 								*
*   FloatArrayVariableDeserializer.java 	*
*                            	   	    	*
*   Deserializes JSON						*
*   information and converts				*
*   into Java objects	        			*
*                               			*
*  �2017 Rogue Dev Studios, LLC 			*
*********************************************/

import java.lang.reflect.Type;

import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;

/**
 * <p>
 * converts Variable.json information into Java Objects
 * <p>
 * 
 * @author Terry Roberson
 * @since 1.0
 */
public class FloatArrayVariableDeserializer implements JsonDeserializer<IVariable<Float[]>> {

	/**
	 * Deserializes into a Variable<Float> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Variable<Float>
	 */
	
	public IVariable<Float[]> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		/*Temp slot for variable name*/
		String _name = null;
		/*Temp slot for variable ID*/
		String _id = null;
		/*Temp slot for variable value*/
		Float[] _value = null;
		/*Temp slot for variable description*/
		String _description = null;
		/*Temp slot for variable requiresInput*/
		boolean _requiresInput = false;
		/*Temp output object holder*/
		IVariable<Float[]> v;
		
		/* Convert JsonElement into JsonObject */
		JsonObject o = json.getAsJsonObject();
		
		//If the object has a name, then we grab it
		if(o.has("name")) {
			_name = o.get("name").getAsString();
		}
		
		//If the object has an ID, then we grab it
		if(o.has("ID")) {
			_id = o.get("ID").getAsString();
		}
		
		//If the object has a value, then we grab it
		if(o.has("value")) {
			JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray("value");
			return context.deserialize(jsonArray, IVariable.class);
		}
		
		//If the object has a description, then we grab it
		if(o.has("description")) {
			_description = o.get("description").getAsString();
		}
		
		//Build the Variable object to return
		v = new Variable<Float[]>(_name, _id, _requiresInput, _description, _value);
			
		return v;
	}
}
