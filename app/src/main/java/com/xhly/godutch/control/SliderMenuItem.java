package com.xhly.godutch.control;

public class SliderMenuItem {
	private int mItemID;
	private String mTitle;

	public SliderMenuItem(int mItemID, String mTitle) {
		super();
		this.mItemID = mItemID;
		this.mTitle = mTitle;
	}
	public int getmItemID() {
		return mItemID;
	}
	public void setmItemID(int mItemID) {
		this.mItemID = mItemID;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	@Override
	public String toString() {
		return "SliderMenuItem [mItemID=" + mItemID + ", mTitle=" + mTitle
				+ "]";
	}
	
}
