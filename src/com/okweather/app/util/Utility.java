package com.okweather.app.util;

import com.okweather.app.db.OKWeatherDB;
import com.okweather.app.model.City;
import com.okweather.app.model.County;
import com.okweather.app.model.Province;

import android.text.TextUtils;

public class Utility {
	/**
	* �����ʹ�����������ص�ʡ������
	*/
	public synchronized static boolean handleProvincesResponse(OKWeatherDB
			okWeatherDB, String response) {
			if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
			for (String p : allProvinces) {
			String[] array = p.split("\\|");
			Province province = new Province();
			province.setProvinceCode(array[0]);
			province.setProvinceName(array[1]);
			// ���������������ݴ洢��Province��
			okWeatherDB.saveProvince(province);
			}
			return true;
			}
			}
			return false;}
	/**
	* �����ʹ�����������ص��м�����
	*/
	public static boolean handleCitiesResponse(OKWeatherDB okWeatherDB,
	String response, int provinceId) {
	if (!TextUtils.isEmpty(response)) {
	String[] allCities = response.split(",");
	if (allCities != null && allCities.length > 0) {
	for (String c : allCities) {
	String[] array = c.split("\\|");
	City city = new City();
	city.setCityCode(array[0]);
	city.setCityName(array[1]);
	city.setProvinceId(provinceId);
	// ���������������ݴ洢��City��
	okWeatherDB.saveCity(city);
	}
	return true;
	}
	}
	return false;}
	/**
	* �����ʹ�����������ص��ؼ�����
	*/
	public static boolean handleCountiesResponse(OKWeatherDB okWeatherDB,
	String response, int cityId) {
	if (!TextUtils.isEmpty(response)) {
	String[] allCounties = response.split(",");
	if (allCounties != null && allCounties.length > 0) {
	for (String c : allCounties) {
	String[] array = c.split("\\|");
	County county = new County();
	county.setCountyCode(array[0]);
	county.setCountyName(array[1]);
	county.setCityId(cityId);
	// ���������������ݴ洢��County��
	okWeatherDB.saveCounty(county);
	}
	return true;}}
	return false;}
}
