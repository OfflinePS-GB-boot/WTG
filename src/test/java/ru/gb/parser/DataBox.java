package ru.gb.parser;

import java.util.ArrayList;

public class DataBox {
    ArrayList images;
    ArrayList text;

	public ArrayList getImages() {
		return images;
	}

	public void setImages(ArrayList images) {
		this.images = images;
	}

	public ArrayList getText() {
		return text;
	}

	public void setText(ArrayList text) {
		this.text = text;
	}

	public DataBox(ArrayList images, ArrayList text) {
		super();
		this.images = images;
		this.text = text;
	}

}
