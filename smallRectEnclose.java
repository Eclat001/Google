package GoogleOA;

/* An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels 
 * are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given
 * the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle 
 * that encloses all black pixels.
 * For example, given the following image:
[
  "0010",
  "0110",
  "0100"
]                                          and x = 0, y = 2, Return 6.
 * */

public class smallRectEnclose {
	public static int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int colmin = BS(image, true, 0, y, 0, m, true);
        int colmax = BS(image, true, y + 1, n, 0, m, false);
        int rowmin = BS(image, false, 0, x, colmin, colmax, true);
        int rowmax = BS(image, false, x + 1, m, colmin, colmax, false);
        return (rowmax - rowmin) * (colmax - colmin);
    }
    public static int BS(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            boolean inside = false;
            for (int i = min; i < max; i++) {
                if ((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    inside = true;
                    break;
                }
            }
            if (inside == goLower) {
                upper = mid;
            }
            else {
                lower = mid + 1;
            }
        }
        return lower;
    }
    public static void main(String... args) {
    	char[][] m = {{'0', '0', '1', '0'},
    			      {'0', '1', '1', '0'},
    			      {'0', '1', '0', '0'}};
    	int x = 0, y = 2;
    	System.out.println(smallRectEnclose.minArea(m, x, y));
    }
}
