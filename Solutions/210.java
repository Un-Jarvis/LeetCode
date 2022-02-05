class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Get indegree of each node
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }
        
        boolean[] visited = new boolean[numCourses];
        List<Integer> orderList = new LinkedList<>();
        while (orderList.size() < numCourses) {
            // Find the next unvisited node with indegree of 0
            int index = 0;
            while (index < numCourses && (indegrees[index] != 0 || (indegrees[index] == 0 && visited[index]))) {
                index++;
            }

            // If such node does not exist, no order can be found. Return an empty array
            if (index == numCourses) return new int[0];

            // Add node to the order
            orderList.add(index);
            visited[index] = true;

            // Update indegrees of the rest nodes
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == index) {
                    indegrees[prerequisites[i][0]]--;
                }
            }
        }
        
        // Convert the list to an array
        int[] order = new int[numCourses];
        for (int i = 0; i < order.length; i++) {
            order[i] = orderList.get(i);
        }
        
        return order;
    }
}