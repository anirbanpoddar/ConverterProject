package com.practice.test;

import java.util.concurrent.CountDownLatch;

import com.practice.converter.Converter;
import com.practice.converter.impl.XMLConverter;

/**
 * This class instantiates XML converter and tests the functionalities using
 * multiple threads.
 * 
 * @author anirbanpoddar
 *
 */
public class XMLConverterMultiThreadTest {

	public static void main(String[] args) {

		// Counter to track completion of all threads.
		final CountDownLatch latch = new CountDownLatch(3);

		// First thread initialization.
		Thread threadA = new Thread(new Runnable() {
			public void run() {
				Converter xmlConverter = XMLConverter.getInstance();
				System.out.println(xmlConverter.getName() + " A started at: " + xmlConverter.getCreationTimeStamp());
				xmlConverter.readAndConvert(".//test//input1.xml");
				latch.countDown();
			}
		});

		// Second thread initialization.
		Thread threadB = new Thread(new Runnable() {
			public void run() {
				Converter xmlConverter = XMLConverter.getInstance();
				System.out.println(xmlConverter.getName() + " B started at: " + xmlConverter.getCreationTimeStamp());
				xmlConverter.readAndConvert(".//test//input2.xml");
				latch.countDown();
			}
		});

		// Third thread initialization.
		Thread threadC = new Thread(new Runnable() {
			public void run() {
				Converter xmlConverter = XMLConverter.getInstance();
				System.out.println(xmlConverter.getName() + " C started at: " + xmlConverter.getCreationTimeStamp());
				xmlConverter.readAndConvert(".//test//input3.xml");
				latch.countDown();
			}
		});

		// Starting all threads.
		threadA.start();
		threadB.start();
		threadC.start();

		// Wait till all threads finish execution and then print in the console
		// and write in the file.
		try {
			latch.await();
			XMLConverter.getInstance().print();
			XMLConverter.getInstance().write(".//test//MultiThreadTestOutput.txt");
		} catch (InterruptedException ex) {
			System.out.println("Test - " + ex.getMessage());
		}

	}

}