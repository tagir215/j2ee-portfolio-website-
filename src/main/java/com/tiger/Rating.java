package com.tiger;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

public class Rating extends WebMarkupContainer{

	public Rating(String id,String title) {
		super(id);
		add(new Label("rating-title",title));
		RepeatingView stars = new RepeatingView("star");
		add(stars);
		for(int i=0; i<5; i++) {
			String markupId = id+"star"+i;
			WebMarkupContainer star = new WebMarkupContainer(markupId);
			star.add(new AttributeAppender("onclick", new Model("alert('This is my JS script');")));
			stars.add(star);
			
		}
	}

}
