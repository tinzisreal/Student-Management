# Student Management Simple Enum

## Structure
- controller
- model
- service
- util
- view

## Improvements
- Use enum for Course
- Check duplicate ID when create
- No repository
- No service interface

## Compile
```bash
javac -d out src/com/tung/studentmanagement/App.java src/com/tung/studentmanagement/controller/*.java src/com/tung/studentmanagement/model/*.java src/com/tung/studentmanagement/service/*.java src/com/tung/studentmanagement/util/*.java src/com/tung/studentmanagement/view/*.java
```

## Run
```bash
java -cp out com.tung.studentmanagement.App
```
