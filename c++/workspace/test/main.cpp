
#include <iostream>
#include <string>
#include <vector>
#include "baseTest.h"
using namespace std;

int main() {
    // ȡ��ַ��
    baseTest c ;
    int a = 100;
    c.add(a);
    cout<<("������aֵ��"+to_string(a))<<endl;
    c.vectors();
    return 0;
}




