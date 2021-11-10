#include <iostream>
#include <string>
#include "Animal.h"
#include "childAnimal.h"
using namespace std;
// enum COLOR { Green, Blue, White, Black, Brown };

int main(int argc, char const *argv[]) {

    // zoo
    int choice = -1;
    Mammal *zoo[1024];
    int i = 0;
    while (choice != 5) {
        cout << "Select the animal to send to Zoo" << endl;
        cout << "1. Dog" << endl;
        cout << "2. Cat" << endl;
        cout << "3. Lion" << endl;
        cout << "4. Move all animals" << endl;
        cout << "5. Quit" << endl;
        cin >> choice;
        switch (choice) {
            case 1:
                zoo[i] = new Dog("Lassie", White, "Andy");
                i++;
                break;
            case 2:
                zoo[i] = new Cat("Kitty", Blue);
                i++;
                break;
            case 3:
                zoo[i] = new Lion("Lion", Green);
                i++;
                break;
            case 4:
                cout << "Move all animals" << endl;
                for (int j = 0; j < i; j++) {
                    zoo[j]->move();
                    zoo[j]->speak();
                    zoo[j]->eat();
                }
                break;
            case 5:
                cout << "Quit" << endl;
                break;
            default:
                cout << "Invalid choice" << endl;
                break;
        }
    }
}


