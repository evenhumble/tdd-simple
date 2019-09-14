package io.hedwig.justdoit.jsoncases.jsonassert;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @@author: patrick
 */
public class JsonAssertDemo {

  @Test
  public void testJsonDemo() throws JSONException {
    String result = "{\"k1\":\"v2\"}";
    JSONAssert.assertEquals(result,"",false);
  }
}
