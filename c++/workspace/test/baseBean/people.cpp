//
// Created by 47405 on 2021/10/11.
//

#include "people.h"

void people::init() {
    cout<<"This is Father Class Function init"<<endl;
}

void people::body() {
    cout<<"This is Father Class Function body,everyone has his body"<<endl;
}

void people::color() {
    init();
    cout<<"people have different color skin"<<endl;
}