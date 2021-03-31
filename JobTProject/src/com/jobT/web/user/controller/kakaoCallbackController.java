package com.jobT.web.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.jobT.web.service.jobtService;

@WebServlet("/kakaoCallback")
public class kakaoCallbackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String clientId = "ba3674ebfeebf2ad1fcf578446a2fabf";// 애플리케이션 클라이언트 아이디값";

		String code = req.getParameter("code");
		String redirectURI = URLEncoder.encode("http://localhost:8080/JobTProject/kakaoCallback", "UTF-8");

		String apiURL;

		apiURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;

		String access_token = ""; // 회원정보 받기 위해서는 access_token값을 받을 필요가 있음
//		String refresh_token = "";
//		System.out.println("apiURL=" + apiURL);
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
//			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res1 = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res1.append(inputLine);
			}
			br.close();

			if (responseCode == 200) {
//				System.out.println(res1.toString());
				JSONParser parsing = new JSONParser(); //
				Object obj = parsing.parse(res1.toString()); //
				JSONObject jsonObj = (JSONObject) obj; // 제이슨 오브젝트에서 access_token 꺼내기 위한 작업(어떻게 했었는지 잘 기억이 안남;)

				access_token = (String) jsonObj.get("access_token"); // access_token값을 받는다

//				System.out.println("acc_to: " + access_token);

				if(access_token!=null&&!access_token.equals("")) {
					String header = "Bearer " + access_token; // Bearer 다음에 공백 추가

					String acc_apiURL = "https://kapi.kakao.com/v2/user/me";

					Map<String, String> requestHeaders = new HashMap<>();
					requestHeaders.put("Authorization", header);
					String responseBody = get(acc_apiURL, requestHeaders); // 이게 회원 정보를 한줄로 받아오는놈

//					System.out.println("respon: " + responseBody);

					Object res_obj = parsing.parse(responseBody);
					JSONObject res_jsonObj = (JSONObject) res_obj;
					String id = res_jsonObj.get("id").toString();
					JSONObject propert =  (JSONObject) res_jsonObj.get("properties");
					String name = propert.get("nickname").toString();
					JSONObject kakao_acc = (JSONObject) res_jsonObj.get("kakao_account");
					JSONObject profile = (JSONObject) kakao_acc.get("profile");
					String nickname = profile.get("nickname").toString();

					//service 
					String category = "K";
					int check = jobtService.getInstance().nicknameCheck(nickname);
					if(check ==0) {
						signUpController suc = new signUpController();
						req.setAttribute("name", name);
						req.setAttribute("nickname", nickname);
						req.setAttribute("category", category);
						suc.doGet(req, res);
					}else {
						HttpSession session = req.getSession(true);	//세션 생성
						session.setAttribute("id", id);	//세션에 id 값 저장
						session.setAttribute("nickname", nickname);
						res.sendRedirect("main");
					}

				}else {
					res.sendRedirect("main");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");

			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
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

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
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
