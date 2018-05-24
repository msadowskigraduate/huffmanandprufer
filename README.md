# Installation Verification
[![Build Status](https://travis-ci.org/msadowskigraduate/huffmanandprufer.svg?branch=master)](https://travis-ci.org/msadowskigraduate/huffmanandprufer)

The following document illustrates installation process and instruction manual
for Huffman encoding and Prufer encoding/decoding software.

Overall features:
  - Generate huffman code and tree for given text file
  - Encode and Decode graphs and text files using Prufer algorithm
  - Simple GUI allowing easy access to features.
---
## Technology Stack

 - Application has been built using Java programming language written 
    in [Intellij IDEA IDE](https://www.jetbrains.com/idea/).
  - [Graphstream](http://graphstream-project.org/doc/) has been used as visualizing software.
- Software uses [Apache Maven](https://maven.apache.org/index.html) as software  management tool.
---
## Installation
In order to install the software perform the following steps:
1. clone the repository using 
```git clone https://github.com/msadowskigraduate/huffmanandprufer.git```
command to directory of your choice.
2. Using terminal of your choice, run command within ```Prufer``` directory:
``` mvn clean compile assembly:single ```
3. ```target``` directory will be created where executable JAR is. With %JAVA% present in the CLASSPATH run:
``` java -jar Prufer-1.0-SNAPSHOT-jar-with-dependencies.jar```

Alternatively:
1. Download precompiled ```.jar``` file to directory of your choice
2. Open terminal, where JAR has been downloaded.
3. Run the executable JAR:
```java -jar Prufer-1.0-SNAPSHOT-jar-with-dependencies.jar```
---
## Manual
Application features simple GUI for ease of use. 

In the tree structure navigate to the text file you would like to perform analysis on. Click on the desired file and press ```Choose file``` in left lower corner.

In order to run algorithm use buttons in the right, upper section. 

Huffman encoding supports text file only, with out any additional formatting required, however whitespaces are registered as characters to encode. Running Huffman encoding will result in generation of optimal binary code for each character for lossless conversion, draw tree presenting frequencies and characters for Huffman code and encode the tree using Prufer algorithm.

Prufer decoding requires special format of input file:
```
1 //root node 
1 3 6 11 5 5 3 6 11 //prufer code
a ; e c b d //labels for leaf nodes
```
Attempt to decode file of not supported format will result in appropriate message displayed on screen.

### License
----

MIT
