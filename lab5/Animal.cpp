#include <iostream>
#include <string>

using namespace std;

enum COLOR { Green, Blue, White, Black, Brown };

class Animal {
protected:
    string _name;
    COLOR _color;
public:
    // Constructor
    Animal() : _name("unknown") {
        cout << "constructing Animal Object" << _name << endl;
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

    void speak() const {
        cout << "Animal " << _name << " is speaking" << endl;
    }

    void move() const {
        cout << "Animal " << _name << " is moving" << endl;
    }
};

class Mammal: public Animal {
    public:
        // constructor
        Mammal(string name, COLOR c): Animal(name, c) {
            cout << "constructing Mammal object" << _name << endl;
        };

        // destructor
        ~Mammal() {
            cout << "destructing Mammal Object " << _name << endl;
        }


        void eat() const {
            cout << "Mammal Eat" <<  endl;
        }
};

class Dog: public Mammal {
    private:
        string _owner;
    public:
        Dog(string name, COLOR c, string owner): Mammal(name, c), _owner(_owner) {
            cout << "constructing Dog object " << _name << endl;
        }


};


int main(int argc, char const *argv[]) {
    // animal
    Animal a("animal", Green);
    a.speak();

    // mammal
    Mammal mammal("mammal", Blue);
    mammal.speak();
    return 0;
}


