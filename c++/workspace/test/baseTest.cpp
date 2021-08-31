//
// Created by 47405 on 2021/8/31.
//

#include "baseTest.h"


void add(int &a){
    cout<<&a<<endl;
    a = a+1;
    cout<<("a in add is "+to_string(a))<<endl;
    //return a;
}
void vectors(){
    vector<int> vec ={1,2,3};
    vector<int>::iterator iter;
    cout<<"vec is ";
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
