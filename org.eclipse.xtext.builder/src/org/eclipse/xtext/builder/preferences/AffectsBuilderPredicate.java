/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import java.util.Map.Entry;

import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

import com.google.common.base.Predicate;
import com.google.common.collect.MapDifference.ValueDifference;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;

/**
 * @author Titouan Vervack - Initial contribution and API
 */
public class AffectsBuilderPredicate implements Predicate<Entry<String, ValueDifference<String>>> {
	private static final String PREFIX = EclipseOutputConfigurationProvider.OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR;

	@Override
	public boolean apply(Entry<String, ValueDifference<String>> input) {
		String key = input.getKey();
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
