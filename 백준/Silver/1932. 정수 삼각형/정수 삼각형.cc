#include <iostream>

using namespace std;

int n;
int maxSum;
int mat[500][500];  // 누적합

int main(){
    cin.tie(nullptr); ios::sync_with_stdio(false);
    cin>>n;
    cin>>maxSum;
    mat[0][0] = maxSum;
    for(int i=1; i<n; i++){
        for(int j=0; j<=i; j++){
            int k;
            cin>>k;
            int temp;
            if(j==0)        temp = k + mat[i-1][0];
            else if(j==i)   temp = k + mat[i-1][j-1];
            else    temp = max(k + mat[i-1][j-1], k + mat[i-1][j]);
            mat[i][j] = temp;
            maxSum = max(maxSum, temp);
        }
    }
    cout<<maxSum<<endl;
}