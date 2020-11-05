package jpmcInterviewSolution.ProjectUtility;

import jpmcInterviewSolution.DriverManger.SingletonDriver;

public class DataContainer {
	private static DataContainer currentInstance = null;

	public String data;

	public DataContainer() {
		data = "";
	}

	public static DataContainer getDataInstace() {

		if (currentInstance == null) {
			synchronized (SingletonDriver.class) {
				if (currentInstance == null) {

					currentInstance = new DataContainer();
				}
			}
		}
		return currentInstance;
	}

	public String getData() {
		return data;
	}

	public void setData(String inputString) {
		data = inputString;
	}
}
