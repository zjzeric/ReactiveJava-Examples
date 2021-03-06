package reactor.examples;

import common.util.CommonUtil;

public final class ThreadPrimeCalculation implements Runnable{
	
	private final long longMax;
	
	public ThreadPrimeCalculation(long max) {
		longMax = max;
	}

	@Override
	public void run() {
		CommonUtil.runPrime(longMax);
	}
}
