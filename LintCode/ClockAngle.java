public class ClockAngle {
	public static void main(String[] args) {
		Integer hour = 5;
		Integer min = 45;
		ClockAngle ca = new ClockAngle();
		double res = ca.parseClockAngle(hour, min);
		System.out.println(res);
	}
	public double parseClockAngle(Integer hour, Integer min) {
		double ratioOfMin = min / 60.0;
		System.out.println(ratioOfMin);
		double angleMin = ratioOfMin * 360;

		double distanceOfHour = hour + ratioOfMin * 1;
		double ratioOfHour = distanceOfHour / 12.0;
		System.out.println(ratioOfHour);
		double angleHour = ratioOfHour * 360;

		double res = angleHour - angleMin > 0 ? angleHour - angleMin : angleMin - angleHour;
		return res > 180 ? 360 - res : res;
	}
}