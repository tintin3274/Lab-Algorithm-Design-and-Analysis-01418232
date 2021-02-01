#include <iostream>
#include <string>
using namespace std;

bool checkIP(string a, string b, string c, string d, int len){
    //cout << "a:(" << a << ") b:(" << b << ") c:(" << c << ") d:(" << d << ")"<< endl;
    if(!(a.length()>0 && b.length()>0 && c.length()>0 && d.length()>0)) return false;
    if(to_string(stoi(a)).length() + to_string(stoi(b)).length() + to_string(stoi(c)).length() + to_string(stoi(d)).length() != len) return false;
    if((stoi(a) > 255) || (stoi(b) > 255) || (stoi(c) > 255) || (stoi(d) > 255)) return false;
    return true;
}

int main(){
    int i, j, k, l, m, n, count;
    string ip;
    cin >> n;
    for(m=0; m<n; m++){
        cin >> ip;
        count = 0;
        for(i=0; i<=3; i++){
            for(j=0; j<=3; j++){
                for(k=0; k<=3; k++){
                    for(l=0; l<=3; l++){
                        if(i+j+k+l != ip.length()) continue;
                        if(checkIP(ip.substr(0, i), ip.substr(i, j), ip.substr(i+j, k), ip.substr(i+j+k, l), ip.length())) count++;
                    }
                }
            }
        }
        cout << count << endl;
    }
}