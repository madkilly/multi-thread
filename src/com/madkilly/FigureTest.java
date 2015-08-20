package com.madkilly;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FigureTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FigureTest T=new FigureTest();
		T.test();
	}
	public void test(){
		sendGET();
		//System.out.print("tete");
	}
	
	public ArrayList<String> getImageName(String path){
		String encoding="UTF-8";
		ArrayList<String> filelist=new ArrayList<String>();
		try{
			File f=new File(path);
			if(!f.exists()){
				throw new FileNotFoundException("filepath.txt");
				
			}
			InputStreamReader read =new InputStreamReader(new FileInputStream(f),encoding);
			BufferedReader bufferedReader=new BufferedReader(read);
			String imageURL=null;
			while((imageURL=bufferedReader.readLine())!=null){
				filelist.add(imageURL);			
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return filelist;
	}
	
	public void visitImage(String url){
		try{
			String imURL="http://20.12.6.91/fdfsimg/"+url;
			URL realUrl=new URL(imURL);
			URLConnection conn=realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.connect();
			
			Map< String, List < String >> map =conn.getHeaderFields();
			for(String key:map.keySet()){
				System.out.println(key + "--->" + map.get(key));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void sendGET(){
		ArrayList<String> filepath=new ArrayList<String>();
		filepath=getImageName("/etc/upload/figure/filepath.txt");
		int filenum=filepath.size();
		for(int i=0,j=0;i<500&&j<=filenum;i++,j++){
			if (j==filenum)
				j=0;
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			visitImage(filepath.get(j));		
				
		}
	}
}