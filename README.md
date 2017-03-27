# REA Robot Challenge

Coding test from REA.

## Getting Started

Make sure that you have [Scala](https://www.scala-lang.org/) and [sbt](http://www.scala-sbt.org/) installed on your computer.

The instructions for the robot are fetched from `input.txt`, located in the root directory of the project.

##### Example

```text
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT
```
Run the application by typing the following command in the CLI,

```sh
sbt run
```

The output will be printed on the CLI.

##### Example

```sh
3,3,NORTH
```

## Running Tests

Navigate to the root directory of the project and type the following in the CLI,

```sh
sbt test
```