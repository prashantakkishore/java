package com.pks.java.eight.lambda.fuctionalinterfaces;

public interface FunctionalInterfaces4Category {

	//Type 1 : Supplier
	@FunctionalInterface
	public interface Supplier<T> {
		T get();
	}

	//Type 2 : Consumer
	@FunctionalInterface
	public interface Consumer<T> {
		void accept(T t);
	}

	@FunctionalInterface
	public interface BiConsumer<T, U> {
		void accept(T t, U u);
	}

	//Type 3 : Predicate
	@FunctionalInterface
	public interface Predicate<T> {
		boolean test(T t);
	}

	@FunctionalInterface
	public interface BiPredicate<T, U> {
		boolean test(T t, U u);
	}

	//Type 4 : Function
	@FunctionalInterface
	public interface Function<T, U> {
		U apply(T t);
	}

	@FunctionalInterface
	public interface BiFunction<T, U, R> {
		U apply(T t, U u);
	}

}
