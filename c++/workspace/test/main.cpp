
#include <iostream>
#include <string>
using namespace std;
class Calc{

public:
    void add(int &a){
        cout<<&a<<endl;
        a = a+1;
        cout<<("add�е�aֵ��"+to_string(a))<<endl;
        //return a;
    }
};

int main() {
    Calc c ;
    int a = 100;
    c.add(a);
    cout<<("������aֵ��"+to_string(a))<<endl;

    return 0;
}
