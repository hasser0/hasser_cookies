cmake_minimum_required(VERSION 3.5)
project({{ cookiecutter.__project_slug }})
set(SOURCES
    src/hello.cpp
    src/main.cpp
)
add_executable({{ cookiecutter.__project_slug }} $SOURCES)

target_include_directories(hello_headers
    PRIVATE
        ${PROJECT_SOURCE_DIR}/include
)
