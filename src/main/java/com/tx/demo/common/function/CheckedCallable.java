package com.tx.demo.common.function;

import org.springframework.lang.Nullable;

/**
 * 受检的 Callable
 *
 * @author L.cm
 */
@FunctionalInterface
public interface CheckedCallable<T> {

	/**
	 * Run this callable.
	 *
	 * @return result
	 * @throws Throwable CheckedException
	 */
	@Nullable
	T call() throws Throwable;
}
