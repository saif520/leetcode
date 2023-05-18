class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        t=0;
        for x in strs:
            if x.isnumeric():
                t=max(int(x),t);
            else:
                t=max(len(x),t);
        return t;