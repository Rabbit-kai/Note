
#include <iostream>
#include <string>
#include <vector>
#include "baseTest.h"
#include "baseBean/chinese.h"
#include "baseBean/people.h"
using namespace std;

int main() {
    // ȡ��ַ��
    baseTest c ;
//    int a = 100;
//    c.add(a);
//    cout<<("������aֵ��"+to_string(a))<<endl;
//    c.vectors();
    //ָ�� ȡ��ַ��
//    c.reference();

    cout<<"�����ʼ������"<<endl;
    chinese son;
    cout<<"1.������ø��Ӷ��еĺ���"<<endl;
    son.init();

    cout<<"2.�����������û�У������еĺ���"<<endl;
    son.body();
    cout<<"3.�����������û�У������еĺ���,�Ҹ���ķ��������˸������඼�еĺ���init."<<endl;
    son.color();

    cout<<"�����ʼ������"<<endl;
    people father;
    cout<<"4.������ø����඼�еĺ���"<<endl;
    father.init();

}




