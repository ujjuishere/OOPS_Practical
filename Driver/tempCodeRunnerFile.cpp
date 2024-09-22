#include <iostream>
#include <string>
#include <algorithm>

// Function to reverse a string and remove leading zeros
std::string reverseAndTrim(const std::string &s) {
    std::string reversed = s;
    std::reverse(reversed.begin(), reversed.end());
    // Remove leading zeros
    reversed.erase(0, reversed.find_first_not_of('0'));
    return reversed.empty() ? "0" : reversed;
}

int main() {
    std::string m1, m2;
    
    // Read the input numbers as strings
    std::cin >> m1 >> m2;
    
    // Reverse the strings and convert to integers
    int reversedM1 = std::stoi(reverseAndTrim(m1));
    int reversedM2 = std::stoi(reverseAndTrim(m2));
    
    // Calculate the difference
    int difference = reversedM1 - reversedM2;
    
    // Output the result
    std::cout << difference << std::endl;
    
    return 0;
}
