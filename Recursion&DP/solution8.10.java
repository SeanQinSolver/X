//solution
public class Solution {
	public enum Color {Black, White, Red, Yellow, Green}

	public boolean PaintFill(Color[][] screen, int r, int c, Color ncolor) {
		if (screen[r][c] == ncolor) return false;
		return PaintFill(screen, r, c, screen[r][c], ncolor);
	}

	public boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
		if (r < 0 || r >= screen.length() || c < 0 || c >= sreen[0].length) {return false;}
		if (screen[r][c] == ocolor) {
			screen[r][c] == ncolor;
			PaintFill(screen, r - 1, c, ocolor, ncolor);
			PaintFill(screen, r + 1, c, ocolor, ncolor);
			PaintFill(screen, r, c - 1, ocolor, ncolor);
			PaintFill(screen, r, c + 1, ocolor, ncolor);
		}
		return true;
	}
}