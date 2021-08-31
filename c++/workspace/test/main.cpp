
#include <iostream>
#include <string>
#include <vector>
#include "baseTest.h"
using namespace std;

int main() {
    // 取地址符
    baseTest c ;
    int a = 100;
    c.add(a);
    cout<<("处理后的a值："+to_string(a))<<endl;
    c.vectors();
    return 0;
}




