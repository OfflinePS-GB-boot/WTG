package ru.gb.parser;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		HTMLParser parser = new HTMLParser();
		String[] pages = parser.getPages(
				"https://www.culture.ru/",
				"news/257227/kuda-skhodit-po-pushkinskoi-karte-v-iyule",
				"entity-card-v2_body");
		System.out.println(pages[0]);

//		Выдает:
//		https://www.culture.ru   >>/news/257227/kuda-skhodit-po-pushkinskoi-karte-v-iyule<< <- нужно отпилить
//      и это оставить->    >>/news/257195/kuda-skhodit-po-pushkinskoi-karte-v-iyule-interesnye-sobytiya-v-moskve<<
//		Нужно:
//		https://www.culture.ru/news/257195/kuda-skhodit-po-pushkinskoi-karte-v-iyule-interesnye-sobytiya-v-moskve"

//		parser.getContent("https://tourism.krd.ru", pages, "hotel");
		DataBox result = parser.getContent(
				"https://www.culture.ru/institutes/10078/gosudarstvennaya-tretyakovskaya-galereya",
				"https://www.culture.ru",
				"KRQ9s");
		System.out.print(result.images.get(0));
	}

}

