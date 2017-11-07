/*
 * generated by Xtext
 */
package org.eclipse.xtext.ui.tests.refactoring.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class ReferringTestLanguageIdeSetup extends ReferringTestLanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new ReferringTestLanguageRuntimeModule(), new ReferringTestLanguageIdeModule()));
	}
}
