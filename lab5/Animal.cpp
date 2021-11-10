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

    virtual void speak() const {
        cout << "Animal " << _name << " is speaking" << endl;
    }

    virtual void move() = 0;
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

        ~Dog() {

        }

        void speak() {
            cout >> "woof" >> endl;
        }

};

class Cat: public Mammal {
    public:
        Cat(string _name, COLOR c): Mammal(name, c) {
            cout << "constructing Cat object " << _name << endl;
        }

        ~Cat() {

        }

        void speak {
            cout << "meeeeeee ow" << endl;
        }

        void move {
            cout << "cat pounces on the table and swipes off your glass of water" << endl;
        }
};

class Lion: public cat {
    public:
        Lion(string _name, COLOR c): Mammal(_name, c) {
            cout << "construct Lion object " << _name << endl;
        }

        ~Lion() {

        }

        void speak {
            cout << "Rawr im a mountain lion" << endl;
        }

        void move {
            cout << "Mauls your face" << endl;
        }
}


int main(int argc, char const *argv[]) {
    // // animal
    // Animal a("animal", Green);
    // a.speak();

    // mammal
    Mammal mammal("mammal", Blue);
    mammal.speak();

    // dog
    Dog dog("dog", White, "me");
    dog.speak();

    // abstract animal
    Animal *animalPtr = new Dog("Lassie", white, "Andy");
    *animalPtr.speak();
    *animalPtr.move();

    // 3.3 part 3
    Dog dogi ("Lassie", white, "Andy");
    Mammal *aniPtr = &dogi;
    Mammal &aniRef = dogi;
    Mammal aniVal = dogi;

    aniPtr->speak();
    aniRef.speak();
    aniVal.speak();
    return 0;
}


