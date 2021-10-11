//
// Created by 47405 on 2021/10/11.
//

#ifndef TEST_CHINESE_H
#define TEST_CHINESE_H
#include "people.h"
#include "iostream"
using namespace std;


class chinese: public people {


public:
    void init();

    chinese(){
        cout<<"This is Chinese's construction"<<endl;
    }
};


#endif //TEST_CHINESE_H
