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

	// ����ü������ ��ȯ �ż���(5�� ~ 9�� ���� ��� ����)
	public String getSensoryHeatLifeList() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://newsky2.kma.go.kr/iros/RetrieveLifeIndexService3/getSensoryHeatLifeList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKey, "UTF-8")); /* �������������п��� ���� ����Ű */
		urlBuilder.append(
				"&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(areaNo, "UTF-8")); /* �������� */
		urlBuilder.append(
				"&" + URLEncoder.encode("requestCode", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8")); /* �Ϲ��� */
		urlBuilder.append("&" + URLEncoder.encode("time", "UTF-8") + "="
				+ URLEncoder.encode(time, "UTF-8")); /* 2017�� 6�� 8�� 6�� ��ǥ */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml , json ���� */
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

	// ü���µ� ��ȯ �ż��� (11�� ~ 3������ ��� ����)
	public String getSensorytemLifeList() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://newsky2.kma.go.kr/iros/RetrieveLifeIndexService3/getSensorytemLifeList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKey, "UTF-8")); /* �������������п��� ���� ����Ű */
		urlBuilder.append(
				"&" + URLEncoder.encode("areaNo", "UTF-8") + "=" + URLEncoder.encode(areaNo, "UTF-8")); /* �����ڵ� */
		urlBuilder.append(
				"&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8")); /* 2017��6��8��6�� */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml, json ����(���Է½� xml) */
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

	// ���׿�����ȸ
	public String getForecastSpaceData() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKey, "UTF-8")); /* ���� ���� */
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "="
				+ URLEncoder.encode(baseDate, "UTF-8")); /* ��15�� 12�� 1�Ϲ�ǥ */
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "="
				+ URLEncoder.encode(baseTime, "UTF-8")); /* 05�� ��ǥ * ������� ���� */
		urlBuilder.append(
				"&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); /* ���������� X ��ǥ�� */
		urlBuilder.append(
				"&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); /* ���������� Y ��ǥ�� */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode(numOfRows, "UTF-8")); /* �� ������ ��� �� */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /* ������ ��ȣ */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml(�⺻��), json */
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
