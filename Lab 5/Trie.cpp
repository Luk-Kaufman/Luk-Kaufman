#include "Trie.h"
#include <iostream>

// Function:  TrieNode::TrieNode -- constructor to create a TrieNode
// Inputs:    none
// Returns:   void -- returns nothing
// Side effects: initializes isEndOfWord to false and sets all children pointers to nullptr
TrieNode::TrieNode() {
    isEndOfWord = false;
    for (int i = 0; i < 26; ++i) {
        children[i] = nullptr;
    }
}

// Function:  Trie::Trie -- constructor to create a Trie
// Inputs:    none
// Returns:   void -- does not return anything
// Side effects: memory is allocated for the root node of the trie and  it is initialized as a new TrieNode.
//               wordCount is set to 0 and nodeCount is set to 1
Trie::Trie() {
    // Create the root node of the trie
    root = new TrieNode();

    // Initialize word count and node count
    wordCount = 0;
    nodeCount = 1;
}

// Function:  Trie::Trie -- copy constructor. Creates a copy of an existing trie
// Inputs:    const Trie& other -- a reference to another Trie object that will be copied
// Returns:   void -- does not return anything
// Side effects: a copy of the other trie is created
Trie::Trie(const Trie& other) {
    // Initialize the root node for the new Trie
    root = new TrieNode();

    // Initialize word count and node count from the other Trie
    wordCount = other.wordCount;
    nodeCount = 1;

    // Recursively copies the nodes from the other Trie to the new Trie
    copy(root, other.root);
}

// Function:  Trie::copy -- recursively copies nodes from one Trie to another
// Inputs:    TrieNode*& dest -- a reference to the destination node where data will be copied to
//            TrieNode* source -- the source node where data is taken from to be copied
// Returns:   void -- does not return anything
// Side effects: trie is recursivly copied
void Trie::copy(TrieNode* &dest, TrieNode* source) {
    if (!source){
        return;
    }
    dest = new TrieNode();
    dest->isEndOfWord = source->isEndOfWord;
    for (int i = 0; i < 26; ++i) {
        if (source->children[i]) {
            copy(dest->children[i], source->children[i]);
        }
    }
}

// Function:  Trie::~Trie -- destructor to deallocate memory for the trie
// Inputs:    none
// Returns:   void -- does not return anything
// Side effects: none
Trie::~Trie() {
    clear(root);
}

// Function:  Trie::clear -- recursively deallocates memory for all nodes in the Trie
// Inputs:    TrieNode* node -- the current node to be cleared
// Returns:   void -- does not return anything
// Side effects: none
void Trie::clear(TrieNode* node) {
    if (!node){
        return;
    }
    for (int i = 0; i < 26; ++i) {
        clear(node->children[i]);
    }
    delete node;
}

// Function:  Trie::insert -- inserts a word into the trie
// Inputs:    const std::string& word -- the word to insert
// Returns:   bool -- returns true if the word is inserted successfully, false if the word already exists in the trie
// Side effects: Increments wordCount and nodeCount if a new word or node is added.
bool Trie::insert(const std::string& word) {
    TrieNode* current = root;

    // runs operation for each character in the word
    for(char character:word){
        // finds index by subtracting 'a' from character
        int index = character - 'a';
        //if no next node exits then create it
        if (!current->children[index]) {
            current->children[index] = new TrieNode();
            nodeCount++;
        }
        // Moves to the child node
        current = current->children[index];
    }

    // Checks if the word already exists in the trie
    if (current->isEndOfWord) {
        return false;
    }

    // last node becomes end of word and word count is  incremented
    current->isEndOfWord = true;
    wordCount++;
    return true;
}

// Function:  Trie::count -- returns the number of words in the trie
// Inputs:    none
// Returns:   int -- the number of words in the trie
// Side effects: none
int Trie::count() const {
    return wordCount;
}

// Function:  Trie::getSize -- returns the total number of nodes in the trie
// Inputs:    none
// Returns:   int -- the total number of nodes in the trie
// Side effects: none
int Trie::getSize() const {
    return nodeCount;  // Returns the stored node count
}

// Function:  Trie::find -- checks if a word exists in the trie
// Inputs:    const std::string& word -- the word to be found in the trie
// Returns:   bool -- true if the word exists, otherwise false
// Side effects: none
bool Trie::find(const std::string& word) const {
    TrieNode* current = root;
    for(char character:word){
        int index = character - 'a';
        if (current->children[index]){
            current = current->children[index];
        }else{
          return false;
        }
    }
    return true;
}

// Function:  Trie::completeCount -- counts how many words in the trie start with the prefix
// Inputs:    const std::string& prefix -- the prefix to search for
// Returns:   int -- the number of words in the trie that start with the prefix
// Side effects: none
int Trie::completeCount(const std::string& prefix) {
    //get to last node in prefix
    TrieNode* current = root;
    for(char character:prefix){
        int index = character - 'a';
        if (current->children[index]){
            current = current->children[index];
        }
    }
    //find the words
    int numFound = 0;
    return countWordsWithPrefix(current,numFound);
}

// Function:  Trie::countWordsWithPrefix -- counts the number of words starting from a given node
// Inputs:    TrieNode* node -- the current node to check for words
//            int& numFound -- a reference to store the number of words found
// Returns:   int -- the number of words found that start from the given node
// Side effects: numFound is increased if the node is a word
int Trie::countWordsWithPrefix(TrieNode* node,int& numFound){
    //base case
    if (node==nullptr){
        return numFound;
    }
    // if end of word then add one to num found
    if (node->isEndOfWord){
        numFound++;
    }
    for(int i = 0; i < 26; i++){
        //if node has a child then recursivly run collectwords again. prefix get's the letter added on
        if (node->children[i]){
            countWordsWithPrefix(node->children[i], numFound);
        }
    }
    return numFound;
}

// Function:  Trie::complete -- returns all words that start with a given prefix
// Inputs:    const std::string& prefix -- the first letters of the words to be found
// Returns:   std::vector<std::string> -- a vector containing all words with the given prefix
// Side effects: none
std::vector<std::string> Trie::complete(const std::string& prefix) {
    std::vector<std::string> results;
    //get to last node in prefix
    TrieNode* current = root;
    for(char character:prefix){
        int index = character - 'a';
        if (current->children[index]){
              current = current->children[index];
        }else{
            return results;
        }
    }
    //find the words
    return collectWords(current, prefix, results);
}

// Function:  Trie::collectWords -- helper function to collect all words from a given node
// Inputs:    TrieNode* node -- current node where words will be collected
//            const std::string& prefix -- the current prefix built up through the recursion
//            std::vector<std::string>& results -- vector to store the words found
// Returns:   std::vector<std::string> -- the vector containing all the words found
// Side effects: The `results` vector is modified to include words found from the given node
std::vector<std::string> Trie::collectWords(TrieNode* node, const std::string& prefix, std::vector<std::string>& results) {
  //base case
    if (node==nullptr){
        return results;
    }
    // if end of word then word is added to results
    if (node->isEndOfWord){
        results.push_back(prefix);
    }
    for(int i = 0; i < 26; i++){
        //if node has a child then recursivly run collectwords again. prefix get's the letter added on
        if (node->children[i]){
            collectWords(node->children[i], prefix + char('a' + i), results);
        }
    }
    return results;
}

// Function:  Trie::operator= -- assignment operator to copy another Trie
// Inputs:    const Trie& other -- the Trie object to copy
// Returns:   Trie& -- reference to the current Trie object
// Side effects: The current Trie is replaced with a copy of the other Trie
Trie& Trie::operator=(const Trie& other) {
    if (this == &other){
      return *this;
    }
    clear(root);
    root = new TrieNode();
    copy(root, other.root);
    wordCount = other.wordCount;
    nodeCount = other.nodeCount;
    return *this;
}