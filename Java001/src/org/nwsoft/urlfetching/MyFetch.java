package org.nwsoft.urlfetching;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MyFetch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		insertPostUser();
		
	}

	private static void insertPostUser() {
		/* {
		 * "userEmail":"siryu_1@COW-DB.1300",
		 * "userPass": "2222",
		 * "userApps": "xCowApp",
		 * "userNick": "nickname",
		 * "userEtc": "COW-DB.1300",
		 * "regDate": "2015-05-01"
		 * }
		 */
		URL url;
        try {
            url = new URL("https://nwsoftengine.appspot.com/_ah/api/nwuserendpoint/v1/nwuser");
            HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
            hurl.setRequestMethod("POST");
            hurl.setDoOutput(true);
            hurl.setRequestProperty("Content-Type", "application/json");
            hurl.setRequestProperty("Accept", "application/json");

            String payload1 = "{'userEmail':'siryu_1@COW-DB.1300'," +
			  				  "'userPass':'2222'," +
			  				  "'userApps':'xCowApp'," +
			  				  "'userNick':'nickname_1'," +
			  				  "'userEtc':'COW-DB.1300'," +
			  				  "'regDate':'2015-05-01'" +
			  				  "}";
            String payload = "{\"userEmail\":\"siryu_1@COW-DB.1300\"," +
            				  "\"userPass\":\"2222\"," +
            				  "\"userApps\":\"xCowApp\"," +
            				  "\"userNick\":\"nickname_1\"," +
            				  "\"userEtc\":\"COW-DB.1300\"," +
            				  "\"regDate\":\"2015-05-01\"" +
            				  "}";
            //payload = URLEncoder.encode(payload,"UTF-8"); //no need to urlEncoding..haha...no blank allowed in stream
            System.out.println(payload);
            OutputStreamWriter osw = new OutputStreamWriter(hurl.getOutputStream());
            osw.write(payload);
            osw.flush();
            osw.close();
            System.err.println(hurl.getResponseCode());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
