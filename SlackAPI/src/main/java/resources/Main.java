package resources;

import slack.SlackApi;
import slack.SlackMessage;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.send();
	}

	public void send() {
		SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
		api.send(new SlackMessage("my message"));

		SlackApi api2 = new SlackApi("https://hooks.slack.com/services/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");
		api2.send(new SlackMessage("gana", "my message"));

		SlackApi api3 = new SlackApi("https://hooks.slack.com/services/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");
		api3.send(new SlackMessage("#general", null, "my message"));

		SlackApi api4 = new SlackApi("https://hooks.slack.com/services/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");
		api4.send(new SlackMessage("#general", "gana", "my message"));
	}

}
