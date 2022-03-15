package com.demo.common.utils;

import java.util.function.Supplier;

/**
 * 解决 no binder available 问题
 *
 * @author Chill
 */
public class BinderSupplier implements java.util.function.Supplier<Object> {

	@Override
	public Object get() {
		return null;
	}
}
