#include <iostream>
#include <string>
#ifndef ANIMAL_H
#define ANIMAL_H
using namespace std;
enum COLOR { Green, Blue, White, Black, Brown };



class Animal {
protected:
    string _name;
    COLOR _color;
public:
    // Constructor
    Animal() : _name("unknown") {
        cout << "constructing Animal Object " << _name << endl;
    }

    // overloaded constructor
    Animal(string n, COLOR c) : _name(n), _color(c) {
        cout << "constructing Animal Object " << _name << endl;
        cout << "color is " << _color << endl;
        cout << "name is " << _name << endl;
    }

    ~Animal() {
        cout << "destructing Animal Object " << _name << endl;
    }

    virtual void speak() = 0;

    // virtual void move() const {
    //     cout << "Animal " << _name << " is moving" << endl;
    // }

    virtual void move() = 0;
};

class Mammal: public Animal {
    public:
        // constructor
        Mammal(string name, COLOR c): Animal(name, c) {
            cout << "constructing Mammal object " << _name << endl;
        };

        // destructor
        ~Mammal() {
            cout << "destructing Mammal Object " << _name << endl;
        }

        virtual void speak() {
            cout << "Mammal " << _name << " is speaking" << endl;
        }

        void eat() const {
            cout << "Mammal Eat" <<  endl;
        }

        void move() override {
            cout << "Mammal" << _name << " is moving" << endl;
        }
};

#endif  // ANIMAL_H