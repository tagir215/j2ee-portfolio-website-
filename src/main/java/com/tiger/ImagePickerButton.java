package com.tiger;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;


public class ImagePickerButton extends AjaxButton {
	
	Topic topic;
	ImagePickerButton nextButton;
	ImagePickerButton previousButton;
	String buttonId;
	int number;
	int margin;
	public ImagePickerButton(String id,String markupId, Topic topic, int margin, int number) {
		super(id);
		this.topic = topic;
		this.buttonId = markupId;
		this.margin = margin;
		this.number = number;
	}
	
	@Override
	protected String getOnClickScript() {
		return JsScripts.getAnimateMovementJs(margin,this);
	}
	
	@Override
	protected void onSubmit(AjaxRequestTarget target) {
		super.onSubmit(target);
		topic.currentButton = this; 
		topic.waitTime = Constants.WAIT_TIME;
	}
	
	
}
