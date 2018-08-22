/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;

import java.util.Map.Entry;

import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.ui.preferences.IBuildPreferenceEvaluator;

import com.google.common.collect.MapDifference.ValueDifference;

/**
 * @since 2.15
 * @author Titouan Vervack - Initial contribution and API
 */
public class XtextBuildPreferenceEvaluator implements IBuildPreferenceEvaluator {

	private static final String PREFIX = EclipseOutputConfigurationProvider.OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR;

	@Override
	public boolean hasBuildAffectingChanges(Entry<String, ValueDifference<String>> preference) {
		String key = preference.getKey();
		if (key.startsWith(PREFIX)) {
			String keyName = key.substring(key.lastIndexOf(PreferenceConstants.SEPARATOR) + 1);
			switch (keyName) {
				case OUTPUT_CREATE_DIRECTORY:
				case OUTPUT_OVERRIDE:
				case OUTPUT_DERIVED:
				case OUTPUT_CLEANUP_DERIVED:
				case OUTPUT_CLEAN_DIRECTORY:
				case OUTPUT_KEEP_LOCAL_HISTORY:
					return false;
			}
		}
		return true;
	}
}
