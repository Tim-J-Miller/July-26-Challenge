/*
Weekly Coding Challenge:

Problem 1: Find the Contiguous Subarray with Sum to a Given Value in an array.

Given an array of positive integer and given value X, find Contiguous sub array whose sum is equal to X.
For example:

arr[]={14, 12, 70, 15, 99, 65, 21, 90};
X =97.
Sum found between index 1 to 3
Elements are 12, 17 and 15

Problem 2: Write a program and show how to implement stack using Linked List in java.(note: implement your own linked list or use the one provided by java)
*/
import scala.util.control.Breaks._
object Main extends App {
  val inputArray =  Array[Int](14, 12, 70, 15, 99, 65, 21, 90)
  val inputSum = 97
  var outArr = Array[Int]()
  var (first, last) = (0, -1)
  breakable{
    inputArray.foreach(x=>{
      if (outArr.sum < inputSum){
        outArr = outArr :+ x
        last = last + 1
      }
      if (outArr.sum > inputSum){
        outArr = outArr.drop(1)
        first = first + 1
      }
      if (outArr.sum == inputSum){
        break()
      }
    })
  }
  
  if (outArr.sum == inputSum){
    println(s"Found contiguous sum running from index $first to index $last")
    outArr.foreach(println)
  }
  else
    {
      println("Found no contiguous sum")
    }
}