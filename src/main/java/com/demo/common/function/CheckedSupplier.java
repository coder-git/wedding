package com.demo.common.function;

import org.springframework.lang.Nullable;

/**
 * 受检的 BinderSupplier
 *
 * @author L.cm
 */
@FunctionalInterface
public interface CheckedSupplier<T> {

	/**
	 * Run the Supplier
	 *
	 * @return T
	 * @throws Throwable CheckedException
	 */
	@Nullable
	T get() throws Throwable;

}
