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
package org.cleartk.classifier.feature.proliferate;

import java.util.Collections;
import java.util.List;

import org.cleartk.classifier.Feature;


/**
 * <br>Copyright (c) 2007-2008, Regents of the University of Colorado 
 * <br>All rights reserved.

 *
 * @author Philip Ogren
 *
 */

public class ContainsHyphenProliferator extends FeatureProliferator{

	public static final String DEFAULT_NAME = "ContainsHyphen";

	/**
	 * string value contains a hyphen
	 */
	public static final String CONTAINS_HYPHEN = "CONTAINS_HYPHEN";
	/**
	 * string value contains no hyphen
	 */
	//TODO do we create a feature for tokens that do not have a hyphen?
	public static final String NO_HYPHEN = "NO_HYPHEN";
	
	public ContainsHyphenProliferator() {
		super(ContainsHyphenProliferator.DEFAULT_NAME);
	}
	public ContainsHyphenProliferator(String featureName) {
		super(featureName);
	}

	@Override
	public List<Feature> proliferate(Feature feature) {
		String featureName = Feature.createName(this.getFeatureName(), feature.getName());
		Object featureValue = feature.getValue();
		if(featureValue == null) return Collections.emptyList();
		else if(featureValue instanceof String) {
			String value = featureValue.toString();
			if(value == null || value.length() == 0) return Collections.emptyList();
			if(value.indexOf("-") != -1)
				return Collections.singletonList(new Feature(featureName, CONTAINS_HYPHEN)); 
		}
		return Collections.emptyList();
	}
}