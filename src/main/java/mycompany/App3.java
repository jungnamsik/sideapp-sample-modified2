package mycompany;

import com.dooray.sideapp.app.DooraySideApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App3 implements DooraySideApp {
    @Override
    public Map<String, Object> execute(Map<String, Object> map) {
        // TODO: 아래 서비스 성격에 알맞게 수정합니다.

        Map<String, Object> result = new HashMap<>();

        result.put("version", 1);
        result.put("layout", "A");

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", "2");
        m1.put("title", "Dooray! 사이드앱 이용하기33333333");
        m1.put("description", "공개 조직, 작성 권한 설정\n첨부파일, 댓글, 조회수 사용 설정\n말머리, 템플릿 설정\n게시판 관리자 설정");
        m1.put("url", "https://ybtour-poc.dooray.com/home/3317368739012375327/3317368739062662401");

        List<Map<String, String>> lm1Meta = new ArrayList<>();
        {
            Map<String, String> m = new HashMap<>();
            m.put("label", "등록자");
            m.put("text", "인사담당");
            lm1Meta.add(m);
        }
        {
            Map<String, String> m = new HashMap<>();
            m.put("label", "등록일");
            m.put("text", "2020.03.02.");
            lm1Meta.add(m);
        }
        m1.put("metadata", lm1Meta);
        list.add(m1);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("id", "1");
        m2.put("title", "노랑풍선 홈페이지33333333333333");
        m2.put("url", "https://ybtour.co.kr");
        list.add(m2);
        result.put("contents", list);

        Map<String, Object> onEmpty = new HashMap<>();
        onEmpty.put("text", "새로운 공지 사항이 없습니다.");
        onEmpty.put("url", "https://ybtour.co.kr");

        result.put("onEmpty", onEmpty);

        return result;
    }
}
