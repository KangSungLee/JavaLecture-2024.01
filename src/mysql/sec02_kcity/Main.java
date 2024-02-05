package mysql.sec02_kcity;

public class Main {

	public static void main(String[] args) {
		CityDao cityDao = new CityDao();
		
		City city = cityDao.getCityBiId(2340);
		System.out.println(city);

	}

}
