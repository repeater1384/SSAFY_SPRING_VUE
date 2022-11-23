package com.ssafy.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlImage {

	static public String doCrawlImage(String aptName) {
		final String stockList = "https://search.naver.com/search.naver?where=image&query=" + aptName;
		Connection conn = Jsoup.connect(stockList);
		Set<String> aptImages = new HashSet<>();
		try {
			Element ele = conn.get().selectFirst(".thumb");
			Elements child = ele.select("img");
			for (Element element2 : child) {
				aptImages.add(element2.attr("src"));
				return element2.attr("src");
			}
		} catch (IOException ignored) {
			System.out.println("??");
		}
		return null;
	}
}
