package dao;

public class Enum {
	int i=0, j=2;
	public void print() {
		RCountryName cName[] = RCountryName.values();
		System.out.println(cName[i++]);
	}
	
	public CountryName getCountry() {
		CountryName cName[] = CountryName.values();
		j--;
		return cName[j++];
	}	
	
	public RCountryName getRCountry() {
		RCountryName rCName[] = RCountryName.values();
		return rCName[0];
	}	
	
}