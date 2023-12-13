package OPQ1_20231213_Phan_Minh_Phong;

class OPQ1_20231213_Phan_Minh_Phong {

    public static int findMaxWater(int[] buildingHeights) {
        // use two pointer approach to find the maximum area
        int left = 0, right = buildingHeights.length - 1;
        int maxArea = 0, currentArea;

        while (left < right) {
            if (buildingHeights[left] < buildingHeights[right]) {
                currentArea = (right - left) * buildingHeights[left];
                left++;
            } else {
                currentArea = (right - left) * buildingHeights[right];
                right--;
            }
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(OPQ1_20231213_Phan_Minh_Phong.findMaxWater(new int[] { 1, 2 ,3, 5, 6, 2, 4, 7 }));
        System.out.println(OPQ1_20231213_Phan_Minh_Phong.findMaxWater(new int[] { 1, 1 }));
        System.out.println(OPQ1_20231213_Phan_Minh_Phong.findMaxWater(new int[] { 1, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }));
    }
}