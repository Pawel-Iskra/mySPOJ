///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 9589, NAME: BF Last binary digit ////////
/// link: https://pl.spoj.com/problems/ODDBF/ /////////
/// RESULT FOR THIS SOLUTION = 79 chars ///////////////
///////////////////////////////////////////////////////


,[>,----------]                   // reading char by char of the number given in the input until the newline character (ASCII 10)
++<<[-]>                          // preparing memory cells for the modulo algorithm
[>->+<[>]>[<+>-]<<[<]>-]          // this modulo algorithm requires starting values as following:
                                  // 0  >n  d  0  0  0
                                  // '0' is memory cell with value zero, '>' is pointer, 'd' is divisor (value 2 in this case)
                                  // after getting out from this loop:
                                  // 0  >0  d-n%d  n%d  0  0
                                  
<++++++[>++++++++<-]>             // prepering value 48 
[>>+<<-]>>.                       // adding value 48 to the result value to print out as an ASCII char


///////////////////////////////////////////////////////////////
/// IMPORTANT NOTE: ///////////////////////////////////////////
/// In fact in this solution I don't operate on a digit but ///
/// its ASCII number minus 10. However it is still correct ////
/// to determine what is the last binary digit of the number //
///////////////////////////////////////////////////////////////
