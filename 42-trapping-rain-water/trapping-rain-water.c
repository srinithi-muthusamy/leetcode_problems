#include <stdio.h>

int trap(int* height, int n) {
    if (n == 0) return 0;

    int leftMax[n], rightMax[n];
    int sum = 0;

    // Fill leftMax array
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = (height[i] > leftMax[i - 1]) ? height[i] : leftMax[i - 1];
    }

    // Fill rightMax array
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = (height[i] > rightMax[i + 1]) ? height[i] : rightMax[i + 1];
    }

    // Calculate trapped water
    for (int i = 0; i < n; i++) {
        int minHeight = (leftMax[i] < rightMax[i]) ? leftMax[i] : rightMax[i];
        sum += (minHeight - height[i]);
    }

    return sum;
}
