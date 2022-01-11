// Count the SUBSETS having product less than k

// Algorithm :

// Divide array into two equal parts.
// Generate all subsets and for each subset calculate product of elements and push this to a vector. 
// Try this for both part of array.
// Sort both new vector which contains products of elements for each possible subsets.
// Traverse any one vector and find upper-bound of element k/vector[i] to find how many subsets are 
// there for vector[i] whose product of elements is less than k.
// Some key points to improve complexity :

// Ignore elements from array if greater than k.
// Ignore product of elements to push into vector (subset1 or subset2) if greater than k.