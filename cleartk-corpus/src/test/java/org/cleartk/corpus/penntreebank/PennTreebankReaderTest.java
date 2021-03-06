/** 
 * Copyright (c) 2007-2008, Regents of the University of Colorado 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution. 
 * Neither the name of the University of Colorado at Boulder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. 
 */
package org.cleartk.corpus.penntreebank;

import org.apache.uima.UIMAException;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.resource.ResourceInitializationException;
import org.cleartk.test.util.DefaultTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.apache.uima.fit.factory.CollectionReaderFactory;

/**
 * <br>
 * Copyright (c) 2007-2008, Regents of the University of Colorado <br>
 * All rights reserved.
 * <p>
 * These tests are intended to verify that your local copy of the PTB will work correctly with
 * ClearTK. Several of the tests that are provided will not run by default because we cannot assume
 * any particular location of your PTB data. To run the tests below please set the member variable
 * "outputDirectory" to a value appropriate for your environment. Then, uncomment the test
 * annotations (appearing as "@Test"). Now, you can invoke the unit tests.
 * 
 * @author Philip
 * 
 */
public class PennTreebankReaderTest extends DefaultTestBase {

  private final String inputDir = "data/treebank/wsj";

  @Test
  public void testReaderDescriptor() throws UIMAException {
    try {
      CollectionReaderFactory.createReader(PennTreebankReader.class);
      Assert.fail("expected exception with no file or directory specified");
    } catch (ResourceInitializationException e) {
    }

    CollectionReader reader = CollectionReaderFactory.createReader(
        PennTreebankReader.class,
        PennTreebankReader.PARAM_CORPUS_DIRECTORY_NAME,
        this.inputDir,
        PennTreebankReader.PARAM_SECTIONS_SPECIFIER,
        "02-21");

    Object directory = reader.getConfigParameterValue(PennTreebankReader.PARAM_CORPUS_DIRECTORY_NAME);
    Assert.assertEquals(this.inputDir, directory);

    Object sections = reader.getConfigParameterValue(PennTreebankReader.PARAM_SECTIONS_SPECIFIER);
    Assert.assertEquals("02-21", sections);
  }

}
