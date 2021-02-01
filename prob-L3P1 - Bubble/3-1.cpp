#include <iostream>
using namespace std;

void display(int array[], int n){
    for(int i=0; i<n; i++){
            cout << array[i];
            if(i+1==n) cout << endl;
            else cout << ", ";
        }
}

int main(){
    int i, n, tmp;
    cin >> n;
    int array[n];
    bool sort = true;

    for(i=0; i<n; i++){
        cin >> array[i];
    }

    display(array, n);

    while (sort)
    {
        sort = false;
        
        for(i=0; i<n; i++){
            if(i+1 < n){
                if(array[i] > array[i+1]){
                    tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    sort = true;
                    display(array, n);
                }
            }
        }
    }
}
