/* Author: Chris Pruett
Date: 1/16/2014
Class: Programming Languages
*/
#include <iostream>
#include <string>
using namespace std;

struct Student {
       
       string name;
       int age;
       float GPA;
       string grade;
       
       };
       
int main() {
    Student* students = new Student[3];
    for (int i = 0; i < 3; i++) {
        cout << "What is the student's name?: " << endl;
        cin >> students[i].name;
        
            cout << "Age of the student?: " << endl;
            cin >> students[i].age;
            
            while (students[i].GPA > 0 && students[i].GPA <= 4) {
            cout << "GPA of the student?: " << endl;
            cin >> students[i].GPA;
            }
            cout << "Grade of the student?: " << endl;
            cin >> students[i].grade;
               
}

for (int j = 0; j < 3; j++){
    cout << "\nStudent Name: ";
    cout << students[j].name;
    cout << "\nStudent Age: ";
    cout << students[j].age;
    cout << "\nStudent GPA: ";
    cout << students[j].GPA;
    cout << "\nStudent Grade: ";
    cout << students[j].grade;
}
    cout << "\n";
    system("pause");
    return 0;
}

