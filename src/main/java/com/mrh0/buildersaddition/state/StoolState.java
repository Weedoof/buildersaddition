package com.mrh0.buildersaddition.state;

import net.minecraft.util.StringRepresentable;

public enum StoolState implements StringRepresentable {
	None("none"),
	White("white"),
	Orange("orange"),
	Magenta("magenta"),
	LightBlue("light_blue"),
	Yellow("yellow"),
	Lime("lime"),
	Pink("pink"),
	Gray("gray"),
	LightGray("light_gray"),
	Cyan("cyan"),
	Purple("purple"),
	Blue("blue"),
	Brown("brown"),
	Green("green"),
	Red("red"),
	Black("black");

	private String name;
	
	private static StoolState[] list = {
		White,
		Orange,
		Magenta,
		LightBlue,
		Yellow,
		Lime,
		Pink,
		Gray,
		LightGray,
		Cyan,
		Purple,
		Blue,
		Brown,
		Green,
		Red,
		Black
	};
	
	private StoolState(String name) {
		this.name = name;
	}
	
	public static StoolState fromIndex(int i) {
		return list[i];
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}
