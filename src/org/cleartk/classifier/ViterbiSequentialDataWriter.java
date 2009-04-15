/** 
 * Copyright (c) 2009, Regents of the University of Colorado 
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
package org.cleartk.classifier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.cleartk.classifier.encoder.features.FeaturesEncoder;
import org.cleartk.classifier.encoder.features.FeaturesEncoder_ImplBase;
import org.cleartk.classifier.encoder.outcome.OutcomeEncoder;
import org.cleartk.util.ReflectionUtil;

public abstract class ViterbiSequentialDataWriter<INPUTOUTCOME_TYPE, OUTPUTOUTCOME_TYPE, FEATURES_TYPE> implements DataWriter<INPUTOUTCOME_TYPE> {

	public static final String OUTCOME_FEATURE_EXTRACTOR_FILE_NAME = "outcome-features-extractors.ser";

	/**
	 * "org.cleartk.classifier.ViterbiSequentialDataWriter.PARAM_OUTCOME_FEATURE_EXTRACTOR"
	 * is an optional, multi-valued, string parameter that specifies which
	 * OutcomeFeatureExtractors should be used. Each value of this parameter
	 * should be the name of a class that implements
	 * {@link OutcomeFeatureExtractor}. One valid value that you might use is "org.cleartk.classifier.feature.extractor.outcome.DefaultOutcomeFeatureExtractor".
	 */
	public static final String PARAM_OUTCOME_FEATURE_EXTRACTOR = "org.cleartk.classifier.ViterbiSequentialDataWriter.PARAM_OUTCOME_FEATURE_EXTRACTOR";

	protected DataWriter dataWriter;
	
	public ViterbiSequentialDataWriter(File outputDirectory) {
	}

}
