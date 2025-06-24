Brute force :

class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int len = stations.length;
        
        int[] howMany = new int[len - 1];
        for(int gasStation = 1; gasStation <= k; gasStation++)
        {
            int index = -1;
            double maxDiff = Integer.MIN_VALUE;
            for(int i = 0; i < len - 1; i++)
            {
                double diff = (double)(stations[i + 1] - stations[i]) /(double) (howMany[i] + 1);
                if(maxDiff < diff)
                {
                    maxDiff = diff;
                    index = i;
                }
            }
            howMany[index]++;
        }
        
        double maxDistance = -1;
        for(int i = 0; i < len - 1; i++)
        {
            double dist = (double)(stations[i + 1] - stations[i]) /(double) (howMany[i] + 1);
            maxDistance = Math.max(maxDistance, dist);
        }
        return maxDistance;
    }
}

Better :

class Solution {
    public static class Pair{
        double sectionLength;
        int index;
        
        Pair(double sectionLength, int index)
        {
            this.sectionLength = sectionLength;
            this.index = index;
        }
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int len = stations.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.sectionLength, a.sectionLength));
        
        for(int i = 0; i < len - 1; i++)
        {
            pq.add(new Pair(stations[i + 1] - stations[i], i));
        }
        int[] howMany = new int[len - 1];
        for(int gasStation = 1; gasStation <= k; gasStation++)
        {
            Pair cur = pq.poll();
            howMany[cur.index]++;
            double initialDiff = stations[cur.index + 1] - stations[cur.index];
            double newsectionLength = (double)initialDiff / (double) (howMany[cur.index] + 1);
            pq.offer(new Pair(newsectionLength, cur.index));
        }
        return pq.poll().sectionLength;
        
    }
}

