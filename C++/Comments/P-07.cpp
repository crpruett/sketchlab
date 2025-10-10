// ConsoleApplication1.cpp : Defines the entry point for the console application.
//

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
	string str1 ("//");
	string str2 ("/*");
	string str3 ("*/");
	string letter;
	bool commentdetected;
	bool multicomment;
	bool multiclosed;
	int n = 0;
	
	ifstream myfile("thefile.txt");
	if (!myfile.is_open()) {
		cout << "Unable to locate or open file.";                        
	}
	
	while ((myfile >> letter)) {
	//	cout << letter;
		
		if (str1.compare(letter) == 0) {
			cout << "Single-line comment initialized... Ended upon return.\n";
			commentdetected = true;
		} else if (str2.compare(letter) == 0) {
			cout << "Multi-line comment initialized...\n";
			commentdetected = true;
			multicomment = true;
		} else if ((str3.compare(letter) == 0) && multicomment == true) {
			cout << "Multi-line comment successfully closed...\n";
			multiclosed = true;
		} 	  else cout << "";
		n++;
		
	}
	
if (multiclosed == false && multicomment == true) {
	cout << "ERROR - Multi-line comment not closed!";
}
if (commentdetected == false) {
	cout << "No comments detected...";
}
	return 0;
	system("pause"); // Or cin.get();
	}

