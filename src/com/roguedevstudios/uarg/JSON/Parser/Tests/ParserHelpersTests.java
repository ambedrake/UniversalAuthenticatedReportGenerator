package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.ParserHelpers;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
/**
 * <p>
 * This will test the ParserHelper.java file
 * <p>
 * @author Christopher E. Howard
 * @author Terry Roberson
 * @since 1.0
 */
public class ParserHelpersTests {
	
	//***** INTEGER TESTING SECTION ******\\
	@Test
	public void ParseIntegerVariableTest() {
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		int valueValue = 500;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign  elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Integer> testVar = ParserHelpers.ParseIntegerVariable(testElement, "TestID");
		
		// Fetch Information about Integer Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue,(int)testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestIntegerSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		int ValueValue = 50;
		int ValueValue1 = 500;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String,Variable<Integer>> testMap = ParserHelpers.ParseIntegerVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
		
	}
	
	//***** STRING TESTING SECTION *****\\
	@Test
	public void ParseStringVariableTest() {
		
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description";
		String descriptionValue = "TestDescription";
		String value = "value";
		String valueValue = "A";
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<String> testVar = ParserHelpers.ParseStringVariable(testElement, "TestID");
		
		// Fetch Information about String Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestStringSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		String ValueValue = "A";
		String ValueValue1 = "B";
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String,Variable<String>> testMap = ParserHelpers.ParseStringVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
	}
	
	//***** DOUBLE TESTING SECTION *****\\
	@Test
	public void ParseDoubleVariableTest() {
		
		//Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Double valueValue = 5.4;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Double> testVar = ParserHelpers.ParseDoubleVariable(testElement, "TestID");
		
		// Fetch Information about Double Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		//Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestDoubleSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Double ValueValue = 575.2;
		Double ValueValue1 = 52.6;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String,Variable<Double>> testMap = ParserHelpers.ParseDoubleVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
		
	}
	
	//***** LONG TESTING SECTION *****\\
	@Test
	public void ParseLongVariableTest() {
		
		// Set up initial conditions 
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Long valueValue = 54L;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Long> testVar = ParserHelpers.ParseLongVariable(testElement, "TestID");
		
		// Fetch Information about Double Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestLongSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Long ValueValue = 50L;
		Long ValueValue1 = 500L;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String,Variable<Long>> testMap = ParserHelpers.ParseLongVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
		
	}
	
	//***** FLOAT TESTING SECTION *****\\
	@Test
	public void ParseFloatVariableTest() {
		
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Float valueValue = 67F;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Float> testVar = ParserHelpers.ParseFloatVariable(testElement, "TestID");
		
		// Fetch Information about Float Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestFloatSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Float ValueValue = 50F;
		Float ValueValue1 = 500F;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String,Variable<Float>> testMap = ParserHelpers.ParseFloatVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
		
	}
	
	//***** BOOLEAN TESTING SECTION *****\\
	@Test
	public void ParseBooleanVariableTest() {
		
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Boolean valueValue = true;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Boolean> testVar = ParserHelpers.ParseBooleanVariable(testElement, "TestID");
		
		// Fetch Information about Boolean Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestBooleanSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Boolean ValueValue = false;
		Boolean ValueValue1 = true;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String,Variable<Boolean>> testMap = ParserHelpers.ParseBooleanVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
	}
	
	
}
