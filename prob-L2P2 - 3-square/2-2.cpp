#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int i, n, a, b, c, k;
    double param, result; 

    cin >> n;
    int input[n];
    for(i=0; i<n; i++){
        cin >> input[i];
    }

    for(i=0; i<n; i++){
        bool found = false;
        
        k = input[i];
        b = 0;

        for(a = 0; a <= b && !found; a++){
            for(b = a; (a*a)+(b*b) < k && !found; b++){
                if(fmod(sqrt (k-(a*a)-(b*b)), 1) == 0){
                    c = sqrt (k-(a*a)-(b*b));
                    found = true;
                    cout << a << " " << b << " " << c << endl;
                }
            }
        }
        if(!found) cout << "-1" << endl;
    }
}