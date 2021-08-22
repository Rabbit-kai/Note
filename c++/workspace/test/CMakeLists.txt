cmake_minimum_required(VERSION 3.20) #指定运行此配置文件所需的 CMake 的最低版本；
project(test)  #该命令表示项目的名称

set(CMAKE_CXX_STANDARD 14)

add_executable(test main.cpp)  #将名为 main.cpp 的源文件编译成一个名称为 test 的可执行文件。
#add_executable(Demo main.cpp MathFunctions.cpp)  多文件时唯一的改动只是在 add_executable 命令中增加了一个 MathFunctions.cpp 源文件
#更省事的方法是使用 aux_source_directory 命令，该命令会查找指定目录下的所有源文件，然后将结果存进指定变量名。其语法如下：
# 查找当前目录下的所有源文件
# 并将名称保存到 DIR_SRCS 变量
#aux_source_directory(. DIR_SRCS)
# 指定生成目标
#add_executable(Demo ${DIR_SRCS})   







