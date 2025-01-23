#include <iostream>
#include <fstream>
#include <string>
#include "Trie.h"

int main() {
    Trie trie;
    std::ifstream file("../wordlist.txt");

    std::string word;

    // Reads each line from wordlist and inserts into the trie
    while (std::getline(file, word)) {
        trie.insert(word);  // Insert the word into the trie
    }
    // Closes the file after reading
    file.close();


    // while loop for autocomplete
    while (true) {
        std::string prefix;
        std::cout << "Please enter a word prefix (or press enter to exit): ";
        std::getline(std::cin, prefix);

        if (prefix.empty()) {
            break;
        }

        // Gets completions for the entered prefix
        std::vector<std::string> completions = trie.complete(prefix);
        int count = trie.completeCount(prefix);

        std::cout << "There are " << count << " completions for the prefix '" << prefix << "'.  Show completions?  ";

        std::string showCompletions;
        std::getline(std::cin, showCompletions);

        if (showCompletions == "Yes" || showCompletions == "yes") {
            std::cout << "Completions" << std::endl;
            std::cout << "-----------" << std::endl;
            for (const auto& completion : completions) {
                std::cout << completion << std::endl;
            }
        }
    }
  return 0;
}
