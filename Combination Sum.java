class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        subSets(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void subSets(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> ans)
    {
        if(index == candidates.length)
        {
            if(target == 0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(target - candidates[index] >= 0)
        {
            temp.add(candidates[index]);
            subSets(candidates, target - candidates[index], index, temp, ans);
            temp.remove(temp.size() - 1);
        }
        subSets(candidates, target , index + 1, temp, ans);
        
    }
}