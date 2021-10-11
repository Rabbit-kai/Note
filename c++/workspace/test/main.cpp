
#include <iostream>
#include <string>
#include <vector>
#include "baseTest.h"
#include "baseBean/chinese.h"
#include "baseBean/people.h"
using namespace std;

int main() {
    // 取地址符
    baseTest c ;
//    int a = 100;
//    c.add(a);
//    cout<<("处理后的a值："+to_string(a))<<endl;
//    c.vectors();
    //指针 取地址符
//    c.reference();

    cout<<"子类初始化：："<<endl;
    chinese son;
    cout<<"1.子类调用父子都有的函数"<<endl;
    son.init();

    cout<<"2.子类调用子类没有，父类有的函数"<<endl;
    son.body();
    cout<<"3.子类调用子类没有，父类有的函数,且父类改方法调用了父类子类都有的函数init."<<endl;
    son.color();

    cout<<"父类初始化：："<<endl;
    people father;
    cout<<"4.父类调用父子类都有的函数"<<endl;
    father.init();

}




