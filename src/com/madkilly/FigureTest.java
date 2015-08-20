package com.madkilly;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FigureTest {

	public static void main(String[] args) {
		Integer SucNum=0;
		myTask T=new myTask(SucNum);
		ExecutorService pool=Executors.newFixedThreadPool(5);
		
		for(int i=0;i<6;i++){
			Thread pT=new Thread(T);
			pool.equals(pT);
		}
		pool.shutdown();
		System.out.printf("正确率%d/30", SucNum);
	}
	

}

