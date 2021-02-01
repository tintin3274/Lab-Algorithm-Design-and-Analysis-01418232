#include <iostream>
#include <sstream>
#include<vector>
#include <limits.h>
using namespace std;

int main(){
    int w, l, d, x, y, z, mx, my, mz, mv, dx=0, dy=0, dz=0, i, index;
    string line, axis;
    cin >> w >> l >> d;
    int distance[d][w][l];
    bool visited[d][w][l];
    vector<string> visit;
    for(z=0; z<d; z++){
        for(y=0; y<w; y++){
            cin >> line;
            for(x=0; x<l; x++){
                distance[z][y][x] = INT_MAX;
                visited[z][y][x] = false;
                if(line.at(x) == 'S'){
                    distance[z][y][x] = 0;
                    axis = to_string(z) + " " + to_string(y) + " " + to_string(x);
                    visit.push_back(axis);
                }
                else if(line.at(x) == 'X') visited[z][y][x] = true;
                else if(line.at(x) == 'M'){ dx = x; dy = y; dz = z; }
            }
        }
    }
    bool find = true;
    while(!visit.empty() && find){
        find = false;
        mx = 0; my = 0; mz = 0;
        mv = INT_MAX;
        for(i=0; i<visit.size(); i++){
            istringstream iss(visit.at(i));
            vector<string> result;
            for(string s;iss>>s;)
                result.push_back(s);
            z = stoi(result.at(0));
            y = stoi(result.at(1));
            x = stoi(result.at(2));

            if(!visited[z][y][x] && distance[z][y][x] < mv){
                mx = x; my = y; mz = z;
                mv = distance[z][y][x];
                find = true;
                index = i;
            }
        }
        if(find){
            if(mx+1 < l && !visited[mz][my][mx+1] && mv < distance[mz][my][mx+1]) {distance[mz][my][mx+1] = mv+1; visit.push_back(to_string(mz)+" "+to_string(my)+" "+to_string((mx+1)));}
            if(mx-1 >= 0 && !visited[mz][my][mx-1] && mv < distance[mz][my][mx-1]) {distance[mz][my][mx-1] = mv+1; visit.push_back(to_string(mz)+" "+to_string(my)+" "+to_string((mx-1)));}
            if(my+1 < w && !visited[mz][my+1][mx] && mv < distance[mz][my+1][mx]) {distance[mz][my+1][mx] = mv+1; visit.push_back(to_string(mz)+" "+to_string((my+1))+" "+to_string(mx));}
            if(my-1 >= 0 && !visited[mz][my-1][mx] && mv < distance[mz][my-1][mx]) {distance[mz][my-1][mx] = mv+1; visit.push_back(to_string(mz)+" "+to_string((my-1))+" "+to_string(mx));}
            if(mz+1 < d && !visited[mz+1][my][mx] && mv < distance[mz+1][my][mx]) {distance[mz+1][my][mx] = mv+1; visit.push_back(to_string((mz+1))+" "+to_string(my)+" "+to_string(mx));}
            if(mz-1 >= 0 && !visited[mz-1][my][mx] && mv < distance[mz-1][my][mx]) {distance[mz-1][my][mx] = mv+1; visit.push_back(to_string((mz-1))+" "+to_string(my)+" "+to_string(mx));}
            visited[mz][my][mx] = true;
            visit.erase(visit.begin()+index);
        }
        if(visited[dz][dy][dx]) find = false;
    }
    cout << distance[dz][dy][dx] << endl;
}