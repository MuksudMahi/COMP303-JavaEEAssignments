package spring.mvc.model;

public class Flight {
	private String title;
	private String firstName;
	private String lastName;
	private String DoB;
	private String phone;
	private String email;
	private String streetAddress;
	private String streetAddress2;
	private String city;
	private String region;
	private String zip;
	private String country;
	private String departure;
	private String departureTime;
	private String returnn;
	private String returnTime;
	private String dCity;
	private String dCountry;
	private String rCity;
	private String rCountry;
	private String airline;
	private String fare;
	private String adults;
	private String kids;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDoB() {
		return DoB;
	}
	public void setDoB(String doB) {
		DoB = doB;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStreetAddress() {
		if(streetAddress2!=null || streetAddress2!="")
		{
			return streetAddress+", "+streetAddress2 + ", " +city+", "+zip;
		}
		return streetAddress+ ", " +city+", "+zip;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getReturnn() {
		return returnn;
	}
	public void setReturnn(String returnn) {
		this.returnn = returnn;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getdCity() {
		return dCity;
	}
	public void setdCity(String dCity) {
		this.dCity = dCity;
	}
	public String getdCountry() {
		return dCountry;
	}
	public void setdCountry(String dCountry) {
		this.dCountry = dCountry;
	}
	public String getrCity() {
		return rCity;
	}
	public void setrCity(String rCity) {
		this.rCity = rCity;
	}
	public String getrCountry() {
		return rCountry;
	}
	public void setrCountry(String rCountry) {
		this.rCountry = rCountry;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getAdults() {
		return adults;
	}
	public void setAdults(String adults) {
		this.adults = adults;
	}
	public String getKids() {
		return kids;
	}
	public void setKids(String kids) {
		this.kids = kids;
	}
	
	public int calculateFare()
	{
		return (Integer.parseInt(adults)*1000)+(Integer.parseInt(kids)*600);
	}
	
	@Override
	public String toString() {
		return "Flight [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", DoB=" + DoB
				+ ", phone=" + phone + ", email=" + email + ", streetAddress=" + streetAddress + ", streetAddress2="
				+ streetAddress2 + ", city=" + city + ", region=" + region + ", zip=" + zip + ", country=" + country
				+ ", diparture=" + departure + ", dipartureTime=" + departureTime + ", returnn=" + returnn
				+ ", returnTime=" + returnTime + ", dCity=" + dCity + ", dCountry=" + dCountry + ", rCity=" + rCity
				+ ", rCountry=" + rCountry + ", airline=" + airline + ", fare=" + fare + ", adults=" + adults
				+ ", kids=" + kids + "]";
	}

	
	
	
}
