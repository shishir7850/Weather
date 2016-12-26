package shishir.purdue.edu;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.Element;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class myServlet extends HttpServlet {
	public String getWeather(String zipcode, String country) throws IOException {
		System.out.println(zipcode + " " + country);
		StringBuilder result = new StringBuilder();

		try
        {
	        URL url;
	        url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zipcode + "," + country + "&APPID=2bbf79a16d21af8f47ee016fd5b9e05c");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            con.getContent();
            InputStream in = new BufferedInputStream(con.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            con.disconnect();
        }catch( Exception e) {
            e.printStackTrace();
        }
		String result1 = result.toString();
		System.out.println(result1);
		String array[] = result1.split("\"");
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("temp")) {
				result1 = array[i + 1];
			}
		}
		result1 = result1.substring(1, result1.length() - 1);
		System.out.println(result1);
		return result1;
	}
}
