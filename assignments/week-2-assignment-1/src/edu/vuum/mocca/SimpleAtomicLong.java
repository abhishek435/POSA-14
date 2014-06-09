// Import the necessary Java synchronization and scheduling classes.

package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;


    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
<<<<<<< HEAD
    // TODO - add the implementation
=======

    // TODO -- you fill in here by replacing the null with an
    // initialization of ReentrantReadWriteLock.
    private final ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();


>>>>>>> 710de2f27659e2239a968b99b1c67d28d3269dec

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
<<<<<<< HEAD
    public SimpleAtomicLong(long initialValue) {
        // TODO - you fill in here
=======
    public SimpleAtomicLong(long initialValue)
    {
        // TODO -- you fill in here
    	this.mValue = initialValue;
>>>>>>> 710de2f27659e2239a968b99b1c67d28d3269dec
    }

    /**
     * @brief Gets the current value
     * 
     * @returns The current value
     */
<<<<<<< HEAD
    public long get() {
        // TODO - you fill in here
=======
    public long get()
    {
        long value = 0;

        // TODO -- you fill in here
       ReadLock readLock =  mRWLock.readLock();
       readLock.lock();
       value = this.mValue;
       readLock.unlock();
        return value;
>>>>>>> 710de2f27659e2239a968b99b1c67d28d3269dec
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
<<<<<<< HEAD
    public long decrementAndGet() {
        // TODO - you fill in here
=======
    public long decrementAndGet()
    {
        long value = 0;

        // TODO -- you fill in here
        WriteLock writeLock =  mRWLock.writeLock();
        writeLock.lock();
        value = --this.mValue;
        writeLock.unlock();

        return value;
>>>>>>> 710de2f27659e2239a968b99b1c67d28d3269dec
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
<<<<<<< HEAD
    public long getAndIncrement() {
        // TODO - you fill in here
=======
    public long getAndIncrement()
    {
        long value = 0;

        WriteLock writeLock =  mRWLock.writeLock();
        writeLock.lock();
        value = this.mValue++;
        writeLock.unlock();

        return value;
>>>>>>> 710de2f27659e2239a968b99b1c67d28d3269dec
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
<<<<<<< HEAD
    public long getAndDecrement() {
        // TODO - you fill in here
=======
    public long getAndDecrement()
    {
        long value = 0;

        // TODO -- you fill in here
        WriteLock writeLock =  mRWLock.writeLock();
        writeLock.lock();
        value = this.mValue--;
        writeLock.unlock();

        return value;
>>>>>>> 710de2f27659e2239a968b99b1c67d28d3269dec
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
<<<<<<< HEAD
    public long incrementAndGet() {
        // TODO - you fill in here
=======
    public long incrementAndGet()
    {
        long value = 0;

        // TODO -- you fill in here
        WriteLock writeLock =  mRWLock.writeLock();
        writeLock.lock();
        value = ++this.mValue;
        writeLock.unlock();
        
        return value;
>>>>>>> 710de2f27659e2239a968b99b1c67d28d3269dec
    }
}

