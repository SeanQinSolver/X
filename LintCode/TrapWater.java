public class TrapWater {
	public int trap(int[] h) {
		if (h == null || h.length == 0) return 0;
		int len = h.length;
		int[] maxH = new int[len];
		maxH[0] = h[0];
		for (int i = 1; i < len; i++) {
			maxH[i] = Math.max(maxH[i - 1], h[i]);
		}

		int backH = 0;
		int sum = 0;
		for (int i = len - 1; i >= 0; i--) {
			sum += backH > h[i] ? (Math.min(backH, maxH[i]) - h[i]) : 0;
			backH = Math.max(backH, h[i]);
		}
		return sum;

	}
	public static void main(String[] args) {
		int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		TrapWater tw = new TrapWater();
		int sum = tw.trap(h);
		System.out.println(sum);
	}
}