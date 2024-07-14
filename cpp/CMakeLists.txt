cmake_minimum_required(VERSION 3.14.5)
project(bank-transaction-reader)

#SET(GCC_COVERAGE_COMPILE_FLAGS "-Wno-deprecated -Wno-return-type")

set(CMAKE_CXX_STANDARD 11)

# -w disable warning
#SET(GCC_COVERAGE_COMPILE_FLAGS "-w")

add_definitions(${GCC_COVERAGE_COMPILE_FLAGS})

#Bring the headers
include_directories(include)
 
#Can manually add the sources using the set command as follows:
set(SOURCES
src/main.cpp
)

#However, the file(GLOB...) allows for wildcard additions:
#file(GLOB SOURCES "src/*.cpp")

add_executable(bank-transaction-reader ${SOURCES})

# Vincule o executável com a biblioteca Flatbuffers
target_link_libraries(bank-transaction-reader ${FLATBUFFERS_LIB})