package com.tiger;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;


public class SkillGraph extends WebMarkupContainer{

	public SkillGraph(String id, String[] skills, int[] measures, String title) {
		super(id);
		add(new Label("skillTitle",title));
		
		RepeatingView skillRow = new RepeatingView("skill");
		add(skillRow);
		for(int i=0; i<skills.length; i++) {
			Skill skill = new Skill("skill"+i+CurrentValues.skillnumber,skills[i],measures[i]);
			skillRow.add(skill);
		}
		CurrentValues.skillnumber++;
	}
	
}
