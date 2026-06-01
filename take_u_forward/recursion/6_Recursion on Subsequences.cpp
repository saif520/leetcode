// print all subsequences
#include <iostream>
#include <vector>
using namespace std;

void subSeq(int ind, vector<int>& ds, int arr[], int n) {
    if (ind == n) {
        for (auto it : ds) {
            cout << it << " ";
        }
        cout << endl;
        return;
    }

    // Take the current element
    ds.push_back(arr[ind]);
    subSeq(ind + 1, ds, arr, n);

    // Backtrack
    ds.pop_back();

    // Do not take the current element
    subSeq(ind + 1, ds, arr, n);
}

int main() {

    int arr[] = {3, 1, 2};
    int n = 3;

    vector<int> ds;

    subSeq(0, ds, arr, n);

    return 0;
}