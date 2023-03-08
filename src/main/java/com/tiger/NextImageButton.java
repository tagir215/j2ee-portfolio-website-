package com.tiger;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;

public class NextImageButton extends AjaxButton {
	

	Topic topic;
	boolean next;
	int imagesCount;
	public NextImageButton(String id, Topic topic,boolean next,int imagesCount) {
		super(id);
		this.topic = topic;
		this.next = next;
		this.imagesCount = imagesCount;
	}
	
	@Override
	protected String getOnClickScript() {
		if(next)
			return getNextImageJs(Constants.MARGIN_LEFT);
		else
			return getNextImageJs(-Constants.MARGIN_LEFT);
	}
	
	private String getNextImageJs(int margin) {
		String var = CurrentValues.currentPositions.get(topic.number);
		int maxMargin = (imagesCount-1) * Constants.MARGIN_LEFT;
		String id = topic.imageContainerId;
		String ref;
		if(next)
			ref = "next";
		else
			ref = "previous";
		
		return ""+var+"+= "+margin+";"
				+ "if("+var+"<"+maxMargin+"){"+var+"=0};"
				+ "if("+var+">0){"+var+"="+maxMargin+"}"
				+ "$('#"+id+"').stop().animate({marginLeft:"+var+"},{duration:300,easing:'linear'});"
				+ ""
				+ ""
				+ "var selectedButton = $('#"+topic.topicId+"').find('.selectedButton');"
				+ "var nextButton = $(selectedButton.data('"+ref+"'));"
				+ "selectedButton.removeClass('selectedButton').addClass('button');"
				+ "nextButton.removeClass('button').addClass('selectedButton');";
	}
	
	
	
	@Override
	protected void onSubmit(AjaxRequestTarget target) {
		super.onSubmit(target);
		if(next) 
			topic.currentButton = topic.currentButton.nextButton;
		else 
			topic.currentButton = topic.currentButton.previousButton;
	
		topic.waitTime = Constants.WAIT_TIME;
	}
	
	
}
