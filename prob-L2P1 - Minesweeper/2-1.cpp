#include <iostream>
#include <sstream>
using namespace std;

int main(){
    int w, l, n, q, i, x, y;
    stringstream output;
    cin >> w >> l >> n >> q;
    int map[l][w];

    for(y=0; y<l; y++){
        for(x=0; x<w; x++){
            map[y][x] = 0;
        }
    }

    for(i=0; i<n; i++){
        cin >> y >> x;
        map[y][x] = -1;
    }

    for(i=0; i<q; i++){
            int count = 0;
            cin >> y >> x;

            if(map[y][x] == -1){
                output << "Bomb" << endl;
                continue;
            }

            if(x-1>=0 && map[y][x-1] == -1) count++;
            if(x+1<w && map[y][x+1] == -1) count++;
            if(y-1>=0 && map[y-1][x] == -1) count++;
            if(y-1>=0 && x-1>=0 && map[y-1][x-1] == -1) count++;
            if(y-1>=0 && x+1<w && map[y-1][x+1] == -1) count++;
            if(y+1<l && map[y+1][x] == -1) count++;
            if(y+1<l && x-1>=0 && map[y+1][x-1] == -1) count++;
            if(y+1<l && x+1<w && map[y+1][x+1] == -1) count++;
            output << count <<  endl;
        }
    
    cout << output.str();
}
