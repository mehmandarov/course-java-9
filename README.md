# Java 9 Course

Teaches you the ins and outs of Java 9 (not the module system, though).
The links below take you to the demo in this project, the JEP responsible for introducing the feature, and to other sources if available.

## Setup

The scripts are written for Linux but should look similar on other operating systems.
They do need three symlinks, though:

* `java9` links to `java` in the JDK 9 install
* `javac9` links to `javac` in the JDK 9 install
* `jar9` links to `jar` in the JDK 9 install

## Language Changes

The language changes are rather small and there is no real point in doing any exercises - it suffices to take a look. 

* [private interface methods](src/org/codefx/demo/java9/lang/private_interface_methods/PrivateInterfaceMethods.java) ([JEP 213](http://openjdk.java.net/jeps/213))
* [try-with-resources on effectively final variables](src/org/codefx/demo/java9/lang/try_with_resources/TryWithResources.java) ([JEP 213](http://openjdk.java.net/jeps/213))
* [diamond operator for anonymous classes](src/org/codefx/demo/java9/lang/diamond_operator/DiamondOperator.java) ([JEP 213](http://openjdk.java.net/jeps/213))
* [`@SaveVarargs` on private non-final methods](src/org/codefx/demo/java9/lang/safe_varargs/SafeVarargs.java) ([JEP 213](http://openjdk.java.net/jeps/213))
* [no warnings for deprecated imports](src/org/codefx/demo/java9/lang/deprecated_imports/DeprecatedImports.java) ([JEP 211](http://openjdk.java.net/jeps/211))
