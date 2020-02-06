package com.imnu.SchoolBus;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
	/*
	 * private MockMvc mvc;
	 * 
	 * @Before public void before() { mvc = MockMvcBuilders.standaloneSetup(new
	 * AdminController()).build(); }
	 * 
	 * @org.junit.Test public void contectLoads() throws Exception { RequestBuilder
	 * req = get("/admins/text");
	 * mvc.perform(req).andExpect(status().isOk()).andExpect(content().string(
	 * "driverlist")); }
	 */
    
}
