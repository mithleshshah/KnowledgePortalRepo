package com.nis.model;

public class Heading {
	private String chapterid;
	private String headingid;
	private String headingname;
	
	private String description;
	
	public String getHeadingname() {
		return headingname;
	}
	public void setHeadingname(String headingname) {
		this.headingname = headingname;
	}
	public String getChapterid() {
		return chapterid;
	}
	public void setChapterid(String chapterid) {
		this.chapterid = chapterid;
	}
	public String getHeadingid() {
		return headingid;
	}
	public void setHeadingid(String headingid) {
		this.headingid = headingid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
