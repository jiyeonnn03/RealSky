package beta_2;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class Weather {
	String serviceKey;
	String areaNo;
	String code = new String("A20");
	String time;
	String baseDate;
	String baseTime;
	String nx;
	String ny;
	String numOfRows = new String("20");
	String pageNo = new String("1");

	// 더위체감지수 반환 매서드(5월 ~ 9월 에만 사용 가능)
	public String getSensoryHeatLifeList() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://newsky2.kma.go.kr/iros/RetrieveLifeIndexService3/getSensoryHeatLifeList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKey, "UTF-8")); /* 공공데이터포털에서 받은 인증키 */
		urlBuilder.append(
				"&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(areaNo, "UTF-8")); /* 서울지점 */
		urlBuilder.append(
				"&" + URLEncoder.encode("requestCode", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8")); /* 일반인 */
		urlBuilder.append("&" + URLEncoder.encode("time", "UTF-8") + "="
				+ URLEncoder.encode(time, "UTF-8")); /* 2017년 6월 8일 6시 발표 */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml , json 선택 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}

	// 체감온도 반환 매서드 (11월 ~ 3월에만 사용 가능)
	public String getSensorytemLifeList() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://newsky2.kma.go.kr/iros/RetrieveLifeIndexService3/getSensorytemLifeList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKey, "UTF-8")); /* 공공데이터포털에서 받은 인증키 */
		urlBuilder.append(
				"&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(areaNo, "UTF-8")); /* 지점코드 */
		urlBuilder.append(
				"&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8")); /* 2017년6월8일6시 */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml, json 선택(미입력시 xml) */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}

	// 동네예보조회
	public String getForecastSpaceData() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKey, "UTF-8")); /* 서비스 인증 */
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "="
				+ URLEncoder.encode(baseDate, "UTF-8")); /* ‘15년 12월 1일발표 */
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "="
				+ URLEncoder.encode(baseTime, "UTF-8")); /* 05시 발표 * 기술문서 참조 */
		urlBuilder.append(
				"&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); /* 예보지점의 X 좌표값 */
		urlBuilder.append(
				"&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); /* 예보지점의 Y 좌표값 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode(numOfRows, "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /* 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml(기본값), json */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}

	public String getServiceKey() {
		return this.serviceKey;
	}

	public String getAreaNo() {
		return this.areaNo;
	}

	public String getCode() {
		return this.code;
	}

	public String getTime() {
		return this.time;
	}

	public String getBaseDate() {
		return this.baseDate;
	}

	public String getBaseTime() {
		return this.baseTime;
	}

	public String getNX() {
		return this.nx;
	}

	public String getNY() {
		return this.ny;
	}

	public String getNumOfRows() {
		return this.numOfRows;
	}

	public String getPageNo() {
		return this.pageNo;
	}

	public void setServiceKey(String key) {
		this.serviceKey = key;
	}

	public void setAreaNo(String no) {
		this.areaNo = no;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	public void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
	}

	public void setNX(String nx) {
		this.nx = nx;
	}

	public void setNY(String ny) {
		this.ny = ny;
	}

	public void setNumOfRows(String n) {
		this.numOfRows = n;
	}

	public void setPageNo(String n) {
		this.pageNo = n;
	}

}
