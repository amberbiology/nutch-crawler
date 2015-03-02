/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nutch.urlfilter.regex;

// JDK imports
import java.io.IOException;
import java.io.Reader;

import org.apache.nutch.net.*;
// Nutch imports
import org.apache.nutch.urlfilter.api.RegexURLFilterBaseTest;
import org.junit.Assert;
import org.junit.Test;


/**
 * JUnit based test of class <code>RegexURLFilter</code>.
 *
 * @author J&eacute;r&ocirc;me Charron
 */
public class TestRegexURLFilter extends RegexURLFilterBaseTest {


  protected URLFilter getURLFilter(Reader rules) {
    try {
      return new RegexURLFilter(rules);
    } catch (IOException e) {
      Assert.fail(e.toString());
      return null;
    }
  }
  
  @Test
  public void test() {
    test("WholeWebCrawling");
    test("IntranetCrawling");

    // Benchmarks on Intel i53570k
    
    bench(50, "Benchmarks"); //  bench time (50) 126ms
    bench(100, "Benchmarks"); // bench time (100) 131ms
    bench(200, "Benchmarks"); // bench time (200) 251ms
    bench(400, "Benchmarks"); // bench time (400) 500ms
    bench(800, "Benchmarks"); // bench time (800) 999ms
    
    // The set of rules for BCube slows down the generation process 
    // but help a lot on limiting the crawl to sites of interest.
    test("BCube");       
    bench(50, "BCube");  // bench time (50) 595ms
    bench(100, "BCube"); // bench time (100) 1153ms
    bench(200, "BCube"); // bench time (200) 2353ms
    bench(400, "BCube"); //bench time (400) 4671ms
    
    
    
    
    
    
    
    
    
    

    
  }

}
