#include <iostream>
#include <fstream>
using namespace std;


int main (int argc, char* argv[]) {
    string line;
    fstream frigginfile;
    if (argc != 2) {
    frigginfile.open ("hello.txt", fstream::in);
} else {
    frigginfile.open (argv[1], fstream::in);
}
    if (!frigginfile.is_open()) {
         cout << "Pointer does not reference a file!!";
         cin.get();                       
         return 0;
}        
    char ch;
    int capnumchar = 0;
    int spacecount = 0;
    int linefeed = 0;
    int digit = 0;
    cout << "The following file was read: \n";
    while (getline(frigginfile, line)) {
          linefeed++;
          }
          
          frigginfile.clear();
          frigginfile.seekg(0);
          linefeed = linefeed - 1;
          
while (frigginfile >> noskipws >> ch) {
    cout << ch;
    if (isupper(ch)) {
       capnumchar++;         
} else if (isdigit(ch)) {
       digit++;
} else if (isspace(ch)) {
       if (ch == 9) {
              spacecount = spacecount + 4;
              } else {
       spacecount++;
}       
}  
}
cout << "\n";
cout << "The number of alpha-characters is: " << capnumchar << endl;
cout << "The number of digits is: " << digit << endl;
cout << "The number of linefeeds is: " << linefeed << endl;
cout << "The number of spaces (including tabs) is: " << spacecount << endl;
frigginfile.close();
system("pause"); // or cin.get();
return 0; 
}
