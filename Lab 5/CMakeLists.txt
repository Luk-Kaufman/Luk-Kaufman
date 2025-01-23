cmake_minimum_required(VERSION 3.29)
project(Lab_5)

set(CMAKE_CXX_STANDARD 14)

add_executable(Lab_5
        Project5Driver.cpp
        Trie.cpp
)

target_include_directories(Lab_5 PRIVATE ${CMAKE_CURRENT_SOURCE_DIR})