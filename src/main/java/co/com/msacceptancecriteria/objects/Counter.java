package co.com.msacceptancecriteria.objects;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	public static AtomicInteger totalSuccess = new AtomicInteger();
	public static AtomicInteger totalFailed = new AtomicInteger();
	public static AtomicInteger totalProcess = new AtomicInteger();
}
