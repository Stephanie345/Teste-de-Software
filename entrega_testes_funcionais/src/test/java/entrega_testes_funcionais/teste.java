package model;

import org.json.simple.JSONObject;

	@Test
    public void jsonObjectToString()  {
        String str = 
            "{"+
                "\"valor_nominal\":100,"+
                "\"dia\":[1,2,3]"+
            "}";
        JSONObject jsonObject = new JSONObject(str);
		Object doc = Configuration.defaultConfiguration().jsonProvider().parse(jsonObject.toString());
		assertTrue("optDouble() should return default double",100 == jsonObject.optDouble("myKey", 100));
		assertTrue("expected 1", Integer.valueOf(1).equals(jsonObject.query("/dia/0")));
		assertTrue("expected 2", Integer.valueOf(2).equals(jsonObject.query("/dia/1")));
        assertTrue("expected 3", Integer.valueOf(3).equals(jsonObject.query("/dia/2")));
   
		
       
    }