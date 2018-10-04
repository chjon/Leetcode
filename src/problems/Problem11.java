package problems;

/**
 * Solutions to "Container With Most Water"
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class Problem11 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Two-pointer solution
	 * The idea is to narrow in on the solution with the largest area by finding the largest possible area for each line
	 * segment
	 *
	 * @param height an array of all the heights
	 * @return the maximum area of a container formed by two line segments
	 */
	public int maxArea(int[] height) {
		int leftIndex = 0;
		int rightIndex = height.length - 1;
		int maxArea = 0;

		while (leftIndex < rightIndex) {
			// Find the area of the container induced by the two line segments
			int area = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
			maxArea = Math.max(area, maxArea);

			// Move the pointer that is currently pointing to the smaller height
			if (height[leftIndex] < height[rightIndex]) {
				leftIndex++;
			} else {
				rightIndex--;
			}
		}

		return maxArea;
	}
}
