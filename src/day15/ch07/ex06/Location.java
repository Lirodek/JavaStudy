package day15.ch07.ex06;

public class Location {
	private String city;
	private int latitude;
	private int hardness;
	public Location(String city, int latitude, int hardness) {
		this.city = city;
		this.latitude = latitude;
		this.hardness = hardness;
	}
	@Override
	public String toString() {
		return city + "  " + latitude + "  " + hardness;
	}
	public String getCity() {
		return city;
	}
	public int getLatitude() {
		return latitude;
	}
	public int getHardness() {
		return hardness;
	}
	
}
