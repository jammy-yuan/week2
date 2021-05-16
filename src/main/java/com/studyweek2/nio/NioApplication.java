package com.studyweek2.nio;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SpringBootApplication
public class NioApplication {
	private static OkHttpClient client = new OkHttpClient();

	private static String run(String url) throws IOException {
	  Request request = new Request.Builder()
	      .url(url)
	      .build();

	  try (Response response = client.newCall(request).execute()) {
	    return response.body().string();
	  }
	}

	public static void main(String[] args) {
		try {
			String url = "http://localhost:8801";
			String responseStr = run(url);
			System.out.println("url: " + url + " ; \n response: \n" + responseStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
