package com.tiger;

import java.time.Duration;

import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class IntervalMover2 extends AbstractAjaxTimerBehavior {
	Topic topic;
	long startTime = 0;
	public IntervalMover2(Duration updateInterval, Topic topic) {
		super(updateInterval);
		this.topic = topic;
	}

	protected void onTimer(AjaxRequestTarget target) {
		if(topic.waitTime<=0 && CurrentValues.userOnPage) {
			topic.selectedButtonId = topic.currentButton.buttonId;
			topic.currentButton = topic.currentButton.nextButton;
			StringBuilder stringBuilder = new StringBuilder();
			//stringBuilder.append(JsScripts.getAnimateMovementJs(topic.currentButton.margin,topic));
			stringBuilder.append(""+CurrentValues.currentPositions.get(topic.number)+"="+topic.currentButton.margin+";");
			stringBuilder.append(JsScripts.getHighlightSelectedJs(topic.currentButton.buttonId, topic.topicId));
			target.appendJavaScript(stringBuilder.toString());
			
		} else {
			topic.waitTime --;
		}
		
	}
	
}
