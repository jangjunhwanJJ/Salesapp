package www.jangjunhwan.kr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Sales {
	public List<Goods> getlist() {
		List<Goods> list = new ArrayList<Goods>();
		for(int i = 0;i < 993; i += 90) {
			// 1. 수집 대상 URL
			String URL = "https://www.microsoft.com/ko-kr/store/top-free/apps/pc?s=store&skipitems="+i;

			try {
				// 2. Connection 생성
				Connection conn = Jsoup.connect(URL);

				// 3. HTML 파싱.
				Document html = conn.get(); // conn.post();

				// 4. 요소 탐색
				// 4-1. Attribute 탐색
				System.out.println("[Attribute 탐색]");
				Elements arr = html.getElementsByClass("m-channel-placement-item");
				
						
				for( Element div : arr ) {
					Goods goods = new Goods();
					Elements badges = div.getElementsByClass("c-badge");
					if(badges.size() > 0) {
						for(Element badge : badges) {
							System.out.println(badge.html());
							goods.setBadge(badge.html());
						}
						Elements appnames = div.getElementsByClass("c-subheading-6");
						for(Element appname : appnames) {
							System.out.println(appname.html());
							goods.setAppName(appname.html());
						}
					}
					/*
                Elements files = fileblock.getElementsByTag("a");

					 * for( Element elm : files ) { String text = elm.text(); String href =
					 * elm.attr("href");
					 * 
					 * System.out.println( text+" > "+href ); }
					 */
					list.add(goods);
				}

				// 4-2. CSS Selector 탐색
				System.out.println("\n[CSS Selector 탐색]");
				Elements files = html.select(".fileblock a");
				for( Element elm : files ) {
					String text = elm.text();
					String href = elm.attr("href");

					System.out.println( text+" > "+href );
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
