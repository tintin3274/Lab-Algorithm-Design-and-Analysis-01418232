
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void printVector(vector<int> arr){
    for (auto i = arr.begin() ; i != arr.end() ; i++){
        cout << *i << " ";
    }
    cout << endl;
}

int main(){
    int n;
    int count1 = 0,count2 = 0;
    bool isUnalternate = false;
    cin >> n;
    vector<int> arr;
    for (int i = 0; i < n; i++ ){
        char temp;
        cin >> temp;
        if (temp == 'r'){
            arr.push_back(1);
        }
        else{
            arr.push_back(0);
        }
    }

    for (int i = 0; i < n; i++){
        if( i % 2 ){
            if(arr[i] != 0)count1++;
        }
        else{
            if(arr[i] != 1)count2++;
        }         
    }
    int result = abs(count1 - count2) + min(count1,count2);
    count1 = 0;
    count2 = 0;

    for (int i = 0; i < n; i++){
        if( i % 2 ){
            if(arr[i] != 1)count1++;
        }
        else{
            if(arr[i] != 0)count2++;
        }         
    }
    result = min(result,abs(count1 - count2) + min( count1 , count2 ));
    cout << result << endl;
    return 0;
}