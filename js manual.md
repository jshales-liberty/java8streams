# Javascript Manual

## values, data types

### data types

- booleans (`true`, `false`)
- special values `null` and `undefined`
- Number type (`5`)
- String type (`"This is a string"`, `'This is also a string'`)
- Arrays (`[6, "hi"]`)
- Objects (`{firstName: "John", lastName: "Doe"}`)

Strings are expressed with either double quotes or single quotes, "1",'2'

### Javascript is dynamically-typed

A variables can hold any kind of value:

```
var x;              // now x is undefined
var x = 5;          // now x is a Number
var x = "John";     // now x is a String
```

## automatic type conversions

Some operations automatically coerce (convert) one or both of their operands. For example, when adding a number to a string, the number is converted into a string.

## operators

Operator: specifies action to perform
Operand: a value being acted upon by an operator
Operation: a use of an operator

In the operation `5 + 3`, `+` is the operator, `3` and `5` are the operands.

### arithmetic operators
- + addition
- - subtraction
- * multiplication
- / division
- % modulus
- ++ increment
- -- decrement

### assignment operators

```
x = y
x += y  // x = x + y
x -= y  // x = x - y
x *= y  // x = x * y
x /= y  // x = x / y
x %= y  // x = x % y
```

### comparison operators

```
==  equality (coerces types)
=== equal value and equal type
!=  not equal
!== not equal value or not equal type
>   greater than
<   less than
>=  greater than or equal to
<=  less than or equal to
?   ternary operator
```

### logical operators

```
&&  logical and
||  logical or
!   logical not
```

Logical operators are typically used with Boolean (logical) values. When they are, they return a Boolean value. However, the && and || operators actually return the value of one of the specified operands, **so if these operators are used with non-Boolean values, they may return a non-Boolean value.**

As logical expressions are evaluated left to right, they are tested for possible "short-circuit" evaluation using the following rules:

false && (anything) is short-circuit evaluated to false.
true || (anything) is short-circuit evaluated to true.

### type operators

```
typeof      Returns the type of a variable
instanceof  Returns true if an object is an instance of an object type
```

## variables, var

- Variable names are called identifiers.
- Identifiers can be short names (like `x` and `y`) or more descriptive names (`age`, `sum`, `totalVolume`).
- Identifiers can contain letters, numeric digits, underscores, and dollar signs.
- Identifiers cannot begin with numeric digits
- Identifiers are case sensitive (y and Y are different variables)

## reserved words

In JavaScript you cannot use these reserved words as variables, labels, or function names:

```
abstract  arguments   await*        boolean
break     byte        case          catch
char      class*      const         continue
debugger  default     delete        do
double    else        enum*         eval
export*   extends*    false         final
finally   float       for           function
goto      if          implements    import*
in        instanceof  int           interface
let*      long        native        new
null      package     private       protected
public    return      short         static
super*    switch      synchronized  this
throw     throws      transient     true
try       typeof      var           void
volatile  while       with          yield
```

## statements vs. expressions

**An expression 'produces'/'returns' a value. Anywhere a value is expected in code, you can write an expression.**

Some expressions produce 'side effects' in that they modify the value of variable(s), *e.g.* `x = 7` returns 7 but also assigns 7 to x.

A Javascript program is a sequence of statements. Statements come in different kinds. Some statements contain other statements, and some contain expressions.

All statements in Javascript end with either a semicolon `;` or a pair of curly braces `{}`.

## variables vs. values

- variables store a reference to a value. 
- values can be assigned to variables.

## if-else

- Conditional statement where a certain block of code will be executed if the condition is true, otherwise the code block specified by the else is executed.

```
if (hour < 18) {
  greeting = "Good day";
} else {
  greeting = "Good evening";
}
```

## while

Loops through a block of code as long as a specified condition is true.

This loop will run 10 times:

```
var a = 0;
while (a < 10){
  a++;
}
```

The following loop will repeat infinitely because the condition is always true:

```
while(true) {
  console.log("Stuff");
}
```

## for

Like `while`, but the condition is preceded by a 'precondition' (a `var` statement) and a 'postcondition' (an expression to evaluate each time after the body runs).

```
for (i = 0; i < cars.length; i++) {
    text += cars[i] + "<br>";
 }
```

## for-in

Loops through the properties of an object:

```
var person = {fname: "John", lname: "Doe", age: 25};
var text = "";
var x;
for (x in person) {
    text += person[x];
}
```

A for-in loop allows you to iterates over the properties of an object.

```
var x = {amber: 2, brandy: 9, todd: 5};
var y = {};
// copy every property from x to y
for (var k in obj) {
    y[k] = x[k];
}
```

A for-in loop also allows you to iterates over the indexes of an array.

```
var x = [10, 20, 30, 40, 50];
var y = [];
// copy every element of 'x' to 'y'
for (var i in arr) {
    y[i] = x[i];         // 'i' is the index, not the value!
}
```

## functions

- A block of code designed to perform a particular task. The function code block will execute when 'invoked'/'called'. We can pass arguments (values) to a call, and they are assigned to the parameters (special local variables that receive the arguments). Functions are useful for code reuse and also to have one piece of code produce different results from different arguments.

```
function myFunction(p1, p2) {
    return p1 * p2;              // The function returns the product of p1 and p2
}
```

## local vs. global variables

The scope of a variable is the portion of code for which the variable's name has meaning or is said to be visible. Variables declared within a function are local and only accessible within that function or by functions inside that function. Any variables declared outside of a function are considered global.

```
// code outside the function here can not use carName
function myFunction() {
    // carName is local to this function
    var carName = "Volvo";
}
```

```
// this carName is global and so can be used outside the function
var carName = " Volvo";
function myFunction() {
    // we can also use the global inside this (and any) function
}
```

## arrays

A value which is collection of references stored contiguously in memory, able to be accessed by numeric index. The references can reference any type of value, meaning we can mix types in an array:

```
var names = ["Bob", "Nancy", "Fred"];
var sizes = [1, 2, 4, 8, 9];
var mixed = [3, "Billy", true, "candy"];   // mix of types in a single array
```

## objects

A Javascript object is a value that contains zero or more key-value pairs. 

We can access and modify the key-value pairs with the [] operator (similar to how we access indexes of arrays).

The key-value pairs of an object are not stored in any order.


## methods

methods are functions contained as values within an object. these functions can be called on an instance of that object. Methods are called using dot notation on an instance of an object.

```
cat1.purr() //for instance this may print a purring noise to the console
cat1.eat()  //this might increment the weight of the cat
```

```
function apple(x) {
    return x + this.num;
}
var obj = {
    num: 4,
    lucas: apple
};
obj.lucas(3);       // return 4
```

## the different uses of . [] {} ;

### .

-   accessing/calling methods
-   accessing/assigning properties of objects

### []

-   creating an array []
-   access/assign to index of an array: `a[0] = 3;`
-   access/assign to key of an object: `o["key"] = 4;`

## {}

-   body of function, loops, if-else, etc.
-   compound statements
-   create an object {foo: 3, "hi": 2}

## ;

-   end a statement that doesn't end with `{}` body
-   seperates precondition, condition, and postcondition of a `for` loop

## for ()

-   surround conditions of if's and loops
-   calling a function or method: `foo()`
-   control order of operations: `(2 + 3) / 2`
-   surround parameters in a `function`

## object links

An object can be linked to one other object. When we look up a property in an object, if the object itself does not have that key, Javascript follows the link and looks in the other object.

To create an object linked to another, we can use the `Object.create` method:

```
var x = {traci: 7};
// y is a new empty object linked to x
var y = Object.create(x);
console.log(y.traci);   // prints 7
```

## anonymous functions

Annonymous functions are functions that are defined as an expression.

```
// a 'normal' function
function hello() {
    console.log("hello");
}

// the anonymous equivalent
var hello = function () {
    console.log("hello");
};
``

Anonymous functions are nice when we can't think of a good name for the function and when we only want to use the function in one place in code.

For instance, when registering event handlers, we typically use anonymous functions:

```
// an example from a Pong game
window.addEventListener("keydown", function (evt) {
    var key = evt.keyCode;
    console.log(key);
    switch(key) {
        case 38:right_rect.top-=6; break;
        case 40:right_rect.top+=6; break;
        case 65:left_rect.top-=6; break;
        case 90:left_rect.top+=6; break;
    }
});
```

## nested function scope / closures

Nested functions are functions within functions.  The advantage of nested functions is they have access to the variables in the scope(s) "above" them.

A closure makes it possible to access the variables of the containing function:

```
function foo(x) {
  var y = x + 2;
  var bar = function () {
    x++;                    // increment x of the containing function
    console.log(x,y);
  };
  return bar;
}
var a = foo(3);
var b = foo(7);

a();  // 4 5
b();  // 8 9
a();  // 5 5
```

## exceptions

When a JavaScript statement generates an error, it is said to throw an exception.  Instead of proceeding to the next statement, the JavaScript interpreter checks for exception handling code.  If there is no exception handler, then the program returns from whatever function threw the exception.  This is repeated for each function on the call stack until an exception handler is found or until the top level function is reached, causing the program to terminate.

Exceptions shouldn't be used for control flow, but exceptions should be caught if the exception represents failed input or output (*e.g.* a failed network request).

## try-catch

Used to surround a block of code that may throw an exception at runtime. Generally not used for control flow. The try surrounds the code that may throw an exception, and if an exception is thrown in the try, execution jumps down to the catch. If no exception is thrown inside the try, execution skips the catch.

```
try {
    document.getElementById("addressLine2");
} catch (ex) {
    // variable ex holds the exception that was thrown
    alert("element not found");
}
```

## the global namespace

Variables in the global namespace have global scope, so they are visible everywhere in code, including inside any function (as long as that function does not have a local of the same name as the global).

## important functions and objects in the global namespace

- Number, Date, Math, String, Array, Object, Function
- eval(), parseInt(), parseFloat(), setInterval(), setTimeout()

## DOM methods and properties

The Document Object Model (DOM) allows you to interact with the HTML page. Allows you to traverse the HTML tree, retrieve and change specific nodes, and react to events.

[Essential DOM elements](https://www.impressivewebs.com/10-essential-dom-methods-techniques-for-practical-javascript/)

## event handlers

An event is an action on the page within the browser, and the handler is the function that is called when that event occurs.  For example, a click even fires when the user clicks an element on the page.

```
<html>
<body>
<ol id="foo">
  <li>Apple</li>
  <li>Orange</li>
  <li>Banana</li>
  <li>Kiwi</li>
</ol>
<script>
function hello(evt) {
    console.log('yo');
}
var foo = document.getElementById('foo');
foo.addEventListener('click', hello); // call 'hello' when user clicks on the list
</script>
</body>
</html>
```