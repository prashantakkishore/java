package com.pks.java.eight.streams;

import java.util.stream.BaseStream;

public class StreamBasics {

	/**
	 * 1 : Stream is a Interface with below signature.
	 * 2 : Operations can be defined on Streams.
	 * 3 : Stream doesn't hold any data.
	 * 4 : Used in Map/Filter/Reduce scenario.
	 * 5 : This can efficiently process large/small amount of data.
	 * 6 : Efficient ? 
	 * 			1 - Can be run in parallel 
	 * 			2 - Its pipelined, to avoid intermediary operations
	 * 			3 - Does processing in single pass.
	 */
	public interface Stream<T> extends BaseStream<T, Stream<T>> {
		// .... //
	}

}
