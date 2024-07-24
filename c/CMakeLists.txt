cmake_minimum_required(VERSION 3.14.5)
project(bank-transaction-writer)

#SET(GCC_COVERAGE_COMPILE_FLAGS "-Wno-deprecated -Wno-return-type")

set(CMAKE_CXX_STANDARD 11)

# -w disable warning
#SET(GCC_COVERAGE_COMPILE_FLAGS "-w")

add_definitions(${GCC_COVERAGE_COMPILE_FLAGS})


if(CMAKE_BUILD_TYPE STREQUAL "Release")
  message(STATUS "**RELEASE** Mode")
  set(FLATBUFFERS_LIB ${CMAKE_CURRENT_SOURCE_DIR}/lib/libflatccrt.a)
endif()

if(CMAKE_BUILD_TYPE STREQUAL "Debug")
  message(STATUS "**DEBUG** Mode")
  set(FLATBUFFERS_LIB ${CMAKE_CURRENT_SOURCE_DIR}/lib/libflatccrt_d.a)  
endif()

message(STATUS "Library: ")
message(STATUS ${FLATBUFFERS_LIB})

#Bring the headers
include_directories(include)
 
#Can manually add the sources using the set command as follows:
set(SOURCES
src/main.c
)

#However, the file(GLOB...) allows for wildcard additions:
#file(GLOB SOURCES "src/*.cpp")

add_executable(bank-transaction-writer ${SOURCES})

# Vincule o executável com a biblioteca Flatbuffers
target_link_libraries(bank-transaction-writer ${FLATBUFFERS_LIB})
