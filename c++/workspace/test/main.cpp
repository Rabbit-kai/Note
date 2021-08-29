
#include <iostream>
#include <string>
#include <vector>
using namespace std;
class test{

public:
    void add(int &a){
        cout<<&a<<endl;
        a = a+1;
        cout<<("add中的a值："+to_string(a))<<endl;
        //return a;
    }
    void vectors(){
        vector<int> vec ={1,2,3};
        vector<int>::iterator iter;
        cout<<"vec的值为：";
        for (iter = vec.begin(); iter != vec.end() ; iter++) {
            cout<<*iter<<"   ";
        }

        //assign
        vector<int> v1;
        v1.assign(vec.begin(),vec.end());
        cout<<endl<<"vector 中copy的元素：";
        for(iter = v1.begin() ; iter != v1.end() ; ++iter)
        {
            cout<<*iter<<" ";
        }

    }

};

int main() {
    // 取地址符
    test c ;
//    int a = 100;
//    c.add(a);
//    cout<<("处理后的a值："+to_string(a))<<endl;
    c.vectors();
    return 0;
}
