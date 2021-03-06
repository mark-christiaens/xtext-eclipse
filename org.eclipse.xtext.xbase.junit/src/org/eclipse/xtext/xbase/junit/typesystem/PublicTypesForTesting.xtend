/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.typesystem

import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated Use org.eclipse.xtext.xbase.testing.typesystem.PublicResolvedTypes instead
 */
@Deprecated
class PublicResolvedTypes extends RootResolvedTypes {
	new(DefaultReentrantTypeResolver resolver) {
		super(resolver, CancelIndicator.NullImpl)
	}
	
	override UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter type) {
		super.createUnboundTypeReference(expression, type)
	}
	
	override getUnboundTypeReference(Object handle) {
		super.getUnboundTypeReference(handle)
	}
	
	override getHints(Object handle) {
		super.getHints(handle)
	}
	
	override basicGetExpressionTypes() {
		super.basicGetExpressionTypes()
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PublicStackedResolvedTypes extends StackedResolvedTypes {
	new(ResolvedTypes parent) {
		super(parent)
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PublicReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	override setTypeComputer(ITypeComputer typeComputer) {
		super.setTypeComputer(typeComputer)
	}
	
	override getBatchScopeProvider() {
		super.getBatchScopeProvider()
	}
	
}
