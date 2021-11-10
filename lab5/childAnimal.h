#include <string>
#include <iostream>
#include "animal.h"
#ifndef CHILDANIMAL_H
#define CHILDANIMAL_H
using namespace std;

class Dog: public Mammal {
    private:
        string _owner;
    public:
        Dog(string name, COLOR c, string owner): Mammal(name, c), _owner(_owner) {
            cout << "constructing Dog object " << _name << endl;
        }

        ~Dog() {
            cout << "destructing Dog Object " << _name << endl;
        }


        void speak() override{
            cout << "woof" << endl;
        }

        void move() override {
            cout << "Dog " << _name << " is moving" << endl;
        }

};

class Cat: public Mammal {
    public:
        Cat(string _name, COLOR c): Mammal(_name, c) {
            cout << "constructing Cat object " << _name << endl;
        }

        ~Cat() {

        }

        void speak() override {
            cout << "meeeeeee ow" << endl;
        }

        void move() override {
            cout << "cat pounces on the table and swipes off your glass of water" << endl;
        }
};

class Lion: public Mammal {
    public:
        Lion(string _name, COLOR c): Mammal(_name, c) {
            cout << "construct Lion object " << _name << endl;
        }

        ~Lion() {

        }

        void speak() override {
            cout << "Rawr im a mountain lion says " << _name << endl;
        }

        void move() override{
            cout << "lion mauls your face" << endl;
        }
};

#endif // CHILDANIMAL_H