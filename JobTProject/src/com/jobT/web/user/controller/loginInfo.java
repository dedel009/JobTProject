package com.jobT.web.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jobT.web.DTO.member;
import com.jobT.web.service.jobtService;

@WebServlet("/user/loginInfo")
public class loginInfo extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res, String access_token) throws ServletException, IOException {
//		System.out.println("에씨씨: "+access_token);               //함 찍어보고 
        String token = access_token; // 네이버 로그인 접근 토큰(access토큰값 받아온거 넣기);
        String header = "Bearer " + token; // Bearer 다음에 공백 추가

        String apiURL = "https://openapi.naver.com/v1/nid/me";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", header);
        String responseBody = get(apiURL,requestHeaders); //  이게 회원 정보를 한줄로 받아오는놈
        
//        System.out.println("respon: "+responseBody);
        

		try {
	        JSONParser parsing = new JSONParser();
			Object obj = parsing.parse(responseBody);
			JSONObject jsonObj = (JSONObject) obj;
			
			Object response = jsonObj.get("response");
			
			JSONObject jsonRes = (JSONObject)response;
			
			String nickname = jsonRes.get("nickname").toString();
			String name = jsonRes.get("name").toString();
			String id = jsonRes.get("id").toString();
//			System.out.println(nickname);
//			System.out.println(name);
//			System.out.println(id);
			
			//service
//			int result = jobtService.getInstance().idCheck("n_"+id);
//			int naver_login = 0;
//			if(result == 0) {	//네이버  아이디가 db에 없을 때
//				naver_login = jobtService.getInstance().createNaverMember("n_"+id,name,nickname);
//			}
			
			signUpController suc = new signUpController();
			req.setAttribute("name", name);
			req.setAttribute("nickname", nickname);
			suc.doGet(req, res);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}