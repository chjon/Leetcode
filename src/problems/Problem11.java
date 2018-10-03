package problems;

/**
 * Solutions to "Container With Most Water"
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class Problem11 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public int maxArea(int[] height) {
		int leftIndex = 0;
		int rightIndex = height.length - 1;
		int area = 0;

		while (leftIndex < rightIndex) {
			area = Math.max(area, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));

			if (height[leftIndex] < height[rightIndex]) {
				leftIndex++;
			} else {
				rightIndex--;
			}
		}

		return area;
	}
}
