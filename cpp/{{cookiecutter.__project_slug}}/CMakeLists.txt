cmake_minimum_required(VERSION 4.1)
project({{ cookiecutter.__project_slug }})
set(CXX_STANDARD {{ cookiecutter.cxx_standard }})
set(SOURCE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/src")
file(GLOB SOURCES "${SOURCE_DIR}/*.cpp")
add_executable({{ cookiecutter.__project_slug }} ${SOURCES})

target_include_directories({{ cookiecutter.__project_slug }}
  PRIVATE
    ${CMAKE_CURRENT_SOURCE_DIR}/include
)
