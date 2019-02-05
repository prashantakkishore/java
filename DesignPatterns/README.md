# Class diagram
A class diagram in the UML is a type of static structure diagram that describes the structure of a system by showing the system's classes, their attributes, operations (or methods), and the relationships among objects.

## Members
---

### Visibility

- `+` Public
- `-` Private
- `#` Protected
- `~` Package

![Alt text](images/class_visibility.png?raw=true "Class Visibility")

### Scope
- Classifier members - Static members of a class.
- Instance members - Instance member of a class.

## Relationships
---
![Alt text](images/uml_class_relation_arrows.png?raw=true "Relationships")

### Instance-level relationships
- Dependency
    - Exists between two classes if changes to the definition of one may cause changes to the other (but not the other way around).
    - Car depends on Wheel

    ![Alt text](images/dependency.png?raw=true "Relationships")

- Association
    - A structural link between two peer classes.
    - A solid line connecting two classes

     ![Alt text](images/association.png?raw=true "Relationships")

- Aggregation

    A special type of association. It represents a "part of" relationship.

    - Class2 is part of Class1.
    - Many instances (denoted by the *) of Class2 can be associated with Class1.
    - Objects of Class1 and Class2 have separate lifetimes.   

    ![Alt text](images/aggregation.png?raw=true "Relationships")

- Composition

    A special type of aggregation where parts are destroyed when the whole is destroyed.

    - Objects of Class2 live and die with Class1.
    - Class2 cannot stand by itself.

    ![Alt text](images/aggregationAndComposition.png?raw=true "Relationships")

#### Differences between Composition and Aggregation
##### Composition relationship
1. When attempting to represent real-world whole-part relationships, e.g. an engine is a part of a car.
2. When the container is destroyed, the contents are also destroyed, e.g. a university and its departments.
##### Aggregation relationship
1. e.g. car model engine ENG01 is part of a car model CM01, as the engine, ENG01, may be also part of a different car model.[8]
2. When the container is destroyed, the contents are usually not destroyed, e.g. a professor has students, when the professor dies the students don't die along with him or her.

### Class-level relationships

#### Generalization/Inheritance
Inheritance.
![Alt text](images/generalization.png?raw=true "Relationships")

#### Realization/Implementation
Implementation , like interface and its impl.

a relationship between two model elements, in which one model element (the client) realizes (implements or executes) the behavior that the other model element (the supplier) specifies.

### All together
![Alt text](images/uml_class_diagram_all_together.png?raw=true "Relationships")

## References
---

https://en.wikipedia.org/wiki/Class_diagram#Dependency

https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-class-diagram/
