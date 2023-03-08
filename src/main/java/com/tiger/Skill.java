package com.tiger;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;

public class Skill extends WebMarkupContainer{

	public Skill(String id,String skill,int measure) {
		super(id);
		
		RepeatingView repeatingView = new RepeatingView("skill-square");
		add(repeatingView);
		for(int i=0; i<10; i++) {
			WebMarkupContainer square = new WebMarkupContainer("square"+CurrentValues.skillnumber+i);
			if(measure>i)
				square.add(AttributeModifier.append("class", "square-yes"));
			else
				square.add(AttributeModifier.append("class", "square-no"));
			repeatingView.add(square);
		}
		
		Label label = new Label("skill-label",skill);
		add(label);
	}
	
}
