package com.tiger;

public class JsScripts {
	public static String getHighlightSelectedJs(String selectedButtonId, String topicId) {
		return "$('#"+topicId+"').find('.selectedButton').removeClass('selectedButton').addClass('button');"
				+"$('#"+selectedButtonId+"').removeClass('button').addClass('selectedButton');";
	}
	
	
	public static String getAnimateMovementJs(int margin, Topic topic) {
		return "$('#"+topic.imageContainerId+"').stop().animate({marginLeft:'"+margin+"'},600);"
				+ ""+CurrentValues.currentPositions.get(topic.number)+"="+margin+";";
	}
	
	
	
	
}
