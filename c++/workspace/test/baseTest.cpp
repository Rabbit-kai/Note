//
// Created by 47405 on 2021/8/31.
//
#include "baseTest.h"

/**
 * @details 引用和指针
 */
void baseTest::reference() {
    /**
     * 引用
     */
    //建立一个指向a的引用，对a和b的任意操作都是对同一个地址的操作。
    //引用只是对原变量起了一个别名
    int a = 1234;
    int &b = a;
//    int &b;// 错误，引用类型必须指定初始化对象

    b+=1;
    cout<< a<<endl<<b<<endl;
    //若变量类型为const类型，则引用类型也应为const类型：
    const string consts = " this is a const object";
    const string &c = consts;
    cout<<"const object:"<<consts<<endl<<"const reference:"<<c<<endl;


    //引用指针,但是要保证不能是*p5=0，指向空值的指针是不能被引用的，因为给引用必须用对象给它初始化，否则引用报错
    int *p5 = &a;
    int &d = *p5;
//    int *p6 = 0;
//    int &f = *p6; //这种赋值方式是错误的
    int * &p4 = p5;//这是可以的，一个指向指针的指针



    /**
     * 指针相关操作
     * （*p1：对象  p1：地址）
     */

    int val1 = 123,val2= 456;
    int *p1 = &val1;
    int *p2 = &val2;
    cout<<"p1:"<<p1<<endl; //p1=00DBFB54  地址
    cout<<"*p1:"<<*p1<<endl; //123
    cout<<"p2:"<<p2<<endl; //p2=00DBFB48  地址
    cout<<"*p2:"<<*p2<<endl; //456
    *p1 = val2; //修改p1的引用，将他指向的对象val1，赋值为val2，这样val1=val2;此时*p1还是指向val1的地址，只是该地址的值变为了456
//    p1=val2; //执行报错，无法为指针赋值对象
//    p1=&val2;  //这种方式是可以的，将val2的地址给p1，p1中本来就是地址。
    cout<<"val1:"<<to_string(val1)<<endl; //val1=456
    cout<<"*p1+1:"<<to_string(*p1+1)<<endl; //p1=457
    cout<<"p1:"<<p1<<endl; //p1=00DBFB54  地址
    cout<<"p1+1:"<<p1+1<<endl; //p1=00DBFB58  地址，取相邻的下一个地址
    cout<<"*p1+1:"<<*p1+1<<endl; //457 将指针对应的对象+1
    cout<<"*(p1+1):"<<*(p1+1)<<endl; //-858993460，取相邻的下一个地址的值，因为没有赋值，所以这里产生一个默认值

    //数组名标识数组的首地址，因此可以给指针对象赋值
    int arr[2] = {0,1};
    int *p3 = arr; //或者p3=&arr，因此arr是一个地址，arr[2],是在arr基础上移动两位
    cout<<"arr is "<< to_string(arr[0])<<","<<to_string(arr[1])<<endl;
    cout<<"p3[0] is "<< to_string(p3[0])<<","<<to_string(p3[1]);
}

/**
 *
 * @param a 这里参数是取地址符，传入的是地址，因此在函数内对a进行变更会影响main函数中a的值
 * 如果将&取地址符去了，则只是传入a的值，而不是地址，此时对a的变更只影响add中a的值，不会影响main函数中a的值
 */
void baseTest::add(int &a){
    cout<<&a<<endl;
    cout << a << endl;
    a = a+1;
    cout<<("a in add is "+to_string(a))<<endl;
    //return a;
}

/**
 * @details 对vector测试
 */
void baseTest::vectors(){
    vector<int> vec ={1,2,3};
    vector<int>::iterator iter;
    cout<<"vec is :";
    for (iter = vec.begin(); iter != vec.end() ; iter++) {
        cout<<*iter<<"   ";
    }

    //assign
    vector<int> v1;
    v1.assign(vec.begin(),vec.end()); //将参数中范围的数值赋值给v1
    cout<<endl<<"vector : ";
    for(iter = v1.begin() ; iter != v1.end() ; ++iter)
    {
        cout<<*iter<<" ";
    }
}
