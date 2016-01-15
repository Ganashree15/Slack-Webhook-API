package slack;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.JsonObject;

public class SlackApi {
	private static final String POST = "POST";
	private static final String PAYLOAD = "payload=";
	private static final String UTF_8 = "UTF-8";

	private final String service;
	private final int timeout;

	public SlackApi(String service) {
		this(service, 5000);
	}

	public SlackApi(String service, int timeout) {
		this.timeout = timeout;
		if (service == null) {
			throw new IllegalArgumentException("Missing WebHook URL Configuration @ SlackApi");
		} else if (!service.startsWith("https://hooks.slack.com/services/")) {
			throw new IllegalArgumentException(
					"Invalid Service URL. WebHook URL Format: https://hooks.slack.com/services/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");
		}

		this.service = service;
	}

	/**
	 * Preparing to send Message to Slack
	 */
	public void send(SlackMessage message) {
		if (message != null) {
			this.send(message.prepare());
		}
	}

	private String send(JsonObject message) {
		HttpURLConnection connection = null;
		try {
			// Create connection
			final URL url = new URL(this.service);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(POST);
			connection.setConnectTimeout(timeout);
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			final String payload = PAYLOAD + URLEncoder.encode(message.toString(), UTF_8);

			// Send request
			final DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(payload);
			wr.flush();
			wr.close();

			// Get Response
			final InputStream is = connection.getInputStream();
			final BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\n');
			}

			rd.close();
			return response.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
