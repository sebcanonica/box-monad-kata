# Box monad kata

A coding kata to understand what is a monad
 (or, more precisely, what I understood :-)).

You will implement a Box<T> which wraps any
kind of value, and turn this box into a monad.
 
Open the [Box_should.java](src/test/java/Box_should.java) 
test file and follow the instructions in there.
 
 ## Pre-requisites
 Generic programming, Function and BiFunction interface, lambdas.
 
 ## References
 The approach is heavily inspired from 
 [Get Programming with Haskell](https://www.manning.com/books/get-programming-with-haskell) 
 ([Unit 5](https://livebook.manning.com/book/get-programming-with-haskell/chapter-27?origin=product-toc)).
 
 See also [Functors, Applicatives, And Monads In Pictures](http://adit.io/posts/2013-04-17-functors,_applicatives,_and_monads_in_pictures.html).
 
 Note that the fmap signature in this kata is
 "reversed" from the Haskell way.