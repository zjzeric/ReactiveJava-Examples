package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kishore.computation.ThreadPrimeCalculation;

public class ExecutorTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorTest.class);

	public static void main(String[] args) throws Exception {
		final int poolSize = 100;
		final ExecutorService service = Executors.newFixedThreadPool(poolSize);
		int batch = 10;
		long index = 0;
		LOGGER.info("Start Time - "+System.currentTimeMillis());
		while (index < 10) {
			while (batch <= 200) {
				batch += 10;
				for (int i = 1; i <= batch; i++) {
					service.submit(new ThreadPrimeCalculation(batch));
				}
				Thread.sleep(1000);
			}
			System.out.println("Resetting Batch, Cooling Down !!!");
			batch = 0;
			index += 1;
			Thread.sleep(10000);
		}
		service.shutdown();
		LOGGER.info("Stop Time - "+System.currentTimeMillis());
	}

}