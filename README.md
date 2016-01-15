# Slack-Webhook-API

Slack Webhook API developed using JAVA

 ![Alt text](https://github.com/Ganashree15/Slack-Webhook-API/tree/master/SlackAPI/image/Snip20160115_1.png "FORMAT")
 
 #Table of contents

- [Overview](#overview)
- [Functions Of Class ](#functionsofclass)
    - [SlackAPI](#slackApi)
    - [SlackAttachment](#SlackAttachment)
    - [SlackField](#slackField)
    - [SlackMessage](#slackMessage)
- [Test](#test)
- [Acknowledgements](#acknowledgements)
- [License](#license)


##Overview

 Slack Incoming Webhook are the best way to post the message from the extenal source to slack, which includes a normal HTTP request with a JSON payload with either a message or any other options that are provided by the slack.
 
##Functions Of Class

####SlackAPI
* Used to post the **Payload** and it also provides the service by configuring the URL
* Always the Incoming Webhook should start with the URL= "https://hooks.slack.com/services/id1/id2/Token" with are generate [here] (https://slack.com/apps/build/custom-integration) Select Incoming Webhook and generate the Tokens.
* This Class mainly calls and ***method*** called *send* which is uses to publish the message to the Slack.
* Initially the message which we publish will be in the JSON Format, so we use an encoder to encode the message to String Format.


####SlackAttachment
  As we know, we can attach any kind of options in the Slack this Class is used for providing the attachments such as Name, Link, Color, Image etc,. All these are based on *SlackField*.


####SlackField
 This Class is used for assigning the Fields such as *allowmarkdown, title, values, etc,.*
  It is also mainly used for obtaining the JSON Objects here.
  
  
####SlackMessage
 This Class is used to generate the format for sending message to the Slack. i.e,. `api.send(new SlackMessage("#Channel", author, "Content- 'msg'/'url'));``

##Test

 Here we are using a Unit Test case by calling the ***send*** method to generate the sample output in the Slack.
 
 Ex: public void send() 
 {
		SlackApi api = new SlackApi("https://hooks.slack.com/services/id1/id2/token");
		api.send(new SlackMessage("Hi friendss"));
}

When we run as-> in Junit Test we get the ping in the Slackbox.

##Acknowledgements

- [Webhook](https://api.slack.com/incoming-webhooks)
- [Slack API](https://api.slack.com/)
- [Documents](https://api.slack.com/docs/attachments)

##License

Copyright © 2002-2015 [JUnit](http://junit.org/license.html). All Rights Reserved.






 
