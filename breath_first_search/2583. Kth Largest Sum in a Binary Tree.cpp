/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    long long kthLargestLevelSum(TreeNode* root, int k) {
        queue<TreeNode*>q;
        q.push(root);
        vector<long long int>v;
        int level=0;
        while(!q.empty()){
            int n=q.size();
            long long int sum=0;
            for(int i=0;i<n;i++){
                TreeNode* front=q.front();
                q.pop();
                sum=sum+front->val;
                if(front->left){
                    q.push(front->left);
                }
                if(front->right){
                    q.push(front->right);
                }
            }
            v.push_back(sum);
            level++;
        }
        // sort(v.begin(),v.end());
        // if(k>v.size())return -1;
        // int n=v.size();
        // return v[n-k];
        priority_queue<long long,vector<long long>,greater<long long>>pq;

        for(int i=0;i<v.size();i++){
            pq.push(v[i]);
            while(pq.size()>k){
                pq.pop();
            }
        }
        if(level<k){
            return -1;
        }
        return pq.top();
    }
};