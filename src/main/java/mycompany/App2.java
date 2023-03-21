package mycompany;

import com.dooray.sideapp.app.DooraySideApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 implements DooraySideApp {
    @Override
    public Map<String, Object> execute(Map<String, Object> map) {
        // TODO: 아래 서비스 성격에 알맞게 수정합니다.

        Map<String, Object> result = new HashMap<>();

        result.put("version", 1);
        result.put("layout", "B");

        List<Map<String, Object>> tabList = new ArrayList<>();

        Map<String, Object> tab1 = new HashMap<>();
        tab1.put("id", "recent1");
        tab1.put("title", "탭1 사이드앱");
        List<Map<String, Object>> tab1arr = new ArrayList<>();
            Map<String, Object> tab1con = new HashMap<>();
            tab1con.put("id", "t01");
            tab1con.put("title", "탭1-제목");
            tab1con.put("description", "탭1-내용");
            tab1con.put("url", "https://ybtour.dooray.com");

            List<Map<String, String>> arr1meta = new ArrayList<>();
            {
                Map<String, String> m = new HashMap<>();
                m.put("label", "등록자");
                m.put("text", "인사담당");
                arr1meta.add(m);
            }
            tab1con.put("metadata", arr1meta);
        tab1arr.add(tab1con) ;

        tab1.put("items", tab1arr );

        Map<String, Object> onEmpty = new HashMap<>();
        onEmpty.put("text", "새로운 공지 사항이 없습니다.");
        onEmpty.put("url", "https://ybtour.co.kr");
        tab1.put("onEmpty", onEmpty);

        tabList.add(tab1);

        Map<String, Object> tab2 = new HashMap<>();
        tab2.put("id", "recent2");
        tab2.put("title", "탭2 사이드앱");
        List<Map<String, Object>> tab2arr = new ArrayList<>();
        tab2.put("items", tab2arr );

        // Map<String, Object> onEmpty = new HashMap<>();

        tabList.add(tab2);

        Map<String, Object> tab3 = new HashMap<>();
        tab3.put("id", "recent3");
        tab3.put("title", "탭2 사이드앱");
        List<Map<String, Object>> tab3arr = new ArrayList<>();
        tab3.put("items", tab3arr );
        tabList.add(tab3);

        result.put("contents", tabList);



        return result;
    }
}
