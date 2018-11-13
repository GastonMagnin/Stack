package Stacks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class projectChekcer {
	public static void main(String[] args) throws IOException {
		for(int i = 1; i < 1000; i++) {
			URL a = new URL(("http://services.informatik.hs-mannheim.de/~fischer/lectures/PR1_Files/Uebungsblatt_"+ i+".pdf"));
			HttpURLConnection auc = (HttpURLConnection) a.openConnection();
			auc.setRequestMethod("GET");
			auc.connect();
			int code;
			if((code = auc.getResponseCode()) != 404) {
				System.out.println(i + " " + code);
			}
			auc.disconnect();
			
		}
	}
}
