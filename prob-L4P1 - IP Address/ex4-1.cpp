#include <iostream>
#include <string>
#include <bits/stdc++.h>
using namespace std;

bool check(string ip){
    if( ip.size() > 3 ||  
        stoi(ip) < 0 ||  
        stoi(ip) > 255 ) 
        return false; 
  
    if( ip.size() > 1 &&  
        stoi(ip) == 0) 
        return false; 
  
    if( ip.size() > 1 &&  
        stoi(ip) != 0 &&  
        ip[0] == '0') 
        return false;

    return true;
}

int main(){
    int i, m, n, j, k, length, count, d1, d2, d3;
    cin >> n;
    string ip[n];
    string s, s_new;
    for(i=0; i<n; i++){
        cin >> ip[i];
    }

    for(m=0; m<n; m++){
        s = ip[m];
        s_new = s;
        length = s.size();
        count = 0;
        
        for(i = 1; i < length - 2; i++){
            for(j = i + 1; j < length - 1; j++){
                for(k = j + 1; k < length; k++){
                    s_new = s_new.substr(0, k) + "." + s_new.substr(k, length - k + 2);
                    s_new = s_new.substr(0, j) + "." + s_new.substr(j, length - j + 3);
                    s_new = s_new.substr(0, i) + "." + s_new.substr(i, length - i + 4);

                    d1 = s_new.find('.');
                    d2 = s_new.find('.', d1+1);
                    d3 = s_new.find('.', d2+1);

                    //cout << d1 << " " << d2 << " " << d3 << endl;
                    //cout << s_new.substr(0, d1) << " " << s_new.substr(d1+1, d2-d1-1) << " " << s_new.substr(d2+1, d3-d2-1) << " " << s_new.substr(d3+1) << endl;

                    if(!(check(s_new.substr(0, d1)))) break;
                    if(!(check(s_new.substr(d1+1, d2-d1-1)))) break;
                    if(!(check(s_new.substr(d2+1, d3-d2-1)))) break;
                    if(!(check(s_new.substr(d3+1)))) break;

                    
                    //if(!(check(s_new.substr(0, d1)) && check(s_new.substr(d1+1, d2-d1-1)) && check(s_new.substr(d2+1, d3-d2-1)) && check(s_new.substr(d3+1)))) break;

                    count++;
                    s_new = s;
                }
            }
        }
        cout << count << endl;
    }
}





/*
int check(string ip){
    vector <string> ips;
    string ex = "";

    for(int i = 0; i < ip.size(); i++){
        if(ip[i] == '.'){
            ips.push_back(ex);
            ex = "";
        }
        else{
            ex = ex + ip[i];
        }
    }
    ips.push_back(ex);

    for(int i = 0; i < ips.size(); i++){ 
        if( ips[i].length() > 3 ||  
            stoi(ips[i]) < 0 ||  
            stoi(ips[i]) > 255 ) 
            return 0; 
  
        if( ips[i].length() > 1 &&  
            stoi(ips[i]) == 0) 
            return 0; 
  
        if( ips[i].length() > 1 &&  
            stoi(ips[i]) != 0 &&  
            ips[i][0] == '0') 
            return 0;
    }
    return 1;
}
*/