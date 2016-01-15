package slackApitext;

import org.junit.Test;

import slack.SlackApi;
import slack.SlackMessage;

public class TestException {

	@Test
	public void send() {
		SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
		api.send(new SlackMessage("Hi friendss"));

		SlackApi api2 = new SlackApi("https://hooks.slack.com/services/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");
		api2.send(new SlackMessage("gana", "Hello"));

		SlackApi api3 = new SlackApi("https://hooks.slack.com/services/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");
		api3.send(new SlackMessage("#general", null, "my message"));

		SlackApi api4 = new SlackApi("https://hooks.slack.com/services/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");
		api4.send(new SlackMessage("#random", "gana", "www.google.com"));
	}
}