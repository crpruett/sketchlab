/* Author: Chris Pruett
Date: 1/16/2014
Class: Programming Languages
*/
#include <iostream>
#include <string>
using namespace std;

       
int main() {
    string students[3];
    int age[3];
    float GPA[3];
    string grade[3];
    
    for (int i = 0; i < 3; i++) {
        cout << "What is the student's name?: " << endl;
        cin >> students[i];
        
            cout << "Age of the student?: " << endl;
            cin >> age[i];
            
            cout << "GPA of the student?: " << endl;
            cin >> GPA[i];
            
            cout << "Grade of the student?: " << endl;
            cin >> grade[i];
               
}

for (int j = 0; j < 3; j++){
    cout << "\nStudent Name: ";
    cout << students[j];
    cout << "\nStudent Age: ";
    cout << age[j];
    cout << "\nStudent GPA: ";
    cout << GPA[j];
    cout << "\nStudent Grade: ";
    cout << grade[j];
}
    
    cout << "\n";
    system("pause");
    return 0;
}
