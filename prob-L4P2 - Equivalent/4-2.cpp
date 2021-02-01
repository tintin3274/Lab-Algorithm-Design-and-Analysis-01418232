#include <iostream>
using namespace std;

bool Equivalent(string a, string b){
    if(a.length() > 1 && b.length() > 1){
        string a1, a2, b1, b2;
        a1 = a.substr(0, a.length()/2);
        a2 = a.substr(a.length()/2);
        b1 = b.substr(0, b.length()/2);
        b2 = b.substr(b.length()/2);

        return ((Equivalent(a1, b1) && Equivalent(a2, b2)) || (Equivalent(a1, b2) && Equivalent(a2, b1)));
    }

    if(a == b) return true;
    return false;
}

int main(){
    string a, b;
    cin >> a >> b;
    if(Equivalent(a, b)) cout << "YES";
    else cout << "NO";
}