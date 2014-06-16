package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

/**
 * @class SimpleSemaphore
 * 
 * @brief This class provides a simple counting semaphore
 *        implementation using Java a ReentrantLock and a
 *        ConditionObject (which is accessed via a Condition). It must
 *        implement both "Fair" and "NonFair" semaphore semantics,
 *        just liked Java Semaphores.
 */
public class SimpleSemaphore {
	/**
	 * Define a ReentrantLock to protect the critical section.
	 */
	// TODO - you fill in here
	private Lock lock = null;
	/**
	 * Define a Condition that waits while the number of permits is 0.
	 */
	// TODO - you fill in here
	private Condition permission = null;

	/**
	 * Define a count of the number of available permits.
	 */
	// TODO - you fill in here.  Make sure that this data member will
	// ensure its values aren't cached by multiple Threads..
	private volatile int availablePermits;
	private int maxPermits;

	public SimpleSemaphore(int permits, boolean fair) {
		// TODO - you fill in here to initialize the SimpleSemaphore,
		// making sure to allow both fair and non-fair Semaphore
		// semantics.
		this.maxPermits = permits;
		this.availablePermits = permits;
		this.lock = new ReentrantLock(fair);
		this.permission = lock.newCondition();
	}

	/**
	 * Acquire one permit from the semaphore in a manner that can be
	 * interrupted.
	 */
	public void acquire() throws InterruptedException {
		// TODO - you fill in here.
		lock.lock();
		try {
			while (availablePermits == 0)
				permission.await();

			--availablePermits;
			permission.signal();
		} finally {
			lock.unlock();
		}

	}

	/**
	 * Acquire one permit from the semaphore in a manner that cannot be
	 * interrupted.
	 */
	public void acquireUninterruptibly() {
		// TODO - you fill in here.
		lock.lock();
		try {
			while (availablePermits == 0)
				permission.awaitUninterruptibly();

			--availablePermits;
			permission.signal();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * Return one permit to the semaphore.
	 */
	void release() {
		// TODO - you fill in here.
		lock.lock();
		try {
			while (availablePermits == maxPermits)
				permission.awaitUninterruptibly();

			++availablePermits;

			permission.signal();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * Return the number of permits available.
	 */
	public int availablePermits() {
		// TODO - you fill in here by changing null to the appropriate
		// return value.
		return availablePermits;
	}
}
