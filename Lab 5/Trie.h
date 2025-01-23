#ifndef TRIE_H
#define TRIE_H

#include <string>
#include <vector>

class TrieNode {
public:
    TrieNode* children[26];
    bool isEndOfWord;

    // Constructor
    TrieNode();
};

class Trie {
private:
    TrieNode* root;
    int wordCount;
    int nodeCount;

    // Helper functions
    void clear(TrieNode* node);
    void copy(TrieNode* &dest, TrieNode* source);
    int countWordsWithPrefix(TrieNode* node, int& Numfound);
    std::vector<std::string> collectWords(TrieNode* node, const std::string& prefix, std::vector<std::string>& results);

public:
    // Constructor and Destructor
    Trie();
    Trie(const Trie& other);
    ~Trie();

    // Member functions
    bool insert(const std::string& word);
    int count() const;
    int getSize() const;
    bool find(const std::string& word) const;
    int completeCount(const std::string& prefix);
    std::vector<std::string> complete(const std::string& prefix);

    // Assignment operator
    Trie& operator=(const Trie& other);
};

#endif // TRIE_H
