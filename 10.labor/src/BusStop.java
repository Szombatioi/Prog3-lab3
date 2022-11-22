
public class BusStop {
	String name, oldName, wheelChair;
	boolean valid;
	double distance;
	double lat = 47.4786346, lon = 19.0555773;
	
	public BusStop(double lat, double lon) {
		valid = false;
		distance = dist1(this.lat, this.lon, lat, lon);
	}
	
	@Override
	public String toString() {
		return "Megálló:\n"+"\tNév: "+name+"("+oldName+")\n"+"\tKerekesszék: "+wheelChair+"\n\tTávolság: "+distance;
	}
	
	double dist1(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371000; // metres
		double phi1 = Math.toRadians(lat1);
		double phi2 = Math.toRadians(lat2);
		double dphi = phi2-phi1;
		double dl = Math.toRadians(lon2-lon1);
		double a = Math.sin(dphi/2) * Math.sin(dphi/2) +
		 Math.cos(phi1) * Math.cos(phi2) *
		 Math.sin(dl/2) * Math.sin(dl/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		return d;
		}


}
