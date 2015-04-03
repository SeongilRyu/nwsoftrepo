package com.nwsoft.java7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class JavaUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//test
		urlFetch("http://google.com");
		//socketConnection("203.233.126.231", 80);
	}
	public static void socketConnection(String host, int port)  {
		Socket socket=null;
		PrintWriter out;
		BufferedReader in;
		try  {
			socket = new Socket(host, port);
			out= new PrintWriter(socket.getOutputStream(), true);
			in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverResponse = null;
			if (socket !=null && in !=null && out !=null) {
				System.out.println("Connection succeed");
				out.println("Hi server...!");
				while ((serverResponse = in.readLine()) != null) {
					System.out.println(serverResponse);
				}
			}
			
			out.flush();
			out.close();
			in.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
	}
	public static void urlFetch(String strUrl) {
		try {
			URL url = new URL(strUrl);
			System.out.println(url.getHost() +"\n" + url.getPath() + "\n" +
			                   url.getQuery() + "\n" + url.getRef());
			BufferedReader in = new BufferedReader(
					new InputStreamReader( 
							url.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
