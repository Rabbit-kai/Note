//
// Created by 47405 on 2021/10/11.
//

#ifndef TEST_PEOPLE_H
#define TEST_PEOPLE_H
#include "iostream"
using namespace std;

class people {
public:
    people(){
        cout<<"This is people's construction"<<endl;
    }
    void init();
    void body();
    void color();

    people(string sex){
        cout<<"This is people's construction with param"<<endl;
    }
};


#endif //TEST_PEOPLE_H
