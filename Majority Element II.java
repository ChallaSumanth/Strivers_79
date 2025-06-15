class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length/3;
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int num : nums)
        {
            if(count1 == 0 && ele2 != num)
            {
                count1 = 1;
                ele1 = num;
            }
            else if(ele1 == num)
                count1++;
            else if(count2 == 0 && ele1 != num)
            {
                count2 = 1;
                ele2 = num;
            }
            else if(ele2 == num)
                count2++;
            else
            {
                count1--;count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int num : nums)
        {
            if(ele1 == num) count1++;
            if(ele2 == num) count2++;
        }
       // System.out.println(count1+":"+count2);
        if(count1 > n) list.add(ele1);
        if(count2 > n) list.add(ele2);
        Collections.sort(list);
        return list;
    }
}