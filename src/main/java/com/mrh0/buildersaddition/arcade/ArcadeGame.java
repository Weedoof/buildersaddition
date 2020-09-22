package com.mrh0.buildersaddition.arcade;

import com.mrh0.buildersaddition.tileentity.ArcadeTileEntity;
import com.mrh0.buildersaddition.util.Notes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.util.SoundEvents;

public abstract class ArcadeGame {
	public ArcadeScreen s;
	private boolean[] keyboardKeys;
	private ArcadeTileEntity te;
	
	public ArcadeGame(ArcadeScreen s, ArcadeTileEntity te) {
		this.s = s;
		this.te = te;
	}
	
	public void frame(long time) {
		
	}
	
	public void start() {
		
	}
	
	public void onKeyPressed(int key) {
		
	}
	
	public void onKeyReleased(int key) {
		
	}
	
	public void onMousePressed(int key) {
		
	}
	
	public void onMouseReleased(int key) {
		
	}
	
	public void playSound(int note) {
		Notes.playClientNote(SoundEvents.BLOCK_NOTE_BLOCK_BIT, note);
	}
	
	public int getBestScore() {
		return 0;
	}
	
	public static boolean isAny(int key) {
		return key > 0;
	}
	
	public static boolean isSpace(int key) {
		return key == 32;
	}
	
	public static boolean isEnter(int key) {
		return key == 257;
	}
	
	public static boolean isHome(int key) {
		return key == 268;
	}
	
	public static boolean isEsc(int key) {
		return key == 256;
	}
	
	public static boolean isHelp(int key) {
		return key == 290;
	}
	
	public static boolean isLeft(int key) {
		return key == 263 || key == 65;
	}
	
	public static boolean isRight(int key) {
		return key == 262 || key == 68;
	}
	
	public static boolean isUp(int key) {
		return key == 265 || key == 87;
	}
	
	public static boolean isDown(int key) {
		return key == 264 || key == 83;
	}
	
	public static boolean isReset(int key) {
		return key == 269;
	}
}
