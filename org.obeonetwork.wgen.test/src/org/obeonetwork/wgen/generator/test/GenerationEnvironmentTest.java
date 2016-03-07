package org.obeonetwork.wgen.generator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.obeonetwork.wgen.generator.GenerationEnvironment;

public class GenerationEnvironmentTest {

	@Test
	public void testConstructor() {
		GenerationEnvironment env = new GenerationEnvironment();
		env.popScope();
	}

	@Test
	public void testConstructorWithDefinitions() {
		Map<String, Object> defs = new HashMap<String, Object>();
		defs.put("x", "valuex");
		defs.put("y", "valuey");
		GenerationEnvironment env = new GenerationEnvironment(defs);
		assertEquals("valuex", env.getValue("x"));
		assertEquals("valuey", env.getValue("y"));
	}

	@Test(expected = EmptyStackException.class)
	public void testEmptyStackPop() {
		GenerationEnvironment env = new GenerationEnvironment();
		env.popScope();
		env.popScope();
	}

	@Test
	public void basicDefinitionTest() {
		GenerationEnvironment env = new GenerationEnvironment();
		env.setValue("x", "valuex");
		assertEquals("valuex", env.getValue("x"));
	}

	@Test
	public void valueNotFoundTest() {
		GenerationEnvironment env = new GenerationEnvironment();

		env.setValue("x", "valuex");
		env.pushScope();
		env.setValue("y", "valuex");
		assertNull(env.getValue("z"));
	}

	@Test
	public void pushScopeDefinitionTest() {
		GenerationEnvironment env = new GenerationEnvironment();
		env.setValue("x", "valuex");
		env.setValue("y", "valuey");
		env.pushScope();
		env.setValue("x", "valuexx");
		assertEquals("valuey", env.getValue("y"));
		assertEquals("valuexx", env.getValue("x"));
	}

	@Test
	public void currentDefinitionTest() {
		GenerationEnvironment env = new GenerationEnvironment();
		env.setValue("x", "valuex");
		env.setValue("y", "valuey");
		env.pushScope();
		env.setValue("x", "valuexx");
		Map<String, Object> map = env.getCurrentDefinitions();

		assertEquals("valuey", map.get("y"));
		assertEquals("valuexx", map.get("x"));
	}

	@Test
	public void popScopeDefinitionTest() {
		GenerationEnvironment env = new GenerationEnvironment();
		env.setValue("x", "valuex");
		env.setValue("y", "valuey");
		env.pushScope();
		env.setValue("x", "valuexx");
		env.setValue("z", "valuezz");
		env.popScope();
		assertEquals("valuey", env.getValue("y"));
		assertEquals("valuex", env.getValue("x"));
		assertNull(env.getValue("z"));
	}

}